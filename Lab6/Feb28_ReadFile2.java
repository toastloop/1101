import java.io.*;
import java.util.Scanner;
public class Feb28_ReadFile2{
    public static void main(String[] args) throws IOException{
        File myFile = new File("Lab6/Feb28_colors2.txt");
        Scanner scanner = new Scanner(myFile);
        while(scanner.hasNextLine()){
            String color = scanner.nextLine();
            if(color.equals("Red") || color.equals("Blue") || color.equals("Yellow")){
                System.out.println("The " + color + " is a primary color.");
            }
            else {
                System.out.println("The " + color + " is NOT a primary color.");
            }
        }
        scanner.close();
    }
}
