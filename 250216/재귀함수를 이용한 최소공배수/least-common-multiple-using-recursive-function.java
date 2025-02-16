import java.util.*;

public class Main {

    static int arr[];

    public static int recursive(int i) {
        if (i == 0) {
            return arr[0];
        }

        int prevLcm = recursive(i - 1);
        return lcd(prevLcm, arr[i]);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int lcd(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(recursive(size - 1));
    }
}
