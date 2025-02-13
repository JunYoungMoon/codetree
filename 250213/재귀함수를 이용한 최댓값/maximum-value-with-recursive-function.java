import java.util.*;

public class Main {

    static int[] maxValueArr;

    public static int maxValue(int i) {
        if(i == 1){
            return maxValueArr[i];
        }

        return Math.max(maxValueArr[i], maxValue(i - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        maxValueArr = new int[size];

        for(int i = 0 ; i < size ; i++){
            maxValueArr[i] = scanner.nextInt();
        }

        System.out.print(maxValue(size - 1));
    }
}