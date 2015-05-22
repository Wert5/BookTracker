import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ActPanel extends JPanel implements ActionListener{
	private BookWindow wind;
	private JButton del;
	private JButton add;
	private JButton ret;
	private JButton chk;
	private JTextField srch;

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
		srch=new JTextField();
		this.add(srch);
		srch.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==del){
			if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog(wind, "Are you sure you want to delete " + wind.getSelection().getTitle()+"?")){
				wind.removeListIndex(wind.getSelectionIndex());
			}
			
		}else if(e.getSource()==add){
			String title=JOptionPane.showInputDialog(wind,"Enter the title:");
			if(title==null){
				return;
			}
			String ISBN = JOptionPane.showInputDialog(wind,"Enter ISBN:");
			if(ISBN==null){
				return;
			}
			double price=0;
			int room=0;
			int num=0;
			Book.g grd=Book.g.NINE;
			boolean go=true;
			while(go){
				try{
					String str=JOptionPane.showInputDialog(wind,"Enter Price:");
					if(str==null){
						return;
					}
					price = Double.parseDouble(str);
					go=false;
				}catch(Exception e1){
					JOptionPane.showMessageDialog(wind, "Please enter valid input.");
					go=true;
				}
			}
			go=true;
			while(go){
				try{
					String str=JOptionPane.showInputDialog(wind,"Enter Storage room:");
					if(str==null){
						return;
					}
					room = Integer.parseInt(str);
					go=false;
				}catch(Exception e1){
					JOptionPane.showMessageDialog(wind, "Please enter valid input.");
					go=true;
				}
			}
			go=true;
			while(go){
				try{
					String str=JOptionPane.showInputDialog(wind,"Enter Number of books:");
					if(str==null){
						return;
					}
					num = Integer.parseInt(str);
					go=false;
				}catch(Exception e1){
					JOptionPane.showMessageDialog(wind, "Please enter valid input.");
					go=true;
				}
			}
			go=true;
			while(go){
				try{
					String grade=JOptionPane.showInputDialog(wind,"Enter grade:").toUpperCase();
					go=false;
					if(grade==null){
						return;
					}else{
						grd=Book.g.valueOf(grade);
					}
				}catch(Exception e1){
					JOptionPane.showMessageDialog(wind, "Please enter valid input.");
					go=true;
				}
			}		
			wind.addBook(new Book(title,new BookOrder(room,num,""),num,price,ISBN,grd,0));
		}
		
	}

}


