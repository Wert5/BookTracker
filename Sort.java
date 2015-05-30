import java.util.ArrayList;
import java.util.Collections;

public class Sort {
	
	/**
	 * This is a collection of methods which return a sorted list based on various criteria
	 * @param b
	 * @return
	 */
	public static ArrayList<Book> sortTitle (ArrayList<Book> b){
		Collections.sort(b,new titleComparator());
		return b;
	}
	public static ArrayList<Book> sortPrice (ArrayList<Book> b){
		Collections.sort(b, new priceComparator());
		return b;
	}
	public static ArrayList<Book> sortRoom (ArrayList<Book> b){
		Collections.sort(b, new roomComparatorBook());
		return b;
	}
	public static ArrayList<BookOrder> sortRoomBO (ArrayList<BookOrder> b){
		Collections.sort(b, new roomComparatorBookOrder());
		return b;
	}
	public static ArrayList<Book> sortNum (ArrayList<Book> b){
		Collections.sort(b, new availableCopiesComparator());
		return b;
	}
	public static ArrayList<BookOrder> sortNumBO (ArrayList<BookOrder> b){
		Collections.sort(b, new availableCopiesComparatorBookOrder());
		return b;
	}
	public static ArrayList<Book> sortISBN (ArrayList<Book> b){
		Collections.sort(b, new ISBN_Comparator());
		return b;
	}
	public static ArrayList<Book> sortGrade (ArrayList<Book> b){
		Collections.sort(b, new gradeComparator());
		return b;
	}
	public static ArrayList<BookOrder> sortTeacher (ArrayList<BookOrder> b){
		Collections.sort(b, new teacherComparator());
		return b;
	}
} 
