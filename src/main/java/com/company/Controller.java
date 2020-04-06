package com.company;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.util.HashMap;

@RestController
public class Controller {


    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @Autowired
    private WordCounter counter;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "hello world";
    }

/*
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String print(@RequestBody String path) {
        ((Counter)counter).setFile(new File(path));
        return counter.show();
    }
*/

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public HashMap<String, Object> print(@RequestBody String text) {

        KeepData keepData = new KeepData();
        ((Counter) counter).setFile(keepData.convert(text));
        String string = counter.show();
        keepData.removeFile();


        HashMap<String, Object> map = new HashMap<>();
        map.put("data", string);
        return map;


    }
}