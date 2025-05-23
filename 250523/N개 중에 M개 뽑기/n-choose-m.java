import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static int n;
    public static int m;
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        choose(0, 0);
    }

    public static void choose(int currNum, int prevNum) {
        if (currNum == m) {
            printChoose();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (currNum >= 1 && prevNum >= i) {
                continue;
            }
            list.add(i);
            choose(currNum + 1, i);
            list.remove(list.size() - 1);
        }
    }

    public static void printChoose() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}