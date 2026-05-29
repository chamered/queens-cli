package com.github.chamered.queens.ui;

import com.github.chamered.queens.core.Board;
import com.github.chamered.queens.core.Cell;

import java.util.Scanner;

import com.github.chamered.queens.ui.ANSIColors;

/**
 * Handles the terminal-based user interface for the Queens game.
 * Responsible for rendering the board with color-coded regions and reading user input.
 */
public class ConsoleUI {

    private final Scanner scanner;

    private static final String ANSI_RESET = "\u001B[0m";

    public ConsoleUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayBoard(Board board) {
        int gridSize = board.getGridSize();

        System.out.println("\n=== QUEENS BOARD ===");

        System.out.print("   ");
        for (int i = 0; i < gridSize; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

        for (int row = 0; row < gridSize; row++) {
            System.out.print(row + "  ");
            for (int col = 0; col < gridSize; col++) {
                Cell cell = board.getCell(row, col);

                String bgColor = getRegionColor(cell.getRegionId());
                String cellContent = getCellContent(cell);

                System.out.print(bgColor + ANSIColors.getTextColor(1) + cellContent + ANSI_RESET);
            }
            System.out.println();
        }

        System.out.println("====================\n");
    }


    public void displayError(String message) {
        System.out.println(ANSIColors.getTextColor(2) + message + ANSIColors.getTextColor(0));
    }

    public void displayCongratulations() {
        System.out.println("🎉 CONGRATULATIONS! You solved the puzzle! 🎉");
    }

    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim().toUpperCase();
    }

    private String getRegionColor(int regionId) {
        return ANSIColors.getBackgroundColor(2 + (regionId % 7));
    }

    private String getCellContent(Cell cell) {
        if (cell.isQueen()) return " Q ";
        else if (cell.isCrossed()) return " X ";
        else return "   ";
    }
}
