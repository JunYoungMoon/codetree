import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int n;
    public static List<Integer> list = new ArrayList<>();
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        visited = new boolean[n + 1];

        choose(1);
    }

    public static void choose(int currNum) {
        if (currNum == n + 1) {
            printChoose();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            list.add(i);
            choose(currNum + 1);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void printChoose() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
