package com.github.chamered.queens;

import com.github.chamered.queens.core.Board;
import com.github.chamered.queens.core.GameController;
import com.github.chamered.queens.ui.ConsoleUI;

/**
 * The main entry point for the Queens CLI application.
 * Initializes a sample game board and starts the console interface.
 */
public class Main {
    public static void main(String[] args) {
        int[][] sampleLevel = {
                {0, 0, 1, 1, 1},
                {0, 2, 2, 1, 3},
                {0, 2, 4, 4, 3},
                {0, 2, 2, 4, 3},
                {0, 0, 4, 4, 3}
        };

        Board board = new Board(sampleLevel);
        ConsoleUI ui = new ConsoleUI();
        GameController game = new GameController(board, ui);
        game.play();
    }
}
