import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        char[] charArray = string.toCharArray();

        Arrays.sort(charArray);

        String s = new String(charArray);
        System.out.println(s);
    }
}
