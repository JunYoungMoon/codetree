import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int n = sc.nextInt();
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        List<Integer> list = new ArrayList<>();

        int currentValue = arr[x][y];
        list.add(currentValue);
        int cnt = 1;
        int currentX = 0;
        int currentY = 0;

        while (cnt > 0) {
            cnt = 0;
            for (int i = 0; i < 4; i++) {
                currentX = x + dx[i];
                currentY = y + dy[i];
                if (currentX >= 0 && currentX < n && currentY >= 0 && currentY < n) {
                    if (arr[currentX][currentY] > currentValue) {
                        currentValue = arr[currentX][currentY];
                        list.add(currentValue);
                        cnt++;
                        break;
                    }
                }
            }
            x = currentX;
            y = currentY;
        }

        for (int value : list) {
            System.out.print(value + " ");
        }
    }
}
