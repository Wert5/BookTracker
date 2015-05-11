import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class BookWindow extends JFrame {
	public BookWindow(){
		super();
		this.setTitle("Books");
		this.setSize(1000,1000);
		this.setLocation(10, 10);
		BorderLayout b=new BorderLayout();
		
		JLabel h = new JLabel("Hello");
		h.setVisible(true);
		//b.addLayoutComponent(h, BorderLayout.NORTH);
		this.setLayout(b);
		this.add(h,BorderLayout.SOUTH);
		addWindowListener(new WindowAdapter() {
		  	public void windowClosing(WindowEvent e) {
			   System.exit(0);
		  	} //windowClosing
		} );

	}
}
