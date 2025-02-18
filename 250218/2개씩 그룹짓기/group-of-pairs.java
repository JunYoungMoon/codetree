import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int groupSize = n * 2;

        int[] arr = new int[groupSize];

        for (int i = 0; i < groupSize; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            int pairSum = arr[i] + arr[groupSize - 1 - i];
            maxSum = Math.max(maxSum, pairSum);
        }
        
        System.out.println(maxSum);
    }
}
