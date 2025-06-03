import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int n, k, r1, c1, r2, c2;
    public static int ans = Integer.MAX_VALUE;
    public static int[][] grid, step;
    public static boolean[][] visited;
    public static List<Pair> wallList = new ArrayList<>();
    public static List<Pair> selectWallList = new ArrayList<>();
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
                if (grid[i][j] == 1) {
                    wallList.add(new Pair(i, j));
                }
            }
        }

        r1 = sc.nextInt() - 1;
        c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;

        combination(0, 0);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static void combination(int idx, int cnt) {
        if (k == cnt) {
            BFS();

            if (visited[r2][c2]) {
                ans = Math.min(ans, step[r2][c2]);
            }
            return;
        }

        if (idx == wallList.size()) {
            return;
        }

        combination(idx + 1, cnt);

        selectWallList.add(wallList.get(idx));
        combination(idx + 1, cnt + 1);
        selectWallList.remove(selectWallList.size() - 1);
    }

    public static void BFS() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
                step[i][j] = 0;
            }
        }

        queue.offer(new Pair(r1, c1));
        visited[r1][c1] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            int currX = pair.x;
            int currY = pair.y;

            for (int i = 0; i < 4; i++) {
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

        for (int i = 0; i < selectWallList.size(); i++) {
            if (selectWallList.get(i).x == x && selectWallList.get(i).y == y) {
                return true;
            }
        }

        if(grid[x][y] == 1){
            return false;
        }

        return true;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
