import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startMonth = scanner.nextInt();
        int startDay = scanner.nextInt();
        int endMonth = scanner.nextInt();
        int endDay = scanner.nextInt();

        int month = startMonth;
        int day = startDay;
        int elapsedDays = 0;

        int[] num_of_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        while (true) {
            if (month == endMonth && day == endDay) {
                break;
            }

            elapsedDays++;
            day++;

            if(day > num_of_days[month]){
                day = 0;
                month++;
            }
        }

        System.out.println(elapsedDays);
    }
}
