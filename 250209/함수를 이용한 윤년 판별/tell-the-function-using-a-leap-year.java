import java.util.Scanner;

public class Main {
    public static boolean 윤년확인(int n){

        if(n % 4 == 0){

            if(n % 100 == 0 && n % 400 != 0){
                return false;
            }

            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        System.out.print(윤년확인(input));
    }
}