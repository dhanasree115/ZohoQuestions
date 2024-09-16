package Fifteenpuzzle;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        puzzleImplementation puzzle = new puzzleImplementation();
        int n = 4;
        int m = 4;
        int[][] tiles = new int[n][m];
        puzzle.initializePuzzle(n, m, tiles);   
        while (true) {
            int[][] winningTiles = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
            if (Arrays.deepEquals(tiles, winningTiles)) {
                System.out.println("You won!!");
                break;
            }
            System.out.print("Enter the tile to move: ");
            int value = input.nextInt();
            if (value == -1) {
                System.out.println("Exiting game");
                break;
            }
            if (value < 1 || value > 15) {
                System.out.println("Enter a valid number between 1 and 15");
                continue;
            }
            if (puzzle.isValid(tiles, n, m, value)) {
                puzzle.makeMove(n, m, tiles, value);
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
        input.close();
    }
}
