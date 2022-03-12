/* Matthew Knowlton
[CS1101] Comprehensive Lab 1
This work is to be done individually. It is not permitted to
share, reproduce, or alter any part of this assignment for any
purpose. Students are not permitted from sharing code, uploading
this assignment online in any form, or viewing/receiving/
modifying code written from anyone else. This assignment is part
of an academic course at The University of Texas at El Paso and
a grade will be assigned for the work produced individually by
the student.
*/
// Import Scanner and File
import java.util.Scanner;
import java.io.*;
public class CL1_Knowlton {
    public static void main(String[] args) throws FileNotFoundException {
        // Open Input Scanner
        Scanner userScanner = new Scanner(System.in);
        // Holds list of User Flights
        String userFlights = "";
        // Holds subtotal for User Flights
        double subtotal = 0.0;
        // Outer Loop Begins
        do{
            // Prints Menu
            System.out.println("\nWELCOME TO MEJIA AIRLINES");
            System.out.println("  1. Add flight");
            System.out.println("  2. View trip");
            System.out.println("  3. Manage trip");
            System.out.println("  4. Checkout");
            System.out.println("  5. Exit Mejia Airlines");
            System.out.print(">> ");
            // Get User Choice for Menu
            int menuChoice = userScanner.nextInt();
            // If User Choice is Exit, Break out of Outer Loop
            if(menuChoice == 5){
                break;
            }
            // Inner Loop for Menu
            while(true){
                // Switch based on User Choice for Menu
                switch(menuChoice){
                    /*** 
                     * 1. Add flight 
                     */
                    case 1:
                        // Open Flight List File
                        File flightList = new File("flights.txt");
                        // Initiate a Scanner for Flight List
                        Scanner flightScanner = new Scanner(flightList);
                        // Skip header row of Flight List
                        flightScanner.nextLine();
                        // Print Header for Table
                        System.out.println("\n+-------------------------------------+");
                        System.out.printf("| %35s |\n", "AVAILABLE FLIGHTS FOR EP     ");
                        System.out.println("+--------------+---------+------------+");
                        System.out.printf("| %-12s | %-7s | %-10s |\n", "City Name", "One Way", "Round Trip");
                        // Loop through each line of Flight List
                        while(flightScanner.hasNextLine()){
                            // Grab City Name, One Way Fare, and Round Trip Fare
                            String cityName = flightScanner.next();
                            Double oneWay = flightScanner.nextDouble();
                            Double roundTrip = flightScanner.nextDouble();
                            // Print Decoration Row
                            System.out.println("+--------------+---------+------------+");
                            // Print Formatted Flight
                            System.out.printf("| %-12s | %-7.2f | %-10.2f |\n", cityName, oneWay, roundTrip);
                        }
                        // Print Final Decoration Row
                        System.out.println("+--------------+---------+------------+");
                        // Close Flight List Scanner
                        flightScanner.close();
                        // Prompt for Name of City
                        System.out.println("\nWhat flight would you like to get? Enter the name of the city");
                        System.out.print(">> ");
                        String flightCity = userScanner.next();
                        // Prompt for Flight type
                        System.out.println("What are you purchasing?\n\t1. One-way\n\t2. Round trip");
                        System.out.print(">> ");
                        int flightType = userScanner.nextInt();
                        // Prompt for number of seats
                        System.out.println("How many seats will you be purchasing?");
                        System.out.print(">> ");
                        int flightSeats = userScanner.nextInt();
                        // Initiate One Way Fare and Round Trip outside of Loop
                        double oneWay = 0.0;
                        double roundTrip = 0.0;
                        // (Re)open the flight list scanner
                        flightScanner = new Scanner(flightList);
                        // Skip the Header line of Flight List
                        flightScanner.nextLine();
                        // Loop through Flight list
                        while(flightScanner.hasNextLine()){
                            // Get city name, one way fare, and round trip from file
                            String city = flightScanner.next();
                            oneWay = flightScanner.nextDouble();
                            roundTrip = flightScanner.nextDouble();
                            // if city is equal to chosen city, break loop
                            if(flightCity == city){
                                break;
                            }
                        }
                        // (Re)close Flight list scanner
                        flightScanner.close();
                        // Choose cost based on flight type
                        double flightCost = (flightType == 1) ? oneWay : roundTrip;
                        // Multiply cost by number of seats to find flight total
                        double flightTotal = flightCost * flightSeats;
                        String flightTypeString = (flightType == 1) ? "One Way" : "Round Trip";
<<<<<<< HEAD
                        // Add flight to list of flights
                        userFlights += String.format("EL PASO to %-12s [Total] $%-12.2f [Type] %-12s [Seats] %-2s", flightCity, flightTotal, flightTypeString, flightSeats);
=======
                        // Add flight to list of flights 
                        userFlights += "EL PASO to " + String.format("%-12s", flightCity) + " [Total] $" + String.format("%-12s", flightTotal) + " [Type] " + String.format("%-12s", flightTypeString) + " [Seats] " + String.format("%-2s", flightSeats) + "\n";
                        // Add flight total to running subtotal
>>>>>>> dffec68 (Removed unused code)
                        subtotal += flightTotal;
                        System.out.println("\nFLIGHT ADDED!");
                    break;
                    /**
                     * 2. View trip
                     */
                    case 2:
                        // Print list of flights
                        System.out.println("\n----------------------------- TRIP INFORMATION ----------------------------");
                        System.out.println(userFlights);
                    break;
                    /**
                     * 3. Manage trip
                     */
                    case 3:
                        // Print user warning
                        System.out.println("\nThis option clears your cart.");
                        // Prompt user for confirmation
                        System.out.println("Are you sure you want to clear your trips? [type in YES or NO]");
                        System.out.print(">> ");
                        // If user inputs yes
                        if(userScanner.next().equals("YES")){
                            // Clear flight string
                            userFlights = "";
                            // Clear running subtotal
                            subtotal = 0.0;
                            // Print message saying cart was cleared
                            System.out.println("\nCart cleared.");
                        }
                        else{
                            // Print message telling the user nothing happened
                            System.out.println("\nCart not changed.");
                            System.out.println("Going back to menu...");
                        }
                    break;
                    /**
                     * 4. Checkout
                     */
                    case 4:
                        // Prompt user for frequent flier number
                        System.out.println("\nPlease enter your frequent flier number");
                        System.out.print(">> ");
                        String frequentFlier = userScanner.next();
                        // Open frequent flier list file
                        File frequentFlierList = new File("frequent-flyer-list.txt");
                        Scanner frequentFlierScanner = new Scanner(frequentFlierList);
                        // Loop through frequent flier list
                        while(frequentFlierScanner.hasNextLine()){
                            // Check if current line matches given number
                            if(frequentFlierScanner.next().equals(frequentFlier)){
                                // Apply 20% Discount
                                subtotal = subtotal - (subtotal * 0.2);
                            }
                        }
                        // Close frequent flier list
                        frequentFlierScanner.close();
                        // Calculate Tax
                        double tax = subtotal * 0.075;
                        // Calculate Total with Tax
                        double total = subtotal + tax;
                        // Print current total
                        System.out.printf("\nYour current total is: $%.2f\n", total);
                        // Prompt user for credit card information
                        System.out.println("Please enter a 16 digit visa/master card number");
                        System.out.print(">> ");
                        String card = userScanner.next();
                        // Print receipt
                        System.out.println("\nYour purchase for:");
                        System.out.print(userFlights);
                        System.out.printf("\nwas successful. You paid $%.2f using the card: %s\n", total, card);
                        System.out.println("Have fun on your trip!");
                        // Exit Program
                        System.exit(0);
                    break;
                    /**
                     * Default Choice
                     */
                    default:
                    break;
                }
                break; // Break out of Inner Loop
            } // End of Inner Loop
        } while(true); // End of Outer Loop
        // Print Exit Statement
        System.out.println("\nThank you for using Mejia Airlines.");
        System.out.println("Stay Safe! Stay Hydrated! Happy Coding!");
        // Close Input Scanner
        userScanner.close();
    }
}
