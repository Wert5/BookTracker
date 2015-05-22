import java.util.Comparator;
public class gradeComparator implements Comparator<Book> {
	@Override
	public int compare(Book arg0, Book arg1) {
		return (arg0.getGrade()).compareTo(arg1.getGrade());
	}
}
