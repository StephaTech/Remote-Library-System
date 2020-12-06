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
        //System.out.println("Welcome to the");
        System.out.println("_________     _________     _________");
        System.out.println("\\Welcome \\    \\        \\    \\Remote  \\");
        System.out.println(" \\        \\    \\ to the \\    \\Library \\");
        System.out.println("  \\        \\    \\        \\    \\System  \\");
        System.out.println("   \\________\\    \\________\\    \\________\\");

        System.out.println("********************************************************************\n"
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
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String optionString = null;
        int option = -1;

        try {
            optionString = br.readLine();
            option = Integer.parseInt(optionString);

        } catch (IOException | NumberFormatException e) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("That's not a valid option, please try an integer number");
            System.out.println("------------------------------------------------------------------");

        }

        return option;// returns to the option
    }

    // for the reader be able to put a String input from options
    public String readingStringFromUser() {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = br.readLine();
        } catch (final IOException e) {
            System.out.println("Oops! Something went wrong");
        }

        return input;
    }

    private boolean validMenuOption(final int option) {

        return option >= 0 && option <= 9;
    }

    private void searchBook() {
        System.out.println("Type a title or author name");
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String optionString = null;
        String identifyer = "";

        try {
            identifyer = br.readLine();
            final Book book = BookFactory.getInstance().searchBookByTitleOrAuthor(identifyer);
            if (book != null) {
                System.out.println("\n The Title or the Author matches are: \n ");
                System.out.println("------------------------------------------------------------------");
                System.out.println("ISBN: \t\tTitle\t\t\t\t\tAuthor");
                System.out.println(book.isbn + "   " + book.title + "   " + book.authorName);
                System.out.println("------------------------------------------------------------------");

            } else {
                System.out.println("------------------------------------------------------------------");
                System.out.println("Sorry, not found!");
                System.out.println("------------------------------------------------------------------");

            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("That's not a valid option, please try again");
            System.out.println("------------------------------------------------------------------");

        }

    }

    private void listBook() {
        final ArrayList<Book> books = BookFactory.getInstance().getBooks();
        System.out.println("------------------------------------------------------------------");
        System.out.println("1 - order by title | 2 - order by author name");
        System.out.println("------------------------------------------------------------------");

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String optionString = null;
        int option = 2;
        try {
            option = Integer.parseInt(br.readLine());
            BookFactory.getInstance().sortBooksBy(option);

            final ArrayList<Book> book = BookFactory.getInstance().getBooks();

            System.out.println(BookFactory.getInstance().getBooks().toArray());
        } catch (IOException | NumberFormatException e) {
            System.out.println("That's not a valid option, please try again");
        }
        System.out.println("----------------------List all books------------------------------------------------------------");
        System.out.println(books.toString());
        System.out.println("------------------------------------------------------------------------------------------------");

    }

    private void searchReader() {
        System.out.println("Type the Id Reader or the Name");
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String identifyer = "";

        try {
            identifyer = br.readLine();
            if (ReaderFactory.isNumber(identifyer)) {
                final long id = Long.parseLong(identifyer);
                final Reader reader = ReaderFactory.getInstance().searchReaderById(id);
                if (reader != null) {
                System.out.println(" --------------The matches for this search are:-------------------");
                    System.out.println(reader.toString());

                } else {
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("not found, please try a valid reader ID!");
                    System.out.println("------------------------------------------------------------------------------------------------");

                }
            } else {
                final Reader reader = ReaderFactory.getInstance().searchReaderByName(identifyer);
                if (reader != null) {
                System.out.println(" --------------The matches for this search are:------------------------------");
                System.out.println(reader.toString());
                } else {
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("not found, please try a valid name!");
                    System.out.println("------------------------------------------------------------------------------------------------");


                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("That's not a valid option, please try again");
        }

    }

    private void listReader() {

        final ArrayList<Reader> readers = ReaderFactory.getInstance().getReader();
        System.out.println("------------------------------------------------------------------");
        System.out.println("1 - order by reader name | 2 - order by ID");
        System.out.println("------------------------------------------------------------------");
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String optionString = null;
        int option = 2;
        try {
            option = Integer.parseInt(br.readLine());
            ReaderFactory.getInstance().sortReadersBy(option);

            final ArrayList<Reader> reader = ReaderFactory.getInstance().getReader();

            System.out.println(ReaderFactory.getInstance().getReader().toArray());
        } catch (Exception e) {
            System.out.println("That's not a valid option, please try again");
        }
        System.out.println("----------------------List all readers------------------------------------------------------------");

        System.out.println(readers.toString());

    }

    private void registReaderborrowed() {// and able to save the new information
        System.out.println("------------------------------------------------------------------");
        System.out.println("Type the ISBN book for borrow");
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            final Long isbn = Long.parseLong(br.readLine());
            System.out.println("Type the ID Reader for borrow");
            final int readerId = Integer.parseInt(br.readLine());
            final boolean isBorrow = BookFactory.getInstance().borrowBook(isbn, readerId);
            if (isBorrow) {
                System.out.println("Book borrowed successfully");
            } else {
                System.out.println("Book already borrowed or not found");
            }

        } catch (Exception e) {
            System.out.println("That's not a valid option, please try again");
        }
    }

    private void registReaderReturns() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("-----------------Return book-----------");
        System.out.println("Type the ISBN book for borrow");
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            final Long isbn = Long.parseLong(br.readLine());
            System.out.println("Type the ID Reader for borrow");
            final int readerId = Integer.parseInt(br.readLine());
            final boolean isBorrow = BookFactory.getInstance().borrowBook(isbn, readerId);
            if (isBorrow) {
                System.out.println("Book borrowed successfully");
            } else {
                System.out.println("Book already borrowed or not found");
            }

        } catch (final Exception e) {
            System.out.println("That's not a valid option, please try again");
        }

        System.out.println("Successfully returned book");

    }

    private void listNextReaderBook() {
        System.out.println("-----------------List next reader by book-----------");

    }

    private void readerWaitingList() {// queue//
        // TODO Auto-generated method stub
        System.out.println("Type the name of the book:");

        System.out.println("Type the name reader:");

    }

    private void listReaderborrowed() {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Type ID Reader");
        try {
            final int readerId = Integer.parseInt(br.readLine());
            final Reader reader = ReaderFactory.getInstance().searchReaderById(readerId);// "BookInformation.txt"
            if (reader != null) {
                for (final Book book : reader.books) {
                    System.out.println("book list" + book);
                }
            }

        } catch (final Exception e) {
            System.out.println("That's not a valid option, please try again");
        }
    }
}
