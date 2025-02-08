import java.util.Scanner;

public class Main {

    public static void printNumber(int num, int start) {
        for (int i = 0; i < num; i++) {
            System.out.print((start % 9 == 0 ? 9 : start % 9) + " ");
            start++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int start = 1;

        for (int i = 0; i < input; i++) {
            printNumber(input, start);
            start += input;
        }
    }
}