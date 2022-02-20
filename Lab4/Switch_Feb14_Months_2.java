/*
Feb 14, 2022
Author: Bianca Alvarez

Switch Branching

Example from Zybooks
*/

import java.util.Random;

public class Switch_Feb14_Months_2 {
	public static void main (String [] args) {
		int month;

		Random rand = new Random();
	   	//generate a number between 1 -12
	   	//randomNum = minimum + rand.nextInt((maximum - minimum) + 1);
		month = 1 + rand.nextInt((12 - 1) + 1);
		System.out.println("Your random num is: " + month);

		if(month == 1) {
			System.out.println("January");

		}
		else if(month == 2) {
			System.out.println("February");

		}
		else if(month == 3) {
			System.out.println("March");

		}
		else if(month == 4) {
			System.out.println("April");

		}
		else if(month == 5) {
			System.out.println("May");

		}
		else if(month == 6) {
			System.out.println("June");

		}
		else if(month == 7) {
			System.out.println("July");

		}
		else if(month == 8) {
			System.out.println("August");

		}
		else if(month == 9) {
			System.out.println("September");

		}
		else if(month == 10) {
			System.out.println("October");

		}
		else if(month == 11) {
			System.out.println("November");

		}
		else if(month == 12) {
			System.out.println("December");

		}
		else{
			System.out.println("Not a month");

		}
			
		

	}


}