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
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nLab 9");
        System.out.println("\nHow many elements would you like to enter?");
        System.out.print(">> ");
        int numElements = scanner.nextInt();
        int[] userNums = new int[numElements];
        System.out.println("\nEnter "  + numElements + " numbers");
        for(int i = 0; i < numElements; i++){
            System.out.print(">> ");
            userNums[i] = scanner.nextInt();
        }
        System.out.print("\n");
        System.out.println("The array is: \n" + printArray(userNums));
        System.out.println("The array in reverse order: \n" + printArrayReverse(userNums));
        System.out.println("The sum of the elements in array: " + sumArray(userNums));
        System.out.println("The average of the elements in array: " + averageArray(userNums));
        System.out.println("There are " + averageArrayNumber(userNums) + " elements equal or more than the average.");
        System.out.println("The index of the elements with greater or equal value to average: " + averageArrayIndexes(userNums));
        System.out.println("The maximum value in the array is: " + maximumValue(userNums));
        System.out.println("The minimum value in the array is: " + minimumValue(userNums));
        System.out.println("There are " + evenNumber(userNums) + " even number(s) in  the  array.");
        System.out.println("The even numbers are : " + evenNumberList(userNums));
        System.out.println("The index of the even numbers are : " + evenNumberIndexes(userNums));

        scanner.close();
    }
    public static String printArray(int[] userNums) {
        String arrayString = "";
        for(int i = 0; i < userNums.length; i++){
            arrayString +=  userNums[i];
            if(i != (userNums.length - 1)){
                arrayString += ", ";
            }
        }
        return arrayString;
    }
    public static String printArrayReverse(int[] userNums) {
        String arrayString = "";
        for(int i = (userNums.length -  1); i >= 0; i--){
            arrayString +=  userNums[i];
            if(i != 0){
                arrayString += ", ";
            }
        }
        return arrayString;
    }
    public static int sumArray(int[] userNums) {
        int sum = 0;
        for(int i = (userNums.length - 1); i >= 0; i--){
            sum += userNums[i];
        }
        return sum;
    }
    public static double averageArray(int[] userNums) {
        int sum = sumArray(userNums);
        return  (double) sum / (double) userNums.length;
    }
    public static int averageArrayNumber(int[] userNums){
        double average = averageArray(userNums);
        int greaterAverage = 0;
        for(int i = 0; i < userNums.length; i++){
            if(userNums[i] >= average){
                greaterAverage++;
            }
        }
        return greaterAverage;
    }
    public static String averageArrayIndexes(int[] userNums){
        double average = averageArray(userNums);
        int greaterAverage = averageArrayNumber(userNums);
        int[] greaterAverageIndexes = new int[greaterAverage];
        int greaterAverageCounter =  0;
        String greaterAverageString = "";
        for(int i = 0; i < userNums.length; i++){
            if(userNums[i] >= average){
                greaterAverageIndexes[greaterAverageCounter] = i;
                greaterAverageCounter++;
            }
        }
        for(int i = 0; i < greaterAverageIndexes.length; i++){
            greaterAverageString += greaterAverageIndexes[i];
            if(i != (greaterAverageIndexes.length - 1)){
                greaterAverageString +=  ", ";
            }
        }
        return greaterAverageString;
    }
    public static String maximumValue(int[] userNums) {
        int  maximumValue = userNums[0];
        int  maximumIndex = 0;
        for(int i = 0; i < userNums.length; i++){
            if(userNums[i] > maximumValue){
                maximumValue = userNums[i];
                maximumIndex = i;
            }
        }
        return maximumValue + " in index: " + maximumIndex;
    }
    public static String minimumValue(int[] userNums) {
        int  minimumValue = userNums[0];
        int  minimumIndex = 0;
        for(int i = 0; i < userNums.length; i++){
            if(userNums[i] < minimumValue){
                minimumValue = userNums[i];
                minimumIndex = i;
            }
        }
        return minimumValue + " in index: " + minimumIndex;
    }
    public static int evenNumber(int[] userNums) {
        int  evenNums = 0;
        for(int i = 0; i < userNums.length; i++){
            if((userNums[i] %  2) == 0){
                evenNums++;
            }
        }
        return  evenNums;
    }
    public static String evenNumberList(int[] userNums) {
        int evenNums =  evenNumber(userNums);
        int[] evenValues = new int[evenNums];
        int evenValueCounter =  0;
        String evenNumberList = "";
        for(int i = 0; i < userNums.length; i++){
            if((userNums[i] %  2) == 0){
                evenValues[evenValueCounter] = userNums[i];
                evenValueCounter++;
            }
        }
        for(int i = 0; i < evenValues.length; i++){
            evenNumberList += evenValues[i];
            if(i != (evenValues.length - 1)){
                evenNumberList += ", ";
            }
        }
        return evenNumberList;
    }
    public static String evenNumberIndexes(int[] userNums) {
        int evenNums  = evenNumber(userNums);
        int[] evenIndexes = new int[evenNums];
        int evenCounter =  0;
        String evenNumberIndexes = "";
        for(int i = 0; i < userNums.length; i++){
            if((userNums[i] %  2) == 0){
                evenIndexes[evenCounter] = i;
                evenCounter++;
            }
        }
        for(int i = 0; i < evenIndexes.length; i++){
            evenNumberIndexes += evenIndexes[i];
            if(i != (evenIndexes.length - 1)){
                evenNumberIndexes += ", ";
            }
        }
        return evenNumberIndexes;
    }
}
