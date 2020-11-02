
public class Reader {
	private int idReader;
	private String name;
	private int mobile;//I might can use as a string b/ I wont do any count with
	
		
	public Reader(int idReader, String name, int mobile) {
		super();
		this.idReader = idReader;
		this.name = name;
		this.mobile = mobile;
	}
	public int getIdReader() {
		return idReader;
	}
	public void setIdReader(int idReader) {
		this.idReader = idReader;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return " [idReader:" + idReader + ", Name:" + name + ", Mobile:" + mobile + "]";
	}
	
}
