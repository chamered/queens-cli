# Queens CLI 👑

A terminal-based implementation of the popular LinkedIn logic puzzle "Queens", written completely in Java. 

This project was created as a hands-on exercise to practice Object-Oriented Programming (OOP), build automation with Maven, and unit testing with JUnit.

## 🧠 What is Queens?
Queens is a logic puzzle where the goal is to place exactly one queen in each row, column, and color region of a grid. Additionally, queens cannot touch each other, not even diagonally.

## ✨ Features
* **Playable CLI Game:** An interactive console interface to place Queens (`Q`), mark Crosses (`X`), and clear cells (`C`).
* **Color-coded Grid:** The terminal UI uses ANSI escape codes to display color-coded regions just like the original puzzle.
* **Real-time Validation:** Core game engine validates rules (Rows, Columns, Regions, Adjacency) to determine if the puzzle is solved.
* **Rigorous Testing:** Comprehensive JUnit 5 test suite for game logic.

## 🚀 Technologies Used
* **Language:** Java (JDK 21+)
* **Build Tool:** Maven
* **Testing:** JUnit 5

## 🛠️ Installation and Setup
To compile and run the project locally using Maven:

```bash
mvn clean compile exec:java -Dexec.mainClass="com.github.chamered.queens.Main"
```

## 🎮 How to Play
In the terminal, use the following commands:
* `Q <row> <col>`: Place a Queen
* `X <row> <col>`: Mark a cell with a Cross
* `C <row> <col>`: Clear the cell

## 🗺️ Roadmap
- [x] Initialize Maven project structure
- [x] Implement core game logic and grid validation (Rows, Columns, Regions, Adjacency)
- [x] Write rigorous JUnit tests for the game engine
- [x] Develop the terminal-based User Interface (CLI)
- [ ] Implement level loading/generation

## 📄 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
