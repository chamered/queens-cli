package com.github.chamered.queens.ui;

import java.io.File;
import java.util.Scanner;

public class MainMenu {

    private final Scanner scanner;

    public MainMenu() {
        this.scanner = new Scanner(System.in);
    }

    public String showAndSelectLevel() {
        printLogo();

        File folder = new File("levels");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null || listOfFiles.length == 0) {
            System.out.println("No levels found in the 'levels/' folder.");
            return null;
        }

        System.out.println("Select a level to play:");
        for (int i = 0; i < listOfFiles.length; i++) {
            System.out.println((i + 1) + ". " + listOfFiles[i].getName());
        }
        System.out.println("0. Exit the game");

        while (true) {
            System.out.print("\nYour choice: ");
            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                return null;
            }

            try {
                int choice = Integer.parseInt(input);
                if (choice > 0 && choice <= listOfFiles.length) {
                    return listOfFiles[choice - 1].getPath();
                } else {
                    System.out.println("Number out of range. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private void printLogo() {
        String logo = """
            
             ██████  ██    ██ ███████ ███████ ███    ██ ███████ 
            ██    ██ ██    ██ ██      ██      ████   ██ ██      
            ██    ██ ██    ██ █████   █████   ██ ██  ██ ███████ 
            ██ ▄▄ ██ ██    ██ ██      ██      ██  ██ ██      ██ 
             ████ ▄▄  ██████  ███████ ███████ ██   ████ ███████ 
                       --- TERMINAL EDITION ---
            """;
        System.out.println("\u001B[33m" + logo + "\u001B[39m");
    }
}
