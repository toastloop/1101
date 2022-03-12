/*
    Name: Lab7_Knowlton
    Author Name: Matthew Knowlton
    Lab Number: 7
    Date: 11 March 2022
*/
// Import Scanner to scan through file
import java.util.Scanner;
// Import java.io.* to read text file
import java.io.*;
public class Lab7_Knowlton {
    public static void main(String[] args) throws FileNotFoundException {
        // Open Birthdays file and Create Scanner
        File birthdaysFile = new File("birthdays.txt");
        Scanner birthdayScanner = new Scanner(birthdaysFile);
        // Skip Header Line
        birthdayScanner.nextLine();
        // Print Heading Line
        System.out.println("+------------------------------------------------------------------+");
        // Print Title
        System.out.println("|                      Lab 7 - Birthday/Generations                |");
        // Print Border
        System.out.println("+-----------+------+-------+-----+-----+---------------------------+");
        // Displayed formatted Table Headings
        System.out.printf("| %-9s | %-4s | %-5s | %-3s | %-3s | %-25s | \n", "Name", "Year", "Month", "Day", "Age", "        Generation");
        // Print Border
        System.out.println("+-----------+------+-------+-----+-----+---------------------------+");

        // Loop over lines from Birthdays file
        while (birthdayScanner.hasNextLine()) {
            // Grab variables from current line
            int birthYear = birthdayScanner.nextInt();
            int birthMonth = birthdayScanner.nextInt();
            int birthDay = birthdayScanner.nextInt();
            String nameOfPerson = birthdayScanner.next();
            // Get age of Person from yearsOfPerson function
            int ageOfPerson = yearsOfPerson(birthYear);
            // Get generation of person from  yearGeneration function
            String generationOfPerson = yearGeneration(ageOfPerson);
            // Display information formatted into table row
            System.out.printf("| %-9s | %-4d | %-5d | %-3d | %-3d | %-25s | \n", nameOfPerson, birthYear, birthMonth, birthDay, ageOfPerson, generationOfPerson);
            // Print border
            System.out.println("+-----------+------+-------+-----+-----+---------------------------+");
        }
        // Close scanner
        birthdayScanner.close();
    }
    // yearsOfPerson takes (int birthYear) returns (int ageOfPerson)
    public static int yearsOfPerson(int birthYear) {
        // Set given year to this year
        int givenYear = 2022;
        // Determine age by subtracting birthYear from givenYear
        int ageOfPerson = givenYear - birthYear;
        // Return age
        return ageOfPerson;
    }
    // yearGeneration takes (int ageOfPerson) returns (String generationOfPerson)
    public static String yearGeneration(int ageOfPerson) {
        // If/Else statement to return generation of person
        if(ageOfPerson < 6){
            return "Generation Alpha";
        }
        else if(ageOfPerson < 22){
            return "Generation Z";
        }
        else if(ageOfPerson < 38){
            return "Millennials Generation";
        }
        else if(ageOfPerson < 54){
            return "Generation X";
        }
        else if(ageOfPerson < 73){
            return "Baby Boomers Generation";
        }
        else if(ageOfPerson < 90){
            return "Silent Generation";
        }
        else{
            return "Greatest Generation";
        }
    }
}