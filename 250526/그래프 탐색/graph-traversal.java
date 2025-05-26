import java.util.*;

public class Main {

    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            graph[v1].add(v2);
            graph[v2].add(v1);
        }


        visited[1] = true;
        DFS(1);
        System.out.println(cnt);
    }

    public static void DFS(int vertex) {
        for (int i = 0; i < graph[vertex].size(); i++) {
            int currV = graph[vertex].get(i);
            if (!visited[currV]) {
                cnt++;
                visited[currV] = true;
                DFS(currV);
            }
        }
    }
}