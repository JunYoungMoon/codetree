import java.util.*;

public class Main {

    public static int[] posN = new int[1000000];
    public static int[] posM = new int[1000000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int timeA = 1;
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            char d = scanner.next().charAt(0);

            for (int j = 0; j < t; j++) {
                if (d == 'L') {
                    posN[timeA] = posN[timeA - 1] - 1;
                } else if (d == 'R') {
                    posN[timeA] = posN[timeA - 1] + 1;
                }

                timeA++;
            }
        }

        int timeB = 1;
        for (int i = 0; i < m; i++) {
            int t = scanner.nextInt();
            char d = scanner.next().charAt(0);

            for (int j = 0; j < t; j++) {
                if (d == 'L') {
                    posM[timeB] = posM[timeB - 1] - 1;
                } else if (d == 'R') {
                    posM[timeB] = posM[timeB - 1] + 1;
                }

                timeB++;
            }
        }

        if (timeA < timeB) {
            for (int i = timeA; i < timeB; i++) {
                posN[i] = posN[i - 1];
            }
        } else if (timeA > timeB) {
            for (int i = timeB; i < timeA; i++) {
                posM[i] = posM[i - 1];
            }
        }

        int ans = 0;
        int timeMax = Math.max(timeA, timeB);

        for (int i = 1; i < timeMax; i++) {
            if (posN[i] == posM[i] && posN[i - 1] != posM[i - 1]) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}