package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter {

    private String name;
    private String flag;

    public WordCounter(String name, String flag) {
        this.name = name;
        this.flag = flag;
    }

    public int Count() {

        if (flag.equals("l") || flag.equals("w") || flag.equals("c")) {
            try {
                File file = new File(name);
                Scanner read = new Scanner(file.getAbsoluteFile());
                int numberOfLines = 0;
                int numberOfWords = 0;
                int numberOfCharacters = 0;
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    numberOfLines++;
                    numberOfWords += counterWord(line);
                    numberOfCharacters += counterCharacter(line);
                }

                System.out.print(name + " : ");
                switch (flag) {
                    case "l":
                        System.out.print("number of lines : " + numberOfLines);
                        return numberOfLines;
                    case "w":
                        System.out.print("number of words : " + numberOfWords);
                        return numberOfWords;
                    case "c":
                        System.out.print("number of characters : " + numberOfCharacters);
                        return numberOfCharacters;
                    default:
                        return -1;
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getLocalizedMessage());
                System.out.println("file doesn't exist");
                return -1;
            }
        } else {
            System.out.println("wrong flag");
            return -1;

        }
    }

    private static int counterWord(String string) {

        Scanner scanner = new Scanner(string);
        int words = 0;
        while (scanner.hasNext()) {
            scanner.next();
            words++;
        }
        return words;
    }

    private static int counterCharacter(String string) {

        Scanner scanner = new Scanner(string);
        int characters = 0;
        while (scanner.hasNext()) {
            String a = scanner.next();
            characters += a.length();
        }
        return characters;
    }

}