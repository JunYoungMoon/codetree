import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] intArr = new int[size];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = scanner.nextInt();
        }

        int cnt = 0;
        int ans = 0;

        for (int i = 0; i < intArr.length; i++) {
            if (i == 0 || intArr[i] * intArr[i - 1] > 0) {
                cnt++;
            } else {
                cnt = 1;
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
