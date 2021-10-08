package com.chrias.springbootcamel.config;

import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.chrias")
public class CamelConfig {

    @Bean
    public JaxbDataFormat jaxbDataFormat() {
        return new JaxbDataFormat("com.chrias.springbootcamel.model");
    }

}
