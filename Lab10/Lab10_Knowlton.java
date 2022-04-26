/*
    Name: Lab10_Knowlton
    Author Name: Matthew Knowlton
    Lab Number: 10
    Date: 18 April 2022
*/

import java.util.*;
public class Lab10_Knowlton {
    public static void main(String[] args) {

        Scanner scanner =  new Scanner(System.in);

        /* Generate Board Matrixes */
        System.out.println("Enter the size of the board rxc: ");
        System.out.print(">> ");
        int n = scanner.nextInt();
        long[][] boardOne = new long[n][n];
        long[][] boardTwo = new long[n][n];
        long[][] boardThree = new long[n][n];

        System.out.print("\n");

        /* Generate Board One */
        System.out.println("Enter " +  n + " numbers between (1-5):");
        for(int i = 0; i < n; i++){
            System.out.print(">> ");
            int userNum = scanner.nextInt();
            boardOne[i][0] = userNum;
            boardOne[0][i] = userNum;
        }
        System.out.print("\n");
        for(int i = 1; i < boardOne.length; i++ ){
            for(int j = 1; j < boardOne[i].length; j++){
                boardOne[i][j] = boardOne[i-1][j-1] * boardOne[i-1][j];
            }
        }

        /* Generate Board Two */
        for(int i = 0; i < boardTwo.length; i++){
            for(int j = 0; j < boardTwo[i].length; j++){
                boardTwo[i][j] = (int) (Math.random() * 10);
            }
        }

        /* Generate Board Three */
        for(int i = 0; i < boardThree.length; i++){
            for(int j = 0; j < boardThree[i].length; j++){
                boardThree[i][j] = boardOne[i][j] + boardTwo[i][j];
            }
        }

        System.out.format("---- %s ----\n", "Board #1");
        printMatrix(boardOne);

        System.out.print("\n");

        System.out.format("---- %s ----\n", "Diagonals");
        diagonalElements(boardOne);

        System.out.format("---- %s ----\n", "Sum");
        sumElements(boardOne);

        System.out.print("\n");

        System.out.format("---- %s ----\n", "Board #2");
        printMatrix(boardTwo);

        System.out.print("\n");

        System.out.format("---- %s ----\n", "Row Sum");
        sumRowElements(boardTwo);

        System.out.format("---- %s ----\n", "Column Sum");
        sumColumnElements(boardTwo);

        System.out.format("---- %s ----\n", "Average");
        averageElements(boardTwo);

        System.out.print("\n");

        System.out.format("---- %s ----\n", "Board #3");
        printMatrix(boardThree);

        System.out.print("\n");

        System.out.format("---- %s ----\n", "Board #3 Reverse");
        printMatrixReverse(boardThree);

        System.out.print("\n");

        System.out.format("---- %s ----\n", "Min Value Array");
        minArray(boardOne, boardTwo, boardThree);

        System.out.format("---- %s ----\n", "Max Value Array");
        maxArray(boardOne, boardTwo, boardThree);

        System.out.format("---- %s ----\n", "Min Value of All Elements");
        minElements(boardOne, boardTwo, boardThree);

        System.out.format("---- %s ----\n", "Max Value of All Elements");
        maxElements(boardOne, boardTwo, boardThree);

        scanner.close();

    }

    /* Print Matrix */
    public static void printMatrix(long[][] board) {
        for(int i = 0; i < board.length; i++ ){
            System.out.print("|");
            for(int j = 0; j < board[i].length; j++){
                System.out.format(" %-3d |", board[i][j]);
            }
            System.out.print("\n");
        }
    }

