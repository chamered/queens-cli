package com.github.chamered.queens.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleValidatorTest {

    private Board board;
    private RuleValidator validator;

    @BeforeEach
    void setUp() {
        int[][] map = {
                {1, 1, 2},
                {1, 2, 2},
                {3, 3, 3}
        };
        board = new Board(map);
        validator = new RuleValidator(board);
    }

    @Test
    void testHasRowConflict() {
        board.placeQueen(0, 0);
        board.placeQueen(0, 2);

        assertTrue(validator.hasRowConflict(), "It should detect a conflict on line 0");

        board.clearCell(0, 2);
        board.placeQueen(1, 2);

        assertFalse(validator.hasRowConflict(), "It should not detect conflicts with queens on different rows");
    }

    @Test
    void testHasColumnConflict() {
        board.placeQueen(0, 1);
        board.placeQueen(2, 1);

        assertTrue(validator.hasColumnConflict(), "It should detect a conflict in column 1");

        board.clearCell(2, 1);
        board.placeQueen(2, 2);

        assertFalse(validator.hasColumnConflict(), "It should not detect conflicts with queens on different columns");
    }

    @Test
    void testHasCorrectTotalQueens() {
        board.placeQueen(0, 0);
        board.placeQueen(1, 1);

        assertFalse(validator.hasCorrectTotalQueens(), "2 queens are not enough in a 3x3 grid");

        board.placeQueen(2, 2);

        assertTrue(validator.hasCorrectTotalQueens(), "3 queens should be considered correct");
    }

    @Test
    void testHasRegionConflict() {
        board.placeQueen(0, 0);
        board.placeQueen(0, 1);

        assertTrue(validator.hasRegionConflict(), "It should detect a conflict in Region 1");

        board.clearCell(0, 1);
        board.placeQueen(0, 2);

        assertFalse(validator.hasRegionConflict(), "It should not detect conflicts with queens in different regions");
    }

    @Test
    void testHasAdjacencyConflict() {
        board.placeQueen(0, 0);
        board.placeQueen(1, 1);

        assertTrue(validator.hasAdjacencyConflict(), "Two queens touching diagonally are in conflict");

        board.clearCell(1, 1);
        board.placeQueen(2, 2);

        assertFalse(validator.hasAdjacencyConflict(), "Distant queens should not create adjacency conflicts");
    }
}