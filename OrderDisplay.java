import java.awt.LayoutManager;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class orderDisplay extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList ordList;
	private DefaultListModel ordMod;
	private JScrollPane scroll;

	public orderDisplay() {
		// TODO Auto-generated constructor stub
		super();
		
	}
	private void init(){
		ordMod=new DefaultListModel();
		ordList=new JList(ordMod);
		scroll=new JScrollPane(ordList);
		this.add(scroll);
	}

}
