
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class BookWindow extends JFrame {
	public SortButtons s=new SortButtons();
	public SortButtons s2=new SortButtons();
	
	public BookWindow(){
		super();
		this.setTitle("Books");
		this.setSize(1000,1000);
		this.setLocation(10, 10);
		JLabel h = new JLabel("Hello");
		h.setVisible(true);
		//b.addLayoutComponent(h, BorderLayout.NORTH);
		this.setLayout(new GridBagLayout());
		addComponents();
		addWindowListener(new WindowAdapter() {
		  	public void windowClosing(WindowEvent e) {
			   System.exit(0);
		  	} //windowClosing
		} );

	}
	
	public void addComponents(){
		GridBagConstraints c=new GridBagConstraints();
		c.gridx=1;	
		c.gridwidth=6;
		c.gridy=1;
		this.add(s,c);
		c.gridy=2;
		this.add(s2,c);
	}
}
