import java.util.Scanner;

public class Main {

    public static final int MAX_N = 15;

    public static int n, m;
    public static char[][] grid = new char[MAX_N][MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.next().charAt(0);
            }

        int cnt = 0;
        for(int i = 1; i < n; i++)
            for(int j = 1; j < m; j++)
                for(int k = i + 1; k < n - 1; k++)
                    for(int l = j + 1; l < m - 1; l++)
                        // 그 중 색깔이 전부 달라지는 경우에만 개수를 세줍니다.
                        if(grid[i][j] != grid[k][l])
                            cnt++;

        System.out.println(cnt);
    }
}