public class OrderList {
	public String teacher;
	public int num=0;
	public String book;
	public int room=0;
	
	public OrderList(BookOrder bookOrders, String book)
	{
		teacher=bookOrders.getTeacher();
		num=bookOrders.getNum();
		room=bookOrders.getRoom();
		this.book=book;
	}
	
	public String getTeacher() {
		return teacher;
	}
	
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public String getBook() {
		return book;
	}

	public void setTitle(String book) {
		this.book = book;
	}
	
	public void setRoom(int room){
		this.room=room;
	}
	
	public int getRoom(){
		return room;
	}

}