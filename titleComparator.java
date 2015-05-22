import java.util.Comparator;
public class titleComparator implements Comparator<Book> {

	@Override
	public int compare(Book arg0, Book arg1) {
		if(arg0.getTitle().equals(arg1.getTitle())){
			return 0;
		}
		return arg0.getTitle().compareTo(arg1.getTitle());
	}
}
