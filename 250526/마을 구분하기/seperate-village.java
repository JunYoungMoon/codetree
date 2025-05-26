import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int[][] visited;
    public static int[][] arr;
    public static int n, cnt;
    public static List<Integer> cntList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && visited[i][j] == 0) {
                    cnt = 1;
                    DFS(i, j);
                    cntList.add(cnt);
                }
            }
        }

        System.out.println(cntList.size());
        Collections.sort(cntList);
        for (int i = 0; i < cntList.size(); i++) {
            System.out.println(cntList.get(i));
        }
    }

    public static void DFS(int x, int y) {
        visited[x][y] = 1;
        arr[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n
                    && visited[nextX][nextY] == 0 && arr[nextX][nextY] == 1) {
                cnt++;
                DFS(nextX, nextY);
            }
        }
    }
}
