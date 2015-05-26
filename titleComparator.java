import java.util.Comparator;
public class titleComparator implements Comparator<Book> {
	@Override
	public int compare(Book arg0, Book arg1) {
		return arg0.getTitle().compareTo(arg1.getTitle()); //Returns a integer representing which Book title comes first in the alphabet, or if they are identical 
	}
}
