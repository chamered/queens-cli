package com.github.chamered.queens.ui;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuTest {

    @Test
    void testExitCommandReturnsNull() {
        Scanner scanner = new Scanner("/exit\n");
        MainMenu menu = new MainMenu(scanner);

        assertNull(menu.showAndSelectLevel());
    }
}
