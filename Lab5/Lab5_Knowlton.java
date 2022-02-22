import java.util.Scanner;
import java.util.ArrayList;
public class Lab5_Knowlton {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int sum = 0;
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for(int i = 1; i < num; i++){
            if((num % i) == 0){
                factors.add(i);
                sum = sum + i;
            }
        }
        if(num == sum){
            System.out.println(num + " is a perfect number!");

            for (int i : factors) {
                System.out.print(i + ", ");
            }
        }

    }
}