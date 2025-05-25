import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int[][] arr;
    public static List<Integer> picked = new ArrayList<>();
    public static int min = Integer.MAX_VALUE;

    public static boolean[] visited;

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

        visited[0] = true;
        picked.add(0);
        choose(1);

        System.out.println(min);
    }

    public static void choose(int currNum) {
        if (currNum == n) {
            //거리에 값에 따른 arr 방문하기
            int totalValue = 0;
            for (int i = 0; i < picked.size() - 1; i++) {
                int currCost = arr[picked.get(i)][picked.get(i + 1)];

                //0일때는 벗어나기
                if (currCost == 0) {
                    return;
                }

                totalValue += currCost;
            }

            //원래 자리로 돌아가기
            int lastPos = picked.get(picked.size() - 1);
            int additionalCost = arr[lastPos][0];
            if (additionalCost == 0) {
                return;
            }

            min = Math.min(totalValue + additionalCost, min);

            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            picked.add(i);
            choose(currNum + 1);
            picked.remove(picked.size() - 1);
            visited[i] = false;
        }
    }
}