import java.util.Scanner;

public class Main {
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        char[] cArr = new char[t];

        String str = sc.next();

        for (int i = 0; i < t; i++) {
           cArr[i]  = str.charAt(i);
        }

        int x = n / 2;
        int y = n / 2;

        int dir = 2;

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int ans = grid[x][y];
        for (char c : cArr) {
            if (c == 'F') {
                //해당 방향으로 한칸 이동
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    x = nx;
                    y = ny;
                    ans += grid[nx][ny];
                }
            } else if (c == 'R') {
                //오른쪽 방향만 회전
                dir = (dir + 1) % 4;
            } else if (c == 'L') {
                //왼쪽 방향만 회전
                dir = (dir + 3) % 4;
            }
        }

        System.out.println(ans);
    }
}