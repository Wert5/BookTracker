import java.util.Comparator;
public class gradeComparator implements Comparator<Book> {
	@Override
	public int compare(Book arg0, Book arg1) {
		return (arg0.getGrade()).compareTo(arg1.getGrade()); //Returns a integer representing the difference between the grade level of the Books to order Books least to greatest based on grade level. Note that AP is the greatest.
	}
}
