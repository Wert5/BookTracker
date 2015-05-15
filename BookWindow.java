import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BookWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SortButtons sort=new SortButtons(this);
	private JList bookList;
	private DefaultListModel bookMod;
	private JScrollPane scroll;
	
	public BookWindow(){
		super();
		this.setTitle("BookTester BETA (Secure Information, DO NOT RELEASE)");
		this.setSize(1200,800);
		this.setResizable(false);
		this.setLocation(40, 50);
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
		bd=new BookData();
		//Book[] test = new Book[50];//For Testing only
		//for(int i=0;i<test.length;i++){
			//test[i]=new Book("abbbbMMMmmm",new BookOrder(100,100,""),100,123.6,"a643524523542354235423646sadgsadgdgfad",Book.g.AP);
		//}
		initList(bd.getOrig().toArray(new Book[bd.getOrig().size()]));
	}
	
	public void initList(Book[] b){
		GridBagConstraints c=new GridBagConstraints();
		c.gridy=2;
		c.gridwidth=6;
		c.gridx=1;
		bookMod = new DefaultListModel();
		for(Book bk:b){
			bookMod.addElement(bk);
		}
		bookList = new JList(bookMod);
		bookList.setFont(new Font(Font.MONOSPACED,Font.PLAIN,12));
		bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookList.setLayoutOrientation(JList.VERTICAL);
		bookList.setVisibleRowCount(-1);
		scroll = new JScrollPane(bookList);
		scroll.setPreferredSize(new Dimension((int)sort.getPreferredSize().getWidth(),500));
		this.add(scroll,c);
		this.repaint();
	}
	
	public void setList(Book[] b){
		if(b.length<=bookMod.getSize()){
			int i=0;
			for(i=0;i<b.length;i++){
				bookMod.set(i, b[i]);
			}
			while(bookMod.getSize()>b.length){
				bookMod.remove(bookMod.getSize()-1);
			}
		}else{
			int i=0;
			for(i=0;i<bookMod.getSize();i++){
				bookMod.set(i, b[i]);
			}
			for(;i<b.length;i++){
				bookMod.add(i, b[i]);
			}
		}
	}

}
