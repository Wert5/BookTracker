import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ActPanel extends JPanel implements ActionListener{
	private BookWindow wind;
	private JButton del;
	private JButton add;
	private JButton ret;
	private JButton chk;

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
		add=new JButton("Add New Book");
		this.add(add);
		add.addActionListener(this);
		del=new JButton("Delete Book");
		this.add(del);
		del.addActionListener(this);
		ret=new JButton("Return Book");
		this.add(ret);
		ret.addActionListener(this);
		chk=new JButton("Check Out Book");
		this.add(chk);
		chk.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==del){
			
		}
		
	}

}
