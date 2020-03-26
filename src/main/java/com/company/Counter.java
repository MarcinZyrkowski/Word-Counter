package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Counter implements WordCounter {

    @Override
    public int countLines(File file) {

        try {
            Scanner read = new Scanner(file);
            int numberOfLines = 0;
            while (read.hasNextLine()) {
                read.nextLine();
                numberOfLines++;
            }
            return numberOfLines;
        } catch (FileNotFoundException e) {
            return -1;
        }

    }

    @Override
    public int countWords(File file) {
        try {
            Scanner read = new Scanner(file);
            int numberOfWords = 0;
            while (read.hasNextLine()) {
                numberOfWords += countWordsInOneLine(read.nextLine());
            }
            return numberOfWords;
        } catch (FileNotFoundException e) {
            return -1;
        }

    }

    @Override
    public int countCharacters(File file) {

        try {
            Scanner read = new Scanner(file);
            int numberOfCharacters = 0;
            while (read.hasNextLine()) {
                numberOfCharacters += countCharacterInOneLine(read.nextLine());
            }
            return numberOfCharacters;
        } catch (FileNotFoundException e) {
            return -1;
        }
    }

    private static int countWordsInOneLine(String string) {
        return string.split("\\s").length;
    }

    private static int countCharacterInOneLine(String string) {
        return string.replaceAll("\\s", "").toCharArray().length;
    }


}