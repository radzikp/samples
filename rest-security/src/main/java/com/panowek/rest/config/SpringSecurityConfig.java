package com.panowek.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Expose the Spring Security Configuration
 *
 * @author q1rp@nykredit.dk
 */
@Configuration
@ImportResource({ "classpath:security-config.xml" })
@ComponentScan("com.panowek.rest.security")
public class SpringSecurityConfig {

    public SpringSecurityConfig() {
        super();
    }


}
