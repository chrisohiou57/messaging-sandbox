package com.chrias.springbootcamel.beans;

import com.chrias.springbootcamel.model.SomeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingBean {

    Logger log = LoggerFactory.getLogger(LoggingBean.class);

    public void logMessage(SomeMessage someMessage) {
        log.debug("Logging the message from a bean: " + someMessage.getSomeMessage());
    }
    
}
