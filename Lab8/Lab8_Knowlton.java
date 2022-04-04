import java.util.Scanner;
public class Lab8_Knowlton {
    public static void main(String[] args) {

        // Open the scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for an  integer
        System.out.println("\nPlease input an integer: ");
        System.out.print(">>");

        // Set the userNumber
        int userNumber = scanner.nextInt();

        // Print the results from each recursive function
        System.out.println("\nNumber: " + userNumber);
        System.out.println("Binary: " + binary(userNumber));
        System.out.println(userNumber  + " Raised to 3: " + power(userNumber, 3));
        System.out.println("Descending Order: " + descending(userNumber));
        System.out.println("Sum: " + sum(userNumber));

        // Close the scanner
        scanner.close();

    }
    public static String binary(int userNumber) {
        // Base case
        if (userNumber == 0){
            return "";
        } 
        else {
            return (binary(userNumber/2) +  (userNumber % 2));
        }
    }
    public static int power(int userNumber, int basePower) {
        if(basePower ==  0){
            return 1;
        }
        else{
            return (power(userNumber, basePower-1) * userNumber);
        }
    }
    public static String descending(int userNumber) {
        if(userNumber == 0){
            return "";
        }
        else{
            return(userNumber + " " + descending((userNumber-1)));
        }
    }
    public static int sum(int userNumber){
        if(userNumber == 0){
            return 0;
        }
        else{
            return (sum((userNumber/10)) + (userNumber % 10));
        }
    }
}