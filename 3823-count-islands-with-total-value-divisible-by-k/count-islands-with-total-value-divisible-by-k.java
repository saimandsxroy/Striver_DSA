import java.util.*;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (grid[row][col] > 0) {
                    int remainder = dfs(row, col, grid, k);

                    if (remainder == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private int dfs(int row, int col, int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        Deque<Integer> stack = new ArrayDeque<>();

        int remainder = grid[row][col] % k;

        grid[row][col] = -1;
        stack.push(row * n + col);

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!stack.isEmpty()) {
            int cell = stack.pop();

            int r = cell / n;
            int c = cell % n;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] > 0) {

                    remainder =
                        (remainder + grid[nr][nc] % k) % k;

                    grid[nr][nc] = -1;
                    stack.push(nr * n + nc);
                }
            }
        }

        return remainder;
    }
}