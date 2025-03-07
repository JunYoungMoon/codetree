import java.util.Scanner;
public class Main {
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int nx = 0;
        int ny = 0;
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            
            int dir;
            if(direction == 'E')
                dir = 0;
            else if(direction == 'W')
                dir = 2;
            else if(direction == 'S')
                dir = 1;
            else
                dir = 3;

            nx = nx + (dx[dir] * distance);
            ny = ny + (dy[dir] * distance);
        }

        System.out.print(nx + " " + ny);
    }
}