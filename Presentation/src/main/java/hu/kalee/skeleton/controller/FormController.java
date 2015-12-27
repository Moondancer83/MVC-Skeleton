package hu.kalee.skeleton.controller;

import hu.kalee.skeleton.model.Form;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @RequestMapping("form")
    public String form(HttpServletRequest request,
                       @ModelAttribute @Valid Form form,
                       BindingResult result,
                       RedirectAttributes redirectAttributes) {

        String pageName;
        if (result.hasErrors()) {
            pageName = "form";
        } else {
            redirectAttributes.addFlashAttribute("form", form);
            redirectAttributes.addFlashAttribute("message","Added successfully.");
            pageName = "redirect:/result";
        }
        return pageName;
    }

    @RequestMapping("result")
    public String result(HttpServletRequest request, @ModelAttribute Form form) {

        return "result";
    }
}
