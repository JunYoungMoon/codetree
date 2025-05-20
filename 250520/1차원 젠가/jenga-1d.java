import java.util.Scanner;

public class Main {

    public static final int MAX = 100;
    public static int carrIndex = 0;
    public static int[] arr = new int[MAX];
    public static int[] carr = new int[MAX];
    public static int n;
    public static int endOfArray;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        endOfArray = n;

        for (int i = 0; i < 2; i++) {
            int s = sc.nextInt() - 1;
            int e = sc.nextInt() - 1;

            cutArray(s, e);
        }

        System.out.println(endOfArray);

        for (int i = 0; i < endOfArray; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void cutArray(int startIndex, int endIndex) {
        carrIndex = 0;
        for (int i = 0; i < endOfArray; i++) {
            if (i < startIndex || i > endIndex) {
                carr[carrIndex++] = arr[i];
            }
        }

        arr = carr;
        endOfArray = carrIndex;
    }
}