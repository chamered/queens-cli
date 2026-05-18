package com.github.chamered.queens.core;

import java.util.HashMap;
import java.util.Map;

public class RuleValidator {

    private final Board board;

    public RuleValidator(Board board) {
        this.board = board;
    }

    public boolean isGameWon() {
        return hasCorrectTotalQueens() &&
                !hasRowConflict() &&
                !hasColumnConflict() &&
                !hasRegionConflict() &&
                !hasAdjacencyConflict();
    }

    boolean hasCorrectTotalQueens() {
        int gridSize = board.getGridSize();
        int queenCount = 0;

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Cell cell = board.getCell(i, j);
                queenCount = cell.isQueen() ? queenCount + 1 : queenCount;
            }
        }

        return queenCount == board.getRegionsCount();
    }

    boolean hasRowConflict() {
        int gridSize = board.getGridSize();
        int queenCount = 0;

        for (int i = 0; i < gridSize; i++) {
            queenCount = 0;
            for (int j = 0; j < gridSize; j++) {
                if (board.getCell(i, j).isQueen()) queenCount++;
                if (queenCount > 1) return true;
            }
        }

        return false;
    }

    boolean hasColumnConflict() {
        int gridSize = board.getGridSize();
        int queenCount = 0;

        for (int i = 0; i < gridSize; i++) {
            queenCount = 0;
            for (int j = 0; j < gridSize; j++) {
                if (board.getCell(j, i).isQueen()) queenCount++;
                if (queenCount > 1) return true;
            }
        }

        return false;
    }

    boolean hasRegionConflict() {
        Map<Integer, Integer> regionConflicts = new HashMap<>();
        int gridSize = board.getGridSize();

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Cell cell = board.getCell(i, j);
                if (cell.isQueen()) {
                    int regionId = cell.getRegionId();
                    int count = regionConflicts.getOrDefault(regionId, 0) + 1;
                    if (count > 1) return true;
                    regionConflicts.put(regionId, count);
                }
            }
        }

        return false;
    }

    boolean hasAdjacencyConflict() {
        int gridSize = board.getGridSize();

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (board.getCell(i, j).isQueen()) {
                    for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
                        for (int colOffset = -1; colOffset <= 1; colOffset++) {
                            if (rowOffset == 0 && colOffset == 0) continue;

                            int neighborRow = i + rowOffset;
                            int neighborCol = j + colOffset;

                            if (!board.isCellOutOfBounds(neighborRow, neighborCol) &&
                                    board.getCell(neighborRow, neighborCol).isQueen()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}
