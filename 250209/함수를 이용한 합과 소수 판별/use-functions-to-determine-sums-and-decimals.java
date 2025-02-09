import java.util.Scanner;

public class Main {
    public static boolean Prime(int num){
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }

        if(DigitsSum(num)){
            return true;
        }

        return false;
    }

    public static boolean DigitsSum(int num){
        int sum = 0;
        while(num > 0){
            sum = sum + num % 10;
            num = num / 10;
        }

        return sum % 2 == 0 ? true : false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int answer = 0;

        for(int i = A; i <= B ; i++){
            if(Prime(i)){
                answer++;
            }
        }

        System.out.print(answer);
    }
}