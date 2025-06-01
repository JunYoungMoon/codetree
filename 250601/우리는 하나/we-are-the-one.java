import java.util.*;


class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, k, u, d, max, ans;
    public static int[][] grid;
    public static List<Pair> cityList = new ArrayList<>();
    public static List<Pair> selectedCity = new ArrayList<>();
    public static Queue<Pair> queue = new LinkedList<>();
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                cityList.add(new Pair(i, j));
            }
        }

        getMaxCity(0, 0);

        System.out.println(ans);
    }

    public static void getMaxCity(int idx, int cnt) {
        if (k == cnt) {
            ans = Math.max(ans, BFS());

//            printCombination();
            return;
        }

        if (cityList.size() == idx) {
            return;
        }

        //미선택
        getMaxCity(idx + 1, cnt);

        //선택
        selectedCity.add(cityList.get(idx));
        getMaxCity(idx + 1, cnt + 1);
        selectedCity.remove(selectedCity.size() - 1);
    }

    public static void printCombination() {
        for (int i = 0; i < selectedCity.size(); i++) {
            System.out.println(selectedCity.get(i).x + ", " + selectedCity.get(i).y);
        }
        System.out.println();
    }

    public static int BFS() {
        //큐 초기화 필요
        int cnt = 0;

        visitedInitialized();

        for (int i = 0; i < selectedCity.size(); i++) {
            queue.offer(new Pair(selectedCity.get(i).x, selectedCity.get(i).y));
            visited[selectedCity.get(i).x][selectedCity.get(i).y] = true;
            cnt++;
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int currX = pair.x;
            int currY = pair.y;

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (canGo(nextX, nextY, currX, currY)) {
                    visited[nextX][nextY] = true;
                    queue.offer(new Pair(nextX, nextY));
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void visitedInitialized() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static boolean canGo(int nextX, int nextY, int currX, int currY) {
        if (!isRange(nextX, nextY)) {
            return false;
        }

        int heightDiff = Math.abs(grid[currX][currY] - grid[nextX][nextY]);

        if (heightDiff >= u && heightDiff <= d) {
            if (!visited[nextX][nextY]) {
                return true;
            }
        }

        return false;
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}