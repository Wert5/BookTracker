import java.util.Comparator;
public class ISBN_Comparator implements Comparator<Book> {
	@Override
	public int compare(Book arg0, Book arg1) {
		return (arg0.getIsbn()).compareTo((arg1.getIsbn())); //Returns a integer representing which Book ISBN is  to chronologically sort
	}
}
