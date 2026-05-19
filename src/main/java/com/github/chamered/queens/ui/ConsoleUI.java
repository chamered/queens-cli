package com.github.chamered.queens.ui;

import com.github.chamered.queens.core.Board;
import com.github.chamered.queens.core.Cell;

import java.util.Scanner;

public class ConsoleUI {

    private final Scanner scanner;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK_TEXT = "\u001B[30m";
    private static final String[] BACKGROUNDS_COLORS = {
            "\u001B[41m", // Red
            "\u001B[42m", // Green
            "\u001B[43m", // Yellow
            "\u001B[44m", // Blue
            "\u001B[45m", // Purple
            "\u001B[46m", // Cyan
            "\u001B[47m"  // White
    };

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
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

                System.out.print(bgColor + ANSI_BLACK_TEXT + cellContent + ANSI_RESET);
            }
            System.out.println();
        }

        System.out.println("====================\n");
    }


    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim().toUpperCase();
    }

    private String getRegionColor(int regionId) {
        // Modulo operator ensures we don't go out of bounds if there are many regions
        return BACKGROUNDS_COLORS[regionId % BACKGROUNDS_COLORS.length];
    }

    private String getCellContent(Cell cell) {
        if (cell.isQueen()) return " Q ";
        else if (cell.isCrossed()) return " X ";
        else return "   ";
    }
}
