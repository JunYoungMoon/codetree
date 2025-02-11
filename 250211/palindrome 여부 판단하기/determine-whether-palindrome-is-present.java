import java.util.Scanner;

public class Main {
    public static void checkPalindrome(char[] input){

        StringBuilder original = new StringBuilder();
        StringBuilder reversed = new StringBuilder();

        for (char digit : input){
            original.append(digit);
            reversed.insert(0,digit);
        }

        if(original.toString().equals(reversed.toString())){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();
        char[] digits = input.toCharArray();

        checkPalindrome(digits);
    }
}