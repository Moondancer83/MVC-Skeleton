package hu.kalee.skeleton.backend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Base application configuration.
 *
 * @author Moondancer
 * @since 2016.01.02..
 */
@Configuration
@ComponentScan(basePackages = {"hu.kalee.skeleton.backend"})
public class BackendAppConfig {

}
