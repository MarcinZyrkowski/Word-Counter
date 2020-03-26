package com.company;


import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scannerOne = new Scanner(System.in);
        System.out.println("please type path to file and get number of lines");
        String pathOne = scannerOne.nextLine();
        File file1 = new File(pathOne);

        Scanner scannerTwo = new Scanner(System.in);
        System.out.println("please type path to file and get number of words");
        String pathTwo = scannerTwo.nextLine();
        File file2 = new File(pathTwo);

        Scanner scannerThree = new Scanner(System.in);
        System.out.println("please type path to file and get number of characters");
        String pathThree = scannerThree.nextLine();
        File file3 = new File(pathThree);

        WordCounter counter = new Counter();
        int numberOfLines = counter.countLines(file1);
        int numberOfWords = counter.countWords(file2);
        int numberOfCharacters = counter.countCharacters(file3);
        System.out.println(numberOfLines);
        System.out.println(numberOfWords);
        System.out.println(numberOfCharacters);


    }
}
