import java.util.Scanner;

public class Main {

    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][n];
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {

            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;

            arr[r][c] = 1;

            int count = 0;
            for (int j = 0; j < 4; j++) {
                int nx = r + dx[j];
                int ny = c + dy[j];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1) {
                    count++;

                    if (count == 3) {
                        ans[i] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(ans[i]);
        }
    }
}