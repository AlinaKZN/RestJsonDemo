package ru.spring.controller.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.spring.controller.demo.config.DemoAppConfig;

public class SpringMvnDispatcherControllerInitilizer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{DemoAppConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
