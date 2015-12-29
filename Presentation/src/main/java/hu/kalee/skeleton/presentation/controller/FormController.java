package hu.kalee.skeleton.presentation.controller;

import hu.kalee.skeleton.business.facade.BusinessFacade;
import hu.kalee.skeleton.business.model.BusinessInputDTO;
import hu.kalee.skeleton.business.model.BusinessResult;
import hu.kalee.skeleton.business.model.ResultStatus;
import hu.kalee.skeleton.presentation.converter.BusinessToPresentationConverter;
import hu.kalee.skeleton.presentation.converter.PresentationToBusinessInputConverter;
import hu.kalee.skeleton.presentation.model.FormDTO;
import hu.kalee.skeleton.presentation.model.ResultDTO;
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
public class FormController {
    @Inject
    BusinessFacade facade;

    @Inject
    PresentationToBusinessInputConverter fromConverter;

    @Inject
    BusinessToPresentationConverter toConverter;


    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(@ModelAttribute("form") FormDTO form) {
        return "form";
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String form(HttpServletRequest request,
                       @ModelAttribute("form") @Valid FormDTO form,
                       BindingResult result,
                       RedirectAttributes redirectAttributes) {

        String pageName;
        if (result.hasErrors()) {
            pageName = "form";
        } else {
            BusinessInputDTO businessInput = fromConverter.convert(form);
            BusinessResult businessResult = facade.process(businessInput);

            if (ResultStatus.OK.equals(businessResult.getStatus())) {
                ResultDTO formResult = toConverter.convert(businessResult.getOutputDTO());
                formResult.setField(form.getField());

                redirectAttributes.addFlashAttribute("result", formResult);
                redirectAttributes.addFlashAttribute("message", businessResult.getMessages().get("message"));
                pageName = "redirect:/result";
            } else {
                pageName = "form";
            }
        }
        return pageName;
    }

    @RequestMapping("result")
    public String result(HttpServletRequest request, @ModelAttribute ResultDTO result) {

        return "result";
    }
}
