import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int sumX = 0;

        while(true){

            sumX = sumX + x;

            if(sumX % y == 0){
                break;
            }
        }

        System.out.print(sumX);
    }
}