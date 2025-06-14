import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


class Cell /*implements Comparable<Cell> */ {
    int x, y, num;

    public Cell(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }

//    @Override
//    public int compareTo(Cell c) {
//        return this.num - c.num;
//    }
}

public class Main {

    public static int n,ans;
    public static int[][] grid, dp;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static ArrayList<Cell> cells = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                dp[i][j] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells.add(new Cell(i, j, grid[i][j]));
            }
        }

        cells.sort(Comparator.comparing(cell -> cell.num));

        for (int i = 0; i < cells.size(); i++) {
            int x = cells.get(i).x;
            int y = cells.get(i).y;

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (inRange(nx, ny) && grid[nx][ny] > grid[x][y]) {
                    if (dp[nx][ny] <= dp[x][y]) {
                        dp[nx][ny] = dp[x][y] + 1;

                        ans = Math.max(ans, dp[nx][ny]);
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}