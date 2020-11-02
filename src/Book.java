
public class Book {
	private int IntStandBookNumber;
	private String title, authorName;
	
	
	public Book() {
		
		this.IntStandBookNumber = IntStandBookNumber;
		this.title = title;
		this.authorName = authorName;
	}


	public Book(int id, String title, String author) {
		super();
		this.IntStandBookNumber = id;
		this.title = title;
		this.authorName = author;
	}


	@Override
	public String toString() {
		return "Book [ISBN:" + IntStandBookNumber + ", Title:" + title + ", Author:" + authorName + "]";
	}
	
	
	
}
