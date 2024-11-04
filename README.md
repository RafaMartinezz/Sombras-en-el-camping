# Camping Shadow Detection

This Java project calculates the shaded areas around trees in a camping grid. Each tree casts a "shadow" on adjacent camping plots, which are represented as empty parcels in a grid. The program uses a grid-based approach to count the shaded plots around each tree and outputs the total shaded area for a given camping site layout.

## Table of Contents

- [Overview](#overview)
- [Purpose](#purpose)
- [Features](#features)
- [Class Structure](#class-structure)
- [Input Format](#input-format)
- [Example Input and Output](#example-input-and-output)
- [Explanation](#explanation)

---

## Overview

The program takes grid dimensions, tree coordinates, and the number of trees as input. It then constructs a camping grid, placing trees at specified coordinates and calculating the shaded areas around them. The shaded areas include all adjacent plots (horizontally, vertically, and diagonally) that are not occupied by another tree or already shaded.

## Purpose

This project serves as a **learning exercise** in:
- Handling **2D arrays** to represent a camping grid and track shaded plots.
- Using **nested loops** to iterate over adjacent cells within grid boundaries.
- Applying **coordinate transformations** to dynamically calculate affected areas around points.
- Practicing **conditional logic** to manage grid boundaries and shaded plot counts.

## Features

- **Grid Representation**: Uses a 2D array to represent camping plots, with values indicating empty plots, tree locations, and shaded areas.
- **Shaded Area Calculation**: For each tree, the program counts all adjacent empty plots and marks them as shaded to avoid duplicate counting.
- **Flexible Input**: Processes multiple grids and trees in a single run, continuing until a termination input (`0 0 0`) is provided.

## Class Structure

- **`App`**: Main class that reads input, initializes the grid, and handles shaded area calculations.
  - **`buscadorSombras`**: A helper method that, for a given tree location, checks adjacent cells and counts empty cells as shaded.

## Input Format

1. **Grid Dimensions**: Two integers representing the number of columns and rows.
2. **Number of Trees**: An integer specifying the number of trees.
3. **Tree Coordinates**: Pairs of integers indicating the (column, row) coordinates for each tree in the grid.
4. **Termination Input**: A `0 0 0` input sequence signals the end of input and terminates the program.

### Example

```plaintext
Input:
4 4 2
1 2
3 3
0 0 0

Output:
10
```

## Example Input and Output

### Input

```plaintext
4 4 2
1 2
3 3
0 0 0
```

### Output

```plaintext
10
```

### Explanation

- **Input**:
  - A 4x4 grid with 2 trees located at coordinates (1, 2) and (3, 3).
- **Output**:
  - The total shaded area is 10 plots.

## Explanation

The program works as follows:
1. **Initialize Grid**: Based on input dimensions and tree locations, it creates a grid with trees positioned at specific coordinates.
2. **Shaded Area Calculation**:
   - For each tree, the `buscadorSombras` method iterates over adjacent cells.
   - Each adjacent empty plot is counted as shaded and marked to avoid recounting.
3. **Result Display**:
   - After calculating shaded plots for all trees, the program outputs the total shaded area for the grid.
   - The program repeats this process until the user inputs `0 0 0`.

