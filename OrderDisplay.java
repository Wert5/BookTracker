import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class OrderDisplay extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList ordList;
	private DefaultListModel ordMod;
	private JScrollPane scroll;

	public OrderDisplay() {
		// TODO Auto-generated constructor stub
		super();
		init();
	}
	private void init(){
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

}
