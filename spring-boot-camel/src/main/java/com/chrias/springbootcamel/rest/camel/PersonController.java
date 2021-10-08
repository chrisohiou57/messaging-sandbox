package com.chrias.springbootcamel.rest.camel;

import com.chrias.springbootcamel.model.Person;
import com.chrias.springbootcamel.service.PersonService;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
// import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class PersonController extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		restConfiguration()
            .component("servlet")
            .contextPath("/camel/")
            .port(8080)
            .enableCORS(true)
            .bindingMode(RestBindingMode.json)
            .apiContextPath("/api-doc")
                .apiProperty("api.title", "Simple REST API Example")
                .apiProperty("cors", "true");

        rest()
            .get("/person")
                .description("Person REST Service")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .outType(Person.class)
                .to("direct:getPeople");

        from("direct:getPeople")
            .bean(PersonService.class, "getPeople");
            // .to("bean:personService?method=getPeople()");
	}
    
}
