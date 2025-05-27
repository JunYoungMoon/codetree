import java.util.Scanner;

public class Main {
    public static int[][] arr;
    public static boolean[][] visited;
    public static int n, maxBlockSize, blockCnt, burstBlockCnt;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && arr[i][j] > 0){
                    visited[i][j] = true;
                    blockCnt = 1;
                    DFS(i, j);
                    if (blockCnt >= 4) {
                        burstBlockCnt++;
                    }

                    maxBlockSize = Math.max(blockCnt, maxBlockSize);
                }
            }
        }
        System.out.println(burstBlockCnt + " " + maxBlockSize);
    }

    public static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (canGo(nextX, nextY, x, y)) {
                visited[nextX][nextY] = true;
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
        if (visited[nextX][nextY]) {
            return false;
        }

        return true;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
