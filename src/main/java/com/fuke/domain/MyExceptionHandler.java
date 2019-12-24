package com.fuke.domain;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public Map handler(Exception e,HttpServletRequest request){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code","500");
        map.put("msg",e);

        return map;
    }

    @ExceptionHandler(value = {MyException.class})
    @ResponseBody
    public Map handler(MyException e){
        Map<String,Object> map = new HashMap<>();
        map.put("code",e.getCode());
        map.put("msg",e.getMsg());
        return map;
    }
}
