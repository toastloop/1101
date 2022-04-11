/* Matthew Knowlton
[CS1101] Comprehensive Lab 2
This work is to be done individually. It is not permitted to
share, reproduce, or alter any part of this assignment for any
purpose. Students are not permitted from sharing code, uploading
this assignment online in any form, or viewing/receiving/
modifying code written from anyone else. This assignment is part
of an academic course at The University of Texas at El Paso and
a grade will be assigned for the work produced individually by
the student.
*/
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
public class CL2_Knowlton {

    public static void main(String[] args) throws FileNotFoundException{
        welcomingMessage();
        /*
        boolean authenticated = false;
        do{
            authenticated = authenticator();
        } while(authenticated == false);
        if(authenticated == true){
            System.out.println("User is Logged In");
        }
        */

        String[][] userTickets = new String[10][6];
        int currentTicket = -1;
        String[][] userFood = new String[10][2];
        int currentFood  = -1;
        double subTotal = 0;

        do{

            displayMenu();

            Scanner scanner = new Scanner(System.in);
            System.out.println("\nPlease enter a selection: ");
            System.out.print(">> ");
            int userChoice = scanner.nextInt();

            switch(userChoice){
                case 1:
                    currentTicket++;
                    subTotal = buyTicket(userTickets, currentTicket);
                break;
                case 2:
                    reserveRide(userTickets, currentTicket);
                break;
                case 3:
                    currentFood++;
                    subTotal = buyFood(userFood, currentFood);
                break;
                case 4:
                    showOrder();
                break;
                case 5:
                    checkOut();
                break;
                case 6:
                    clearCart(userTickets, userFood);
                break;
                case 7:
                    exitProgram();
                break;
                default:
                    System.out.println("Please enter a number from  1-7");
                break;
            }
        }while(true);
    }

    public static void welcomingMessage() {
        //This function displays a welcoming message.
        System.out.println("\n*************************************");
        System.out.println("******* Welcome to Akbar Park *******");
        System.out.println("*************************************");
    }

    public static boolean authenticator() throws FileNotFoundException{
        //This function takes care of authentication (sign in/up).
        Scanner scanner = new Scanner(System.in);
        System.out.println("Already signed up? [y/n] ");
        String userInput = scanner.next();
        if(userInput.equals("y")){
            return signIn();
        } else {
            return signUp();
        }
    }

