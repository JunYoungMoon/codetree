import java.util.Scanner;

public class Main {

    public static int power(int a, int b){
        int temp = 1;

        for(int i = 0 ; i < b; i++){
            temp = temp * a;
        }

        return temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.print(power(a,b));
    }
}