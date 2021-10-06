package com.chrias.springbootcamel.activemq;

import com.chrias.springbootcamel.beans.LoggingBean;
import com.chrias.springbootcamel.model.SomeMessage;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class JsonQueueLoggingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:queue:USERS.JSON")
            .log("Received JSON Message Body: ${body}")
            .unmarshal()
            .json(SomeMessage.class)
            .bean(LoggingBean.class, "logMessage");
    }

}
