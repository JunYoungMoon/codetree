import java.util.Scanner;

public class Main {

    public static boolean hasMonthAndDate(int M, int D){
        if (M < 1 || M > 12) {
            return false;
        }

        if(M == 2 && D > 28){
            return false;
        }

        if((M == 4 || M == 6 || M == 9 || M == 11) && D > 30){
            return false;
        }

        if((M == 1 || M == 3 || M == 5 || M == 7 || M == 8 || M == 10 || M == 12) && D > 31){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();        
        int D = scanner.nextInt();

        if(hasMonthAndDate(M,D)){
            System.out.print("Yes");
        }else{
            System.out.print("No");
        }
    }
}