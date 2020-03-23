package com.company;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        Counter counter = new Counter();
        int numberOfLines = counter.countLines(new File("/Users/mzyrkowski/IdeaProjects/Ważne - zadania/007_Word_Counter_New/try.txt"));
        int numberOfWords = counter.countWords(new File("/Users/mzyrkowski/IdeaProjects/Ważne - zadania/007_Word_Counter_New/try.txt"));
        int numberOfCharacters = counter.countCharacters(new File("/Users/mzyrkowski/IdeaProjects/Ważne - zadania/007_Word_Counter_New/try.txt"));
        System.out.println(numberOfLines);
        System.out.println(numberOfWords);
        System.out.println(numberOfCharacters);


    }
}
