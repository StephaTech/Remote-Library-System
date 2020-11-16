import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader {
	private int idReader;
	private String readerName;
	private long mobile;//I might can use as a string b/ I wont do any count with it
	private final ArrayList<Reader> readerRecords = new ArrayList<>();
	
	
	public Reader(int idReader, String readerName, long mobile) {
		
		this.idReader = idReader;
		this.readerName = readerName;
		this.mobile = mobile;
	}

	public Reader() {
		
	}
	
	public ArrayList<Reader> loadDataReader(){
		try {
			final BufferedReader buff = new BufferedReader(new FileReader("BookInformation.txt"));
			String contentLine = buff.readLine();

            String[] data;
            int idReader;
            String readerName;
            long mobile;

            while (contentLine != null) {

                data = contentLine.split(",");
                idReader = int.parseInt(data[0]);
                readerName = data[1];
                mobile = data[2];
                final Reader reader = new Reader(idReader, readerName, mobile);
                readerRecords.add(reader);
                contentLine = buff.readLine();
                System.out.println(reader.toString());
            }

        } catch (final IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return readerRecords;
	}

//	public int getIdReader() {
//		return idReader;
//	}
//	public void setIdReader(int idReader) {
//		this.idReader = idReader;
//	}
//	public String getName() {
//		return readerName;
//	}
//	public void setName(String name) {
//		this.readerName = name;
//	}
//	public long getMobile() {
//		return mobile;
//	}
//	public void setMobile(long mobile) {
//		this.mobile = mobile;
//	}
	@Override
	public String toString() {
		return " [idReader:" + idReader + ", Name:" + readerName + ", Mobile:" + mobile + "]";
	}
	
}
