package com.company;

import java.io.File;

public interface WordCounter {

    int countLines(File file);

    int countWords(File file);

    int countCharacters(File file);

}
