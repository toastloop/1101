/**
 * PasswordValidation
 */
import java.util.Scanner;
public class PasswordValidation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a password: ");
        System.out.print(">>");
        String password = scanner.next();
        char[] passwordArray = password.toCharArray();
        boolean uppercase = false;
        boolean lowercase = false;
        boolean number = false;
        boolean special = false;
        boolean validated = false;
        for(int i = 0; i < passwordArray.length; i++){
            if(Character.getType(passwordArray[i]) == Character.UPPERCASE_LETTER){
                uppercase = true;
            }
            else if (Character.getType(passwordArray[i]) == Character.LOWERCASE_LETTER){
                lowercase = true;
            }
            else if (Character.getType(passwordArray[i]) == Character.DECIMAL_DIGIT_NUMBER){
                number = true;
            }
            else{
                special = true;
            }

            if((uppercase == true) && (lowercase == true) && (number == true) && (special == true) && (passwordArray.length >= 8)){
                validated = true;
                break;
            }
        }
        if(validated == true){
            System.out.println("Password Validated");
        } else {
            System.out.println("Password Invalid");
        }
        
    }
}
