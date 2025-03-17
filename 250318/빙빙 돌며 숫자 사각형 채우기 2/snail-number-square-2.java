import java.util.Scanner;

public class Main {
public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        int dir = 1;

        int x = 0, y = 0;

        int count = 1;
        for (int i = 0; i < n * m; i++) {

            arr[x][y] = count++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!(nx >= 0 && nx < n && ny >= 0 && ny < m) || arr[nx][ny] > 0) {
                dir = (dir + 1) % 4;

                x = x + dx[dir];
                y = y + dy[dir];
            } else {
                x = nx;
                y = ny;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}