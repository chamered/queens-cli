package com.github.chamered.queens.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class LevelLoaderTest {

    @TempDir
    Path tempDir;

    @Test
    void testLoadValidLevel() throws Exception {
        Path file = tempDir.resolve("valid.txt");
        Files.writeString(file, "1 2\n3 4\n");

        int[][] result = LevelLoader.loadLevel(file.toString());

        assertEquals(2, result.length);
        assertEquals(1, result[0][0]);
        assertEquals(2, result[0][1]);
        assertEquals(3, result[1][0]);
        assertEquals(4, result[1][1]);
    }

    @Test
    void testLoadEmptyFile() throws Exception {
        Path file = tempDir.resolve("empty.txt");
        Files.createFile(file);

        assertThrows(LevelLoadException.class, () -> LevelLoader.loadLevel(file.toString()));
    }

    @Test
    void testLoadMalformedFile() throws Exception {
        Path file = tempDir.resolve("bad.txt");
        Files.writeString(file, "1 2\n3\n");

        assertThrows(LevelLoadException.class, () -> LevelLoader.loadLevel(file.toString()));
    }

    @Test
    void testLoadNonExistentFile() {
        assertThrows(LevelLoadException.class, () -> LevelLoader.loadLevel("/nonexistent/file.txt"));
    }
}
