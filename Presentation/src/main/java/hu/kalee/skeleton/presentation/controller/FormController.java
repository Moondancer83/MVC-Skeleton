package hu.kalee.skeleton.presentation.controller;

import hu.kalee.skeleton.business.facade.BusinessFacade;
import hu.kalee.skeleton.business.model.BusinessInputDTO;
import hu.kalee.skeleton.business.model.BusinessOutputDTO;
import hu.kalee.skeleton.business.model.BusinessResult;
import hu.kalee.skeleton.business.model.ResultStatus;
import hu.kalee.skeleton.presentation.model.Form;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("form")
    public String form(HttpServletRequest request,
                       @ModelAttribute @Valid Form form,
                       BindingResult result,
                       RedirectAttributes redirectAttributes) {

        String pageName;
        if (result.hasErrors()) {
            pageName = "form";
        } else {
            BusinessInputDTO businessInput = new BusinessInputDTO();
            businessInput.setData(form.getField());
            BusinessResult businessResult = facade.process(businessInput);
            if (ResultStatus.OK.equals(businessResult.getStatus())) {
                redirectAttributes.addFlashAttribute("result", businessResult.getOutputDTO());
                redirectAttributes.addFlashAttribute("message", businessResult.getMessages().get("message"));
                pageName = "redirect:/result";
            } else {
                pageName = "form";
            }
        }
        return pageName;
    }

    @RequestMapping("result")
    public String result(HttpServletRequest request, @ModelAttribute BusinessOutputDTO result) {

        return "result";
    }
}