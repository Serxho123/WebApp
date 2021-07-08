package com.springmvc.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AddViewConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/ordershop").setViewName("ordershop");
        registry.addViewController("/").setViewName("ordershop");
        registry.addViewController("/login").setViewName("login");
    }
}
