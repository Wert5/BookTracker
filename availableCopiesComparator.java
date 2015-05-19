import java.util.Comparator;
public class availableCopiesComparator implements Comparator<Book> {
	@Override
	public int compare(Book arg0, Book arg1) {
		return (arg0.getStore().getNum())-(arg1.getStore().getNum());
	}
}
