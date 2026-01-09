package com.Website.BulkTech.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
public void addViewControllers(ViewControllerRegistry registry){
    registry.addViewController("/daily").setViewName("daily");
    registry.addViewController("/memberlogin").setViewName("memberlogin");
    registry.addViewController("/new-user").setViewName("new-user");
}
}
