import java.util.ArrayList;
/*
 * 
 */

public class Book {
	private String title;
	private BookOrder store;
	private int total;
	private ArrayList<BookOrder> orders=new ArrayList<BookOrder>();
	private double price=0;
	private String isbn="";
	private int grade=0;
	
	public Book(String t,BookOrder bo,int tot,double p,String i,int grd){
		this.title=t;
		this.store = bo;
		this.total = tot;
		this.price = p;
		this.isbn = i;
		this.grade = grd;
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
	public int getGrade() {
		return grade;
	}
	
	private String toLength(String a, int l){
		if(a.length()>=l){
			return a.substring(0,l);
		}
		while(a.length()<l){
			a+=" ";
		}
		return a;
	}
	
	public String toString(){
		String r=toLength(title,30);
		return r+"x";
	}
	
}
