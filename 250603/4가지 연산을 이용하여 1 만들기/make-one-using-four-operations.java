import java.util.*;

public class Main {
    public static class Pair {
        int num, step;

        public Pair(int num, int step) {
            this.num = num;
            this.step = step;
        }
    }

    public static int n;
    public static int MAX_VALUE = 1_000_000;
    public static Queue<Pair> queue = new LinkedList<>();
    public static boolean[] visited = new boolean[MAX_VALUE + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        System.out.println(BFS());
    }

    public static int BFS() {
        queue.offer(new Pair(n, 0));

        while (!queue.isEmpty()) {

            Pair pair = queue.poll();
            int currNum = pair.num;
            int step = pair.step;

            if(visited[currNum]) continue;
            visited[currNum] = true;

            if(currNum == 1){
                return step;
            }

            if (inRange(currNum - 1)) {
                queue.offer(new Pair(currNum - 1, step + 1));
            }

            if (inRange(currNum + 1)) {
                queue.offer(new Pair(currNum + 1, step + 1));
            }

            if (inRange(currNum / 2)) {
                if (currNum % 2 == 0) {
                    queue.offer(new Pair(currNum / 2, step + 1));
                }
            }

            if (inRange(currNum / 3)) {
                if (currNum % 3 == 0) {
                    queue.offer(new Pair(currNum / 3, step + 1));
                }
            }
        }

        return 0;
    }

    public static boolean inRange(int currNum) {
        return currNum > 0 && currNum < MAX_VALUE && !visited[currNum];
    }
}
