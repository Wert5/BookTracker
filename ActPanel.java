import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ActPanel extends JPanel implements ActionListener{
	private BookWindow wind;
	private OrderDisplay ord;
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
	
	public void setord(OrderDisplay o){
		ord=o;
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
	/**
	 * This method sets up the display by initializing the buttons
	 */
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
	/**
	 * This method handles the buttons by bringing up windows to get information and calling the necessary methods.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==del){
			try{
				if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog(wind, "Are you sure you want to delete " + wind.getSelection().getTitle()+"?")){
					wind.removeListIndex(wind.getSelectionIndex());
				}
			}catch(Exception e1){
				JOptionPane.showMessageDialog(wind,"Please select a book.");
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
		}else if(e.getSource()==chk){
			int rm=0;
			int num=0;
			String teach="";
			boolean go=true;
			while(go)
			{				
				try{
					wind.getSelection();
						
					String str=JOptionPane.showInputDialog("Please enter the room number.");
					if(str==null){
						return;
					}else{
						rm=Integer.parseInt(str);
					}
					go=false;
					
				}catch(ArrayIndexOutOfBoundsException e1){
					JOptionPane.showMessageDialog(wind,"Please select a book.");
					return;
				}catch(Exception e2){
					JOptionPane.showMessageDialog(wind,"Please enter valid input.");
					go=true;
				}
			}
			go=true;
			while(go)
			{				
				try{
						
					String str=JOptionPane.showInputDialog("Please enter the number of books being checked out.");
					if(str==null){
						return;
					}else{
						num=Integer.parseInt(str);
						if(wind.getSelection().getStore().getNum()>num){
							go=false;
						}else{
							go=true;
							JOptionPane.showMessageDialog(wind,"There are not enough books in storage\nto fulfill this request.");
						}
					}
					
					
				}catch(ArrayIndexOutOfBoundsException e1){
					JOptionPane.showMessageDialog(wind,"Please select a book.");
					return;
				}catch(Exception e2){
					JOptionPane.showMessageDialog(wind,"Please enter valid input.");
					go=true;
				}
			}
			go=true;
			while(go)
			{				
				try{
						
					teach=JOptionPane.showInputDialog("Please enter the Teacher");
					if(teach==null){
						return;
					}
					go=false;
					
				}catch(ArrayIndexOutOfBoundsException e1){
					JOptionPane.showMessageDialog(wind,"Please select a book.");
					return;
				}catch(Exception e2){
					JOptionPane.showMessageDialog(wind,"Please enter valid input.");
					go=true;
				}
			}
			wind.getSelection().addOrder(new BookOrder(rm,num,teach));
			BookData.saveOrder(wind.ordFile, new OrderList(new BookOrder(rm,num,teach),wind.getSelection().getTitle()));
			wind.getSelection().getStore().setNum(wind.getSelection().getStore().getNum()-num);;
		}else if(e.getSource()==ret){
			boolean go=true;
			int num;
			while(go)
			{				
				try{
					String str=JOptionPane.showInputDialog("Please enter the number of books being returned.");
					if(str==null){
						return;
					}else if(ord.getSelection()!=null){
						num=Integer.parseInt(str);
						if(ord.getSelection().getNum()>=num){
							go=false;
							ord.getSelection().setNum(ord.getSelection().getNum()-num);
							wind.getSelection().getStore().setNum(num+wind.getSelection().getStore().getNum());
							if(ord.getSelection().getNum()==0){
								ord.removeOrd();
								System.out.println("removing");
							}
						}else{
							go=true;
							JOptionPane.showMessageDialog(wind,"There are not enough books in this order\nto fulfill this request.");
							
						}
					}else{
						JOptionPane.showMessageDialog(wind,"Please select a book order.");
					}
					
					
				}catch(ArrayIndexOutOfBoundsException e1){
					JOptionPane.showMessageDialog(wind,"Please select a book order.");
					return;
				}/*catch(Exception e2){
					JOptionPane.showMessageDialog(wind,"Please enter valid input.");
					go=true;
				}*/
				
			}
		}
		
		wind.refreshOrder();
	}

}



