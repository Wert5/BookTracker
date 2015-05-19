import java.util.Comparator;
public class ISBN_Comparator implements Comparator<Book> {
	@Override
	public int compare(Book arg0, Book arg1) {
		return (arg0.getIsbn()).compareTo((arg1.getIsbn()));
	}
}
