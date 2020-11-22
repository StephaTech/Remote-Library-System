import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader {
	 int idReader;
	 String readerName;
	 String readerAddress;//I might can use as a string b/ I wont do any count with it
	//private final ArrayList<Reader> readerRecords = new ArrayList<>();
	
	
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
		return " [idReader:" + idReader + ", Name:" + readerName + ", Adress:" + readerAddress + "]";
	}
	
}
