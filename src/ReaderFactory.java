import java.io.BufferedReader;
import java.io.FileReader;//Import the File class
import java.io.IOException;//Import the IOException class to handle errors
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReaderFactory {

    private static ReaderFactory INSTANCE;
    private static ArrayList<Reader> readers = new ArrayList<>();

    private ReaderFactory() {
        loadReaderFromFile();
    }
//singleton
    public static ReaderFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ReaderFactory();
        }
        return INSTANCE;
    }

    public ArrayList<Reader> getReader() {
        return readers;
    }

    public void sortReadersBy(int option) {
        if (option == 1) {
            Collections.sort(readers, new Comparator<Reader>() {
                @Override
                public int compare(Reader o1, Reader o2) {
                    return o1.readerName.compareTo(o2.readerName);
                }
            });
        } else if (option == 2) {
            Collections.sort(readers, new Comparator<Reader>() {
                @Override
                public int compare(Reader o1, Reader o2) {
                    //return o1.idReader.compareTo(o2.idReader);
                    return ((Reader)o1).idReader -  ((Reader)o2).idReader;

                    
                }
            });
        }
    }

    private ArrayList<Reader> loadReaderFromFile() {

        try {
            final BufferedReader br = new BufferedReader(new FileReader("ReaderInformation.txt"));//specified location
            String contentLine = br.readLine();

            String[] data;
            int idReader;
            String readerName;
            String readerAddress;

            while (contentLine != null) {

                data = contentLine.split(",");
                idReader = Integer.parseInt(data[0]);// converting for int
                readerName = data[1];
                readerAddress = data[2];
                final Reader reader = new Reader(idReader, readerName, readerAddress);
                readers.add(reader);
                contentLine = br.readLine();
            }

        } catch (final IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readers;
    }

    // linear Search
    public Reader searchReaderByNameOrId(final String identifier ) {//tentei por +  int= identifier--> nao funciona
        for (int i = 0; i < readers.size(); i++) {//I want stop when find the element
            if (readers.get(i).readerName.equals() || readers.get(i).idReader.equals()) {//???
                return readers.get(i);//the position where my element is i
            }
        }
        return null;//if is not inside the collection, this will show the elment is not there
    }

}