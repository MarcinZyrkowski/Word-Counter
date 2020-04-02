package com.company;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public interface WordCounter {

    int countLines(File file);

    int countWords(File file);

    int countCharacters(File file);

}
