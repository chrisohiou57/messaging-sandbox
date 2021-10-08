package com.chrias.springbootcamel.activemq;

import com.chrias.springbootcamel.beans.LoggingBean;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

@Component
public class XmlUnmarshallingRoute extends RouteBuilder {

    private DataFormat jaxb;

    public XmlUnmarshallingRoute(JaxbDataFormat jaxbDataFormat) {
        this.jaxb = jaxbDataFormat;
    }

    @Override
    public void configure() throws Exception {
        from("activemq:USERS.XML")
            .log("Received XML Message Body: ${body}")
            .unmarshal(jaxb)
            .bean(LoggingBean.class, "logMessage");
    }
    
}
