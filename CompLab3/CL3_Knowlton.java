/* Matthew Knowlton
   [CS1101 - SP22] Comprehensive Lab 3
   This work is to be done individually. It is not permitted to
   share, reproduce, or alter any part of this assignment for any
   purpose. Students are not permitted from sharing code,
   uploading this assignment online in any form, or
   viewing/receiving/modifying code written from anyone else. This
   assignment is part of an academic course at The University of
   Texas at El Paso and a grade will be assigned for the work
   produced individually by the student.
*/
import java.io.IOException;
import java.util.Scanner;
public class CL3_Knowlton {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        do{
            switch(scanner.nextInt()){
                case 1 -> {}
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 5 -> {}
                case 6 -> {}
            }
        } while(true);
    }
    public static void displayMainMenu() {
        System.out.println("\nPlease select a menu option below to get started. [Enter a number between 1 and 5]");
        System.out.println(" 1. View Flights");
        System.out.println(" 2. Add Flights");
        System.out.println(" 3. View Trips");
        System.out.println(" 4. Manage Trips");
        System.out.println(" 5. Checkout");
        System.out.println(" 6. Exit Meija Airlines");
    }
    public static void displayAvailableFlights(Flight[] flights) {
        
    }
    public static Integer getDestinationIdx(String city, Flight[] flights) {
        return 0;
    }
    public static String updateReceipt(Trip trip, String city) {
        return "";
    }
    public static Double getTripPrice(Trip trip) {
        return 0.0;
    }
    public static Double calculateDiscount(Double total, Double discountRate) {
        return 0.0;
    }
    public static Double calculateSubtotalWithDiscount(Double subtotal, Double discountAmount){
        return 0.0;
    }
    public static Double calculateTotalTax(Double total, Double taxRate){
        return 0.0;
    }
    public static Double calculateTotal(Double total, Double taxAmount){
        return 0.0;
    }
    public static void viewFinalReceipt(Double subtotal, Double discountRate, Double discountAmount, Double subtotalDiscount, Double taxAmount, Double total) {
        
    }
}