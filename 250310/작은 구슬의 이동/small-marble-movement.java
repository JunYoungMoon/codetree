import java.util.Scanner;

public class Main {
    public static final int ASCII_NUM = 128;
    public static int[] mapper = new int[ASCII_NUM];

    public static int[] dx = new int[]{0, 1, -1, 0};
    public static int[] dy = new int[]{1, 0, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int T = scanner.nextInt();
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        char c = scanner.next().charAt(0);

        mapper['R'] = 0;
        mapper['D'] = 1;
        mapper['U'] = 2;
        mapper['L'] = 3;

        //처음 방향 설정
        int moveDir = mapper[c];

        for (int i = 0; i < T; i++) {
            //nx,ny는 미래의 이동할 값
            //x,y가 현재의 값
            int nx = x + dx[moveDir];
            int ny = y + dy[moveDir];

            //미래의 값으로 전진해봄
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                // 전진이 된다면 이동
                x = nx;
                y = ny;
            } else {
                //벽에 부딫히는 경우 방향만 전환
                moveDir = 3 - moveDir;
            }
        }

        System.out.println((x + 1) + " " + (y + 1));
    }
}