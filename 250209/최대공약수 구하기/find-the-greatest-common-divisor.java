import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int min = Math.min(a, b);

        int answer = 1;
        for(int i = 1 ; i <= min; i++){
            if(a % i == 0 && b % i ==0){
                answer = i;
            }
        }

        System.out.println(answer);
    }
}