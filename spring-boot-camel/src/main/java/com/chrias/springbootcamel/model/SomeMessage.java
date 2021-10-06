package com.chrias.springbootcamel.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SomeMessage implements Serializable {

    @XmlElement
    private String someMessage;

    @XmlElement
    private NestedObject nestedObject;

    public SomeMessage(){}

    public SomeMessage(String someMessage) {
        this.someMessage = someMessage;
        this.nestedObject = new NestedObject(someMessage);
    }

    public String getSomeMessage() {
        return this.someMessage;
    }

    public void setSomeMessage(String someMessage) {
        this.someMessage = someMessage;
    }

    public NestedObject getNestedObject() {
        return this.nestedObject;
    }

    public void setNestedObject(NestedObject nestedObject) {
        this.nestedObject = nestedObject;
    }

    @Override
    public String toString() {
        return "{" +
            " someMessage='" + getSomeMessage() + "'" +
            ", nestedObject='" + getNestedObject() + "'" +
            "}";
    }    

}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class NestedObject implements Serializable {

    @XmlElement
    private String someMessage;

    public NestedObject() {}

    public NestedObject(String someMessage) {
        this.someMessage = someMessage;
    }

    public String getSomeMessage() {
        return this.someMessage;
    }

    public void setSomeMessage(String someMessage) {
        this.someMessage = someMessage;
    }
    
    @Override
    public String toString() {
        return "{" +
            " someMessage='" + getSomeMessage() + "'" +
            "}";
    }
    
}