package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("write name of file: ");
        Scanner scanner = new Scanner(System.in);
        String nameOfFile = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder("/Users/mzyrkowski/IdeaProjects/Ważne - zadania/007_Word_Counter_New/");
        stringBuilder.append(nameOfFile);
        String path = stringBuilder.toString();

        System.out.println("write flag");

        System.out.println("number of lines : l");
        System.out.println("number of words : w");
        System.out.println("number of characters : c");

        Scanner scannerTwo = new Scanner(System.in);
        String flag = scannerTwo.nextLine();

        WordCounter wordCounter = new WordCounter(path, flag);
        wordCounter.Count();

    }
}
