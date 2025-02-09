import java.util.Scanner;

public class Main {

    public static int add(int n){
        int sum = 0;
        for(int i = 1; i <= n ; i++){
            sum = sum + i;
        }

        return sum;
    }

    public static int divide(int n){
        return n / 10;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        int n = add(input);
        System.out.println(divide(n));

    }
}