import java.util.*;

class Number implements Comparable<Number>{

    int number;
    int index;

    public Number(int number, int index) {
        this.number = number;
        this.index = index;
    }

    @Override
    public int compareTo(Number b) {
        if(number != b.number)
            return number - b.number;
        return index - b.index;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] answer = new int[n];

        Number[] numbers = new Number[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = new Number(sc.nextInt(), i);
        }

        Comparator<Number> customComparator = Comparator
                .comparingInt((Number k) -> k.number)
                .thenComparingInt(k -> k.index);

        Arrays.sort(numbers, customComparator);

        for (int i = 0; i < n; i++)
            answer[numbers[i].index] = i + 1;

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
