package ru.vsu.cs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        int number = readSomething();

        String text = readFile(number);
        StringBuilder resultText = getLengthWords(text);

        writeFile(resultText, number);
        printSomething(text, resultText);
    }

    private static int readSomething() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the file you want to open: ");
        return scanner.nextInt();
    }

    private static String readFile(int number) {
        String text = "";
        File input = new File("src\\ru\\vsu\\cs\\file\\input" + number + ".txt");
        try {
            Scanner scanner = new Scanner(input);
            text = scanner.nextLine();
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found");
            System.exit(1);
        }
        return text;
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

    private static void writeFile(StringBuilder resultText, int number) throws Exception {
        FileWriter output = new FileWriter("src\\ru\\vsu\\cs\\file\\output" + number + ".txt");
        output.write(String.valueOf(resultText));
        output.close();
    }

    private static void printSomething(String text, StringBuilder resultText) {
        System.out.println("Text from a text file: " + text + "\n" + "Text with the number of characters in the word: " + resultText);
    }
}