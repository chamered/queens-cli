# Queens CLI 👑

[![Java CI with Maven](https://github.com/chamered/queens-cli/actions/workflows/ci.yml/badge.svg)](https://github.com/chamered/queens-cli/actions/workflows/ci.yml)

A terminal-based implementation of the popular LinkedIn logic puzzle "Queens", written completely in Java. 

This project was created as a hands-on exercise to practice Object-Oriented Programming (OOP), build automation with Maven, unit testing with JUnit, and file I/O for level loading.

## 🧠 What is Queens?
Queens is a logic puzzle where the goal is to place exactly one queen in each row, column, and color region of a grid. Additionally, queens cannot touch each other, not even diagonally.

## ✨ Features
* **Playable CLI Game:** An interactive console interface to place Queens (`Q`), mark Crosses (`X`), and clear cells (`C`).
* **Interactive Main Menu:** A beautifully designed ASCII-art menu to select levels without restarting the application.
* **Color-coded Grid:** The terminal UI uses ANSI escape codes to display color-coded regions just like the original puzzle.
* **Custom Levels (Modding):** Create and play your own maps! The game dynamically reads `.txt` files from a dedicated `levels/` folder.
* **Real-time Validation:** Core game engine validates rules (Rows, Columns, Regions, Adjacency) to determine if the puzzle is solved.
* **Rigorous Testing:** Comprehensive JUnit 5 test suite for game logic.

## 🚀 Technologies Used
* **Language:** Java (JDK 21+)
* **Build Tool:** Maven
* **Testing:** JUnit 5

## 🛠️ Installation and Setup

### Option 1: Play the Latest Release (Recommended)
1. Go to the [Releases](../../releases) page and download the latest `.zip` file.
2. Extract the folder, which contains the executable `.jar` and the required `levels/` directory.
3. Open your terminal inside the extracted folder and run:
   ```bash
   java -jar queens-cli.jar
   ```

### Option 2: Build from Source
To compile and package the project locally using Maven:
1. Clone the repository.
2. Package the application into an executable `.jar`:
   ```bash
   mvn clean package
   ```
3. Make sure you have a `levels/` directory containing at least one `.txt` map in the same folder where you execute the game.
4. Run the generated game engine:
   ```bash
   java -jar target/queens-cli-1.0-SNAPSHOT.jar
   ```

## 🎮 How to Play
In the terminal, use the following commands (case-insensitive):
* `Q <row> <col>`: Place a Queen (e.g., `Q 0 1`)
* `X <row> <col>`: Mark a cell with a Cross
* `C <row> <col>`: Clear the cell

### 🛠️ Create Your Own Levels
You can easily add new maps to the game:
1. Create a `.txt` file inside the `levels/` folder.
2. Write a square grid of numbers separated by spaces, where each number represents a colored region.
*(Note: A 5x5 grid must contain exactly 5 distinct region numbers, e.g., 0 to 4 or 1 to 5).*

## 🗺️ Roadmap
- [x] Initialize Maven project structure
- [x] Implement core game logic and grid validation (Rows, Columns, Regions, Adjacency)
- [x] Write rigorous JUnit tests for the game engine
- [x] Develop the terminal-based User Interface (CLI)
- [x] Implement interactive Main Menu and level loading from text files
- [ ] Implement level generation

## 📄 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
