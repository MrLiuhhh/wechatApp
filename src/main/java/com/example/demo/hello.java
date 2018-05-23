package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liumolong on 18/5/24.
 */
@RestController
public class hello {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello springBoot";
    }
}
