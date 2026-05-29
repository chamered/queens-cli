package com.github.chamered.queens.ui;

import com.github.chamered.queens.ui.ANSIColors;

import java.io.File;
import java.util.Scanner;

public class MainMenu {

    private static final String VERSION = "1.2.0";

    private final Scanner scanner;
    private boolean firstTime = true;

    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public String showAndSelectLevel() {
        if (firstTime) {
            printLogo();
            System.out.println(ANSIColors.getTextColor(4) + "                                              v" + VERSION + ANSIColors.getTextColor(0));
            printHelp();
            firstTime = false;
        }

        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("/help") || input.equals("help")) {
                printHelp();
                continue;
            }

            if (input.equals("/levels") || input.equals("levels")) {
                listLevels();
                continue;
            }

            if (input.equals("/exit") || input.equals("exit") || input.equals("0")) {
                return null;
            }

            if (input.startsWith("/play ") || input.startsWith("play ")) {
                String[] parts = input.split("\\s+");
                try {
                    int choice = Integer.parseInt(parts[1]);
                    String path = resolveLevel(choice);
                    if (path == null) {
                        continue;
                    }
                    return path;
                } catch (NumberFormatException e) {
                    System.out.println(ANSIColors.getTextColor(2) + "Usage: /play <N> where N is a level number." + ANSIColors.getTextColor(0));
                }
                continue;
            }

            System.out.println(ANSIColors.getTextColor(2) + "Unknown command. Type /help to see available commands." + ANSIColors.getTextColor(0));
        }
    }

    private void printHelp() {
        System.out.println(ANSIColors.getTextColor(0) + "/help " + ANSIColors.getTextColor(7) + "show this help");
        System.out.println(ANSIColors.getTextColor(0) + "/levels " + ANSIColors.getTextColor(7) + "list available levels");
        System.out.println(ANSIColors.getTextColor(0) + "/play <N> " + ANSIColors.getTextColor(7) + "start level N");
        System.out.println(ANSIColors.getTextColor(0) + "/quit " + ANSIColors.getTextColor(7) + "return to main menu while in game");
        System.out.println(ANSIColors.getTextColor(0) + "/exit " + ANSIColors.getTextColor(7) + "exit the game");
        System.out.print(ANSIColors.getTextColor(0));
    }

    private void listLevels() {
        File folder = new File("levels");
        if (!folder.exists()) {
            folder.mkdirs();
            System.out.println(ANSIColors.getTextColor(2) + "'levels' folder not found. I just created it for you!" + ANSIColors.getTextColor(0));
            System.out.println(ANSIColors.getTextColor(4) + "Add some .txt files and restart the game." + ANSIColors.getTextColor(0));
            return;
        }

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files == null || files.length == 0) {
            System.out.println(ANSIColors.getTextColor(2) + "No levels found in 'levels/' folder." + ANSIColors.getTextColor(0));
            System.out.println(ANSIColors.getTextColor(4) + "Add some .txt files and restart the game." + ANSIColors.getTextColor(0));
            return;
        }

        System.out.println("Available levels:");
        for (int i = 0; i < files.length; i++) {
            System.out.println("  " + (i + 1) + ". " + files[i].getName());
        }
    }

    private String resolveLevel(int choice) {
        File folder = new File("levels");
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println(ANSIColors.getTextColor(2) + "Levels folder not found." + ANSIColors.getTextColor(0));
            return null;
        }

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files == null || files.length == 0) {
            System.out.println(ANSIColors.getTextColor(2) + "No levels available." + ANSIColors.getTextColor(0));
            return null;
        }

        if (choice < 1 || choice > files.length) {
            System.out.println(ANSIColors.getTextColor(2) + "Number out of range. Use /levels to see available levels." + ANSIColors.getTextColor(0));
            return null;
        }

        return files[choice - 1].getPath();
    }

    private void printLogo() {
        String logo = """
             ██████╗ ██╗   ██╗███████╗███████╗███╗   ██╗███████╗
            ██╔═══██╗██║   ██║██╔════╝██╔════╝████╗  ██║██╔════╝
            ██║   ██║██║   ██║█████╗  █████╗  ██╔██╗ ██║███████╗
            ██║▄▄ ██║██║   ██║██╔══╝  ██╔══╝  ██║╚██╗██║╚════██║
            ╚██████╔╝╚██████╔╝███████╗███████╗██║ ╚████║███████║
             ╚══▀▀═╝  ╚═════╝ ╚══════╝╚══════╝╚═╝  ╚═══╝╚══════╝
            """;
        System.out.print(ANSIColors.getTextColor(4) + logo + ANSIColors.getTextColor(0));
    }
}
