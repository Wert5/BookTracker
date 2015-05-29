import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class OrderDisplay extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList ordList;
	private DefaultListModel ordMod;
	private JScrollPane scroll;
	private JPanel buts;
	private JButton rm;
	private JButton num;
	private JButton teach;
	private ArrayList<BookOrder> arr;
	private Book bk;
	public static final String ordFile="orders.txt";

	public OrderDisplay() {
		// TODO Auto-generated constructor stub
		super();
		bk=new Book("",null,0,0,null,Book.g.AP,0);
		init();
	}
	private void init(){
		arr=new ArrayList<BookOrder>();
		buts=new JPanel(new FlowLayout());
		((FlowLayout)buts.getLayout()).setAlignment(FlowLayout.LEFT);
		rm=new JButton("Room");
		rm.setMargin(new Insets(0,0,0,0));
		rm.addActionListener(this);
		num=new JButton("Num");
		num.setMargin(new Insets(0,0,0,0));
		num.addActionListener(this);
		teach=new JButton("Teach");
		teach.setMargin(new Insets(0,30,0,30));
		teach.addActionListener(this);
		buts.add(rm);
		buts.add(num);
		buts.add(teach);
		this.setLayout(new BorderLayout());
		this.add(buts,BorderLayout.NORTH);
		
		ordMod=new DefaultListModel();
		ordList=new JList(ordMod);
		scroll=new JScrollPane(ordList);
		this.add(scroll);
		this.setMinimumSize(new Dimension(200,500));
		this.setVisible(true);
	}
	public void setList(Book k){
		bk=k;
		ArrayList<BookOrder> a=;
		for(OrderList ol:BookData.ordersSubmit){
			if(ol.getBook().equals(k.getTitle())){
				
			}
		}
		BookOrder[] b=(a.toArray(new BookOrder[a.size()]));
		if(b.length<=ordMod.getSize()){
			int i=0;
			for(i=0;i<b.length;i++){
				ordMod.set(i, b[i]);
				arr.set(i,b[i]);
			}
			while(ordMod.getSize()>b.length){
				ordMod.remove(ordMod.getSize()-1);
				arr.remove(ordMod.getSize());
			}
		}else{
			int i=0;
			for(i=0;i<ordMod.getSize();i++){
				ordMod.set(i, b[i]);
				arr.set(i,b[i]);
			}
			for(;i<b.length;i++){
				ordMod.add(i, b[i]);
				arr.add(i,b[i]);
			}
		}
		this.repaint();
		for(BookOrder ao:arr){
			BookData.saveOrder(ordFile,new OrderList(ao,k.getTitle()));
		}
	}
	
	public BookOrder getSelection(){
		return (BookOrder)ordMod.getElementAt(ordList.getLeadSelectionIndex());
		
	}
	
	public int getSelectionInd(){
		return ordList.getLeadSelectionIndex();
		
	}
	
	public void removeOrd(){
		BookOrder ind=getSelection();
		ordMod.removeElement(ind);
		arr.remove(ind);
		BookData.ordersSubmit.remove(ind);
		setList(bk);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==rm){
			bk.setOrders(Sort.sortRoomBO(bk.getOrders()));
			setList(bk);
		}else if(ae.getSource()==num){
			bk.setOrders(Sort.sortNumBO(bk.getOrders()));
			setList(bk);
		}else{
			bk.setOrders(Sort.sortTeacher(bk.getOrders()));
			setList(bk);
		}
		
	}

}
