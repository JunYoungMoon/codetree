import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, k, s1, s2;
    public static int[][] grid;
    public static Queue<Point> queue = new LinkedList<>();
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int answerCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            s1 = sc.nextInt() - 1;
            s2 = sc.nextInt() - 1;

            if (!visited[s1][s2] && grid[s1][s2] == 0) {
                if (s1 == 0 && s2 == 0) {
                    answerCnt++;
                    break;
                }
                queue.offer(new Point(s1, s2));
                BFS();
            }
        }

        System.out.println(answerCnt);
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int currX = point.x;
            int currY = point.y;

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (canGo(nextX, nextY)) {
                    answerCnt++;
                    visited[nextX][nextY] = true;
                    queue.offer(new Point(nextX, nextY));
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
        return x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 0;
    }
}
