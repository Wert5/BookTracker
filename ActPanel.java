import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ActPanel extends JPanel {
	private BookWindow wind;

	public ActPanel(BookWindow bw) {
		// TODO Auto-generated constructor stub
		super();
		wind=bw;
		init();
	}

	public ActPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public ActPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public ActPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	private void init(){
		JButton temp=new JButton("Add New Book");
		this.add(temp);
		temp.addActionListener(wind);
		temp=new JButton("Delete Book");
		this.add(temp);
		temp.addActionListener(wind);
		temp=new JButton("Return Book");
		this.add(temp);
		temp.addActionListener(wind);
		temp=new JButton("Check Out Book");
		this.add(temp);
		temp.addActionListener(wind);
	}

}