    /* Print Matrix in Reverse */
    public static void printMatrixReverse(long[][] board) {
        for(int i = board.length-1; i >= 0; i-- ){
            System.out.print("|");
            for(int j = board[i].length-1; j >= 0; j--){
                System.out.format(" %-3d |", board[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void diagonalElements(long[][] board) {
        System.out.println("The elements in the diagonal are: ");
        for(int i = 0; i < board.length; i++ ){
            System.out.print(board[i][i]);
            if((i+1) != board.length){
                System.out.print(", ");
            }
        }
        System.out.print("\n");
    }

    public static void sumElements(long[][] board) {
        long sum = 0;
        for(int i = 0; i < board.length; i++ ){
            for(int j = 0; j < board[i].length; j++){
                sum += board[i][j];
            }
        }
        System.out.println("The sum of all elements: " + sum);
    }

    public static void sumRowElements(long[][] board) {
        long sum = 0;
        for(int i = 0; i < board[0].length; i++ ){
            sum += board[0][i];
        }
        System.out.println("The sum of all elements in row: " + sum);
    }

    public static void sumColumnElements(long[][] board) {
        long sum = 0;
        for(int i = 0; i < board.length; i++ ){
            sum += board[i][0];
        }
        System.out.println("The sum of all elements in row: " + sum);
    }

    public static void averageElements(long[][] board) {
        int sum = 0;
        for(int i = 0; i < board.length; i++ ){
            for(int j = 0; j < board[i].length; j++){
                sum += board[i][j];
            }
        }
        double average = (double) sum /  (double) (board.length * board.length);
        System.out.println("The average of all elements: " +  average);
    }

    public static long minBoard(long[][] board) {
        long min = board[0][0];
        for(int i = 0; i < board.length; i++ ){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] < min){
                    min = board[i][j];
                }
            }
        }
        return  min;
    }

    public static long maxBoard(long[][] board) {
        long max = board[0][0];
        for(int i = 0; i < board.length; i++ ){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] > max){
                    max = board[i][j];
                }
            }
        }
        return max;
    }

    public static void minArray(long[][] boardOne, long[][] boardTwo, long[][] boardThree) {

        long[] minValues = new long[3];

        minValues[0] = minBoard(boardOne);
        minValues[1] = minBoard(boardTwo);
        minValues[2] = minBoard(boardThree);

        System.out.print("[ ");
        for(int i = 0; i < minValues.length; i++){
            System.out.print(minValues[i]);
            if(i != minValues.length - 1){
                System.out.print(", ");
            }
        }
        System.out.print(" ]\n");

    }

    public static void maxArray(long[][] boardOne, long[][] boardTwo, long[][] boardThree) {

        long[] maxValues = new long[3];

        maxValues[0] = maxBoard(boardOne);
        maxValues[1] = maxBoard(boardTwo);
        maxValues[2] = maxBoard(boardThree);

        System.out.print("[ ");
        for(int i = 0; i < maxValues.length; i++){
            System.out.print(maxValues[i]);
            if(i != maxValues.length - 1){
                System.out.print(", ");
            }
        }
        System.out.print(" ]\n");

    }

    public static void maxElements(long[][] boardOne, long[][] boardTwo, long[][] boardThree) {

        long[] maxValues = new long[3];

        maxValues[0] = maxBoard(boardOne);
        maxValues[1] = maxBoard(boardTwo);
        maxValues[2] = maxBoard(boardThree);

        long maxOverall = maxValues[0];
        for(int i = 0; i < maxValues.length; i++){
            if(maxValues[i]  > maxOverall){
                maxOverall = maxValues[i];
            }
        }

        System.out.println("The max value of all elements in all boards: "  + maxOverall);
    }

    public static void minElements(long[][] boardOne, long[][] boardTwo, long[][] boardThree) {

        long[] minValues = new long[3];

        minValues[0] = minBoard(boardOne);
        minValues[1] = minBoard(boardTwo);
        minValues[2] = minBoard(boardThree);

        long minOverall = minValues[0];
        for(int i = 0; i < minValues.length; i++){
            if(minValues[i]  < minOverall){
                minOverall = minValues[i];
            }
        }

        System.out.println("The min value of all elements in all boards: "  + minOverall);
    }

}
