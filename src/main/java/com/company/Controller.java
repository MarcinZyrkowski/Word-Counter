package com.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;

@RestController
public class Controller {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @Autowired
    private WordCounter counter;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "hello world";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public HashMap<String, Object> print(@RequestBody String text) {

        int numberOfLines = counter.countLines(text);
        int numberOfWords = counter.countWords(text);
        int numberOfCharacters = counter.countCharacters(text);

        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("Lines", numberOfLines);
        map.put("Words",numberOfWords);
        map.put("Characters", numberOfCharacters);
        return map;

    }
}