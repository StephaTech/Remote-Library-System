import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
			}

		} while (option != 0);

		System.out.println("Thank you and welcome back");
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
		// TODO Auto-generated method stub

	}

	private void listBook() {

		Book book = new Book();
		book.loadDataBook();

		System.out.println("\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\o//");
		System.out.println("\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\o//");
		System.out.println("\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\\\o//\\o//\\o//\\o//\\o//\\o//\\o//\\o//");
	}

}
