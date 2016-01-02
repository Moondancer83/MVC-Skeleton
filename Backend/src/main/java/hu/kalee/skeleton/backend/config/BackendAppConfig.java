package hu.kalee.skeleton.backend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Base application configuration.
 *
 * @author Moondancer
 * @since 2016.01.02..
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"hu.kalee.skeleton.backend"})
public class BackendAppConfig {

}
