import java.util.Scanner;

public class Main {
    public static int[][] arr;
    public static int[][] visited;
    public static int n, maxBlockSize, blockCnt, burstBlockCnt;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                blockCnt = 1;
                DFS(i, j);
                if (blockCnt >= 4) {
                    burstBlockCnt++;
                }
                if (blockCnt > maxBlockSize) {
                    maxBlockSize = blockCnt;
                }
            }
        }
        System.out.println(burstBlockCnt + " " + maxBlockSize);
    }

    public static void DFS(int x, int y) {
        visited[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (canGo(nextX, nextY, x, y)) {
                blockCnt++;
                DFS(nextX, nextY);
            }
        }
    }

    public static boolean canGo(int nextX, int nextY, int currX, int currY) {
        if (!inRange(nextX, nextY)) {
            return false;
        }
        if (arr[currX][currY] != arr[nextX][nextY]) {
            return false;
        }
        if (visited[nextX][nextY] == 1) {
            return false;
        }

        return true;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}