package com.company.controller;

import com.company.dto.CounterDto;
import com.company.services.WordCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    WordCounterService counterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "hello world";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<CounterDto> print(@RequestBody String text) {
        return new ResponseEntity<>(counterService.countAllText(text), HttpStatus.OK);
    }
}