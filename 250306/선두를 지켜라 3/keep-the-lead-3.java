import java.util.Scanner;

public class Main {

    public static int[] posA = new int[1000000];
    public static int[] posB = new int[1000000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int timeA = 1;
        for (int i = 0; i < A; i++) {
            int v = scanner.nextInt();
            int t = scanner.nextInt();

            while (t > 0) {
                posA[timeA] = posA[timeA - 1] + v;
                t--;
                timeA++;
            }
        }

        int timeB = 1;
        for (int i = 0; i < B; i++) {
            int v = scanner.nextInt();
            int t = scanner.nextInt();

            while (t > 0) {
                posB[timeB] = posB[timeB - 1] + v;
                t--;
                timeB++;
            }
        }

        boolean checkA = true;
        boolean checkB = true;
        boolean checkC = true;
        int ans = 0;
        for (int i = 1; i < timeA; i++) {
            if(posA[i] > posB[i] && checkA){
                ans++;
                checkC = true;
                checkB = true;
                checkA = false;
            }

            if(posB[i] > posA[i] && checkB){
                ans++;
                checkC = true;
                checkB = false;
                checkA = true;
            }
            
            if(posA[i] == posB[i] && checkC){
                ans++;
                checkC = false;
                checkB = true;
                checkA = true;
            }
        }

        System.out.println(ans);
    }
}