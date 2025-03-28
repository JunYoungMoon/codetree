import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        
        // 만약 모든 숫자가 '1'이면 가장 큰 값을 위해 첫 번째 1을 0으로 변경
        if (!binary.contains("0")) {
            binary = "0" + binary.substring(1); // 첫 번째 숫자를 0으로 바꿈
        } else {
            // 가장 앞의 '0'을 '1'로 변경
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '0') {
                    binary = binary.substring(0, i) + '1' + binary.substring(i + 1);
                    break; // 첫 번째 0을 변경한 후 종료
                }
            }
        }

        // 변환된 이진수를 십진수로 변환
        int num = Integer.parseInt(binary, 2);

        // 출력
        System.out.println(num);
    }
}
