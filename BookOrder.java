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
	
	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String toString(){
		String result = "     ";
		result+=toLength(""+room,4,' ')+"  |   ";
		result+=toLength(""+num,3,' ')+"  |   ";
		result+=toLength(teacher,13,' ');
		return result;
	}
}

