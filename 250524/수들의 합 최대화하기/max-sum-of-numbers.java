import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] arr;

    public static List<Integer> list = new ArrayList<>();
    public static boolean[] visited;
    public static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        choose(1);

        System.out.println(max);
    }

    public static void choose(int currNum) {
        if (currNum == n + 1) {
            maxChoose();
            return;
        }

        for (int j = 0; j < n; j++) {
            if (visited[j]) {
                continue;
            }

            visited[j] = true;
            list.add(arr[currNum - 1][j]);
            choose(currNum + 1);
            list.remove(list.size() - 1);
            visited[j] = false;
        }
    }

    public static void maxChoose() {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        max = Math.max(max, sum);
    }
}
