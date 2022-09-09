package com.company.services;

public interface WordCounterService {

    Long countLines(String text);

    Long countWords(String text);

    Long countCharacters(String text);

}
