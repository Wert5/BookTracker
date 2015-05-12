
import java.awt.Dimension;
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
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class BookWindow extends JFrame {
	private SortButtons sort=new SortButtons();
	private JList<String> bookList;
	private JScrollPane scroll;
	
	public BookWindow(){
		super();
		this.setTitle("Books");
		this.setSize(1000,700);
		this.setResizable(false);
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
		this.add(sort,c);
		c.gridy=2;
		String[] test = new String[50];//For Testing only
		test[0]=" aaaaabbbbbcccccdddddeeeeefffff  |  1111  |    111    |  1111  |  111.22  |  978-0-316-01369-7  |  11";
		test[1]=test[0];
		for(int i=2;i<test.length;i++){
			test[i]="choice"+i;
		}
		bookList = new JList<String>(test);
		bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookList.setLayoutOrientation(JList.VERTICAL);
		bookList.setVisibleRowCount(-1);
		scroll = new JScrollPane(bookList);
		scroll.setPreferredSize(new Dimension((int)sort.getPreferredSize().getWidth(),500));
		this.add(scroll,c);

	}
}
