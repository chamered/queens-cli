package com.github.chamered.queens;

import com.github.chamered.queens.core.Board;
import com.github.chamered.queens.core.GameController;
import com.github.chamered.queens.core.LevelLoader;
import com.github.chamered.queens.ui.ConsoleUI;

/**
 * The main entry point for the Queens CLI application.
 * Initializes a sample game board and starts the console interface.
 */
public class Main {
    public static void main(String[] args) {
        try {
            int[][] level = LevelLoader.loadLevel("levels/level1.txt");
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
