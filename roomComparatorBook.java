import java.util.Comparator;
public class roomComparatorBook implements Comparator<Book> {
	@Override
	public int compare(Book arg0, Book arg1) {
		return (arg0.getStore().getRoom())-(arg1.getStore().getRoom());
	}
}
