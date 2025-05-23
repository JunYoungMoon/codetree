import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static int k;
    public static int n;
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        choose(0);
    }

    public static void choose(int currNum) {
        if (currNum == n) {
            printChooseNumber();
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (currNum >= 2 &&
                    list.get(list.size() - 1) == i &&
                    list.get(list.size() - 2) == i) {
                continue;
            }

            list.add(i);
            choose(currNum + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void printChooseNumber() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}