package hu.kalee.skeleton.presentation.controller;

import hu.kalee.skeleton.business.facade.BusinessFacade;
import hu.kalee.skeleton.business.model.BusinessInputDTO;
import hu.kalee.skeleton.business.model.BusinessOutputDTO;
import hu.kalee.skeleton.business.model.BusinessResult;
import hu.kalee.skeleton.presentation.converter.BusinessToPresentationConverter;
import hu.kalee.skeleton.presentation.converter.PresentationToBusinessInputConverter;
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
    public static final String OK_VIEW_NAME = "redirect:/result";
    public static final String ERROR_VIEW_NAME = "redirect:/error";
    public static final String OK_URL = "result";
    @Inject
    BusinessFacade facade;

    @Inject
    PresentationToBusinessInputConverter fromConverter;

    @Inject
    BusinessToPresentationConverter toPresentationConverter;

    @Inject
    public FormController(Converter<FormDTO, BusinessInputDTO> toBusinessConverter, Converter<BusinessOutputDTO, ResultDTO> toPresentationConverter) {
        super(toBusinessConverter, toPresentationConverter);
    }

    /**
     * Loads Calling View after GET request.
     *
     * @param form The input model
     * @return The name of calling view view
     */
    @RequestMapping(value = CALLING_URL, method = RequestMethod.GET)
    public String form(@ModelAttribute("form") FormDTO form) {
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
    public String form(HttpServletRequest request,
                       @ModelAttribute("form") @Valid FormDTO form,
                       BindingResult result,
                       RedirectAttributes redirectAttributes) {

        return process(form, result, redirectAttributes);
    }

    @Override
    String getCallingViewName() {
        return CALLING_VIEW_NAME;
    }

    @Override
    String getOkViewName() {
        return OK_VIEW_NAME;
    }

    @Override
    void preProcessInput(BusinessInputDTO businessInput) {

    }

    @Override
    void postProcessResult(FormDTO input, ResultDTO serviceResult) {
        serviceResult.setField(input.getField());
    }

    @Override
    BusinessResult callFacade(BusinessInputDTO businessInput) {
        return facade.process(businessInput);
    }
}
