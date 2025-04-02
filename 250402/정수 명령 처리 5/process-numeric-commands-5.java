import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String command = sc.next();

            if (command.equals("push_back")) {
                list.add(sc.nextInt());
            } else if (command.equals("get")) {
                System.out.println(list.get(sc.nextInt() - 1));
            } else if (command.equals("size")) {
                System.out.println(list.size());
            } else if (command.equals("pop_back")) {
                list.remove(list.size()-1);
            }
        }
    }
}