    public static boolean signIn() throws FileNotFoundException{
        //The function takes care of sign in action.
        boolean signedIn = false;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your email address:");
            String userName = scanner.next();
            System.out.println("Enter your password:");
            String passWord = scanner.next();
            // Open Authentication List File
            File userList = new File("authenticateFile.txt");
            // Initiate a Scanner for Authentication List
            Scanner userScanner = new Scanner(userList);
            // Loop through each line of Authentication List
            while(userScanner.hasNextLine()){
                String userListName = userScanner.next();
                String userListPassword = userScanner.next();
                // Check that username and password equal  provided  credentials
                if(userName.equals(userListName) && passWord.equals(userListPassword)){
                    signedIn = true;
                    break;
                }
            }
            if(signedIn == false){
                System.out.println("Error: Invalid Email or Password");
            }
            userScanner.close();
        }while(signedIn == false);
        return signedIn;
    }

    public static boolean signUp(){
        //This function takes care of sign up action.
        boolean signedUp = false;
        do{
        Scanner scanner = new Scanner(System.in);
            boolean emailValid = false;
            do{
                System.out.println("Enter your  email address: ");
                String userEmail = scanner.next();
                if(userEmail.contains("@")){
                    emailValid = true;
                } else {
                    System.out.println("Error: Enter a Valid Email Address");
                }
            }while(emailValid == false);
            boolean passwordValid = false;
            do{
                System.out.println("Enter your  email password: (At least 8 characters, one uppercase and one lowercase, and one digit and one special character)");
                String userPass = scanner.next();
                System.out.println("Enter your  password again: ");
                String userPassConfirm = scanner.next();
                if(userPass.equals(userPassConfirm) && passwordChecker(userPass)){
                    passwordValid = true;
                } else {
                    System.out.println("Error: Passwords either do  not match or are invalid.");
                }
            } while(passwordValid == false);
            if(emailValid && passwordValid){
                signedUp = true;
                break;
            }
        } while(signedUp == false);
        return signedUp;
    }

    public static boolean passwordChecker(String password) {
        //This function checks the password requirements.
        boolean lowerCase = hasLowerCase(password);
        boolean upperCase = hasUpperCase(password);
        boolean digitChar  = hasDigit(password);
        boolean specialChar = hasSpecialChar(password);
        boolean length = hasEightChar(password);
        if(!lowerCase || !upperCase || !digitChar || !specialChar || !length){
            return false;
        } else {
            return true;
        }
    }

    public static boolean hasLowerCase(String password) {
        //This function checks if the string has a lower case letter.
        char[] passwordArray = password.toCharArray();
        boolean passwordLower = false;
        for(int i = 0; i < passwordArray.length; i++){
            if(Character.isLowerCase(passwordArray[i])){
                passwordLower = true;
            }
        }
        return passwordLower;
    }

    public static boolean hasUpperCase(String password) {
        //This function checks if the string has an upper case letter.
        char[] passwordArray = password.toCharArray();
        boolean passwordUpper = false;
        for(int i = 0; i < passwordArray.length; i++){
            if(Character.isUpperCase(passwordArray[i])){
                passwordUpper = true;
            }
        }
        return passwordUpper;
    }

    public static boolean hasDigit(String password) {
        //This function checks if the string has a digit.
        char[] passwordArray = password.toCharArray();
        boolean passwordDigit = false;
        for(int i = 0; i < passwordArray.length; i++){
            if(Character.isDigit(passwordArray[i])){
                passwordDigit = true;
            }
        }
        return passwordDigit;
    }

    public static boolean hasSpecialChar(String password) {
        //This function checks if the string has a special character.
        char[] passwordArray = password.toCharArray();
        boolean passwordSpecial = false;
        for(int i = 0; i < passwordArray.length; i++){
            if(!Character.isLetterOrDigit(passwordArray[i])){
                passwordSpecial = true;
            }
        }
        return passwordSpecial;
    }

    public static boolean hasEightChar(String password) {
        //This function checks if the string has at least eight characters
        return (password.length() >= 8);
    }

    public static void displayMenu() {
        //TODO
        // This function displays the options in the menu
        System.out.println("\nChoose an Item [1-7]");
        System.out.println("1 - Buy Ticket");
        System.out.println("2 - Reserve a Ride");
        System.out.println("3 - Buy Food");
        System.out.println("4 - Show the Orders");
        System.out.println("5 - Check Out");
        System.out.println("6 - Clear the Cart");
        System.out.println("7 - Exit");
    }

    public static boolean isAllDigits(String str) {
        //TODO
        //this function checks if the credit card number is all in digits.
        return true;
    }

    public static double buyTicket(String[][] userTickets, int currentTicket) throws FileNotFoundException{
        //TODO

        File ticketList = new File("tickets.txt");
        Scanner ticketScanner = new Scanner(ticketList);
        String[][] ticketListArray = new String[8][3];
        String[] selectedTicket = new String[3];
        String userTypeSelection = "";
        int userTicketSelection = 0;
        int userTicketAmount = 0;

        // Skip Header Line
        ticketScanner.nextLine();

        int i = 0;
        while(ticketScanner.hasNextLine()){
            ticketListArray[i][0] = ticketScanner.next();
            ticketListArray[i][1] = ticketScanner.nextDouble();
            ticketListArray[i][2] = ticketScanner.next();
            i++;
        }

        boolean addTicket = false;
        do{
            System.out.println("\n+---------------------------------------------+");
            System.out.println("+       -- // Akbar's Theme Park // --        +");
            System.out.println("+---------------------------------------------+");
            System.out.printf("| %-6s | %-8s | %-12s | %-8s |\n", "Ticket", "Time", "PriceForEach", "Date");
            System.out.println("+--------+----------+--------------+----------+");

            int j = 1;
            for(String[] ticket: ticketListArray){
                System.out.printf("| %-6d | %-8s | %-12s | %-8s |\n", j, ticket[0], ticket[1], ticket[2]);
                System.out.println("+--------+----------+--------------+----------+");
                j++;
            }

            Scanner userInput = new Scanner(System.in);

            System.out.println("\nSelect a ticket from the list [1-8]");
            System.out.print(">>");
            userTicketSelection = (userInput.nextInt() - 1);
            do{
                if(!(userTicketSelection <= ticketListArray.length)){
                    System.out.println("\nPlease enter an integer from 1-8");
                    System.out.print(">> ");
                    userTicketSelection = (userInput.nextInt() - 1);
                } else {
                    selectedTicket = ticketListArray[userTicketSelection];
                }
            }while(!(userTicketSelection <= ticketListArray.length));

            System.out.println("\nAre you a student (s), an adult (a), or a kid (k)? [s/a/k]");
            System.out.print(">>");
            userTypeSelection = userInput.next();
            do{
                if(!(userTypeSelection.equals("s") || userTypeSelection.equals("a")  || userTypeSelection.equals("k"))){
                    System.out.println("Please enter s, a, or k.");
                    System.out.print(">> ");
                    userTypeSelection = userInput.next();
                }
            }while(!(userTypeSelection.equals("s") || userTypeSelection.equals("a")  || userTypeSelection.equals("k")));

            System.out.println("\nHow many tickets do you want?");
            System.out.print(">> ");
            userTicketAmount = userInput.nextInt();
            do{
                if(!(userTicketAmount  > 0)){
                    System.out.println("Please enter a positive number.");
                    System.out.print(">>");
                    userTicketAmount = userInput.nextInt();
                }else {
                    addTicket = true;
                }
            }while(!(userTicketAmount  > 0));

        }while(addTicket == false);

        userTickets[currentTicket][0] = selectedTicket[0];
        userTickets[currentTicket][1] = selectedTicket[1] + "";
        userTickets[currentTicket][2] = selectedTicket[2];
        userTickets[currentTicket][3] = userTypeSelection;
        userTickets[currentTicket][4] = userTicketAmount + "";

        for(String[] ticket : userTickets){
            System.out.println(Arrays.toString(ticket));
        }

        double subTotal = selectedTicket[1] *  userTicketAmount;
        return (selectedTicket[1] *  userTicketAmount);

    }
    public static double reserveRide(String[][] userTickets, int currentTicket){
        //TODO
        String currentValue = userTickets[currentTicket-1][3];
        System.out.print(currentValue);
        if(currentValue == "s"){
            System.out.println("Your ride cost is $20.00 per student, for " + userTickets[currentTicket-1][0]);
        }
        else if(currentValue == "a"){
            System.out.println("Your ride cost is $30.00 per adult, for " + userTickets[currentTicket-1][0]);
        }
        else if(currentValue == "k") {
            System.out.println("Your ride cost is free per child, for " + userTickets[currentTicket-1][0]);
        }
        return 0.0;
    }
    public static int buyFood(String[][] userFood, int currentFood){
        //TODO
        return currentFood + 1;
    }
    public static void showOrder(){
        //TODO
    }
    public static void checkOut(){
        //TODO
    }
    public static void clearCart(String[][] userTickets, String[][] userFood){
        userTickets = new String[10][6];
        userFood =  new String[10][2];
    }
    public static void exitProgram() {
        System.out.println("Have a Great Day, See You Soon!");
        System.exit(0);
    }
}
