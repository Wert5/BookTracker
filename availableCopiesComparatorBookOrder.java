import java.util.Comparator;
public class availableCopiesComparatorBookOrder implements Comparator<BookOrder> {
	@Override
	public int compare(BookOrder arg0, BookOrder arg1) {
		return (arg0.getNum())-(arg1.getNum());
	}
}
