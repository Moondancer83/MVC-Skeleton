package hu.kalee.skeleton.presentation.controller;

import hu.kalee.skeleton.business.model.BusinessResult;
import hu.kalee.skeleton.business.model.InputDTO;
import hu.kalee.skeleton.business.model.OutputDTO;
import hu.kalee.skeleton.presentation.model.MessageHolder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Base Controller.
 *
 * @author Moondancer
 * @since 2015.12.29..
 *
 * @param <A> Input DTO from frontend
 * @param <B> Input DTO for business layer usage
 * @param <C> Output DTO from business layer
 * @param <D> Output DTO for frontend usage
 */
public abstract class BaseController<A extends InputDTO & MessageHolder, B extends InputDTO, C extends OutputDTO, D extends OutputDTO> {
    public static final String REDIRECT_PREFIX = "redirect:/";
    public static final String ERROR_VIEW_NAME = "error";

    private final Converter<A, B> toBusinessConverter;
    private final Converter<C, D> toPresentationConverter;

    /**
     * Initializing dependencies.
     *
     * @param toBusinessConverter     Presentation to business converter for input DTO
     * @param toPresentationConverter Business to presentation converter for output DTO
     */
    public BaseController(final Converter<A, B> toBusinessConverter, final Converter<C, D> toPresentationConverter) {
        this.toBusinessConverter = toBusinessConverter;
        this.toPresentationConverter = toPresentationConverter;
    }

    /**
     * Common workflow.
     *
     * @param input              The input DTO from frontend
     * @param result             The validation result from frontend
     * @param redirectAttributes The redirect attributes
     * @return The name of next view
     */
    final public String process(final A input,
                                final BindingResult result,
                                final RedirectAttributes redirectAttributes) {
        String viewName;

        if (result.hasErrors()) {
            viewName = getCallingViewName();
        } else {
            try {
                B businessInput = prepareInput(input);
                BusinessResult businessResult = callFacade(businessInput);

                switch (businessResult.getStatus()) {
                    case OK:
                        D serviceResult = prepareResult(input, businessResult);

                        redirectAttributes.addFlashAttribute("result", serviceResult);
                        redirectAttributes.addFlashAttribute("message", businessResult.getMessages().get("message"));
                        viewName = REDIRECT_PREFIX + getOkViewName();
                        break;
                    case ERROR:
                        redirectAttributes.addFlashAttribute("message", businessResult.getMessages().get("message"));
                        viewName = REDIRECT_PREFIX + ERROR_VIEW_NAME;
                        break;
                    case WARNING:
                    default:
                        input.addMessage("warning", businessResult.getMessages().get("warning"));
                        viewName = getCallingViewName();
                        break;
                }
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("message", e.getMessage());
                viewName = REDIRECT_PREFIX + ERROR_VIEW_NAME;
            }
        }

        return viewName;
    }

    private B prepareInput(final A input) {
        B businessInput = toBusinessConverter.convert(input);
        preProcessInput(businessInput);

        return businessInput;
    }

    private D prepareResult(final A input, final BusinessResult businessResult) {
        @SuppressWarnings("unchecked")
        C businessOutputDTO = (C) businessResult.getOutputDTO();
        D serviceResult = toPresentationConverter.convert(businessOutputDTO);
        postProcessResult(input, serviceResult);

        return serviceResult;
    }

    /**
     * Returns the name of controller specific calling view.
     *
     * @return The name of calling view
     */
    abstract String getCallingViewName();

    /**
     * Returns the name of controller specific ok view.
     *
     * @return The name of ok view
     */
    abstract String getOkViewName();

    /**
     * Pre-processor workflow for input data.
     *
     * @param businessInput The business formatted raw input data
     */
    abstract void preProcessInput(B businessInput);

    /**
     * Post-processor workflow for output data.
     *
     * @param input The presentation formatted raw input data
     * @param serviceResult The presentation formatted raw output data
     */
    abstract void postProcessResult(A input, D serviceResult);

    /**
     * Calls specific business logic.
     *
     * @param businessInput The business formatted input data
     * @return The business formatted raw output data
     */
    abstract BusinessResult callFacade(B businessInput);


}
