import java.util.Scanner;

public class Main {
    public static int n;
    public static int mod = 10007;
    public static int[] dp = new int[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }

        System.out.println(dp[n]);
    }
}
