import java.util.Comparator;
public class roomComparator implements Comparator<BookOrder> {
	@Override
	public int compare(BookOrder arg0, BookOrder arg1) {
		return (arg0.getRoom())-(arg1.getRoom());
	}
}