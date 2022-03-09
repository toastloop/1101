import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class March2_Example_Methods {
    public static void main(String[] args) throws IOException{
        String fruit = "";
        Double quantity = 0.0;
        Double priceForEach = 0.0;
        Double total = 0.0;
        Double totalRounded = 0.0;
        File file = new File("fruits.txt");
        Scanner scanner = new Scanner(file);
        scanner.nextLine(); //skip first line

        while(scanner.hasNext()){
            fruit = scanner.next();
            quantity = scanner.nextDouble();
            priceForEach = scanner.nextDouble();
            total = totalPrice(quantity, priceForEach);
            totalRounded = Math.round(total*Math.pow(10,2))/Math.pow(10,2);
            System.out.printf(" %s | %.2f | %.2f | %s ", fruit, priceForEach, totalRounded, fruit);

            System.out.println(fruit + " - " + quantity + "lbs " + priceForEach);
            System.out.println(totalRounded);
        }

        scanner.close();
    }
    public static double totalPrice(double quantity, double price) {
        Double total = 0.0;
        total = quantity * price;
        return total;
    }
}
