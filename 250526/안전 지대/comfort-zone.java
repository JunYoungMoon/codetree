import java.util.Scanner;

public class Main {

    public static int n, m;
    public static int[][] arr;
    public static int[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        visited = new int[n][m];

        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();

                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        int maxZone = 0;
        int answerK = 0;

        for (int k = 1; k < maxHeight ; k++) {
            int zoneCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (k < arr[i][j] && visited[i][j] == 0) {
                        DFS(i, j, k);
                        zoneCount++;
                    }
                }
            }

            if (zoneCount > maxZone) {
                maxZone = zoneCount;
                answerK = k;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    visited[i][j] = 0;
                }
            }
        }

        System.out.println(answerK + " " + maxZone);
    }

    public static void DFS(int x, int y, int k) {
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m
                    && k < arr[nextX][nextY] && visited[nextX][nextY] == 0) {
                DFS(nextX, nextY, k);
            }
        }
    }
}
