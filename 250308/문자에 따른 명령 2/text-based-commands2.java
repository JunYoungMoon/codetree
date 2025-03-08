import java.util.Scanner;

public class Main {

    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] charArray = s.toCharArray();

        int nx = 0;
        int ny = 0;
        int v = 3;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'L') {
                //반시계 방향으로 회전
                v = (v + 3) % 4;
            } else if (charArray[i] == 'R') {
                //시계 방향으로 회전
                v = (v + 1) % 4;
            } else if (charArray[i] == 'F') {
                //nx,ny 증가
                nx = nx + dx[v];
                ny = ny + dy[v];
            }
        }

        System.out.println(nx + " " + ny);
    }
}