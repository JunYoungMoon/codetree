import java.util.Scanner;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main2 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int n, cnt, time;

    public static int[][] arr = new int[100][100];
    public static int[][] count = new int[100][100];
    public static int[][] nextCount = new int[100][100];

    public static void simulate() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextCount[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == 1) {
                    int nextX, nextY;
                    int maxNum = 0;
                    Pair maxPos = new Pair(-1, -1);

                    for (int k = 0; k < 4; k++) {
                        nextX = i + dx[k];
                        nextY = j + dy[k];

                        if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && arr[nextX][nextY] > maxNum) {
                            maxNum = arr[nextX][nextY];
                            maxPos = new Pair(nextX, nextY);
                        }
                    }

                    nextCount[maxPos.x][maxPos.y] += 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[i][j] = nextCount[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] >= 2) {
                    count[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        cnt = sc.nextInt();
        time = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < cnt; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            count[x][y] = 1;
        }

        for (int i = 0; i < time; i++) {
            simulate();
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = ans + count[i][j];
            }
        }

        System.out.print(ans);
    }
}
