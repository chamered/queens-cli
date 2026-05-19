package com.github.chamered.queens;

import com.github.chamered.queens.core.Board;
import com.github.chamered.queens.core.GameController;
import com.github.chamered.queens.core.LevelLoader;
import com.github.chamered.queens.ui.ConsoleUI;
import com.github.chamered.queens.ui.MainMenu;

/**
 * The main entry point for the Queens CLI application.
 * Initializes a sample game board and starts the console interface.
 */
public class Main {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        String selectedLevelPath = menu.showAndSelectLevel();

        if (selectedLevelPath == null) {
            System.out.println("Thanks for playing! See you next time. \uD83D\uDC4B");
            return;
        }

        try {
            int[][] level = LevelLoader.loadLevel(selectedLevelPath);
            Board board = new Board(level);
            ConsoleUI ui = new ConsoleUI();

            GameController game = new GameController(board, ui);
            game.play();
        } catch (Exception e) {
            System.err.println("Unable to start game: Error loading level!");
            System.err.println("Details: " + e.getMessage());
        }
    }
}
