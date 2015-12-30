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
    @RequestMapping("result")
    public String result(HttpServletRequest request, @ModelAttribute ResultDTO result) {

        return "result";
    }
}
