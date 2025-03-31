import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int dist = 0;
            int prevIdx = 0;
            for (int j = 1; j < n; j++) {
                if(i == j) continue;

                dist = dist + Math.abs(x[prevIdx] - x[j]) + Math.abs(y[prevIdx] - y [j]);
                prevIdx = j;
            }

            ans = Math.min(ans, dist);
        }

        System.out.println(ans);
    }
}