package com.company;


import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
public class Controller {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "hello world";
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String print(@RequestBody String path) {
        File file = new File(path);
        WordCounter counter = new Counter();
        int numberOfLines = counter.countLines(file);
        int numberOfWords = counter.countWords(file);
        int numberOfCharacters = counter.countCharacters(file);

        return "Lines: " + numberOfLines + " Words: " + numberOfWords + " Characters: " + numberOfCharacters;
    }


}
