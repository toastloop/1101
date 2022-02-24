/*
    Name: Lab6_Knowlton
    Author Name: Matthew Knowlton
    Lab Number: 6
    Date: 24 February 2022
*/
// Import scanner for user input
import java.util.Scanner;
public class Lab6_Knowlton {
    public static void main(String[] args) {
        // Initiate scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Print welcome statement
        System.out.println("Welcome to Lab 6, finding Zeros! Please enter an integer value between 1 and 10:");
        // Prompt for number of integers
        int numIntegers = scanner.nextInt();
        // Holds sum of all integers
        double sumIntegers = 0;
        // Holds number of positive integers
        int numPositiveIntegers = 0;
        // Holds sum of positive integers
        double sumPositiveIntegers = 0;
        // Holds greatest integer
        int greatestInteger = 0;
        // Holds smallest integer
        int smallestInteger = 0;
        // Holds a string of all integers
        String allIntegers = "";
        // Iterate using number of integers
        for(int iterator = 1; iterator <= numIntegers; iterator++){
            // Print a separator
            System.out.println("*****");
            // Instruct user to enter an integer
            System.out.println("Enter Integer " + iterator + ":");
            // Prompt user for current integer
            Integer currentInteger = scanner.nextInt();
            // Add user integer to the sum of integers
            sumIntegers += currentInteger;
            // Check if integer is positive
            if(currentInteger > 0){
                // Increment number of positive integers
                numPositiveIntegers += 1;
                // Add the integer to the sum of positive integers
                sumPositiveIntegers += currentInteger;
            }
            // Check if current integer is larger than greatest integer or if this is the first integer
            if(currentInteger > greatestInteger || iterator == 1){
                // Set greatest integer to current integer
                greatestInteger = currentInteger;
            }
            // Check if current integer is less than smallest integer or if this is the first integer
            if(currentInteger < smallestInteger || iterator == 1){
                // Set smallest integer to current integer
                smallestInteger = currentInteger;
            }
            // Check if this is the first integer
            if(iterator == 1){
                // Set all integers string to current integer
                allIntegers += currentInteger;
            }
            else {
                // Append all integers with a comma and then the current integer
                allIntegers += "," + currentInteger;
            }
            // Take the length  of  the number and subtract the length after removing the zeros
            int currentZeros = currentInteger.toString().length() - currentInteger.toString().replaceAll("0", "").length();
            // Print  out the number of zeros
            System.out.println("// Number of 0s //");
            System.out.println(currentInteger + " -> " + currentZeros);
        }
        // Print a separator 
        System.out.println("*****");
        // Calculate average of all integers
        double averageIntegers = (sumIntegers / numIntegers);
        // Calculate average of all positive integers
        double averagePositiveIntegers = (sumPositiveIntegers / numPositiveIntegers);
        // Print the list of entered integers
        System.out.println("The number(s) entered by the user are: ");
        System.out.println(allIntegers);
        // Print the number of positive integers
        System.out.println(numPositiveIntegers + " number(s) are greater than 0.");
        // Print the average of the positive numbers
        System.out.println("The average of all positive numbers is: " + averagePositiveIntegers);
        // Print the average of all integers
        System.out.println("The average of all numbers is: " + averageIntegers);
        // Print the greatest integer
        System.out.println("The greatest number is: " + greatestInteger);
        // Print the smallest integer
        System.out.println("The smallest number is: " + smallestInteger);
        // Close the scanner
        scanner.close();
    }
}
