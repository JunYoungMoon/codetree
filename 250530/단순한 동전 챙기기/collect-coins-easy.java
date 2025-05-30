import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int COIN_NUM = 9;
    public static List<Pair> coinList = new ArrayList<>();
    public static List<Pair> selectCoinList = new ArrayList<>();

    public static int m = 3;
    public static int n;

    public static int ans = Integer.MAX_VALUE;
    public static Pair start, end;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        char[][] grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);

                if (grid[i][j] == 'S') {
                    start = new Pair(i, j);
                }

                if (grid[i][j] == 'E') {
                    end = new Pair(i, j);
                }
            }
        }

        for (int i = 0; i < COIN_NUM; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (grid[j][k] == i + '0') {
                        coinList.add(new Pair(j, k));
                    }
                }
            }
        }

        if (coinList.size() > 2) {
            getMin(0, 0);
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }

    public static void getMin(int idx, int cnt) {
        if (idx == coinList.size()) {
            if (cnt == m) {
                ans = Math.min(ans, calc());
            }
            return;
        }

        selectCoinList.add(coinList.get(idx));
        getMin(idx + 1, cnt + 1);
        selectCoinList.remove(selectCoinList.size() - 1);

        getMin(idx + 1, cnt);
    }

    public static int dist(Pair a, Pair b) {
        int ax = a.x;
        int ay = a.y;

        int bx = b.x;
        int by = b.y;

        return Math.abs(ax - bx) + Math.abs(ay - by);
    }

    public static int calc() {
        int numMoves = dist(start, selectCoinList.get(0));

        for (int i = 0; i < selectCoinList.size() - 1; i++) {
            numMoves += dist(selectCoinList.get(i), selectCoinList.get(i + 1));
        }

        numMoves += dist(selectCoinList.get(selectCoinList.size() - 1), end);

        return numMoves;
    }
}