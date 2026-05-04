package com.web.service;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldService {
    @GetMapping(value = "/sayHi/{name}")
    public String sayHello(@PathVariable String name){ //@PathParam use this annotation when developing jax rs rest webservice
        return "Hello "+name+", how are you?";
    }

    @GetMapping(value = "/sayGM")
    public String sayGM(@RequestParam(defaultValue = "Friends") String name){
        return "Good Morning "+name;
    }
}
