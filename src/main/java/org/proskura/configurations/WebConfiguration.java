package org.proskura.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by User on 20.11.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan ({"org.proskura.controllers"})
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/**/*.pdf").addResourceLocations("/WEB-INF/docs/");
        registry.addResourceHandler("/**/*.jpg").addResourceLocations("/WEB-INF/images/");
        registry.addResourceHandler("/**/*.png").addResourceLocations("/WEB-INF/images/");
        registry.addResourceHandler("/**/*.css").addResourceLocations("/WEB-INF/css/");
        registry.addResourceHandler("/**/*.html").addResourceLocations("/WEB-INF/html/");
        registry.addResourceHandler("/**/*.js").addResourceLocations("/WEB-INF/js/");
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }



}
