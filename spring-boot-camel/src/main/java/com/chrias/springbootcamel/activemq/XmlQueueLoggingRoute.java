package com.chrias.springbootcamel.activemq;

import com.chrias.springbootcamel.beans.LoggingBean;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

@Component
public class XmlQueueLoggingRoute extends RouteBuilder {

    DataFormat jaxb = new JaxbDataFormat("com.chrias.springbootcamel.model");

    @Override
    public void configure() throws Exception {
        from("activemq:USERS.XML")
            .log("Received XML Message Body: ${body}")
            .unmarshal(jaxb)
            .bean(LoggingBean.class, "logMessage");
    }
    
}
