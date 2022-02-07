/*
    Name: Lab3_Knowlton
    Author Name: Matthew Knowlton
    Lab Number: 3
    Date: 7 February 2022
*/
import java.util.Scanner;
import java.util.Random;
public class Lab3_Knowlton {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        
        int q1_num1 = random.next(101);
        int q1_num2 = random.next(101);
        int q1_ans = q1_num1 + q1_num2;
        System.out.println(" What is " + q1_num1 + " + " + q1_num2 + "?");
        userInput = scanner.nextLine();
        if(userInput == q1_ans){
            System.out.println("That answer is correct.");
            score = score+1;
        }
        else {
            System.out.println("Incorrect! The correct answer is " + q1_ans);
        }
        
        int q2_num1 = random.next(101);
        int q2_num2 = random.next(101);
        int q2_ans = q2_num1 + q2_num2;
        System.out.println(" What is " + q2_num1 + " + " + q2_num2 + "?");
        userInput = scanner.nextLine();
        if(userInput == q2_ans){
            System.out.println("That answer is correct.");
            score = score+1;
        }
        else {
            System.out.println("Incorrect! The correct answer is " + q1_ans);
        }

        int q3_num1 = random.next(101);
        int q3_num2 = random.next(101);
        int q3_ans = q3_num1 + q3_num2;
        System.out.println(" What is " + q3_num1 + " + " + q3_num2 + "?");
        userInput = scanner.nextLine();
        if(userInput == q3_ans){
            System.out.println("That answer is correct.");
            score = score+1;
        }
        else {
            System.out.println("Incorrect! The correct answer is " + q1_ans);
        }
        
        int q4_num1 = random.next(101);
        int q4_num2 = random.next(101);
        int q4_ans = q4_num1 + q4_num2;
        System.out.println(" What is " + q4_num1 + " + " + q4_num2 + "?");
        userInput = scanner.nextLine();
        if(userInput == q4_ans){
            System.out.println("That answer is correct.");
            score = score+1;
        }
        else {
            System.out.println("Incorrect! The correct answer is " + q1_ans);
        }
        
        double scorePercentage = (score / 4) * 100;
        System.out.println("Congrulations! You scored a " + scorePercentage + "% !");
        
        
    }
    
}