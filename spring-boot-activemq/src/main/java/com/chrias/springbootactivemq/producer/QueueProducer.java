package com.chrias.springbootactivemq.producer;

import com.chrias.springbootactivemq.model.SomeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class QueueProducer {

    private JmsTemplate jsonJmsTemplate;
    private JmsTemplate xmlJmsTemplate;

    @Autowired
    public QueueProducer(@Qualifier("jsonJmsTemplate") JmsTemplate jsonJmsTemplate, @Qualifier("xmlJmsTemplate") JmsTemplate xmlJmsTemplate) {
        this.jsonJmsTemplate = jsonJmsTemplate;
        this.xmlJmsTemplate = xmlJmsTemplate;
    }

    public void sendJsonMessage(String text) {
        jsonJmsTemplate.convertAndSend("USERS.JSON", new SomeMessage(text));
    }

    public void sendXmlMessage(String text) {
        xmlJmsTemplate.convertAndSend("USERS.XML", new SomeMessage(text));
    }

}
