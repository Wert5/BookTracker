import java.util.ArrayList;


public class Book {
	private BookOrder store=new BookOrder();
	private int total;
	private ArrayList<BookOrder> orders=new ArrayList<BookOrder>();
	private double price=0;
	private String isbn="";
	private int grade=0;
	
	public Book(BookOrder bo,int tot,double p,String i,int grd){
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
	
	
	
}
