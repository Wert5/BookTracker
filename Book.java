import java.util.ArrayList;
/*
 * This class represents a book. it stores data and formats a string about the book.
 */

public class Book {
	public enum g {NINE,TEN,ELEVEN,TWELVE,AP};
	public static final String sep=" | ";
	private String title;
	private BookOrder store;
	private int total;
	private ArrayList<BookOrder> orders=new ArrayList<BookOrder>();
	private double price=0;
	private String isbn="";
	private g grade;
	
	public Book(String t,BookOrder bo,int tot,double p,String i,g grd){
		this.title=t;
		this.store = bo;
		this.total = tot;
		this.price = p;
		this.isbn = i;
		this.grade = grd;
	}
	
	public String getTitle() {
		return title;
	}

	public BookOrder getStore() {
		return store;
	}
	public int getTotal() {
		return total;
	}
	public ArrayList<BookOrder> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<BookOrder> orders) {
		this.orders = orders;
	}
	public double getPrice() {
		return price;
	}
	public String getIsbn() {
		return isbn;
	}
	public g getGrade() {
		return grade;
	}
	
	private String toLength(String a, int l,char pad){
		if(a.length()>=l){
			return a.substring(0,l);
		}
		while(a.length()<l){
			a+=""+pad;
		}
		return a;
	}
	/**
	 * Returns a String formatted for the list GUI.
	 */
	public String toString(){
		String r=" "+toLength(title,25,' ')+sep;
		r+=""+toLength(""+total,3,' ')+""+ sep;
		r+=""+toLength(""+store.room,3,' ')+""+ sep;
		r+=""+toLength(""+total,4,' ')+""+ sep;
		r+=""+toLength(""+(int)price+"."+toLength(""+(int)(price*100%100),2,'0'),6,' ')+""+sep;
		r+=toLength(isbn,20,' ')+sep;
		if(!grade.equals(g.AP)){
			r+=toLength(""+(grade.ordinal()+9),2,' ');
		}else{
			r+="AP";
		}
		return r;
	}
	
}
