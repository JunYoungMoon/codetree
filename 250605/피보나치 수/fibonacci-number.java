import java.util.*;

public class Main {

    public static int n;
    public static int[] memo;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        memo = new int[n + 1];

        Arrays.fill(memo, -1);

        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }

        if (n <= 2) {
            return 1;
        } else {
            memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }

        return memo[n];
    }
}
