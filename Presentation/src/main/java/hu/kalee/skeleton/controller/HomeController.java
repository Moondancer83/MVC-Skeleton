package hu.kalee.skeleton.controller;

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
    @RequestMapping("home")
    public String home() {
        return "home";
    }
}
