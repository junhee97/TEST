package Domain.DTO;

public class BookDTO {

	private int Book_code;
	private int Classification_id;
	private String book_author;
	private String book_name;
	private String publisher;
	private int isreserve;

	// 생성자
	public BookDTO() {
	}

	public BookDTO(int book_code, int classification_id, String book_author, String book_name, String publisher,
			int isreserve) {
		super();
		this.Book_code = book_code;
		this.Classification_id = classification_id;
		this.book_author = book_author;
		this.book_name = book_name;
		this.publisher = publisher;
		this.isreserve = isreserve;
	}

	// getter & setter
	public int getBook_code() {
		return Book_code;
	}

	public void setBook_code(int book_code) {
		this.Book_code = book_code;
	}

	public int getClassification_id() {
		return Classification_id;
	}

	public void setClassification_id(int classification_id) {
		this.Classification_id = classification_id;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getIsreserve() {
		return isreserve;
	}

	public void setIsreserve(int isreserve) {
		this.isreserve = isreserve;
	}

	// toString
	@Override
	public String toString() {
		return "BookDTO [Book_code=" + Book_code + ", Classification_id=" + Classification_id + ", book_author="
				+ book_author + ", book_name=" + book_name + ", publisher=" + publisher + ", isreserve=" + isreserve
				+ "]";
	}

}
