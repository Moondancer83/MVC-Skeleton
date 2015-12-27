package hu.kalee.skeleton.business.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Base application configuration.
 *
 * @author Moondancer
 * @since 2015.12.27..
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"hu.kalee.skeleton.business"})
public class AppConfig {

}
