package com.github.chamered.queens.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void testCellInitialization() {
        Cell cell = new Cell(2, 3, 1);

        assertEquals(2, cell.getRow(), "The row should be 2");
        assertEquals(3, cell.getCol(), "The column should be 3");
        assertEquals(1, cell.getRegionId(), "The region ID should be 1");
        assertTrue(cell.isEmpty(), "A new cell must be always empty by default");
    }

    @Test
    void testCellStateChange() {
        Cell cell = new Cell(0, 0, 1);

        cell.setState(CellState.QUEEN);

        assertTrue(cell.isQueen(), "The cell should contain a queen");
        assertFalse(cell.isEmpty(), "The cell should no longer be empty");
    }
}