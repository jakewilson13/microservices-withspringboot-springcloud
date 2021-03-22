package com.tts3.webservices.restfulwebservices.controller;


import com.tts3.webservices.restfulwebservices.model.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //spring boot autoconfiguration dispatcher servlet is handling
    //all of the requests
    @GetMapping(value = "/hello")
    public String sayHello() {
        return "Hello World!";
    }

    //HttpMessageConverterAutoConfiguration is responsible for translating this bean
    //into a JSON format within the browser
    @GetMapping(value = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    //path variable is used for url paths to take in a variable
    //in this case, whatever we pass into the browser after/path-variable/? -
    //will be taken in as a variable we declared as a parameter called "name"
    @GetMapping(value = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
