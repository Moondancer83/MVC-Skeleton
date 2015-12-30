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
 */
public abstract class BaseController<A extends InputDTO & MessageHolder, B extends InputDTO, C extends OutputDTO, D extends OutputDTO> {
    public static final String ERROR_VIEW_NAME = "redirect:/error";

    Converter<A, B> toBusinessConverter;
    Converter<C, D> toPresentationConverter;

    public BaseController(Converter<A, B> toBusinessConverter, Converter<C, D> toPresentationConverter) {
        this.toBusinessConverter = toBusinessConverter;
        this.toPresentationConverter = toPresentationConverter;
    }

    public String process(A input,
                          BindingResult result,
                          RedirectAttributes redirectAttributes) {
        String viewName;

        if (result.hasErrors()) {
            viewName = getCallingViewName();
        } else {
            B businessInput = toBusinessConverter.convert(input);
            preProcessInput(businessInput);
            BusinessResult businessResult = callFacade(businessInput);

            switch (businessResult.getStatus()) {
                case OK:
                    @SuppressWarnings("unchecked")
                    C businessOutputDTO = (C) businessResult.getOutputDTO();
                    D serviceResult = toPresentationConverter.convert(businessOutputDTO);
                    postProcessResult(input, serviceResult);

                    redirectAttributes.addFlashAttribute("result", serviceResult);
                    redirectAttributes.addFlashAttribute("message", businessResult.getMessages().get("message"));
                    viewName = getOkViewName();
                    break;
                case ERROR:
                    redirectAttributes.addFlashAttribute("message", businessResult.getMessages().get("message"));
                    viewName = ERROR_VIEW_NAME;
                    break;
                case WARNING:
                default:
                    input.addMessage("warning", businessResult.getMessages().get("warning"));
                    viewName = getCallingViewName();
                    break;
            }
        }

        return viewName;
    }

    abstract String getCallingViewName();

    abstract String getOkViewName();

    abstract void preProcessInput(B businessInput);

    abstract void postProcessResult(A input, D serviceResult);

    abstract BusinessResult callFacade(B businessInput);


}
