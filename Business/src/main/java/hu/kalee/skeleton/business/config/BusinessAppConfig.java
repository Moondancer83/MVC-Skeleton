package hu.kalee.skeleton.business.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Base application configuration.
 *
 * @author Moondancer
 * @since 2015.12.27..
 */
@Configuration
@ComponentScan(basePackages = {"hu.kalee.skeleton.business", "hu.kalee.skeleton.backend.service"})
public class BusinessAppConfig {
    @Bean
    public Mapper mapper() {
        return new DozerBeanMapper();
    }
}
