import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        String[] word = new String[size];

        for (int i = 0; i < word.length; i++) {
            word[i] = scanner.next();
        }

        Arrays.sort(word);

        for (int i = 0; i < word.length; i++) {
            System.out.println(word[i]);
        }
    }
}