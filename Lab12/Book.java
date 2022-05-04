/*
    Name: Book
    Author Name: Matthew Knowlton
    Lab Number: 12
    Date: 3 May 2022
*/

public class Book {

    /* Title (String) */
    public String title = "";

    /* Author (String) */
    public String author = "";

    /* yearPublished (Integer) */
    public Integer yearPublished = null;

    /* nextNode (Book) */
    public Book nextNode = null;

    /**
     * Book Constructor
     */
    public Book(){}

    /**
     * Book Constructor
     * @param title
     */
    public Book(String title){
        this.title = title;
    }

    /**
     * Book Constructor
     * @param title
     * @param author
     */
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    /**
     * Book Constructor
     * @param title
     * @param author
     * @param yearPublished
     */
    public Book(String title, String author, int yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

} // End of Book Class