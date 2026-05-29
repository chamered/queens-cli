package com.github.chamered.queens.core;

import com.github.chamered.queens.ui.ConsoleUI;

public class GameController {

    private final Board board;
    private final ConsoleUI ui;
    private final RuleValidator validator;
    private boolean quitRequested;

    public GameController(Board board, ConsoleUI ui) {
        this.board = board;
        this.ui = ui;
        this.validator = new RuleValidator(board);
    }

    public void play() {
        boolean gameWon = false;

        while (!gameWon && !quitRequested) {
            ui.displayBoard(board);

            String input = ui.getUserInput("Enter your move: ");

            boolean validMove = processInput(input);
            if (!validMove) {
                System.out.println(ANSIColors.getTextColor(2) + "Invalid command or coordinates. Please try again." + ANSIColors.getTextColor(0));
                continue;
            }

            gameWon = validator.isGameWon();
        }

        if (gameWon) {
            ui.displayBoard(board);
            System.out.println("🎉 CONGRATULATIONS! You solved the puzzle! 🎉");
        }
    }

    private boolean processInput(String input) {
        if (input.equalsIgnoreCase("/quit") || input.equalsIgnoreCase("quit")) {
            quitRequested = true;
            return true;
        }

        String[] moves = input.split(" ");

        try {
            int row = Integer.parseInt(moves[1]);
            int col = Integer.parseInt(moves[2]);

            return switch (moves[0].toLowerCase()) {
                case "q" -> board.placeQueen(row, col);
                case "x" -> board.placeCross(row, col);
                case "c" -> board.clearCell(row, col);
                default -> false;
            };
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return false;
        }
    }
}
