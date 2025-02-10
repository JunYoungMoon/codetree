import java.util.Scanner;

public class Main {

    public static boolean checkLeapYear(int Y, int M, int D){
        if(Y % 4 == 0 && Y % 100 == 0 && Y % 400 == 0){
            return true;
        }

        if(Y % 4 == 0 && Y % 100 == 0){
            return false;
        }

        if(Y % 4 == 0){
            return true;
        }

        return false;
    }

    public static boolean checkMonthAndDate(int M, int D, boolean leapYear){
        if (M < 1 || M > 12) {
            return false;
        }

        if(leapYear){
            if(M == 2 && D > 29){
                return false;
            }
        }else{
            if(M == 2 && D > 28){
                return false;
            }
        }


        if((M == 4 || M == 6 || M == 9 || M == 11) && D > 30){
            return false;
        }

        if((M == 1 || M == 3 || M == 5 || M == 7 || M == 8 || M == 10 || M == 12) && D > 31){
            return false;
        }

        return true;
    }

    public static void checkWeather(int M){
        if(M >= 3 && M <= 5){
            System.out.print("Spring");
        }

        if(M >= 6 && M <= 8){
            System.out.print("Summer");
        }

        if(M >= 9 && M <= 11){
            System.out.print("Fall");
        }

        if(M <= 2 || M == 12){
            System.out.print("Winter");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Y = scanner.nextInt();
        int M = scanner.nextInt();
        int D = scanner.nextInt();

        boolean leapYear = checkLeapYear(Y, M, D);

        if(checkMonthAndDate(M, D, leapYear)){
            checkWeather(M);
        }else{
            System.out.print("-1");
        }
    }
}