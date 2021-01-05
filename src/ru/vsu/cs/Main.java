package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String text = readSomething();
        StringBuilder resultText = getLengthWords(text);
        printSomething(resultText);
    }

    private static String readSomething() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ur text: ");
        return scanner.nextLine();
    }

    private static void printSomething(StringBuilder resultText) {
        System.out.println("The final text: " + resultText);
    }

    private static StringBuilder getLengthWords(String text) {
        StringBuilder resultText = new StringBuilder();
        String[] words = text.split("[ \\-#:;$]");

        int length = 0;
        for (int i = 0; i < words.length; i++) {
            length += words[i].length();
            resultText.append(words[i]).append("(").append(words[i].length()).append(")");

            if (i + 1 < words.length) {
                resultText.append(text.charAt(length + i));
            }
        }
        return resultText;
    }
}