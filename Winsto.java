import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Winsto extends BookWindow implements ListSelectionListener{
	public OrderDisplay ord;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Winsto bw=new Winsto();
		bw.setVisible(true);
	}
	
	public void addComponents(){
		super.addComponents();
		initOrder();
	}
	private void initOrder(){
		ord=new OrderDisplay();
		GridBagConstraints c=new GridBagConstraints();
		c.gridx=7;
		c.gridy=2;
		this.add(ord,c);
		this.bookList.addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent ls) {
		ord.setList(ls.getFirstIndex());
	}
	
}

