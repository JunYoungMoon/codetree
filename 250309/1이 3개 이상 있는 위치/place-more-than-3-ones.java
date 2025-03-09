import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];

                    if (ny >= 0 && ny < n && nx >= 0 && nx < n && arr[ny][nx] == 1) {
                        cnt++;
                    }
                }

                if (cnt >= 3) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}