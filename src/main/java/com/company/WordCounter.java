package com.company;

import java.io.File;

public interface WordCounter {

    int countLines(File file);

    int countWords(File file);

    int countCharacters(File file);

    int countLines(String string);

    int countWords(String string);

    int countCharacters(String string);

    String show();

}
