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
import java.util.*;
import java.io.*;
public class CL2_Knowlton {
    public static void main(String[] args) throws IOException{
        // Show Welcome Message
        welcomingMessage();

        // Authenticate
        boolean authenticated = false;
        do{
            authenticated = authenticator();
        } while(authenticated == false);
        if(authenticated == true){
            System.out.println("\nUser is Logged In");
        }

        // Initialize variables
        int currentTicket = 0;
        char currentType = ' ';
        double currentPrice = 0.0;
        String currentTime = "";
        String currentDate = "";
        int currentAmount = 0;
        String currentFoodItem = "";
        double currentFoodPrice =  0.0;
        int rideCost = 0;
        String currentStateTax = "";
        double currentStateRate = 0.0;
        double subTotal = 0.0;
        double discountPrice  = 0.0;
        double taxAmount = 0.0;
        double totalAmount = 0.0;
        String cart = "";
        Scanner scanner = new Scanner(System.in);

        // Main Menu Loop
        do{

            // Display Menu
            displayMenu();
            
            // Prompt for Selection
            System.out.println("\nPlease enter a selection: ");
            System.out.print(">> ");
            int userChoice = scanner.nextInt();

            // Switch based on user selection
            switch(userChoice){

                // Add tickets
                case 1:

                    // Add ticket loop
                    boolean addTicket = false;
                    do{

                        // Print Ticket Menu
                        System.out.println("\n+---------------------------------------------+");
                        System.out.println("+       -- // Akbar's Theme Park // --        +");
                        System.out.println("+---------------------------------------------+");
                        System.out.printf("| %-6s | %-8s | %-12s | %-8s |\n", "Ticket", "Time", "PriceForEach", "Date");
                        System.out.println("+--------+----------+--------------+----------+");
                        File ticketList = new File("tickets.txt");
                        Scanner ticketScanner = new Scanner(ticketList);
                        ticketScanner.nextLine();
                        int i = 1;
                        while(ticketScanner.hasNextLine()){
                            System.out.printf("| %-6d | %-8s | %-12s | %-8s |\n", i, ticketScanner.next(), ticketScanner.nextDouble(), ticketScanner.next());
                            System.out.println("+--------+----------+--------------+----------+");
                            i++;
                        }
                        ticketScanner.close();
                        
                        // Ask for Ticket Selection
                        boolean ticketSelection = false;
                        do{
                            System.out.println("\nSelect a ticket from the list [1-8]");
                            System.out.print(">> ");
                            currentTicket = scanner.nextInt() - 1;
                            if(currentTicket < 0  || currentTicket > 7){
                                System.out.println("\nPlease enter a digit from 1-8.");
                            } else {
                                ticketSelection = true;
                            }
                        } while(ticketSelection == false);

                        // Ask for Type of Ticket
                        boolean typeSelection = false;
                        do{
                            System.out.println("\nAre you a student (s), an adult (a), or a kid (k)? [s/a/k]");
                            System.out.print(">> ");
                            String stringType = scanner.next();
                            currentType = stringType.charAt(0);
                            if(currentType != 's' && currentType != 'a' && currentType != 'k'){ 
                                System.out.println("\nPlease enter either s, a, or k.");
                            } else {
                                typeSelection = true;
                            }
                        } while(typeSelection == false);

                        // Ask for  Quantity of Ticket
                        boolean quantitySelection = false;
                        do{
                            System.out.println("\nHow many tickets do you want?");
                            System.out.print(">> ");
                            currentAmount = scanner.nextInt();
                            if(currentAmount < 0){
                                System.out.println("\nPlease enter a positive integer.");
                            } else  {
                                quantitySelection = true;
                            }
                        } while(quantitySelection ==  false);

                        // Pull Information for Selected Ticket
                        File ticketCheckList = new File("tickets.txt");
                        Scanner ticketCheckScanner = new Scanner(ticketCheckList);
                        ticketCheckScanner.nextLine();
                        int j = 0;
                        while(ticketCheckScanner.hasNextLine()){
                            currentTime = ticketCheckScanner.next();
                            currentPrice = ticketCheckScanner.nextDouble();
                            currentDate = ticketCheckScanner.next();
                            if(currentTicket == j){
                                break;
                            } else{
                                j++;
                            }
                        }
                        ticketCheckScanner.close();

                        // Determine discount
                        if(currentType == 's'){
                            discountPrice = 0.08;
                        } else if(currentType == 'a'){
                            discountPrice = 0.0;
                        } else if(currentType =='k'){
                            discountPrice = 0.09;
                        }
                        double ticketPrice = ((currentPrice * currentAmount) - (currentPrice * currentAmount * discountPrice));

                        // Calculate subtotal
                        subTotal = subTotal + ticketPrice;

                        // Add to cart
                        cart += currentTime + "\t\t$" + roundCents(ticketPrice) + "\t" + currentDate + "\n";
                        addTicket = true;
                    } while(addTicket == false);

                    // Print confirmation message
                    System.out.printf("\nThe ticket(s) have been added to your cart, your balance is  $%.2f\n", subTotal);
                break;

                case 2:
                    // Check if user doesn't have a ticket
                    if(currentType == ' '){
                        break;
                    }

                    // Determine ride cost  based on type of ticket.
                    if(currentType == 's'){
                        System.out.println("\nYour ride cost is $20.00 per student, for " + currentTime);
                        rideCost = 20;
                    }
                    else if(currentType == 'a'){
                        System.out.println("\nYour ride cost is $30.00 per adult, for " + currentTime);
                        rideCost = 30;
                    }
                    else if(currentType == 'k') {
                        System.out.println("\nYour ride cost is free per child, for " + currentTime);
                        rideCost = 0;
                    }

                    // Calculate new subtotal
                    subTotal = subTotal + (currentAmount * rideCost);

                    // Add to cart
                    cart += "A ride is reserved \t\t$" + (currentAmount * rideCost) + "\n";

                    // Print confirmation message
                    System.out.printf("The ride reservation has  been added to your cart, your balance is $%.2f\n", subTotal);
                break;

                case 3:
                    // Check if user doesn't have a ticket
                    if(currentType == ' '){
                        break;
                    }

                    // Print Food Menu
                    System.out.println("\n+-----------------------+");
                    System.out.println("+ -- // Food Menu // -- +");
                    System.out.println("+-----------------------+");
                    System.out.printf("| %-13s | %-5s |\n", "Item", "Price");
                    System.out.println("+---------------+-------+");
                    File foodFile = new File("Foodmenu.txt");
                    Scanner foodList = new Scanner(foodFile);
                    foodList.nextLine();
                    while(foodList.hasNextLine()){
                        System.out.printf("| %-13s | %-5.2f |\n", foodList.next(), foodList.nextDouble());
                        System.out.println("+---------------+-------+");
                    }
                    foodList.close();

                    // Prompt for food selection
                    boolean foodSelection = false;
                    do{
                    System.out.println("\nWhat do you want to order? (type the menu item)");
                    System.out.print(">> ");
                    String userItem = scanner.next();

                    // Pull information for food selection
                    File foodCheckList = new File("Foodmenu.txt");
                    Scanner foodCheckScanner = new Scanner(foodCheckList);
                    foodCheckScanner.nextLine();
                    while(foodCheckScanner.hasNextLine()){
                        currentFoodItem = foodCheckScanner.next();
                        currentFoodPrice = foodCheckScanner.nextDouble();
                        if(currentFoodItem.equals(userItem)){
                            foodSelection = true;
                            break;
                        }
                    }
                    foodCheckScanner.close();
                    if(foodSelection == false){
                        System.out.println("\nPlease check the spelling of the food you selected.");
                    }
                    }while(foodSelection == false);

                    // Add to Cart
                    cart += currentFoodItem + "\t\t\t$"  + currentFoodPrice + "\n";

                    // Calculate new subtotal
                    subTotal = subTotal + currentFoodPrice;

                    // Print confirmation message
                    System.out.println("\nA " + currentFoodItem + " has been added to your order.");

                    // Print new balance
                    System.out.printf("Your current balance is $%2.2f\n", subTotal);
                break;

                case 4:
                    // Print Cart
                    System.out.print("\n" + cart);
                break;

                case 5:
                    //Print Cart
                    System.out.println("\n" + cart);

                    // Show total before tax
                    System.out.printf("Your total before tax is $%2.2f\n", subTotal);

                    // Prompt for State Tax
                    boolean taxSelected = false;
                    do{
                        System.out.println("\nPlease enter your state: [Texas/New-York/...]");
                        System.out.print(">> ");
                        String taxInput = scanner.next();
                        File taxList = new File("StatesTaxRate.txt");
                        Scanner taxScanner = new Scanner(taxList);
                        taxScanner.nextLine();
                        while(taxScanner.hasNextLine()){
                            currentStateTax = taxScanner.next();
                            currentStateRate = taxScanner.nextDouble();
                            if(currentStateTax.equals(taxInput)){
                                taxSelected = true;
                                break;
                            }
                        }
                        if(taxSelected ==  false){
                            System.out.println("\nPlease check the spelling of your selected state.");
                        }
                        taxScanner.close();
                    }while(taxSelected == false);

                    // Print State Tax Rate
                    System.out.println("\nYour tax rate is  " + currentStateRate);
                    // Determine Tax Amount
                    taxAmount = subTotal * (currentStateRate * 0.01);
                    // Determine Total with Tax
                    totalAmount = subTotal + taxAmount;

                    // Print Total with Tax
                    System.out.printf("Your total after tax is: %.2f\n", totalAmount);

                    // Prompt for Credit Card
                    boolean creditChecked = false;
                    do{
                        System.out.println("\nPlease enter your card number: (16 digits)");
                        System.out.print(">>  ");
                        String creditCard = scanner.next();
                        if(creditCheck(creditCard) &&  (creditCard.length() == 16)){
                            creditChecked = true;
                        }
                        else{
                            System.out.println("\nPlease check your 16 digit card number.");
                        }
                    } while(creditChecked == false);

                    // If credit card is good clear cart
                    if(creditChecked == true){
                        System.out.println("\nThe transaction has been approved! Thank you!");
                        System.out.println("Your cart is now empty!");
                        currentTicket = 0;
                        currentType = ' ';
                        currentPrice = 0.0;
                        currentTime = "";
                        currentDate = "";
                        currentAmount = 0;
                        currentFoodItem = "";
                        currentFoodPrice =  0.0;
                        subTotal = 0.0;
                        discountPrice  = 0.0;
                        taxAmount = 0.0;
                        totalAmount = 0.0;
                        cart = "";
                    } else {
                        System.out.println("There was an error with your credit card.");
                        break;
                    }
                break;

                case 6:
                    // Prompt user for confirmation
                    System.out.println("Are you sure? [y/n]");
                    System.out.print(">> ");
                    char userInput = scanner.next().charAt(0);
                    if(userInput == 'y'){
                        currentTicket = 0;
                        currentType = ' ';
                        currentPrice = 0.0;
                        currentTime = "";
                        currentDate = "";
                        currentAmount = 0;
                        currentFoodItem = "";
                        currentFoodPrice =  0.0;
                        subTotal = 0.0;
                        discountPrice  = 0.0;
                        taxAmount = 0.0;
                        totalAmount = 0.0;
                        cart = "";
                        System.out.println("\nItems from your cart have been removed!");
                    }
                break;

                case 7:
                    // Print Leaving Message
                    System.out.println("\nHave a Great Day, See You Soon!");
                    // Close scanner
                    scanner.close();
                    // Exit
                    System.exit(0);
                break;

                default:
                    // Printer Error Message
                    System.out.println("\nPlease enter an integer from 1-7.");
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

    public static boolean authenticator() throws IOException{
        //This function takes care of authentication (sign in/up).
        Scanner scanner = new Scanner(System.in);

        // Prompt if user is already signed up
        System.out.println("\nAlready signed up? [y/n]");
        System.out.print(">>  ");
        String userInput = scanner.next();

        // Direct user to either Sign in or Sign up
        if(userInput.equals("y")){
            return signIn();
        } else {
            return signUp();
        }
    }

    public static boolean signIn() throws IOException{
        //The function takes care of sign in action.
        boolean signedIn = false;
        // tracks login attemps
        int loginAttempts = 0;
        // Loop for user login
        do{
            // If user has surpassed 3 chances exit.
            if(loginAttempts == 3){
                System.out.println("Error: You attempted to login to many times.");
                System.exit(0);
            }
            // Prompt for email address.
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter your email address:");
            System.out.print(">> ");
            String userName = scanner.next();
            // Prompt for password
            System.out.println("\nEnter your password:");
            System.out.print(">> ");
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
            // If sign in failed print error message
            if(signedIn == false){
                System.out.println("\nError: Invalid Email or Password");
            }
            // Close scanner
            userScanner.close();
            // Add one to login attempts
            loginAttempts++;
        }while(signedIn == false);
        //  Return sign in status
        return signedIn;
    }

    public static boolean signUp() throws IOException{
        //This function takes care of sign up action.
        boolean signedUp = false;
        // Sign up loop
        do{
            Scanner scanner = new Scanner(System.in);
            String userEmail = "";
            String userPass = "";
            String userPassConfirm = "";

            // Loop for user email and validation
            boolean emailValid = false;
            do{
                System.out.println("\nEnter your  email address: ");
                System.out.print(">> ");
                userEmail = scanner.next();
                if(userEmail.contains("@")){
                    emailValid = true;
                } else {
                    System.out.println("Error: Enter a Valid Email Address");
                }
            }while(emailValid == false);

            // Loop for user password and validation
            boolean passwordValid = false;
            do{
                System.out.println("\nEnter your  email password: (At least 8 characters, one uppercase and one lowercase, and one digit and one special character)");
                System.out.print(">> ");
                userPass = scanner.next();
                System.out.println("\nEnter your  password again: ");
                System.out.print(">> ");
                userPassConfirm = scanner.next();
                if(userPass.equals(userPassConfirm) && passwordChecker(userPass)){
                    passwordValid = true;
                } else {
                    System.out.println("Error: Passwords either do  not match or are invalid.");
                }
            } while(passwordValid == false);

            // if validation passes, write login to file
            if(emailValid && passwordValid){
                FileWriter fw = new FileWriter("authenticateFile.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.newLine();
                bw.write(userEmail + " "  + userPass);
                bw.close();
                signedUp = true;
                break;
            }
        } while(signedUp == false);
        // return sign up status
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
    public static boolean creditCheck(String creditCard) {
        // Base case if no string left
        if(creditCard == ""){
            return true;
        } else {
            // check if digit and call substring
            return Character.isDigit(creditCard.charAt(creditCard.length()-1)) && creditCheck(creditCard.substring(0, creditCard.length()-1));
        }
    }

    public static double roundCents(double value){
        // Rounds dollar double variables to the nearest cent
        return (Math.round(value * Math.pow(10, 2)) / Math.pow(10, 2));
    }
    public static void flush(){
        // Flushes Screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static void displayMenu() {
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
}
