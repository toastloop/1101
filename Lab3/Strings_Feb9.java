import java.util.Scanner;
public class Strings_Feb9{
    public static void main(String[] args){
        String movieTheater;
        String movie1;
        String movie2;
        String movie3;
        
        String flavor;
        String dessert;
        String order;
        String order2;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of a Movie Theater and 3 movies:");

        movieTheater = scanner.nextLine();
        movie1 = scanner.nextLine();
        movie2 = scanner.nextLine();
        movie3 = scanner.nextLine();
        
        if(movieTheater.isBlank()){

        }

        System.out.println("Movie 1 to lowercase: " + movie1.toLowerCase());

        System.out.println("Enter your favorite dessert: ");
        dessert = scanner.nextLine();
        System.out.println("Enter your favorite dessert flavor: ");
        flavor = scanner.nextLine();

        order = flavor + " " + dessert;
        System.out.println("Order 1: " + order);

        order2 = flavor.concat(" ").concat(dessert);
        System.out.println("Order 2: " + order2);

        System.out.println("Flavor first char(0): " + flavor.charAt(0));

        System.out.println("Flavor substring start from index 2");
        System.out.println(flavor.substring(2, 5));
        
        System.out.println(movie1.equals(movie3));
        System.out.println(movie2.equals(movie1));

        //Close Scanner
        scanner.close();
    }
}
