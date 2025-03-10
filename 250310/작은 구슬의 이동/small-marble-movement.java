import java.util.Scanner;

public class Main {
    public static int[] dx = new int[]{0, 1, -1, 0};
    public static int[] dy = new int[]{1, 0, 0, -1};

    public static int getDir(char a) {
        if (a == 'R')
            return 0;
        else if (a == 'D')
            return 1;
        else if (a == 'U')
            return 2;
        else
            return 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int T = scanner.nextInt();
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        char c = scanner.next().charAt(0);

        //처음 방향 설정
        int moveDir = getDir(c);
        int nx = x + dx[moveDir];
        int ny = y + dy[moveDir];

        for (int i = 0; i < T; i++) {
            //방향대로 전진
            nx = nx + dx[moveDir];
            ny = ny + dy[moveDir];
            //벽에 부딫히는 경우
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                //방향만 전환
                moveDir = 3 - moveDir;
            }
        }

        System.out.println((nx + 1) + " " + (ny + 1));
    }
}