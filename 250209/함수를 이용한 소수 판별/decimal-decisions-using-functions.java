import java.util.Scanner;

public class Main {

    public static boolean isPrime(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int sum = 0;
        for(int i = A; i <= B; i++){
            if(isPrime(i)){
                sum = sum + i;
            }
        }
        System.out.print(sum);
    }
}