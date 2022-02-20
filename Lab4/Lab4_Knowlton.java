/*
    Name: Lab4_Knowlton
    Author Name: Matthew Knowlton
    Lab Number: 4
    Date: 14 February 2022
*/
import java.util.Scanner;
public class Lab4_Knowlton {
    public static void main(String[] args){

        // Init Scanner
        Scanner scanner = new Scanner(System.in);

        // Prompt for user name
        String name;
        System.out.println("\n\rPlease enter a name.");
        name = scanner.nextLine();

        // Print Welcome and Menu
        System.out.println("\n\rWelcome to CS 1101 Coffee Shop, " + name + "!");
        System.out.println("\n\r*MENU*\n\r" +
        "\n\r" +
        "\tCOFFEE\n\r" +
        "1) Americano - $1.50\n\r" +
        "2) Latte - $3.50\n\r" +
        "3) Cappuccino - $3.25\n\r" +
        "4) Espresso - $2.00\n\r" +
        "\n\r" +
        "\tPASTRIES\n\r" +
        "5) Coffee Cake - $5.00\n\r" +
        "6) Muffin pastry - $3.00\n\r" +
        "7) Lemon Bread - $2.25");

        // Init variables used later
        int selection;
        String item;
        int quantity;
        double price;
        double subtotal;
        double discount;
        double tax;
        double total;

        // Get user selection
        System.out.println("\n\rPlease select an item off of the menu.");
        selection = scanner.nextInt();

        // Set item and price for selection
        switch(selection){
            case 1:
                item = "Americano";
                price = 1.50;
            break;
            case 2:
                item = "Latte";
                price = 3.50;
            break;
            case 3:
                item = "Cappuccino";
                price = 3.25;
            break;
            case 4:
                item = "Espresso";
                price = 2.00;
            break;
            case 5:
                item = "Coffee Cake";
                price = 5.00;
            break;
            case 6:
                item = "Muffin Pastry";
                price = 3.00;
            break;
            case 7:
                item = "Lemon Bread";
                price = 2.25;
            break;
            default:
                item = "";
                price = 0.00;
            break;
        }

        // Print item selection
        if(item != ""){
            System.out.println("\n\rYou have selected " + item);
        }
        else{
            System.out.println("\n\rSelection not found");
            System.exit(1);
        }

        // Prompt for quantity
        System.out.println("\n\rPlease enter a quantity.");
        quantity = scanner.nextInt();

        // Calculate Subtotal Before Tax and Discount
        subtotal = price*quantity;
        System.out.print("\n\rTotal Before Tax and Discount: $");
        System.out.printf("%.2f\n\r", (subtotal));

        // Calculate discount
        if(subtotal >= 10.00){
            discount = subtotal * 0.1;
        }
        else{
            discount = 0.00;
        }
        System.out.print("\n\rDiscount: $");
        System.out.printf("%.2f\n\r", (discount));

        // Calculate Subtotal After Discount
        subtotal = subtotal - discount;
        System.out.print("Price After Discount: $");
        System.out.printf("%.2f\n\r", (subtotal));

        // Calculate Tax
        tax = subtotal * 0.07;
        System.out.print("Tax: $");
        System.out.printf("%.2f\n\r", (tax));

        // Calculate Total after Discount and Tax
        total = subtotal + tax;
        System.out.print("Total: $");
        System.out.printf("%.2f\n\r", (total));

        // Close Scanner
        scanner.close();

    }
}
