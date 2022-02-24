/*
    Name: Lab5_Knowlton
    Author Name: Matthew Knowlton
    Lab Number: 5
    Date: 23 February 2022
*/
// Import scanner for user input
import java.util.Scanner;
public class Lab5_Knowlton {
    public static void main(String[] args){
        // Initialize Scanner for Input
        Scanner scanner = new Scanner(System.in);
        // Print Welcome Statement
        System.out.println("Welcome to Lab 5, Perfect Numbers! Please enter an integer value:");
        // Prompt for an Integer
        int num = scanner.nextInt();
        // Initialize a variable to sum factors
        int sum = 0;
        // Initialize a string to hold the factors
        String factors = "";
        // Loop through numbers starting at 1 (to avoid dividing by  zero) up to given integer increasing by 1
        for(int i = 1; i < num; i++){
            // Check if the the number is a factor of the given integer
            if((num % i) == 0){
                // Add the number to the sum of the factors
                sum = sum + i;
                if(i == 1){
                    // Assign the number to list of factors by casting it to a string
                    factors = "" + i;
                } else {
                    // Add the number to the list of factors with a preceding comma
                    factors = factors + ", " + i;
                }
            }
        }
        // If the sum of  the factors is equal to the given integer
        if(num == sum){
            // Print the number is a perfect number
            System.out.println(num + " is a perfect number!");
            System.out.print("The factors are " + factors + ".");
        }
        else{
            //  Print out that the given integer is not a perfect number
            System.out.println(num + " is not a perfect number.");
        }
        scanner.close();
    }
}