import java.util.Scanner;

public class Main {
    public static boolean 소수구하기(int num){
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        
        if(자릿수합이짝수인가(num)){
            return true;
        }

        return false;
    }

    public static boolean 자릿수합이짝수인가(int num){
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
            if(소수구하기(i)){
                answer++;
            }
        }

        System.out.print(answer);
    }
}