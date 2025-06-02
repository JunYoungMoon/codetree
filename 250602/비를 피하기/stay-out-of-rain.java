import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int n, h, m;
    public static int[][] grid, ans, step;
    public static boolean[][] visited;
    public static List<Pair> peopleList = new ArrayList<>();
    public static List<Pair> arriveList = new ArrayList<>();
    public static Queue<Pair> queue = new LinkedList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][n];
        ans = new int[n][n];
        step = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();

                if (grid[i][j] == 2) {
                    peopleList.add(new Pair(i, j));
                }

                if (grid[i][j] == 3) {
                    arriveList.add(new Pair(i, j));
                }
            }
        }

        for (int i = 0; i < peopleList.size(); i++) {
            visitedInit();
            stepInit();

            Pair peoplePair = peopleList.get(i);
            queue.offer(new Pair(peoplePair.x, peoplePair.y));
            visited[peoplePair.x][peoplePair.y] = true;

            BFS();

            ans[peoplePair.x][peoplePair.y] = minArrive();
        }

        printAns();
    }

    public static void printAns(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static int minArrive() {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arriveList.size(); i++) {
            Pair arrivePair = arriveList.get(i);
            int temp;

            if (visited[arrivePair.x][arrivePair.y]) {
                temp = step[arrivePair.x][arrivePair.y];
            } else {
                temp = -1;
            }

            min = Math.min(min, temp);
        }

        return min;
    }

    public static void visitedInit() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static void stepInit() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                step[i][j] = 0;
            }
        }
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int currX = pair.x;
            int currY = pair.y;

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (canGo(nextX, nextY)) {
                    visited[nextX][nextY] = true;
                    queue.offer(new Pair(nextX, nextY));
                    step[nextX][nextY] = step[currX][currY] + 1;
                }
            }
        }
    }

    public static boolean canGo(int x, int y) {
        if (!inRange(x, y)) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        return true;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n && grid[x][y] != 1;
    }
}
