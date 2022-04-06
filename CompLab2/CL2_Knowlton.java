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
import java.util.Scanner;
import java.io.*;
public class CL2_Knowlton {

    public static void main(String[] args) throws FileNotFoundException{
        welcomingMessage();
        boolean authenticated = false;
        do{
            authenticated = authenticator();
        } while(authenticated == false);
        if(authenticated == true){
            System.out.println("User is Logged In");
        }
    }

    public static void welcomingMessage() {
        //This function displays a welcoming message.
        System.out.println("*************************************");
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
        return true;
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
    }

    public static boolean isAllDigits(String str) {
        //TODO
        //this function checks if the credit card number is all in digits.
        return true;
    }

}
