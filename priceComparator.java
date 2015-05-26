import java.util.Comparator;
public class priceComparator implements Comparator<Book> {
	@Override
	public int compare(Book arg0, Book arg1) {
		return (int)((arg0.getPrice()-arg1.getPrice())*100); //Returns a integer representing the difference between the price of the Books to order Books least to greatest based on price
	}
}
