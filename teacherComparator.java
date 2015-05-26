import java.util.Comparator;
public class teacherComparator implements Comparator<BookOrder> {
	@Override
	public int compare(BookOrder o1, BookOrder o2) {
		return (o1.getTeacher()).compareTo(o2.getTeacher()); //Returns a integer representing which BookOrder teacher name comes first in the alphabet, or if they are identical;
	}
}
