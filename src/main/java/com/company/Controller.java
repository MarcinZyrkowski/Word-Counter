package com.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "hello world";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Response print(@RequestBody String text) {

        WordCounter counter = new Counter();

        Response response = new Response();
        response.setLines(counter.countLines(text));
        response.setWords(counter.countWords(text));
        response.setCharacters(counter.countCharacters(text));

        return response;
    }
}