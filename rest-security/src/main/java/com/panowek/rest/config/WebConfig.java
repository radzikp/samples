package com.panowek.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Place description here.
 *
 * @author q1rp@nykredit.dk
 */

@Configuration
@ComponentScan("com.panowek.rest.security.service")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    public WebConfig() {
        super();
    }

}
