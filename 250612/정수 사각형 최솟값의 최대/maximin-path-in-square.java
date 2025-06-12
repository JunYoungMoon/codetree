package com.mjyAfter.mjy20250612;

import java.util.Scanner;

class Grid {
    private final int size;
    private final int[][] data;

    public Grid(int size) {
        this.size = size;
        this.data = new int[size][size];
    }

    public void setValue(int row, int col, int value) {
        validateCoordinates(row, col);
        data[row][col] = value;
    }

    public int getValue(int row, int col) {
        validateCoordinates(row, col);
        return data[row][col];
    }

    public int getSize() {
        return size;
    }

    private void validateCoordinates(int row, int col) {
        if (row <= 0 && row >= size && col <= 0 && col >= size) {
            throw new IllegalArgumentException("잘못된 좌표: (" + row + ", " + col + ")");
        }
    }
}

class MaxMinPathFinder {
    private final Grid grid;
    private final int[][] dp;

    public MaxMinPathFinder(Grid grid) {
        this.grid = grid;
        this.dp = new int[grid.getSize()][grid.getSize()];
    }

    public int findMaximumMinimumPath() {
        initializeDP();
        calculateOptimalPath();
        return dp[grid.getSize() - 1][grid.getSize() - 1];
    }

    private void initializeDP() {
        int size = grid.getSize();

        dp[0][0] = grid.getValue(0, 0);

        for (int col = 1; col < size; col++) {
            dp[0][col] = Math.min(dp[0][col - 1], grid.getValue(0, col));
        }

        for (int row = 1; row < size; row++) {
            dp[row][0] = Math.min(dp[row - 1][0], grid.getValue(row, 0));
        }
    }

    private void calculateOptimalPath() {
        int size = grid.getSize();

        for (int row = 1; row < size; row++) {
            for (int col = 1; col < size; col++) {
                int fromTop = dp[row - 1][col];
                int fromLeft = dp[row][col - 1];
                int currentValue = grid.getValue(row, col);

                dp[row][col] = Math.min(Math.max(fromTop, fromLeft), currentValue);
            }
        }

    }

    public void printDPTable() {
        for (int i = 0; i < grid.getSize(); i++) {
            for (int j = 0; j < grid.getSize(); j++) {
                System.out.print(grid.getValue(i, j) + " ");
            }
            System.out.println();
        }
    }
}

class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public Grid readGrid() {
        int size = scanner.nextInt();

        Grid grid = new Grid(size);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int value = scanner.nextInt();
                grid.setValue(row, col, value);
            }
        }
        return grid;
    }

    public void close(){
        scanner.close();
    }
}


public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        Grid grid = inputHandler.readGrid();

        MaxMinPathFinder pathFinder = new MaxMinPathFinder(grid);
        int result = pathFinder.findMaximumMinimumPath();

        System.out.println(result);
    }
}