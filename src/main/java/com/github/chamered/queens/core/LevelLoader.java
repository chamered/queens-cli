package com.github.chamered.queens.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LevelLoader {

    /**
     * Loads a level from a text file and converts it to an array of integers.
     *
     * @param filePath The file path (e.g., "levels/level1.txt")
     * @return The level map as an int[][]
     * @throws IOException If the file doesn't exist or can't be read
     */
    public static int[][] loadLevel(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(filePath));

        if (lines.isEmpty()) {
            throw new IllegalArgumentException("The level file is empty.");
        }

        int gridSize = lines.size();
        int[][] regionMap = new int[gridSize][gridSize];

        int row = 0;
        for (String line : lines) {
            String[] col = line.trim().split("\\s+");

            if (col.length != gridSize) {
                throw new IllegalArgumentException("Error at line " + row + ": there are " + col.length + " columns instead of " + gridSize);
            }

            for (int i = 0; i < gridSize; i++) {
                regionMap[row][i] = Integer.parseInt(col[i]);
            }
            row++;
        }

        return regionMap;
    }
}
