import java.util.*;

class Pair {
    int x, y, step;

    public Pair(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}

public class Main {
    public static int n, k;
    public static int[][] grid;
    public static int[][] step;
    public static boolean[][] visited;
    public static Queue<Pair> queue = new LinkedList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        grid = new int[n][n];
        step = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 0) {
                    step[i][j] = -1;
                }

                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        BFS();

        printStep();
    }

    public static void printStep() {
        for (int i = 0; i < step.length; i++) {
            for (int j = 0; j < step.length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    System.out.print(-2 + " ");
                } else {
                    System.out.print(step[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            int currX = pair.x;
            int currY = pair.y;
            int currStep = pair.step;

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (canGo(nextX, nextY)) {
                    visited[nextX][nextY] = true;
                    queue.offer(new Pair(nextX, nextY, currStep + 1));
                    step[nextX][nextY] = currStep + 1;
                }
            }
        }
    }

    public static boolean canGo(int x, int y) {
        if (!inRange(x, y)) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        return true;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 1;
    }
}
