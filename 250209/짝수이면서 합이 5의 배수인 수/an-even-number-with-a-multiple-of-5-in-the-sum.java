import java.util.Scanner;

public class Main {
    public static String isMagicNumber(int n){
        int a = n / 10;
        int b = n % 10;

        if(n % 2 == 0 && (a + b) % 5 == 0){
            return "Yes";
        }else{
            return "No";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(isMagicNumber(scanner.nextInt()));
    }
}