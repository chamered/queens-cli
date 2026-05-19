package com.github.chamered.queens.ui;

import com.github.chamered.queens.core.ANSIColors;

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
        if (!folder.exists()) {
            folder.mkdirs();
            System.out.println(ANSIColors.getTextColor(2) + "⚠️ 'levels' folder not found. I just created it for you!" + ANSIColors.getTextColor(0));
            System.out.println(ANSIColors.getTextColor(4) + "👉 Please put your .txt files there and restart the game." + ANSIColors.getTextColor(0));
            return null;
        }

        File[] listOfFiles = folder.listFiles(((dir, name) -> name.endsWith(".txt")));

        if (listOfFiles == null || listOfFiles.length == 0) {
            System.out.println(ANSIColors.getTextColor(2) + "⚠️ No levels found in the 'levels/' folder." + ANSIColors.getTextColor(0));
            System.out.println(ANSIColors.getTextColor(4) + "👉 Add some .txt files and restart the game!" + ANSIColors.getTextColor(0));
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
                    System.out.println(ANSIColors.getTextColor(2) + "Number out of range. Try again." + ANSIColors.getTextColor(0));
                }
            } catch (NumberFormatException e) {
                System.out.println(ANSIColors.getTextColor(2) + "Please enter a valid number." + ANSIColors.getTextColor(0));
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
        System.out.println(ANSIColors.getTextColor(4) + logo + ANSIColors.getTextColor(0));
    }
}
