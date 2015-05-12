import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * 
 * @author 154667
 *This class is the panel with the sorting buttons on it.
 */

public class SortButtons extends JPanel {
	public JButton[] sortBut;

	public SortButtons() {
		super();
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
		sortBut[2]=new JButton("Room");
		sortBut[3]=new JButton("Store");
		sortBut[4]=new JButton("Price");
		sortBut[5]=new JButton("ISBN");
		sortBut[6]=new JButton("Grade");
		for(JButton a:sortBut){
			a.setMargin(new Insets(0,0,0,0));
			this.add(a);
		}
		sortBut[0].setMargin(new Insets(0,85,0,85));
		sortBut[2].setMargin(new Insets(0,5,0,5));
	}

}
