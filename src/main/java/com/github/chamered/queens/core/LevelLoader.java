package com.github.chamered.queens.core;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LevelLoader {

    public static int[][] loadLevel(String filePath) throws LevelLoadException {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(filePath));
        } catch (Exception e) {
            throw new LevelLoadException("Unable to read level file: " + filePath, e);
        }

        if (lines.isEmpty()) {
            throw new LevelLoadException("The level file is empty.");
        }

        int gridSize = lines.size();
        int[][] regionMap = new int[gridSize][gridSize];

        int row = 0;
        for (String line : lines) {
            String[] col = line.trim().split("\\s+");

            if (col.length != gridSize) {
                throw new LevelLoadException("Error at line " + row + ": there are " + col.length + " columns instead of " + gridSize);
            }

            for (int i = 0; i < gridSize; i++) {
                regionMap[row][i] = Integer.parseInt(col[i]);
            }
            row++;
        }

        return regionMap;
    }
}
