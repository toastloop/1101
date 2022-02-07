/*
    Game: Guessing Game
    Author: Matthew Knowlton
    Date: 2/7/2022
*/

// Import Scanner to get user input
import java.util.Scanner;
// Import Random to generate random number
import java.util.Random;


public class GuessNumberGame{
    public static void main(String[] args){
        // Initialize Variables
        String userName;
        int userGuessNumber;
        int secretNumber;
        // Initialize Scanner and Random
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Ask user for their name and assign to userName
        System.out.println("What is your name?");
        userName = scanner.nextLine();
        // Greet user with userName 
        System.out.println("Welcome " + userName + ". This is the Number Guessing Game.");
        secretNumber = random.nextInt(2);
        // Ask user for their guess and asssign it to userGuessNumber
        System.out.println("What is your guess?");
        userGuessNumber = scanner.nextInt();
        
        // Check if number matches guess
        if( userGuessNumber == secretNumber){
            System.out.println(userName + ", your number is correct! You Win the Game!");
        }
        else{
            System.out.println("Game over! The number was " + secretNumber);
        }
        
    }
}