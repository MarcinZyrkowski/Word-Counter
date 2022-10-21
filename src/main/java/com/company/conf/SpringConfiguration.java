package com.company.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.company"})
@PropertySource({"application.properties"})
public class SpringConfiguration {

}
