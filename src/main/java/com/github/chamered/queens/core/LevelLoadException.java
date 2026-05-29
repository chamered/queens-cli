package com.github.chamered.queens.core;

public class LevelLoadException extends Exception {
    public LevelLoadException(String message) {
        super(message);
    }

    public LevelLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
