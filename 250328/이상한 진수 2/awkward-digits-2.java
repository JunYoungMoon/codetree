import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                binary = binary.substring(0, i) + '1' + binary.substring(i + 1);
                break;
            }
        }

        int num = Integer.parseInt(binary, 2);

        System.out.println(num);
    }
}