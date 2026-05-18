package com.github.chamered.queens.core;

public class Cell {

    private final int row;
    private final int col;
    private final int regionId;
    private CellState state;

    public Cell(int row, int col, int regionId) {
        this.row = row;
        this.col = col;
        this.regionId = regionId;
        this.state = CellState.EMPTY;
    }

    // Getters
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getRegionId() {
        return regionId;
    }

    public CellState getState() {
        return state;
    }

    // Setter
    public void setState(CellState state) {
        this.state = state;
    }

    // Helper methods
    public boolean isQueen() {
        return state == CellState.QUEEN;
    }

    public boolean isEmpty() {
        return state == CellState.EMPTY;
    }

    public boolean isCrossed() {
        return state == CellState.CROSSED;
    }
}
