/*
Author: Matthew Knowlton
Date: 14 February 2022
Assignment: Switch Branch
*/

// Import Java Random Generator
import java.util.Random;
public class SwitchBranch {
	public static void main (String [] args) {
        // Initialize Random Generator
        Random random = new Random();
        // Generate random number between 1 and 12
        int month = 1 + random.nextInt((12 - 1) + 1);
        // Print the random number
        System.out.println("Your random month is: " + month);
        // Switch based on random number to print month name
        switch(month){
            case 1:
                System.out.println("January");
            break;
            case 2:
                System.out.println("February");
            break;
            case 3:
                System.out.println("March");
            break;
            case 4:
                System.out.println("April");
            break;
            case 5:
                System.out.println("May");
            break;
            case 6:
                System.out.println("June");
            break;
            case 7:
                System.out.println("July");
            break;
            case 8:
                System.out.println("August");
            break;
            case 9:
                System.out.println("September");
            break;
            case 10:
                System.out.println("October");
            break;
            case 11:
                System.out.println("November");
            break;
            case 12:
                System.out.println("December");
            break;
            default:
                System.out.println("Not a Month!");
            break;
        }
	}
}
