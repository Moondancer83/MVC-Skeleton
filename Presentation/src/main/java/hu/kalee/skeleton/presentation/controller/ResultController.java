package hu.kalee.skeleton.presentation.controller;

import hu.kalee.skeleton.presentation.model.ResultDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Result Controller.
 *
 * @author Moondancer
 * @since 2015.12.29..
 */
@Controller
public class ResultController {
    /**
     * Result page.
     *
     * @param request HTTP request object
     * @param result  Output DTO
     * @return The name of view
     */
    @RequestMapping("result")
    public final String result(final HttpServletRequest request, @ModelAttribute final ResultDTO result) {

        return "result";
    }
}
