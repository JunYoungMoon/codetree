import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static Queue<Point> queue = new LinkedList<>();
    public static final Point NOT_EXISTS = new Point(-1, -1);
    public static int n, k;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int max;
    public static Point currCell;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int startX = sc.nextInt() - 1;
        int startY = sc.nextInt() - 1;

        currCell = new Point(startX, startY);

        for (int i = 0; i < k; i++) {
            initializeVisited();
            BFS();

            Point bestPoint = NOT_EXISTS;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!visited[j][k] || j == currCell.x && k == currCell.y)
                        continue;

                    Point newPoint = new Point(j, k);

                    if (needUpdate(bestPoint, newPoint)) {
                        bestPoint = newPoint;
                    }
                }
            }

            if (bestPoint.x == NOT_EXISTS.x && bestPoint.y == NOT_EXISTS.y) {
                break;
            } else {
                currCell = bestPoint;
            }
        }

        System.out.println(currCell.x + 1 + " " + currCell.y + 1);
    }

    public static void initializeVisited() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                visited[i][j] = false;
    }

    public static boolean needUpdate(Point bestPoint, Point newPoint) {
        if (bestPoint.x == NOT_EXISTS.x && bestPoint.y == NOT_EXISTS.y) {
            return true;
        }

        int bestX = bestPoint.x;
        int bestY = bestPoint.y;

        int newX = newPoint.x;
        int newY = newPoint.y;

        //숫자 -행 -열
        if (grid[newX][newY] != grid[bestX][bestY]) {
            return grid[newX][newY] > grid[bestX][bestY];
        }
        if (-newX != -bestX) {
            return -newX > -bestX;
        }

        return -newY > -bestY;
    }

    public static void BFS() {
        int cX = currCell.x;
        int cY = currCell.y;

        int targetNum = grid[cX][cY];

        visited[cX][cY] = true;
        queue.offer(currCell);

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            int currX = point.x;
            int currY = point.y;

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (canGo(nextX, nextY, targetNum)) {
                    visited[nextX][nextY] = true;
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }
    }

    public static boolean canGo(int x, int y, int currValue) {
        if (!inRange(x, y)) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        if (grid[x][y] >= currValue) {
            return false;
        }

        return true;
    }

    public static boolean inRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < n) {
            return true;
        }
        return false;
    }
}


