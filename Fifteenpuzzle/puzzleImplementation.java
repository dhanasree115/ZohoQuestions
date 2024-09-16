package Fifteenpuzzle;

import java.util.Random;

public class puzzleImplementation {
    public static void initializePuzzle(int n, int m, int[][] tiles) {
        int tile = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tile == n * m) {
                    tiles[i][j] = 0; 
                } else {
                    tiles[i][j] = tile++;
                }
            }
        }
        shuffle(tiles, n, m);  
        printPuzzle(n, m, tiles);
    }
    public static void shuffle(int[][] tiles, int n, int m) {
        Random rand = new Random();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int i1 = rand.nextInt(i + 1);
                int j1 = rand.nextInt(m);
                int temp = tiles[i][j];
                tiles[i][j] = tiles[i1][j1];
                tiles[i1][j1] = temp;
            }
        }
    }
    public static boolean isValid(int[][] tiles, int n, int m, int value) {
        int blankRow = -1, blankCol = -1;
        int tileRow = -1, tileCol = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tiles[i][j] == 0) {
                    blankRow = i;
                    blankCol = j;
                }
                if (tiles[i][j] == value) {
                    tileRow = i;
                    tileCol = j;
                }
            }
        }
        return (tileCol == blankCol && Math.abs(tileRow - blankRow) == 1)
                || (tileRow == blankRow && Math.abs(tileCol - blankCol) == 1);
    }
    public static void makeMove(int n, int m, int[][] tiles, int value) {
        int blankRow = -1, blankCol = -1;
        int tileRow = -1, tileCol = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tiles[i][j] == 0) {
                    blankRow = i;
                    blankCol = j;
                }
                if (tiles[i][j] == value) {
                    tileRow = i;
                    tileCol = j;
                }
            }
        }
        tiles[blankRow][blankCol] = value;
        tiles[tileRow][tileCol] = 0;
        printPuzzle(n, m, tiles);
    }
    public static void printPuzzle(int n, int m, int[][] tiles) {
        System.out.println("Current puzzle:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(tiles[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
