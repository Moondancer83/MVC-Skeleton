package hu.kalee.skeleton.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home controller.
 *
 * @author Moondancer
 * @since 2015.12.26.
 */
@Controller
public class HomeController {
    /**
     * Home page.
     *
     * @return The name of home page view
     */
    @RequestMapping("home")
    public final String home() {
        return "home";
    }
}
