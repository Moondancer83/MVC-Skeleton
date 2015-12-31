package hu.kalee.skeleton.presentation.controller;

import hu.kalee.skeleton.business.facade.BusinessFacade;
import hu.kalee.skeleton.business.model.BusinessInputDTO;
import hu.kalee.skeleton.business.model.BusinessOutputDTO;
import hu.kalee.skeleton.business.model.BusinessResult;
import hu.kalee.skeleton.presentation.model.FormDTO;
import hu.kalee.skeleton.presentation.model.ResultDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Form Controller.
 *
 * @author Moondancer
 * @since 2015.12.23..
 */
@Controller
public class FormController extends BaseController<FormDTO, BusinessInputDTO, BusinessOutputDTO, ResultDTO> {
    public static final String CALLING_URL = "form";
    public static final String CALLING_VIEW_NAME = "form";
    public static final String OK_VIEW_NAME = "result";

    /**
     * Business Facade dependency.
     */
    @Inject
    private BusinessFacade facade;

    /**
     * Controller for dependency injection.
     *
     * @param toBusinessConverter     Presentation to business converter for input DTO
     * @param toPresentationConverter Business to presentation converter for output DTO
     */
    @Inject
    public FormController(final Converter<FormDTO, BusinessInputDTO> toBusinessConverter, final Converter<BusinessOutputDTO, ResultDTO> toPresentationConverter) {
        super(toBusinessConverter, toPresentationConverter);
    }

    /**
     * Loads Calling View after GET request.
     *
     * @param form The input model
     * @return The name of calling view view
     */
    @RequestMapping(value = CALLING_URL, method = RequestMethod.GET)
    public final String form(@ModelAttribute("form") final FormDTO form) {
        return CALLING_VIEW_NAME;
    }

    /**
     * Processes POST request.
     * Validation warnings, Error or Result.
     *
     * @param request The HTTP Request object
     * @param form The input object
     * @param result The validation result
     * @param redirectAttributes The redirect attribures object
     * @return The name of next view.
     */
    @RequestMapping(value = CALLING_URL, method = RequestMethod.POST)
    public final String form(final HttpServletRequest request,
                             @ModelAttribute("form") @Valid final FormDTO form,
                             final BindingResult result,
                             final RedirectAttributes redirectAttributes) {

        return process(form, result, redirectAttributes);
    }

    @Override
    final String getCallingViewName() {
        return CALLING_VIEW_NAME;
    }

    @Override
    final String getOkViewName() {
        return OK_VIEW_NAME;
    }

    @Override
    void preProcessInput(final BusinessInputDTO businessInput) {

    }

    @Override
    final void postProcessResult(final FormDTO input, final ResultDTO serviceResult) {
        serviceResult.setField(input.getField());
    }

    @Override
    final BusinessResult callFacade(final BusinessInputDTO businessInput) {
        return facade.process(businessInput);
    }
}
