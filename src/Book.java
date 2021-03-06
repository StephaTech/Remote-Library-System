import java.util.ArrayList;

public class Book {

    long isbn;// long because the number is long
    String title;
    String authorName;
    boolean isBorrowed;

    public Book(final long isbn, final String title, final String authorName) {

        this.isbn = isbn;
        this.title = title;
        this.authorName = authorName;
        //this.isBorrowed = isBorrowed;
    }

    public Book() {

    }
//connection to the singleton
    public ArrayList<Book> getBooks() {
        return BookFactory.getInstance().getBooks();
    }

    @Override
    public String toString() {
		
        return " ISBN:\t" + isbn + ", Title:\t" + title + ", Author:\t" + authorName + "\n";
        
    }
}
