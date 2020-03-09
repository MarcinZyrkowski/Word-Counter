package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordCounter {

    public static void function() {
        System.out.println("please write name of file");

        Scanner sc = new Scanner(System.in);
        String plik = sc.nextLine();

        System.out.println("please write flag");
        System.out.println("-l : to count lines");
        System.out.println("-w : to count words");
        System.out.println("-c : to count characters");

        Scanner flag = new Scanner(System.in);
        String flagS = flag.nextLine();

        try {
            Scanner odczyt = new Scanner(new File(plik));
            int numberOfLines = 0;
            int numberOfWords = 0;
            int numberOfCharacters = 0;
            while (odczyt.hasNextLine()) {
                String line = odczyt.nextLine();
                numberOfLines++;
                numberOfWords += counterWord(line);
                numberOfCharacters += counterCharacter(line);
            }


            System.out.print(plik + " : ");
            switch (flagS) {
                case "-l":
                    System.out.print("number of lines : " + numberOfLines);
                    break;
                case "-w":
                    System.out.print("number of words : " + numberOfWords);
                    break;
                case "-c":
                    System.out.print("number of characters : " + numberOfCharacters);
                    break;
                default:
                    System.out.println("wrong flag");
            }
        } catch (
                FileNotFoundException e) {
            System.out.println("file doesn't exist");
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