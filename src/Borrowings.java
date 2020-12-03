import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Borrowings {

	private Reader reader;
	private Book book;
	private ArrayList<Book> borrowedBooks = new ArrayList<>();
	private ArrayList<Reader> borrowerReader = new ArrayList<>();

	public Borrowings(Reader reader, Book book, ArrayList<Book> borrowedBooks, ArrayList<Reader> borrowerReader) {
		super();
		this.reader = reader;
		this.book = book;
		borrowedBooks = new ArrayList<Book>();
		borrowerReader = new ArrayList<Reader>();
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public ArrayList<Reader> getBorrowerReader() {
		return borrowerReader;
	}

	public void setBorrowerReader(ArrayList<Reader> borrowerReader) {
		this.borrowerReader = borrowerReader;
	}

	@Override
	public String toString() {
		return "Borrowings [reader=" + reader + ", book=" + book + ", borrowedBooks=" + borrowedBooks
				+ ", borrowerReader=" + borrowerReader + "]";
	}

	

}
