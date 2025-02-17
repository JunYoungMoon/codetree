import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] arr1 = new int[size];
        int[] arr2 = new int[size];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = scanner.nextInt();
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = scanner.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        String answer = "Yes";

        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]){
                answer = "No";
                break;
            }
        }
        
        System.out.print(answer);
    }
}