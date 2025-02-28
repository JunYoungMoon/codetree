import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] peopleCount = new int[n + 1];
        // int[] penalizedPerson = new int[m];

        int ans = -1;
        for (int i = 0; i < m; i++) {
            // penalizedPerson[i] = sc.nextInt();
            int tmp = sc.nextInt();

            peopleCount[tmp]++;

            if(peopleCount[tmp] >= k){
                ans = tmp;
                break;
            }
        }
        System.out.print(ans);
    }
}