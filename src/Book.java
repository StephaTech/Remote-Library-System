import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Book {

    private long isbn;//long because the number is long
    private String title, authorName;
    final ArrayList<Book> records = new ArrayList<>();

    public Book(final long isbn, final String title, final String authorName) {

        this.isbn = isbn;
        this.title = title;
        this.authorName = authorName;
    }

    public Book(){//constructor without parameter

    }

    public ArrayList<Book> loadDataBook() {

        try {
            final BufferedReader br = new BufferedReader(new FileReader("BookInformation.txt"));
            String contentLine = br.readLine();

            String[] data;
            long isbn;
            final String name;
            String authorName;

            while (contentLine != null) {

                data = contentLine.split(",");
                isbn = Long.parseLong(data[0]);//converting for int
                title = data[1];
                authorName = data[2];
                final Book book = new Book(isbn, title, authorName);
                records.add(book);
                contentLine = br.readLine();
                System.out.println(book.toString());
            }

        } catch (final IOException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

        return records;
    }

    @Override
    public String toString() {
        return "Book [ISBN:" + isbn + ", Title:" + title + ", Author:" + authorName + "]";
    }

}
