package com.github.chamered.queens.core;

public class ANSIColors {

    private static final String[] TEXT_COLORS = {
            "\u001B[39m", // Default
            "\u001B[30m", // Black
            "\u001B[31m", // Red
            "\u001B[32m", // Green
            "\u001B[33m", // Yellow
            "\u001B[34m", // Blue
            "\u001B[35m", // Purple
            "\u001B[36m", // Cyan
            "\u001B[37m"  // White
    };
    private static final String[] BACKGROUNDS_COLORS = {
            "\u001B[49m", // Default
            "\u001B[40m", // Black
            "\u001B[41m", // Red
            "\u001B[42m", // Green
            "\u001B[43m", // Yellow
            "\u001B[44m", // Blue
            "\u001B[45m", // Purple
            "\u001B[46m", // Cyan
            "\u001B[47m"  // White
    };

    /**
     * 0. Default
     * 1. Black
     * 2. Red
     * 3. Green
     * 4. Yellow
     * 5. Blue
     * 6. Purple
     * 7. Cyan
     * 8. White
     * @return Corresponding ANSI Color Escape Code
     */
    public static String getTextColor(int index) {
        try {
            return TEXT_COLORS[index];
        } catch (Exception e) {
            return TEXT_COLORS[0];
        }
    }

    /**
     * 0. Default
     * 1. Black
     * 2. Red
     * 3. Green
     * 4. Yellow
     * 5. Blue
     * 6. Purple
     * 7. Cyan
     * 8. White
     * @return Corresponding ANSI Color Escape Code
     */
    public static String getBackgroundColor(int index) {
        try {
            return BACKGROUNDS_COLORS[index];
        } catch (Exception e) {
            return BACKGROUNDS_COLORS[0];
        }
    }
}
