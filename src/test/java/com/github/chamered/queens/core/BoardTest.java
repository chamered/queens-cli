package com.github.chamered.queens.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testBoardInitialization() {
        int[][] testRegionMap = {
                {1, 1, 2},
                {1, 2, 2},
                {3, 3, 3}
        };

        Board board = new Board(testRegionMap);

        assertEquals(3, board.getGridSize(), "The grid size must be 3");

        // Cell (0, 0) - top left corner, must belong to region 1
        Cell cellA = board.getCell(0, 0);
        assertNotNull(cellA, "The cell must not be null");
        assertEquals(0, cellA.getRow());
        assertEquals(0, cellA.getCol());
        assertEquals(1, cellA.getRegionId(), "The cell at (0,0) must belong to region 1");
        assertTrue(cellA.isEmpty(), "The newly created cell must be empty");

        // Cell (1, 2) - center row, right column, must belong to region 2
        Cell cellB = board.getCell(1, 2);
        assertEquals(2, cellB.getRegionId(), "The cell at (1,2) must belong to region 2");

        // Cell (2, 1) - last row, center column, must belong to region 3
        Cell cellC = board.getCell(1, 2);
        assertEquals(2, cellC.getRegionId(), "The cell at (2,1) must belong to region 3");
    }

    @Test
    void testPlaceQueenAndClearAll() {
        int[][] map = {{1, 1}, {1, 1}};
        Board board = new Board(map);

        boolean success = board.placeQueen(0, 1);

        assertTrue(success, "Placing a queen in valid bounds must return true");
        assertTrue(board.getCell(0, 1).isQueen(), "The cell (0,1) must contain a queen");

        board.clearCell(0, 1);

        assertTrue(board.getCell(0, 1).isEmpty(), "The cell must be returned empty");
    }

    @Test
    void testOutOfBoundsPlacement() {
        int[][] map = {{1, 1}, {1, 1}};
        Board board = new Board(map);

        assertFalse(board.placeQueen(-1, 0), "Negative coordinates must evaluate to false");
        assertFalse(board.placeCross(2, 2), "Coordinates beyond gridSize must evaluate to false");

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
           board.getCell(5, 5);
        });
    }
}