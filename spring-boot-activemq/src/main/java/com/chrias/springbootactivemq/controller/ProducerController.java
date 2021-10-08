package com.chrias.springbootactivemq.controller;

import com.chrias.springbootactivemq.producer.QueueProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private QueueProducer producer;

    @Autowired
    public ProducerController(QueueProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/sendJsonMessage/{text}")
    public String sendJsonMessage(@PathVariable String text, @RequestParam String queue) {
        if (StringUtils.hasText(queue)) {
            producer.sendJsonMessage(text, queue);
        } else {
            producer.sendJsonMessage(text);
        }
        
        return "JSON Message Sent!";
    }

    @GetMapping("/sendXmlMessage/{text}")
    public String sendXmlMessage(@PathVariable String text, @RequestParam String queue) {
        if (StringUtils.hasText(queue)) {
            producer.sendXmlMessage(text, queue);
        } else {
            producer.sendXmlMessage(text);
        }
        
        return "XML Message Sent!";
    }
    
}
