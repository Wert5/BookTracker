import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public OrderDisplay() {
		// TODO Auto-generated constructor stub
		super();
		init();
	}
	private void init(){
		buts=new JPanel();
		rm=new JButton("Rm");
		num=new JButton("Num");
		teach=new JButton("Teach");
		buts.add(rm);
		buts.add(num);
		buts.add(teach);
		this.setLayout(new BorderLayout());
		this.add(buts,BorderLayout.NORTH);
		
		ordMod=new DefaultListModel();
		ordList=new JList(ordMod);
		scroll=new JScrollPane(ordList);
		this.add(scroll);
		scroll.setMinimumSize(new Dimension(700,1000));
		this.setMinimumSize(new Dimension(500,1000));
		this.setVisible(true);
	}
	public void setList(BookOrder[] b){
		if(b.length<=ordMod.getSize()){
			int i=0;
			for(i=0;i<b.length;i++){
				ordMod.set(i, b[i]);
			}
			while(ordMod.getSize()>b.length){
				ordMod.remove(ordMod.getSize()-1);
			}
		}else{
			int i=0;
			for(i=0;i<ordMod.getSize();i++){
				ordMod.set(i, b[i]);
			}
			for(;i<b.length;i++){
				ordMod.add(i, b[i]);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

