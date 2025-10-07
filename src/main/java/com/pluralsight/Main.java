package com.pluralsight;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("logs.txt"));
            launchApp(myWriter);
            String userInput;

            while (true) {
                System.out.println("Enter a search term (x to exit): ");
                userInput = myScanner.nextLine();

                if (userInput.equalsIgnoreCase("x")) {
                    exitApp(myWriter);
                    break;
                } else {
                    myWriter.write(formatter.format(LocalDateTime.now()));
                    searchingTerm(myWriter, userInput);
                }
            }
            myScanner.close();
            myWriter.close();
        } catch (Exception exception) {
            System.out.println("Error loading file");
            System.out.println(exception.getMessage());
        }
    }

    public static void launchApp(BufferedWriter writer) {
        try {
            writer.write(formatter.format(LocalDateTime.now()) + " ");
            writer.write("Launched App\n");
        } catch (Exception exception) {
            System.out.println("Sorry couldn't write that!");
            System.out.println(exception.getMessage());
        }
    }

    public static void searchingTerm(BufferedWriter writer, String userSearch) {
        try {
            writer.write(" " + userSearch + "\n");
        } catch (Exception exception) {
            System.out.println("Sorry couldn't write that!");
            System.out.println(exception.getMessage());
        }
    }

    public static void exitApp(BufferedWriter writer) {
        try {
            writer.write(formatter.format(LocalDateTime.now()) + " ");
            writer.write("Exit App\n");
        } catch (Exception exception) {
            System.out.println("Sorry couldn't write that!");
            System.out.println(exception.getMessage());
        }
    }
}
