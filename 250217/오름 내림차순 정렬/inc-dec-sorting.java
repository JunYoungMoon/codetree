import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] arr = new int[size];

        for(int i = 0 ; i < size ; i++){
            arr[i] = scanner.nextInt();
        }

        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(size1 -> new Integer[size1]);

        Arrays.sort(arr2, 0 , size);    //그냥 위치로 한번 사용해봄.


        for(int i = 0 ; i < arr2.length ; i++){
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        Arrays.sort(arr2, Collections.reverseOrder());

        for(int i = 0 ; i < arr2.length ; i++){
            System.out.print(arr2[i] + " ");
        }
    }
}