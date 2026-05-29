package com.github.chamered.queens.core;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents the game board for the Queens logic puzzle.
 * Responsible for initializing the grid layout based on a given region map
 * and managing the placement or removal of queens and crosses.
 */
public class Board {

    private final int gridSize;
    private final Cell[][] grid;
    private final Set<Integer> regions;

    public Board(int[][] regionMap) {
        this.gridSize = regionMap.length;
        this.grid = new Cell[gridSize][gridSize];
        this.regions = new HashSet<>();

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                int regionId = regionMap[row][col];
                regions.add(regionId);
                grid[row][col] = new Cell(row, col, regionId);
            }
        }
    }

    public Cell getCell(int row, int col) {
        if (isCellOutOfBounds(row, col)) {
            return null;
        }
        return grid[row][col];
    }

    public int getGridSize() {
        return gridSize;
    }

    public int getRegionsCount() {
        return regions.size();
    }

    public boolean placeQueen(int row, int col) {
        if (isCellOutOfBounds(row, col)) {
            return false;
        }

        grid[row][col].setState(CellState.QUEEN);
        return true;
    }

    public boolean placeCross(int row, int col) {
        if (isCellOutOfBounds(row, col)) {
            return false;
        }

        grid[row][col].setState(CellState.CROSSED);
        return true;
    }

    public boolean clearCell(int row, int col) {
        if (isCellOutOfBounds(row, col)) {
            return false;
        }

        grid[row][col].setState(CellState.EMPTY);
        return true;
    }

    boolean isCellOutOfBounds(int row, int col) {
        return row < 0 || row >= gridSize || col < 0 || col >= gridSize;
    }
}
