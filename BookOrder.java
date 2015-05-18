/**
 * 
 * @author 154667
 * 
 * This class stores a book order.
 *
 */
public class BookOrder {
	public String teacher;
	public int room=0;
	public int num=0;
	
	public BookOrder(int r,int n,String t){
		room=r;
		num=n;
		teacher=t;
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
	
	public String toString(){
		String result = "";
		result+=room+" | ";
		result+=num+" | ";
		result+=toLength(teacher,10,' ');
		return result;
	}
}
