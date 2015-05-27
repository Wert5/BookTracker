import java.util.Comparator;
public class availableCopiesComparatorBookOrder implements Comparator<BookOrder> {
	@Override
	public int compare(BookOrder arg0, BookOrder arg1) {
		return (arg0.getNum())-(arg1.getNum()); //Returns a integer representing the difference between the number of available copies of the BookOrders and organizes them least to greatest based on number of available copies
		}
}
