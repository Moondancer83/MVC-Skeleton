package hu.kalee.skeleton.presentation.config;

import hu.kalee.skeleton.backend.config.BackendAppConfig;
import hu.kalee.skeleton.business.config.BusinessAppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Initializing servlet.
 *
 * @author Moondancer
 * @since 2015.12.26.
 */
public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{AppConfig.class, BusinessAppConfig.class, BackendAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
