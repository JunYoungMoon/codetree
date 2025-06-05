import java.util.Scanner;

public class Main {
    public static int n;
    public static int mod = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 3]) % mod;
        }

        System.out.println(dp[n]);
    }
}
