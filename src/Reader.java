import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader {
	 int idReader;
	 String readerName;
	 String readerAddress;
	 List<Book> books = new ArrayList<>();
	
	
	public Reader(int idReader, String readerName, String readerAddress) {
		
		this.idReader = idReader;
		this.readerName = readerName;
		this.readerAddress = readerAddress;
	}

	public Reader() {
		
	}
	//connection to the singleton
    public ArrayList<Reader> getReaders() {
        return ReaderFactory.getInstance().getReader();
    }
	
	@Override
	public String toString() {
		return " Reader ID:\t" + idReader + ", Name:\t" + readerName + ", Address:\t" + readerAddress+ "\n";
	}
	
}
