package com.github.chamered.queens.ui;

import com.github.chamered.queens.core.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleUITest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream output;
    private ConsoleUI ui;

    @BeforeEach
    void setUp() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testDisplayBoard() {
        int[][] map = {{1, 1}, {2, 2}};
        Board board = new Board(map);
        ui = new ConsoleUI(new Scanner(System.in));

        ui.displayBoard(board);
        String out = output.toString();

        assertTrue(out.contains("QUEENS BOARD"));
        assertTrue(out.contains("0"));
        assertTrue(out.contains("1"));
    }

    @Test
    void testGetUserInputReturnsUppercase() {
        Scanner scanner = new Scanner("test input\n");
        ui = new ConsoleUI(scanner);

        String result = ui.getUserInput("prompt: ");

        assertEquals("TEST INPUT", result);
    }

    @Test
    void testDisplayError() {
        ui = new ConsoleUI(new Scanner(System.in));

        ui.displayError("Something went wrong");
        String out = output.toString();

        assertTrue(out.contains("Something went wrong"));
    }

    @Test
    void testDisplayCongratulations() {
        ui = new ConsoleUI(new Scanner(System.in));

        ui.displayCongratulations();
        String out = output.toString();

        assertTrue(out.contains("CONGRATULATIONS"));
    }
}
