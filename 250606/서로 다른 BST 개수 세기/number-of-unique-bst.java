import java.util.Scanner;

public class Main {

    public static int n;
    public static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        memo = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }

        System.out.println(numOfUniqueBST(n));
    }

    public static int numOfUniqueBST(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }

        if (n <= 1) {
            return 1;
        }

        int sumNum = 0;

        for (int i = 0; i < n; i++) {
            sumNum += numOfUniqueBST(i) * numOfUniqueBST(n - i - 1);
        }

        return memo[n] = sumNum;
    }
}