import java.awt.LayoutManager;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JPanel;


public class SortButtons extends JPanel {
	public JButton[] sortBut;

	public SortButtons() {
		// TODO Auto-generated constructor stub
		setUp();
	}

	public SortButtons(LayoutManager arg0) {
		super(arg0);
		setUp();
		// TODO Auto-generated constructor stub
	}
	
	public void setUp(){
		sortBut=new JButton[7];
		sortBut[0]=new JButton("Title");
		sortBut[1]=new JButton("Total");
		sortBut[2]=new JButton("Storeroom");
		sortBut[3]=new JButton("Stored Books");
		sortBut[4]=new JButton("Price");
		sortBut[5]=new JButton("ISBN");
		sortBut[6]=new JButton("Grade");
		for(JButton a:sortBut){
			this.add(a);
		}
	}

}
