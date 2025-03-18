import java.util.Scanner;

public class Main {

    public static int[] dx = new int[]{0, -1, 0, 1};
    public static int[] dy = new int[]{1, 0, -1, 0};

    public static int n;

    public static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        int x = n / 2;
        int y = n / 2;

        int[][] grid = new int[n][n];
        int dir = 0; int moveNum = 1;

        int cnt = 1;
        while (isRange(x,y)) {

            for(int i = 0; i < moveNum ; i++){
                grid[x][y] = cnt++;

                x = x + dx[dir];
                y = y + dy[dir];
            }

            dir = (dir + 1) % 4;

            if(dir == 0 || dir == 2){
                moveNum++;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
}