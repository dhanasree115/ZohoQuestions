package Minesweeper;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
        System.out.println("Enter the number of rows:");
        int n = input.nextInt();
        System.out.println("Enter the number of columns:");
        int m = input.nextInt();
        System.out.println("Enter the number of mines:");
        int mines = input.nextInt();
        char[][] grid = new char[n][m];
        boolean[][] revealed = new boolean[n][m];
        MinesweeperImplementation.initializeGrid(n, m, grid, revealed);
        MinesweeperImplementation.placeMines(n, m, mines, grid);
        MinesweeperImplementation.calculateAdjacent(n, m, grid);
        while (true) {
        	MinesweeperImplementation.printGrid(n, m, grid, revealed);
            System.out.println("Enter a row number:");
            int row = input.nextInt();
            System.out.println("Enter a column number:");
            int col = input.nextInt();
            if (!MinesweeperImplementation.isValidCell(row, col, n, m)) {
                System.out.println("Invalid cell. Try again.");
                continue;
            }
            if (grid[row][col] == 'M') {
                System.out.println("Game Over! You hit a mine.");
                break;
            }
            MinesweeperImplementation.revealCell(row, col, grid, revealed);
            if (MinesweeperImplementation.isGameWon(n, m, revealed, mines)) {
                System.out.println("Congratulations! You won.");
                break;
            }
        }
       input.close();
	}

}
