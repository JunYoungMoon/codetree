import java.util.Scanner;

public class Main {

    public static int n, m;
    public static int[] dx = {0, 1};
    public static int[] dy = {1, 0};
    public static int[][] arr;
    public static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = sc.nextInt();
                arr[i][j] = v;
            }
        }

        DFS(0, 0);
        System.out.println(answer);
    }

    public static void DFS(int x, int y) {
        arr[x][y] = 0;

        if (x == n - 1 && y == m - 1) {
            answer = 1;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m && arr[nextX][nextY] == 1) {
                DFS(nextX, nextY);
            }
        }
    }
}
