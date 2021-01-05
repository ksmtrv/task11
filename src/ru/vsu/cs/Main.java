package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String text = readSomething();
        StringBuilder finalText = getLengthWords(text);
        printSomething(finalText);
    }

    private static String readSomething() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ur text: ");
        return scanner.nextLine();
    }

    private static void printSomething(StringBuilder finalText) {
        System.out.println("The final text: " + finalText);
    }

    private static StringBuilder getLengthWords(String text) {
        StringBuilder finalText = new StringBuilder();
        String[] words = text.split("[ \\-#:;$]");

        int length = 0;
        for (int i = 0; i < words.length; i++) {
            length += words[i].length();
            finalText.append(words[i]).append("(").append(words[i].length()).append(")");

            if (i + 1 < words.length) {
                finalText.append(text.charAt(length + i));
            }
        }
        return finalText;
    }
}