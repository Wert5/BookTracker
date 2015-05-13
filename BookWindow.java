
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class BookWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SortButtons sort=new SortButtons(this);
	private JList<Book> bookList;
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
		Book[] test = new Book[50];//For Testing only
		for(int i=0;i<test.length;i++){
			test[i]=new Book("abbbbMMMmmm",new BookOrder(100,100,""),100,123.6,"a643524523542354235423646sadgsadgdgfad",1);
		}
		setList(test);
	}
	
	public void setList(Book[] b){
		GridBagConstraints c=new GridBagConstraints();
		c.gridy=2;
		c.gridwidth=6;
		c.gridx=1;
		bookList = new JList<Book>(b);
		bookList.setFont(new Font(Font.MONOSPACED,Font.PLAIN,12));
		bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookList.setLayoutOrientation(JList.VERTICAL);
		bookList.setVisibleRowCount(-1);
		scroll = new JScrollPane(bookList);
		scroll.setPreferredSize(new Dimension((int)sort.getPreferredSize().getWidth(),500));
		this.add(scroll,c);
		this.revalidate();
	}

}
