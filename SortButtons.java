import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author 154667
 *This class is the panel with the sorting buttons on it.
 */

public class SortButtons extends JPanel implements ActionListener{
	public JButton[] sortBut;
	private BookWindow window;

	public SortButtons(BookWindow bw) {
		super();
		// TODO Auto-generated constructor stub
		setUp();
		window=bw;
	}
	
	public void setUp(){
		sortBut=new JButton[7];
		sortBut[0]=new JButton("Title");
		sortBut[1]=new JButton("Total");
		sortBut[2]=new JButton("Room");
		sortBut[3]=new JButton("Store");
		sortBut[4]=new JButton("Price");
		sortBut[5]=new JButton("ISBN");
		sortBut[6]=new JButton("Grade");
		for(JButton a:sortBut){
			a.setMargin(new Insets(0,0,0,0));
			this.add(a);
		}
		sortBut[0].setMargin(new Insets(0,80,0,80));
		sortBut[3].setMargin(new Insets(0,5,0,5));
		sortBut[4].setMargin(new Insets(0,10,0,10));
		sortBut[5].setMargin(new Insets(0,60,0,60));
		for(JButton j:sortBut)
			j.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		for(JButton j:sortBut){
			if(ae.getSource()==j){
				JOptionPane.showMessageDialog(this, "Sorting by "+ae.getActionCommand().toLowerCase());
				Book[] test = new Book[50];//For Testing only
				for(int i=0;i<test.length;i++){
					test[i]=new Book(ae.getActionCommand(),new BookOrder(100,100,"Hello"),100,123.6,"a643524523542354235423646sadgsadgdgfad",Book.g.AP,0);
					ArrayList<BookOrder> orders=new ArrayList<BookOrder>();
					for(int k=0;k<50;k++){
						orders.add(new BookOrder(20,13,"winstonssssssssssss"));
					}
					test[i].setOrders(orders);
				}
				window.setList(test);
				window.repaint();
				
			}
		}
	}

}

