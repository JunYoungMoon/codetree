import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, m;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        visited[0][0] = true;
        queue.offer(new Point(0, 0));
        int answer = BFS();

        System.out.println(answer);
    }

    public static int BFS() {
        while (!queue.isEmpty()) {
            Point currPoint = queue.poll();

            int x = currPoint.x;
            int y = currPoint.y;

            if (x == n - 1 && y == m - 1) {
                return 1;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (canGo(nextX, nextY)) {
                    visited[nextX][nextY] = true;
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }
        return 0;
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
        return x >= 0 && y >= 0 && x < n && y < m && grid[x][y] != 0;
    }
}
