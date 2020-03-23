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
        } catch ( FileNotFoundException e) {
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

        Scanner scanner = new Scanner(string);
        int words = 0;
        while (scanner.hasNext()) {
            scanner.next();
            words++;
        }
        return words;
    }

    private static int countCharacterInOneLine(String string) {

        Scanner scanner = new Scanner(string);
        int characters = 0;
        while (scanner.hasNext()) {
            String a = scanner.next();
            characters += a.length();
        }
        return characters;
    }

    /*
    private static String getPath(String pathFromUser) {
        Path path = Paths.get(pathFromUser);
        if (path.isAbsolute()) {
            return path.toString();
        } else {
            return path.resolve(".").toString();
        }
    }
     */

}