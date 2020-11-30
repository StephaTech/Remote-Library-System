import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CmdLine {

	public CmdLine() {

		int option = -1;

		do {
			do {
				displayOptions();
				option = readingIntFromUser();

			} while (!validMenuOption(option));

			if (option == 1) {
				searchBook();
			} else if (option == 2) {
				listBook();
			} else if (option == 3) {
				searchReader();
			} else if (option == 4) {
				listReader();
			} else if (option == 5) {
				registReaderborrowed();
			} else if (option == 6) {
				readerWaitingList();
			} else if (option == 7) {
				registReaderReturns();
			} else if (option == 8) {
				listNextReaderBook();
			} else if (option == 9) {
				listReaderborrowed();
			}

		} while (option != 0);

		System.out.println("Thank you and goodbye");
		System.exit(0);

	}

	private void displayOptions() {

		System.out.println("********************************************************************\n"
				+ "*              Welcome to the Remote Library System 			\n"
				+ "********************************************************************\n"
				+ "* (1) Search for a book by title and/or author name 			\n"
				+ "* (2) List all books by title an/or author name alphabetical order \n"
				+ "* (3) Search for a specific reader by name and/ or ID			\n"
				+ "* (4) List all readers by alphabetical and/or ID order		\n"
				+ "* (5) Registered that reader has borrowed a book				\n"
				+ "* (6) Add readers to a waiting list(queue)					\n"
				+ "* (7) Register readers return book 							\n"
				+ "* (8) List next reader for that book 							\n"
				+ "* (9) Reader: list the books that they have borrowed 			\n"
				+ "* (0) Exit library											\n"
				+ "***************************************************************\n"
				+ "* Please choose one of the options:											\n");

	}

	// for the reader be able to put a integer input from options
	private int readingIntFromUser() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String optionString = null;
		int option = -1;

		try {
			optionString = br.readLine();
			option = Integer.parseInt(optionString);

		} catch (IOException | NumberFormatException e) {
			System.out.println("That's not a valid option, please try an integer number");
		}

		return option;// returns to the option
	}

	// for the reader be able to put a String input from options
	public String readingStringFromUser() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		try {
			input = br.readLine();
		} catch (IOException e) {
			System.out.println("Oops! Something went wrong");
		}

		return input;// or option?
	}

	private boolean validMenuOption(int option) {

		return option >= 0 && option <= 9;
	}

	private void searchBook() {
		System.out.println("Type a title or author name");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String optionString = null;
		String identifyer = "";

		try {
			identifyer = br.readLine();
			Book book = BookFactory.getInstance().searchBookByTitleOrAuthor(identifyer);
			if (book != null) {
				System.out.println(" search - " + book.authorName + " " + book.title);
			} else {
				System.out.println("not found!");
			}

		} catch (IOException | NumberFormatException e) {
			System.out.println("That's not a valid option, please try again");
		}

	}

	private void listBook() {
		ArrayList<Book> books = BookFactory.getInstance().getBooks();
		System.out.println("1 - orde by title | 2 - orde by author name");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String optionString = null;
		int option = 2;
		try {
			option = Integer.parseInt(br.readLine());
			BookFactory.getInstance().sortBooksBy(option);

			ArrayList<Book> book = BookFactory.getInstance().getBooks();

			System.out.println(BookFactory.getInstance().getBooks().toArray());
		} catch (IOException | NumberFormatException e) {
			System.out.println("That's not a valid option, please try again");
		}

		System.out.println(books.toString());
	}

	private void searchReader() {
		System.out.println("Type the Id Reader or the Name");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String optionString = null;
		String identifyer = "";

		try {
			identifyer = br.readLine();
			Reader reader = ReaderFactory.getInstance().searchReaderByIdOrName(identifier);
			if (reader != null) {
				System.out.println(" search - " + reader.readerName + " " + reader.idReader);
			} else {
				System.out.println("not found!");
			}

		} catch (IOException | NumberFormatException e) {
			System.out.println("That's not a valid option, please try again");
		}

	}

	private void listReader() {

		ArrayList<Reader> readers = ReaderFactory.getInstance().getReader();
		System.out.println("1 - orde by ID | 2 - order by reader name");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String optionString = null;
		int option = 2;
		try {
			option = Integer.parseInt(br.readLine());
			ReaderFactory.getInstance().sortReadersBy(option);

			ArrayList<Reader> reader = ReaderFactory.getInstance().getReader();

			System.out.println(ReaderFactory.getInstance().getReader().toArray());
		} catch (IOException | NumberFormatException e) {
			System.out.println("That's not a valid option, please try again");
		}

		System.out.println(readers.toString());

		System.out.println("\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\o//");
		System.out.println("\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\o//");
		System.out.println("\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\o//");

	}

	private void registReaderborrowed() {
		// TODO Auto-generated method stub

	}

	private void readerWaitingList() {
		// TODO Auto-generated method stub

	}

	private void registReaderReturns() {
		// TODO Auto-generated method stub

	}

	private void listNextReaderBook() {
		// TODO Auto-generated method stub

	}

	private void listReaderborrowed() {
		// TODO Auto-generated method stub

	}

}
