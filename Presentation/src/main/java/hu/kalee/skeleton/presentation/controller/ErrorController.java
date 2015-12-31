package hu.kalee.skeleton.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Error controller.
 *
 * @author Moondancer
 * @since 2015.12.29..
 */
@Controller
public class ErrorController {
    /**
     * Default error page.
     *
     * @return The name of error view
     */
    @RequestMapping(value = "error")
    public final String error() {
        return "error";
    }
}
