/*
    Name: Lab9_Knowlton
    Author Name: Matthew Knowlton
    Lab Number: 9
    Date: 5 April 2022
*/
// Import Scanner to read user input
import java.util.*;
public class Lab9_Knowlton {

    public static void main(String[] args) {
        // Create scanner to get user input
        Scanner scanner = new Scanner(System.in);
        // Print Title
        System.out.println("\nLab 9");
        // Prompt User for the  Number of  Elements
        System.out.println("\nHow many elements would you like to enter?");
        System.out.print(">> ");
        int numElements = scanner.nextInt();
        // Create an Array with  the number of Elements
        int[] userNums = new int[numElements];
        // Prompt User for the Element Values and assign to array
        System.out.println("\nEnter "  + numElements + " numbers");
        for(int i = 0; i < numElements; i++){
            System.out.print(">> ");
            userNums[i] = scanner.nextInt();
        }
        System.out.print("\n");
        // Print Array
        System.out.println("The array is: \n" + printArray(userNums));
        // Print Reverse Array
        System.out.println("The array in reverse order: \n" + printArrayReverse(userNums));
        // Print Sum of Array
        System.out.println("The sum of the elements in array: " + sumArray(userNums));
        // Print Average of Array
        System.out.println("The average of the elements in array: " + averageArray(userNums));
        // Print Number of Elements Larger than Average
        System.out.println("There are " + averageArrayNumber(userNums) + " elements equal or more than the average.");
        // Print Indexes of Elements Larger than Average
        System.out.println("The index of the elements with greater or equal value to average: " + averageArrayIndexes(userNums));
        // Print Maximum Value and Index
        System.out.println("The maximum value in the array is: " + maximumValue(userNums));
        // Print Minimum Value and Index
        System.out.println("The minimum value in the array is: " + minimumValue(userNums));
        // Print number of Even Elements
        System.out.println("There are " + evenNumber(userNums) + " even number(s) in  the  array.");
        // Print Values of Even Elements
        System.out.println("The even numbers are : " + evenNumberList(userNums));
        // Print Index of Even Elements
        System.out.println("The index of the even numbers are : " + evenNumberIndexes(userNums));

        scanner.close();
    }
    public static String printArray(int[] userNums) {
        // Create a String
        String arrayString = "";
        // Loop through array and add elements to string
        for(int i = 0; i < userNums.length; i++){
            arrayString +=  userNums[i];
            if(i != (userNums.length - 1)){
                arrayString += ", ";
            }
        }
        // Return String
        return arrayString;
    }
    public static String printArrayReverse(int[] userNums) {
        //  Create String
        String arrayString = "";
        //  Loop backwards through array and add elements to string
        for(int i = (userNums.length -  1); i >= 0; i--){
            arrayString +=  userNums[i];
            if(i != 0){
                arrayString += ", ";
            }
        }
        // Return String
        return arrayString;
    }
    public static int sumArray(int[] userNums) {
        // Create Sum  Variable
        int sum = 0;
        // Loop through array and add values to sum variable
        for(int i = (userNums.length - 1); i >= 0; i--){
            sum += userNums[i];
        }
        // Return sum variable
        return sum;
    }
    public static double averageArray(int[] userNums) {
        // Get Sum Total
        int sum = sumArray(userNums);
        //  Return  the Average (sum/num of elements)
        return  (double) sum / (double) userNums.length;
    }
    public static int averageArrayNumber(int[] userNums){
        // Get Average of Array
        double average = averageArray(userNums);
        // Create a counter  for elements greater than Average
        int greaterAverage = 0;
        // Loop through array and increase total if element is greater than average
        for(int i = 0; i < userNums.length; i++){
            if(userNums[i] >= average){
                greaterAverage++;
            }
        }
        // Return counter 
        return greaterAverage;
    }
    public static String averageArrayIndexes(int[] userNums){
        // Get Average of Array
        double average = averageArray(userNums);
        // Get number of elements larger than average
        int greaterAverage = averageArrayNumber(userNums);
        //  Create an array  to hold  indexes of elements larger than average
        int[] greaterAverageIndexes = new int[greaterAverage];
        // Create counter to uses when assigning indexes to  array
        int greaterAverageCounter =  0;
        // Create string to hold formatted list of indexes
        String greaterAverageString = "";
        //  Loop  through array and add index to new array if value > average
        for(int i = 0; i < userNums.length; i++){
            if(userNums[i] >= average){
                greaterAverageIndexes[greaterAverageCounter] = i;
                greaterAverageCounter++;
            }
        }
        // Loop through new array and format a string to hold indexes
        for(int i = 0; i < greaterAverageIndexes.length; i++){
            greaterAverageString += greaterAverageIndexes[i];
            if(i != (greaterAverageIndexes.length - 1)){
                greaterAverageString +=  ", ";
            }
        }
        // Return formatted string of indexes
        return greaterAverageString;
    }
    public static String maximumValue(int[] userNums) {
        //  Set maximum value to index 0
        int  maximumValue = userNums[0];
        // Set maximum  index  to  0
        int  maximumIndex = 0;
        // Loop through array and assign value and index if largest element
        for(int i = 0; i < userNums.length; i++){
            if(userNums[i] > maximumValue){
                maximumValue = userNums[i];
                maximumIndex = i;
            }
        }
        // Return string with max value and max index
        return maximumValue + " in index: " + maximumIndex;
    }
    public static String minimumValue(int[] userNums) {
        // set min value to index 0;
        int  minimumValue = userNums[0];
        // set min index to 0
        int  minimumIndex = 0;
        // loop through array and assign value and index if smallest value
        for(int i = 0; i < userNums.length; i++){
            if(userNums[i] < minimumValue){
                minimumValue = userNums[i];
                minimumIndex = i;
            }
        }
        // return  formatted string with min value and index
        return minimumValue + " in index: " + minimumIndex;
    }
    public static int evenNumber(int[] userNums) {
        // create a counter for number of even elements
        int  evenNums = 0;
        // loop through array increasing counter if element is even
        for(int i = 0; i < userNums.length; i++){
            if((userNums[i] %  2) == 0){
                evenNums++;
            }
        }
        // return counter
        return  evenNums;
    }
    public static String evenNumberList(int[] userNums) {
        // get number of even elements
        int evenNums =  evenNumber(userNums);
        // create an array to hold even element values
        int[] evenValues = new int[evenNums];
        // create counter to assign elements to new array
        int evenValueCounter =  0;
        // create string to  hold formatted list of even values
        String evenNumberList = "";
        // loop through array to find even values and add to array
        for(int i = 0; i < userNums.length; i++){
            if((userNums[i] %  2) == 0){
                evenValues[evenValueCounter] = userNums[i];
                evenValueCounter++;
            }
        }
        // loop through new array to format string with even values
        for(int i = 0; i < evenValues.length; i++){
            evenNumberList += evenValues[i];
            if(i != (evenValues.length - 1)){
                evenNumberList += ", ";
            }
        }
        // return formatted string
        return evenNumberList;
    }
    public static String evenNumberIndexes(int[] userNums) {
        // get number of even elements
        int evenNums  = evenNumber(userNums);
        // create array to  hold indexes of even values
        int[] evenIndexes = new int[evenNums];
        // create a counter to assign indexes to new array
        int evenCounter =  0;
        // create string to hold formatted list of even value indexes
        String evenNumberIndexes = "";
        // loop through array and add indexes associated with even values
        for(int i = 0; i < userNums.length; i++){
            if((userNums[i] %  2) == 0){
                evenIndexes[evenCounter] = i;
                evenCounter++;
            }
        }
        // loop through new array to format string with even indexes
        for(int i = 0; i < evenIndexes.length; i++){
            evenNumberIndexes += evenIndexes[i];
            if(i != (evenIndexes.length - 1)){
                evenNumberIndexes += ", ";
            }
        }
        // return formatted string
        return evenNumberIndexes;
    }
}
