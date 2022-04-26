/*
    Name: Runner_Lab11_Knowlton
    Author Name: Matthew Knowlton
    Lab Number: 11
    Date: 25 April 2022
*/

/* Import java util classes */
import java.util.*;

public class Runner_Lab11_Knowlton {
    public static void main(String[] args) {
        /* Cities */
        City[] listOfCities = new City[20];

        /* Source: https://en.wikipedia.org/wiki/List_of_United_States_cities_by_population */
        listOfCities[0] = new City ("El Paso", "Texas", 258.4, 678815, 3740);
        listOfCities[1] = new City ("New York", "New York State", 300.5, 8804190, 33);
        listOfCities[2] = new City ("Los Angeles", "California", 469.5, 3898747, 305);
        listOfCities[3] = new City ("Chicago", "Illinois", 227.7, 2746388, 597);
        listOfCities[4] = new City ("Houston", "Texas", 640.4, 2304580, 80);
        listOfCities[5] = new City ("Phoenix", "Arizona", 518.0, 1608139, 1086);
        listOfCities[6] = new City ("Philadelphia", "Pennsylvania", 134.4, 1603797, 39);
        listOfCities[7] = new City ("San Antonio", "Texas", 498.8, 1434625, 650);
        listOfCities[8] = new City ("San Diego", "California", 325.9, 1386932, 62);
        listOfCities[9] = new City ("Dallas", "Texas", 339.6, 1304379, 430);
        listOfCities[10] = new City ("San Jose", "California", 178.3, 1013240, 82);
        listOfCities[11] = new City ("Austin", "Texas", 319.9, 961855, 289);
        listOfCities[12] = new City ("Jacksonville", "Florida", 747.3, 949611, 16);
        listOfCities[13] = new City ("Fort Worth", "Texas", 342.9, 918915, 653);
        listOfCities[14] = new City ("Columbus", "Ohio", 220.0, 905748, 902);
        listOfCities[15] = new City ("Indianapolis", "Indiana", 361.6, 887642, 718);
        listOfCities[16] = new City ("Charlotte", "North Carolina", 308.3, 874579, 761);
        listOfCities[17] = new City ("San Francisco", "California", 46.9, 873965, 52);
        listOfCities[18] = new City ("Seattle", "Washington", 83.8, 737015, 175);
        listOfCities[19] = new City ("Denver", "Colorado", 153.1, 715522, 5130);

        /* User Input */
        Scanner scanner = new Scanner(System.in);

        /* Print Welcome */
        System.out.println("\nWelcome to the List of Cities!");

        /* Loop until user exits */
        do{

            /* Print Menu */
            System.out.println("\nSelection an option:\n");
            System.out.println("1. Show all the cities in the list");
            System.out.println("2. Look up a city by name");
            System.out.println("3. Look up cities by a state");
            System.out.println("4. Most populated city");
            System.out.println("5. Highest city");
            System.out.println("6. Exit\n");

            /* Get User Selection */
            System.out.print(">> ");
            int userSelection = scanner.nextInt();

            /* Search by City or State */
            if(userSelection == 2 || userSelection == 3){
                System.out.println((userSelection == 2) ? "\nWhat is the  city that you are looking for?" : "\nWhat is the state you are looking for?");
                System.out.print(">> ");
                scanner.nextLine();
            }

            /* Switch User Selection */
            switch(userSelection){
                case 1 -> print(listOfCities);
                case 2 -> searchByCity(listOfCities, scanner.nextLine());
                case 3 -> searchByState(listOfCities, scanner.nextLine());
                case 4 -> maxPopulation(listOfCities);
                case 5 -> highestElevation(listOfCities);
                case 6 -> exit(scanner);
                default -> System.out.println("\nInvalid option!");
            }

        }while(true);
    }

    public static void print(City[] listOfCities) {
        /* Print Header */
        printHeader();

        /* Loop through cities and print formatted info */
        for(City city : listOfCities){
            printCity(city);
        }
    }

    public static void searchByCity(City[] listOfCities, String name) {
        /* Found boolean so it only print header if there is a result */
        boolean found = false;

        /* Loop through cities and print if city matches name */
        for(City city: listOfCities){
            if(Objects.equals(city.getName(), name)){
                if(found == false) printHeader();
                printCity(city);
                found = true;
            }
        }

        /* If no result was found, print error */
        if(found == false) System.out.println("\nCity not found!");
    }

    public static void searchByState(City[] listOfCities, String state){
        /* Found boolean so it only print header if there is a result */
        boolean found = false;

        /* Loop through cities and print if state matches state */
        for(City city: listOfCities){
            if(Objects.equals(city.getState(), state)){
                if(found == false) printHeader();
                printCity(city);
                found = true;
            }
        }

        /* If no result was found, print error */
        if(found == false) System.out.println("\nState not found!");
    }

    public static void maxPopulation(City[] listOfCities){
        /* Set maxCity equal to the first element's name */
        String maxCity = listOfCities[0].getName();

        /* Set maxPopulation equal to the first element's population */
        int maxPopulation = listOfCities[0].getPopulation();

        /* Loop through cities updating maxCity and maxPopulation */
        for(City city: listOfCities){
            maxCity = (city.getPopulation() > maxPopulation) ? city.getName() : maxCity;
            maxPopulation = (city.getPopulation() > maxPopulation) ? city.getPopulation() : maxPopulation;
        }

        /* Print the information about the largest city */
        searchByCity(listOfCities, maxCity);
    }

    public static void highestElevation(City[] listOfCities){
        /* Set maxCity equal to the first element's name */
        String maxCity = listOfCities[0].getName();

        /* Set maxPopulation equal to the first element's elevation */
        int maxElevation = listOfCities[0].getElevation();

        /* Loop through cities updating maxCity and maxElevation */
        for(City city: listOfCities){
            maxCity = (city.getElevation() > maxElevation) ? city.getName() : maxCity;
            maxElevation = (city.getElevation() > maxElevation) ? city.getElevation() : maxElevation;
        }

        /* Print the information about the highest city */
        searchByCity(listOfCities, maxCity);
    }

    public static void printHeader() {
        /* Print a formatted string of each of the columns */
        System.out.format("\n%-16s %-14s %-12s %-11s %-9s\n", "Name", "State", "Size", "Population", "Elevation");
    }

    public static void printCity(City city){
        /* Print a formatted string of each column of the City */
        System.out.format("%-16s %-14s %-12.6f %-11d %-9d\n", city.getName(), city.getState(), city.getSize(), city.getPopulation(), city.getElevation());
    }

    public static void exit(Scanner scanner){
        /* Close the Scanner */
        scanner.close();

        /* Print the goodbye message */
        System.out.println("\nGoodbye!");

        /* Exit the program */
        System.exit(0);
    }

}