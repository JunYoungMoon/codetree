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

    public static int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
    public static int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};
    public static int n, r1, c1, r2, c2;
    public static int[][] step;
    public static boolean[][] visited;
    public static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        r1 = sc.nextInt() - 1;
        c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;

        step = new int[n][n];
        visited = new boolean[n][n];

        queue.offer(new Pair(r1, c1));
        visited[r1][c1] = true;

        BFS();

        if (visited[r2][c2]) {
            System.out.println(step[r2][c2]);
        } else {
            System.out.println(-1);
        }
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            int currX = pair.x;
            int currY = pair.y;

            for (int i = 0; i < 8; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (canGo(nextX, nextY)) {
                    queue.offer(new Pair(nextX, nextY));
                    visited[nextX][nextY] = true;
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
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
