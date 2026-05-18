package com.github.chamered.queens.core;

public class Board {

    private final int gridSize;
    private final Cell[][] grid;

    public Board(int[][] regionMap) {
        this.gridSize = regionMap.length;
        this.grid = new Cell[gridSize][gridSize];

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                int regionId = regionMap[row][col];

                grid[row][col] = new Cell(row, col, regionId);
            }
        }
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public int getGridSize() {
        return gridSize;
    }
}
