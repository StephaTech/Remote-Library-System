import java.io.BufferedReader;
import java.io.FileReader;//Import the File class
import java.io.IOException;//Import the IOException class to handle errors
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookFactory {

    private static BookFactory INSTANCE;
    private static ArrayList<Book> books = new ArrayList<>();

    private BookFactory() {
        loadBooksFromFile();
    }

    // singleton
    public static BookFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BookFactory();
        }
        return INSTANCE;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void sortBooksBy(int option) {
        if (option == 1) {
            Collections.sort(books, new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.title.compareTo(o2.title);
                }
            });
        } else if (option == 2) {
            Collections.sort(books, new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.authorName.compareTo(o2.authorName);
                }
            });
        }
    }

    // This loads my database
    private ArrayList<Book> loadBooksFromFile() {

        try {
            final BufferedReader br = new BufferedReader(new FileReader("BookInformation.txt"));// specified location
            String contentLine = br.readLine();

            String[] data;
            long isbn;
            String title;
            String authorName;

            while (contentLine != null) {

                data = contentLine.split(",");
                isbn = Long.parseLong(data[0]);// converts to int
                title = data[1];
                authorName = data[2];
                final Book book = new Book(isbn, title, authorName);
                books.add(book);
                contentLine = br.readLine();
            }

        } catch (final IOException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }

    // linear Search(Menu option 1)
    public Book searchBookByTitleOrAuthor(final String identifyer) {
        for (int i = 0; i < books.size(); i++) {// I want stop when find the element
            if (books.get(i).title.contains(identifyer) || books.get(i).authorName.contains(identifyer)) {// comparison
                return books.get(i);// the position where my element is i
            }
        }
        return null;// if is not inside the collection, this will show the elment is not there
    }

    public boolean borrowBook(long isbn, int readerId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isbn == isbn && (!books.get(i).isBorrowed)) {
                books.get(i).isBorrowed = true;
                Reader reader = ReaderFactory.getInstance().searchReaderById(readerId);
                reader.books.add(books.get(i));
                return true;
            }
        }
        return false;
    }
   public boolean returnBook(long isbn, int readerId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isbn == isbn && (books.get(i).isBorrowed)) {
                books.get(i).isBorrowed = false;
                Reader reader = ReaderFactory.getInstance().searchReaderById(readerId);
                reader.books.remove(books.get(i));
                return true;
            }
        }
        return false;
    } 
}