package com.chrias.springbootactivemq.config;

import javax.jms.ConnectionFactory;

import com.chrias.springbootactivemq.model.SomeMessage;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class JmsConfig {

    @Bean(name="jsonListenerContainerFactory")
    public DefaultJmsListenerContainerFactory jsonListenerContainerFactory(ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer,
            @Qualifier("jsonMessageConverter") MessageConverter jsonMessageConverter) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        
        // This provides all boot's default to this factory
        configurer.configure(factory, connectionFactory);

        // You could still override other Boot defaults if necessary
        factory.setMessageConverter(jsonMessageConverter);
        return factory;
    }

    @Bean(name="xmlListenerContainerFactory")
    public DefaultJmsListenerContainerFactory xmlListenerContainerFactory(ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer,
            @Qualifier("xmlMessageConverter") MessageConverter xmlMessageConverter) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        
        // This provides all boot's default to this factory
        configurer.configure(factory, connectionFactory);

        // You could still override other Boot defaults if necessary
        factory.setMessageConverter(xmlMessageConverter);
        return factory;
    }

    @Bean(name="jsonJmsTemplate")
    public JmsTemplate jsonJmsTemplate(ConnectionFactory connectionFactory, @Qualifier("jsonMessageConverter") MessageConverter jsonMessageConverter) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory);
        jmsTemplate.setMessageConverter(jsonMessageConverter);
        return jmsTemplate;
    }

    @Bean(name="xmlJmsTemplate")
    public JmsTemplate xmlJmsTemplate(ConnectionFactory connectionFactory, @Qualifier("xmlMessageConverter") MessageConverter xmlMessageConverter) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory);
        jmsTemplate.setMessageConverter(xmlMessageConverter);
        return jmsTemplate;
    }

    @Bean(name = "jsonMessageConverter")
    public MessageConverter jsonMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @Bean(name = "xmlMessageConverter")
    public MessageConverter xmlMessageConverter() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // marshaller.setContextPath("org.chrias.springbootactivemq.model");
        marshaller.setClassesToBeBound(SomeMessage.class);

        MarshallingMessageConverter converter = new MarshallingMessageConverter();
        converter.setMarshaller(marshaller);
        converter.setUnmarshaller(marshaller);
        return converter;
    }

}
