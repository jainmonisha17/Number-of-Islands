import java.util.*;

public class numOfIslands {

    public void bfs(int ro, int co, int[][] visited, char[][] grid) {
        visited[ro][co] = 1;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;

        // until queue becomes empty

        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            // traverse the neighbours & mark them if land

            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int neighbourRow = row + delRow;
                    int neighbourCol = col + delCol;

                    // check if neightbour row and neighbour col is valid and unvisited

                    if (neighbourRow >= 0 && neighbourRow < n &&
                            neighbourCol >= 0 && neighbourCol < m &&
                            grid[neighbourRow][neighbourCol] == '1' &&
                            visited[neighbourRow][neighbourCol] == 0) {

                        visited[neighbourRow][neighbourCol] = 1;
                        queue.add(new Pair(neighbourRow, neighbourCol));

                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] visited = new int[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {

                if (visited[row][col] == 0 && grid[row][col] == '1') {
                    count++;
                    bfs(row, col, visited, grid);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '0', '1', '1', '1', '0', '0', '0' },
                { '0', '0', '1', '1', '0', '1', '0' }
        };

        numOfIslands obj = new numOfIslands();
        System.out.println(obj.numIslands(grid));
    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
