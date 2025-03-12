import java.util.*;

public class Main {
    //E,S,W,N
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};

    public static int count = 0;
    public static int nx = 0;
    public static int ny = 0;

    public static boolean move(int index, int dist){
        for (int i = 0; i < dist; i++) {
            nx = nx + dx[index];
            ny = ny + dy[index];

            count++;

            if(nx == 0 && ny == 0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            char cDir = sc.next().charAt(0);
            int dist = sc.nextInt();

            int dir;

            if (cDir == 'E') {
                dir = 0;
            } else if (cDir == 'S') {
                dir = 1;
            } else if (cDir == 'W') {
                dir = 2;
            } else {
                dir = 3;
            }

            boolean done = move(dir, dist);

            if(done){
                break;
            }

        }
        System.out.println(count);
    }
}