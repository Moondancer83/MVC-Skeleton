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
    @RequestMapping(value = "error")
    public String error() {
        return "error";
    }
}
