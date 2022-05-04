/*
    Name: Runner_Lab12_Knowlton
    Author Name: Matthew Knowlton
    Lab Number: 12
    Date: 3 May 2022
*/

/* Import Scanner and Locale from java.util */
import java.util.Locale;
import java.util.Scanner;

public class Runner_Lab12_Knowlton {

    /* Scanner object parameter */
    public static Scanner scanner = new Scanner(System.in).useLocale(Locale.US).useDelimiter("\n");

    /* Head node of the linked list */
    public static Book headNode = null;

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {

        /* Preexisting Books */
        Book[] bookList = new Book[10];
        bookList[0] = new Book("Gulliver's Travels", "Jonathan Swift", 1726);
        bookList[1] = new Book("Don Quixote", "Miguel De Cervantes", 1615);
        bookList[2] = new Book("The Count of Monte Cristo", "Alexandre Dumas", 1845);
        bookList[3] = new Book("Charlotte's Web", "EB White", 1952);
        bookList[4] = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        bookList[5] = new Book("Pride and Prejudice", "Harper Lee", 1813);
        bookList[6] = new Book("Jane Eyre", " Charlotte Brontë", 1847);
        bookList[7] = new Book("1984", "George Orwell", 1949);
        bookList[8] = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        bookList[9] = new Book("Animal Farm", "George Orwell", 1945);

        /* Links Preexisting Books */
        for(Book book : bookList){

            /* If head is null set book to head */
            if(headNode == null){
                headNode = book;
            }

            /* Else link book to next node */
            else {
                Book current = headNode;
                while(current.nextNode != null){
                    current = current.nextNode;
                }
                current.nextNode = book;
            }

        }

        /* Print intro message */
        System.out.println("Welcome to the book library");

        do{

            /* Print menu */
            System.out.println("\nSelect an option:");
            System.out.println(" 1. Show all of the books in the library.");
            System.out.println(" 2. Add one book at the end of the linked list.");
            System.out.println(" 3. Remove one book from the end of the linked list.");
            System.out.println(" 4. Exit");

            /* Prompt for user input */
            System.out.print("\n>> ");

            /* Switch based on user input */
            switch(scanner.nextInt()){

                /* Print library */
                case 1 -> print(headNode);

                /* Add book to library */
                case 2 -> {

                    /* Title */
                    System.out.println("\nWhat is the title of the book that you would like to add?");
                    System.out.print(">> ");
                    String title = scanner.next();

                    /* Author */
                    System.out.println("\nWhat is the author?");
                    System.out.print(">> ");
                    String author = scanner.next();

                    /* Year Published */
                    System.out.println("\nIn what year was this book published?");
                    System.out.print(">> ");
                    Integer year = scanner.nextInt();

                    /* Create book object and add to linked list */
                    Book newBook = new Book(title, author, year);
                    add(headNode, newBook);

                    /* Print add message */
                    System.out.println("\nA new book was added to the library!");

                }

                /* Remove book from library */
                case 3 -> remove(headNode);

                /* Exit program */
                case 4 -> {

                    /* Close Scanner */
                    scanner.close();

                    /* Print Message */
                    System.out.println("\nHave a good day. Bye!");

                    /* Exit Program */
                    System.exit(0);

                }

                /* If input doesn't match any cases */
                default -> {

                    /* Print Message */
                    System.out.println("Please input an integer between [1-4].");

                }

            } // End of Switch

        } while(true);

    } // End of Main Method

    /**
     * Prints a table of the books in the linked list.
     * @param head
     */
    public static void print(Book head) {

        /* Print Table Header */
        System.out.println("\n+----------------------------------------------------------------+");
        System.out.println("|                     -- // My Library // --                     |");
        System.out.println("+----------------------------------------------------------------+");
        System.out.format("| %-40s | %-19s |\n", "Title", "Author");
        System.out.println("+----------------------------------------------------------------+");


        /* Print Book Information */
        if(head != null){

            /* Set current book to head */
            Book current = head;

            /* Loop though linked list */
            while(current != null){

                /* Print format  */
                System.out.format("| %-40s | %-19s |\n", current.title, current.author);

                /* Set current to the next node */
                current = current.nextNode;

            }

        }

        /* Print Table Footer */
        System.out.println("+----------------------------------------------------------------+\n");

    }

    /**
     * Add a book to the linked list.
     * @param head
     * @param toAdd
     * @return
     */
    public static Book add(Book head, Book toAdd) {

        /* Set current to head */
        Book current = head;

        /* If there is no other book set this to head */
        if(current == null){

            /* Set head to current new book */
            headNode = toAdd;

            /* Return head node */
            return headNode;

        }

        /* Loop through linked list */
        while(current.nextNode != null){
            current = current.nextNode;
        }

        /* Set the next node to current */
        current.nextNode = toAdd;

        /* Return head book */
        return head;

    }

    /**
     * Removes the last book in the linked list
     * @param head
     * @return
     */
    public static Book remove(Book head) {

        /* If there are no books in the library */
        if(head == null){

            /* Print warning */
            System.out.println("\nWARNING!! The library was already empty!");

            /* Return headNode */
            return headNode;

        } 

        /* Else if there is 1 book left in the library */
        else if (head.nextNode == null){

            /* Print remove message */
            System.out.println("\nThe last book from the library has been removed!");

            /* Print count message */
            System.out.println("There are 0 books in the library.");

            /* Set headNode to null */
            headNode = null;

            /* Return headNode */
            return headNode;

        }

        /* Else, there is more than 1 book  */
        else{

            /* Set current to head */
            Book current = head;

            /* Set count to one (to account for head node) */
            Integer count = 1;

            /* Loop through linked list */
            while(current.nextNode.nextNode != null){

                /* Set current to next node */
                current = current.nextNode;

                /* Increase count */
                count++;

            }

            /* Print remove message */
            System.out.println("\nThe last book from the library has been removed!");

            /* Print count message */
            System.out.println((count == 1) ? "There is 1 book in the library." : "There are " + count + " books in the library.");

            /* Set the nextNode to null */
            current.nextNode = null;

            /* Return headNode */
            return head;

        }

    }

} // End of Runner Class