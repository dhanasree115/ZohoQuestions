package Minesweeper;

public class MinesweeperImplementation {
	public static void initializeGrid(int n, int m, char[][] grid, boolean[][] revealed) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = '-';
                revealed[i][j] = false;
            }
        }
    }

    public static void placeMines(int n, int m, int mines, char[][] grid) {
        int count = 0;
        while (count < mines) {
            int row = (int) (Math.random() * n);
            int col = (int) (Math.random() * m);
            if (grid[row][col] != 'M') {
                grid[row][col] = 'M';
                count++;
            }
        }
    }

    public static boolean isValidCell(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public static void calculateAdjacent(int n, int m, char[][] grid) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'M') continue;
                int count = 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (isValidCell(i + x, j + y, n, m) && grid[i + x][j + y] == 'M') {
                            count++;
                        }
                    }
                }
                if (count > 0) {
                    grid[i][j] = (char) (count + '0');  
                }
            }
        }
    }

    public static void revealCell(int row, int col, char[][] grid, boolean[][] revealed) {
        if (!isValidCell(row, col, grid.length, grid[0].length) || revealed[row][col]) {
            return;
        }
        revealed[row][col] = true;
        if (grid[row][col] == '-') {  
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    revealCell(row + x, col + y, grid, revealed);
                }
            }
        }
    }

    public static boolean isGameWon(int n, int m, boolean[][] revealed, int mines) {
        int revealedCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (revealed[i][j]) {
                    revealedCount++;
                }
            }
        }
        return revealedCount == (n * m - mines);  
    }

    public static void printGrid(int n, int m, char[][] grid, boolean[][] revealed) {
        System.out.print("   ");
        for (int j = 0; j < m; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < m; j++) {
                if (!revealed[i][j]) {
                    System.out.print("- ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}