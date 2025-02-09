import java.util.Scanner;

public class Main {
    public static String hasSubarrayWithSum(int[] arrA, int[] arrB, int sumB) {
        int sumA = 0;

        for (int i = 0; i < arrB.length; i++) {
            sumA = sumA + arrA[i];
        }

        if(sumA == sumB){
            return "Yes";
        }

        for (int i = arrB.length; i < arrA.length; i++) {
            sumA = sumA + arrA[i];
            sumA = sumA - arrA[i - arrB.length];

            if(sumA == sumB){
                return "Yes";
            }
        }

        return "No";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenA = scanner.nextInt();
        int lenB = scanner.nextInt();

        if(lenB > lenA){
            System.out.println("No");
            return;
        }

        int[] arrA = new int[lenA];
        int[] arrB = new int[lenB];

        for (int i = 0; i < lenA; i++) {
            arrA[i] = scanner.nextInt();
        }

        scanner.nextLine();

        int sumB = 0;

        for (int i = 0; i < lenB; i++) {
            arrB[i] = scanner.nextInt();
            sumB = sumB + arrB[i];
        }

        System.out.println(hasSubarrayWithSum(arrA, arrB, sumB));
    }
}