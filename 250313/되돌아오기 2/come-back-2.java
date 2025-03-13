import java.util.Scanner;

public class Main {
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] charArr = sc.next().toCharArray();

        int x = 0;
        int y = 0;
        int dir = 0;
        boolean flag = false;

        for (int i = 0; i < charArr.length; i++) {

            if (charArr[i] == 'R') {
                dir = (dir + 1) % 4;
            } else if (charArr[i] == 'L') {
                dir = (dir - 1 + 4) % 4;
            } else {
                x = x + dx[dir];
                y = y + dy[dir];
            }

            if (x == 0 && y == 0) {
                System.out.println(i + 1);
                flag = true;
                break;
            }
        }

        if(!flag)
            System.out.print(-1);
    }
}