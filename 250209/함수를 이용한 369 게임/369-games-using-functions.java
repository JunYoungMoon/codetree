import java.util.Scanner;

public class Main {

    public static boolean containsMultipleOfThree(int n) {

        while(n > 0){
            int digit = n % 10;

            if(digit % 3 == 0 && disit != 0){
                return true;
            }
            n = n / 10;
        }

        return false;
    }

    public static boolean isMagicMultipleOfThree(int n) {
        if (n % 3 == 0 || containsMultipleOfThree(n)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int cnt = 0;

        for(int i = A ; i <= B; i++){
            if(isMagicMultipleOfThree(i)){
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}