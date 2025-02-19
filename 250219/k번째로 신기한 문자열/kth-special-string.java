import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int rank = scanner.nextInt();
        String find = scanner.next();

        String[] strArr = new String[size];

        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = scanner.next();
        }

        Arrays.sort(strArr, (a, b) -> {
            boolean aStarts = a.startsWith(find);
            boolean bStarts = b.startsWith(find);

            if (aStarts && !bStarts) return -1;
            if (!aStarts && bStarts) return 1;
            return a.compareTo(b);
        });

        System.out.print(strArr[rank-1]);
    }
}