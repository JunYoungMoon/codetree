import java.util.Scanner;

public class Main {

    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};
    public static int x = 0, y = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        int move = 0;
        int nx;
        int ny;

        arr[x][y] = 1;
        for (int i = 2; i <= n * m; i++) {
            nx = x + dx[move];
            ny = y + dy[move];

            if (!(0 <= nx && nx < n && 0 <= ny && ny < m) || arr[nx][ny] != 0) {
                move = (move + 1) % 4;
            }

            x = x + dx[move];
            y = y + dy[move];

            arr[x][y] = i;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}