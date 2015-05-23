import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

	public OrderDisplay() {
		// TODO Auto-generated constructor stub
		super();
		init();
	}
	private void init(){
		arr=new ArrayList<BookOrder>();
		buts=new JPanel(new FlowLayout());
		((FlowLayout)buts.getLayout()).setAlignment(FlowLayout.LEFT);
		rm=new JButton("Room");
		rm.setMargin(new Insets(0,0,0,0));
		num=new JButton("Num");
		num.setMargin(new Insets(0,0,0,0));
		teach=new JButton("Teach");
		teach.setMargin(new Insets(0,30,0,30));
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
	public void setList(BookOrder[] b){
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
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==rm){
			setList(Sort.sortRoomBO(arr).toArray(new BookOrder[arr.size()]));
		}else if(ae.getSource()==num){
			setList(Sort.sortNumBO(arr).toArray(new BookOrder[arr.size()]));
		}else{
			setList(Sort.sortTeacher(arr).toArray(new BookOrder[arr.size()]));
		}
		
	}

}

