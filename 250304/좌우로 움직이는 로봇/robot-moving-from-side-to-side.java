import java.util.*;

public class Main {

    public static int[][] posN = new int[1000000][2];
    public static int[][] posM = new int[1000000][2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int timeA = 1;
        int distanceA = 0;
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            String d = scanner.next();

            for (int j = 0; j < t; j++) {
                if (Objects.equals(d, "L")) {
                    distanceA--;
                    posN[timeA][0] = distanceA;
                    posN[timeA][1] = -1;
                } else if (Objects.equals(d, "R")) {
                    distanceA++;
                    posN[timeA][0] = distanceA;
                    posN[timeA][1] = 1;
                }

                timeA++;
            }
        }

        int timeB = 1;
        int distanceB = 0;
        for (int i = 0; i < m; i++) {
            int t = scanner.nextInt();
            String d = scanner.next();

            for (int j = 0; j < t; j++) {
                if (Objects.equals(d, "L")) {
                    distanceB--;
                    posM[timeB][0] = distanceB;
                    posM[timeB][1] = -1;
                } else if (Objects.equals(d, "R")) {
                    distanceB++;
                    posM[timeB][0] = distanceB;
                    posM[timeB][1] = 1;
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
        int timeMax;
        if (timeA < timeB) {
            timeMax = timeB;
        } else {
            timeMax = timeA;
        }

        for (int i = 1; i < timeMax; i++) {
            if (posN[i][0] == posM[i][0] && posN[i][1] != posM[i][1]) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}