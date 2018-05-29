package com.example.demo.handler;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liumolong on 18/5/30.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String,Object> exceptionHandler(HttpServletRequest request,Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("sucess", false);
        map.put("errMsg", e.getMessage());
        return map;
    }
}
