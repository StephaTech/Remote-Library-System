import java.util.ArrayList;

public class borrowings extends Reader {
	ArrayList<Reader> readers = new ArrayList<>();
	ArrayList<Book> books =  new ArrayList<>();
    //ArrayList<Borrowing> borrowings = new ArrayList<>();
    
    public ArrayList<Reader> getReaders() {
        return readers;
    }

    public void setReaders(ArrayList<Reader> readers) {
        this.readers = readers;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    
    @Override
    public String toString() {
        return "-----------borrowings---------" + "[books=" + books + "]"+ "[readers=" + readers + "]";
    }

}
