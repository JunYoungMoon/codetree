import java.util.Scanner;

public class Main {

    public static int n;
    public static int[] dp;
    public static int mod = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = ((dp[i - 1] * 1) + (dp[i - 2] * 2)) % mod;
        }

        System.out.println(dp[n]);
    }
}