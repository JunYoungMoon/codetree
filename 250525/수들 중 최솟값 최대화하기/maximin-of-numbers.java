import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int n, min, max;
    public static boolean[] visited;
    public static List<Integer> list = new ArrayList<>();
    public static List<Integer> minList = new ArrayList<>();
    public static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n];
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        choose(0);
        maximum();
        System.out.println(max);
    }

    public static void choose(int currNum) {
        if (currNum == n) {
            minimize();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            list.add(arr[currNum][i]);
            choose(currNum + 1);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void minimize() {
        min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            min = Math.min(min, list.get(i));
        }
        minList.add(min);
    }

    public static void maximum() {
        max = 0;
        for (int i = 0; i < minList.size(); i++) {
            max = Math.max(max, minList.get(i));
        }
    }
}