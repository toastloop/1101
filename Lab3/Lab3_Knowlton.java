/*
    Name: Lab3_Knowlton
    Author Name: Matthew Knowlton
    Lab Number: 3
    Date: 7 February 2022
*/

// Import Scanner and Random utilities
import java.util.Scanner;
import java.util.Random;

public class Lab3_Knowlton {
    public static void main(String[] args){
        // Initialize scanner and random
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // Initialize score and input variables
        int score = 0;
        int userInput; 
        
        // Question 1
        // Generate 2 Random Numbers and Answer
        int q1_num1 = random.nextInt(101);
        int q1_num2 = random.nextInt(101);
        int q1_ans = q1_num1 + q1_num2;
        // Ask user for answer
        System.out.println(" What is " + q1_num1 + " + " + q1_num2 + "?");
        userInput = scanner.nextInt();
        // Compare user answer and generated answer
        if(userInput == q1_ans){
            // Print response and add 1 to score
            System.out.println("That answer is correct.");
            score = score+1;
        }
        else {
            // Print response
            System.out.println("Incorrect! The correct answer is " + q1_ans);
        }
        
        // Question 2
        int q2_num1 = random.nextInt(101);
        int q2_num2 = random.nextInt(101);
        int q2_ans = q2_num1 + q2_num2;
        System.out.println(" What is " + q2_num1 + " + " + q2_num2 + "?");
        userInput = scanner.nextInt();
        if(userInput == q2_ans){
            System.out.println("That answer is correct.");
            score = score+1;
        }
        else {
            System.out.println("Incorrect! The correct answer is " + q2_ans);
        }

        // Question 3
        int q3_num1 = random.nextInt(101);
        int q3_num2 = random.nextInt(101);
        int q3_ans = q3_num1 + q3_num2;
        System.out.println(" What is " + q3_num1 + " + " + q3_num2 + "?");
        userInput = scanner.nextInt();
        if(userInput == q3_ans){
            System.out.println("That answer is correct.");
            score = score+1;
        }
        else {
            System.out.println("Incorrect! The correct answer is " + q3_ans);
        }
        
        // Question 4
        int q4_num1 = random.nextInt(101);
        int q4_num2 = random.nextInt(101);
        int q4_ans = q4_num1 + q4_num2;
        System.out.println(" What is " + q4_num1 + " + " + q4_num2 + "?");
        userInput = scanner.nextInt();
        if(userInput == q4_ans){
            System.out.println("That answer is correct.");
            score = score+1;
        }
        else {
            System.out.println("Incorrect! The correct answer is " + q4_ans);
        }
        
        // Calculate Score Percentage (25 percent for each question)
        int scorePercentage = score * 25;
        // Output score
        System.out.println("Congratulations! You scored a " + scorePercentage + "% !");
        
        // Clear scanner
        String clearScanner = scanner.nextLine();
        if(!clearScanner.isEmpty()){
            clearScanner = null;
        }
        
        /*
         * Extra Credit
         */
        System.out.println("Extra Credit");
        // Ask the user for a string
        System.out.println("Please input a string: ");
        String extraString1 = scanner.nextLine();
        // Ask the user for another string
        System.out.println("Please input another string: ");
        String extraString2 = scanner.nextLine();

        // Calculate and output lengths of strings
        System.out.println("The length of String 1 is " + extraString1.length() + " and the length of String 2 is " + extraString2.length());
        
        // Compare and output strings
        boolean equal = extraString1.equals(extraString2);
        System.out.println("Does String 1 equal String 2? " + equal);

        // Concatenate Strings
        String stringConcat = extraString1.concat(extraString2);
        System.out.println("String 1 concat with String 2: " + stringConcat);

        // Uppercase Strings
        System.out.println("String 1 Uppercase: " + extraString1.toUpperCase() + "\n\r" + "String 2 Uppercase: " + extraString2.toUpperCase());

        // Output character at position 7 of each string
        System.out.println("String 1 at char position 7: " + extraString1.charAt(6) + "\n\r" + "String 2 at char position 7: " + extraString2.charAt(6));

        // Output last character of each string
        System.out.println("Last letter of String 1: " + extraString1.charAt(extraString1.length() - 1) + "\n\r" + "Last letter of String 2: " + extraString2.charAt(extraString2.length() - 1)); 

        // Close Scanner
        scanner.close();
    }
    
}
