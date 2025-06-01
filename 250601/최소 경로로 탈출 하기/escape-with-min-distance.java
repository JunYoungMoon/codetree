import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, m;
    public static int[][] grid;
    public static int[][] step;
    public static boolean[][] visited;
    public static Queue<Pair> queue = new LinkedList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        step = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        BFS();

        int answer = -1;

        if (visited[n - 1][m - 1]) {
            System.out.println(step[n - 1][m - 1]);
        } else {
            System.out.println(answer);
        }

    }

    public static void BFS() {
        visited[0][0] = true;
        queue.offer(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int currX = pair.x;
            int currY = pair.y;

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (canGo(nextX, nextY)) {
                    visited[nextX][nextY] = true;
                    queue.offer(new Pair(nextX, nextY));
                    step[nextX][nextY] = step[currX][currY] + 1;
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
        return x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1;
    }
}
