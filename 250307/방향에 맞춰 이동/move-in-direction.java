import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int nx = 0;
        int ny = 0;
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            
            if(direction == 'N'){
                ny = ny + distance;
            }

            if(direction == 'E'){
                nx = nx + distance;
            }

            if(direction == 'S'){
                ny = ny - distance;
            }

            if(direction == 'W'){
                nx = nx - distance;
            }
        }

        System.out.print(nx + " " + ny);
    }
}