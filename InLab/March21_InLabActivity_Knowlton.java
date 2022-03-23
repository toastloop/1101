import java.util.Scanner;
public class March21_InLabActivity_Knowlton{

    public static void main (String [] args){

        Scanner scanner = new Scanner(System.in);

    	//Ask user for an integer
        System.out.println("\n------- sumDigits ------");
        System.out.println("Please input an integer: ");
        System.out.print(">>");
    	int sumDigitsInput = scanner.nextInt();
    	//Call method sumDigits, passing the integer from the user, print the result
        int sumDigitsOutput = sumDigits(sumDigitsInput);
        System.out.println(sumDigitsOutput);


    	//Ask user for a string
        System.out.println("\n------- changeXY ------");
        System.out.println("Please input a string: ");
        System.out.print(">>");
    	String changeXYInput = scanner.next();
    	//Call method changeXY, passing the string from the user, print the result
        String changeXYOutput = changeXY(changeXYInput);
        System.out.println(changeXYOutput);

    	
    	//Ask user for a string
        System.out.println("\n------- allStar ------");
        System.out.println("Please input a string: ");
        System.out.print(">>");
    	String allStarInput = scanner.next();
    	//Call method allStar, passing the string from the user, print the result
        String allStarOutput = allStar(allStarInput);
        System.out.println(allStarOutput);
    	
    	//Ask user for a string
        System.out.println("\n------- stringClean ------");
        System.out.println("Please input a string: ");
        System.out.print(">>");
    	String stringCleanInput = scanner.next();
    	//Call method stringClean, passing the string from the user, print the result
        String stringCleanOutput = stringClean(stringCleanInput);
        System.out.println(stringCleanOutput);

    	
    	//Ask user for a string
        System.out.println("\n------- mirrorEnds ------");
        System.out.println("Please input a string: ");
        System.out.print(">>");
    	String mirrorEndsInput = scanner.next();
    	//Call method mirrorEnds, passing the string from the user, print the result
        String mirrorEndsOutput = mirrorEnds(mirrorEndsInput);
        System.out.println(mirrorEndsOutput);

    	//Ask user for 3 integers
        System.out.println("\n------- closeFar ------");
        System.out.println("Please input three integers: ");
        System.out.print(">>");
    	int closeFarInput1 = scanner.nextInt();
        System.out.print(">>");
    	int closeFarInput2 = scanner.nextInt();
        System.out.print(">>");
    	int closeFarInput3 = scanner.nextInt();
    	//Call method closeFar, passing the integers from the user, print the result
        String closeFarOutput = (closeFar(closeFarInput1, closeFarInput2, closeFarInput3)) ? "true" : "false";
        System.out.println(closeFarOutput);

        scanner.close();
    }

    /* Given a non-negative int n, return the sum of its digits recursively 
    * (no loops).*/
    public static int sumDigits(int n) {
        // Base Case
    	if(n == 0){
            return 0;
        }
    	return n % 10 + sumDigits((n/10));//change return statement if needed
    }


    /* Given a string, compute recursively (no loops) a new string where all the 
    * lowercase 'x' chars have been changed to 'y' chars.*/
    public static String changeXY(String str) {
        if(str.length() <= 0){
            return str;
        } else if(str.charAt(0) == 'x') {
            return "y" + changeXY(str.substring(1));
        } else {
            return str.charAt(0) + changeXY(str.substring(1));
        }
    }

    /* Given a string, compute recursively a new string where all the adjacent 
    * chars are now separated by a "*".*/
    public static String allStar(String str) {
        if(str.length() <= 1){
            return str;
        } else {
            return str.charAt(0) + "*" + allStar(str.substring(1));
        }
    }

    /* Given a string, return recursively a "cleaned" string where adjacent chars 
    * that are the same have been reduced to a single char. So "yyzzza" yields 
    * "yza".*/
    public static String stringClean(String str) {
        if(str.length() <= 1){
            return str;
        }
        if(str.charAt(0) == str.charAt(1)){
            return stringClean(str.substring(1));
        } else {
            return str.charAt(0) + stringClean(str.substring(1));
        }
    }


    /*Solve using a loop. 
    *Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string. 
    *In other words, zero or more characters at the very beginning of the given string, and at the 
    *very end of the string in reverse order (possibly overlapping). 
    *For example, the string "abXYZba" has the mirror end "ab".  */
    public static String mirrorEnds(String string) {
        String pattern = "";
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == string.charAt(string.length() - i - 1)){
                pattern += string.charAt(i);
            } else {
                break;
            }
        }
        return  pattern;
    }

    /*Given three ints, a b c, return true if one of b or c is "close" (differing from a by at most 1), 
    *while the other is "far", differing from both other values by 2 or more. 
    *Note: Math.abs(num) computes the absolute value of a number. */
    public static boolean closeFar(int a, int b, int c) {
    	if((Math.abs(a - b) <= 1) && (Math.abs(a - c) >= 2) && (Math.abs(b - c) >= 2)){
            return true;
        }
        else if((Math.abs(a - c) <= 1) && (Math.abs(a - b) >= 2) && (Math.abs(b - c) >= 2)){
            return true;
        }
        else{
    	    return false;//change return statement if needed
        }
    }

}