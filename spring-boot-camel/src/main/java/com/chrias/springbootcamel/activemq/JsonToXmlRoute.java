package com.chrias.springbootcamel.activemq;

import com.chrias.springbootcamel.beans.LoggingBean;
import com.chrias.springbootcamel.model.SomeMessage;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

@Component
public class JsonToXmlRoute extends RouteBuilder {

    private DataFormat jaxb;

    public JsonToXmlRoute(JaxbDataFormat jaxbDataFormat) {
        this.jaxb = jaxbDataFormat;
    }

	@Override
	public void configure() throws Exception {
		from("activemq:queue:USERS.JSON_TO_XML")
            .log("Received JSON Message Body: ${body}")
            .unmarshal()
            .json(SomeMessage.class)
            .bean(LoggingBean.class, "logMessage")
            .marshal(jaxb)
            .log("Converted to XML: ${body}");
	}
    
}
