package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordCounter {

    private String name;
    private String flag;

    WordCounter(String name, String flag) {
        this.name = name;
        this.flag = flag;
        function(name, flag);
    }

    public void function(String name, String flag) {

        if(flag.equals("l") || flag.equals("w") || flag.equals("c") ) {
            try {
                Scanner read = new Scanner(new File(name));
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
                        break;
                    case "w":
                        System.out.print("number of words : " + numberOfWords);
                        break;
                    case "c":
                        System.out.print("number of characters : " + numberOfCharacters);
                        break;
                    default:
                        break;
                }
            } catch (
                    FileNotFoundException e) {
                System.out.println("file doesn't exist");
            }
        }else{
            System.out.println("wrong flag");
        }
    }

    private static int counterWord(String string) {

        Scanner scanner = new Scanner(string);
        int words = 0;
        while (true) {
            try {
                scanner.next();
                words++;
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return words;
    }

    private static int counterCharacter(String string) {

        Scanner scanner = new Scanner(string);
        int characters = 0;
        while (true) {
            try {
                String a = scanner.next();

                characters += a.length();
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return characters;
    }

}