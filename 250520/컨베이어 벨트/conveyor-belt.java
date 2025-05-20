import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[2][n];

        for(int i = 0 ; i < 2 ; i++){
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            int temp1 = arr[0][n - 1];
            int temp2 = arr[1][n - 1];

            for (int j = 0; j < 2; j++) {
                for(int k = n - 2; k >= 0; k--){
                    arr[j][k + 1] = arr[j][k];
                }
            }

            arr[1][0] = temp1;
            arr[0][0] = temp2;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}