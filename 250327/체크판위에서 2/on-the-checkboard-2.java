import java.util.Scanner;

public class Main {
    public static final int MAX_N = 15;

    public static int n, m;
    public static char[][] grid = new char[MAX_N][MAX_N];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.next().charAt(0);
            }

        int cnt = 0;
        for(int i = 1; i < n; i++)
            for(int j = 1; j < m; j++)
                for(int k = i + 1; k < n - 1; k++)
                    for(int l = j + 1; l < m - 1; l++)
                        if(grid[0][0] != grid[i][j] && 
                           grid[i][j] != grid[k][l] &&
                           grid[k][l] != grid[n - 1][m - 1])
                            cnt++;
        
        System.out.println(cnt);
    }
}