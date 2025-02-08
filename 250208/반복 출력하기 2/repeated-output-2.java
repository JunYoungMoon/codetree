import java.util.Scanner;

public class Main {
    public static void printStar(int n) { // 1부터 n번째 줄까지 별을 출력하는 함수
        if(n == 0)                        // n이 0이라면, 더 이상 진행하지 않고
            return;                       // 퇴각합니다.
        
        printStar(n - 1);                 // 1부터 n - 1번째 줄까지 출력하는 함수
        System.out.println("HelloWorld");      // n번째 줄에 해당하는 별 출력
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        printStar(input);
    }
}