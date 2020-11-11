
public class Reader {
	private int idReader;
	private String readerName;
	private int mobile;//I might can use as a string b/ I wont do any count with it
			
	public Reader(int idReader, String readerName, int mobile) {
		super();
		this.idReader = idReader;
		this.readerName = readerName;
		this.mobile = mobile;
	}
	public int getIdReader() {
		return idReader;
	}
	public void setIdReader(int idReader) {
		this.idReader = idReader;
	}
	public String getName() {
		return readerName;
	}
	public void setName(String name) {
		this.readerName = name;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return " [idReader:" + idReader + ", Name:" + readerName + ", Mobile:" + mobile + "]";
	}
	
}
