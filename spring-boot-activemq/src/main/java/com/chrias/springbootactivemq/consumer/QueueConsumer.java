package com.chrias.springbootactivemq.consumer;

import javax.jms.JMSException;

import com.chrias.springbootactivemq.model.SomeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class QueueConsumer {
    Logger log = LoggerFactory.getLogger(QueueConsumer.class);
  
    @JmsListener(destination = "USERS.JSON", containerFactory = "jsonListenerContainerFactory")
    public void consumeJsonMessage(SomeMessage someMessage) throws JMSException {
        log.debug("JSON Message Received: " + someMessage);
    }

    @JmsListener(destination = "USERS.XML", containerFactory = "xmlListenerContainerFactory")
    public void consumeXmlMessage(SomeMessage someMessage) throws JMSException {
        log.debug("XML Message Received: " + someMessage);
    }

}
