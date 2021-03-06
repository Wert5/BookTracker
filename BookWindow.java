import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class BookWindow extends JFrame implements ListSelectionListener {
	/**
	 * This class represents the main window of our application
	 * It includes multiple panels.
	 * The window directly contains the main book list.
	 */
	private static final long serialVersionUID = 1L;
	private SortButtons sort=new SortButtons(this);
	protected JList bookList;
	private DefaultListModel bookMod;
	private JScrollPane scroll;
	private BookData bd;
	private OrderDisplay ord;
	private ArrayList<Book> arr;
	private final String save="dataBase.txt";
	public static final String ordFile="orders.txt";
	/**
	 *The constructor initializes the window by setting the size, making it visible and setting it up to close
	 */
	public BookWindow(){
		super();
		this.setTitle("Books");
		this.setSize(1500,700);
		this.setResizable(false);
		this.setLocation(10, 10);
		JLabel h = new JLabel("Hello");
		h.setVisible(true);
		//b.addLayoutComponent(h, BorderLayout.NORTH);
		this.setLayout(new GridBagLayout());
		addComponents();
		this.addWindowListener(new WindowAdapter() {
		  	public void windowClosing(WindowEvent e) {
			   System.exit(0);
		  	} //windowClosing
		} );
	}
	/**
	 * This method sets up the GUI by adding each custom panel in the correct position. It also loads the data and initializes the list.
	 */
	public void addComponents(){
		GridBagConstraints c=new GridBagConstraints();
		c.gridx=1;
		c.gridy=2;
		c.gridheight=2;
		ActPanel ap=new ActPanel(this);
		ap.setMinimumSize(new Dimension(110,500));
		this.add(ap,c);
		c=new GridBagConstraints();
		c.gridheight=1;
		c.gridx=2;	
		c.gridwidth=6;
		c.gridy=1;
		this.add(sort,c);
		c.gridy=2;
		bd=new BookData();
		ArrayList<Book> dat= bd.loadData(save);
		initList(dat.toArray(new Book[dat.size()]));
		ap.setord(ord);
	}
	/**
	 * This method sets up the list by creating a ListModel and loading it with the books. It also sets up the list display.
	 */
	public void initList(Book[] b){
		arr=new ArrayList<Book>();
		GridBagConstraints c=new GridBagConstraints();
		c.gridy=2;
		c.gridwidth=6;
		c.gridx=2;
		bookMod = new DefaultListModel();
		for(Book bk:b){
			bookMod.addElement(bk);
			arr.add(bk);
		}
		bookList = new JList(bookMod);
		bookList.setFont(new Font(Font.MONOSPACED,Font.PLAIN,12));
		bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookList.setLayoutOrientation(JList.VERTICAL);
		bookList.setVisibleRowCount(-1);
		scroll = new JScrollPane(bookList);
		scroll.setMinimumSize(new Dimension((int)sort.getPreferredSize().getWidth(),500));
		this.add(scroll,c);
		initOrder();
	}
	
	private void initOrder(){
		ord=new OrderDisplay();
		GridBagConstraints c=new GridBagConstraints();
		c.gridx=8;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		this.add(ord,c);
		this.bookList.addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent ls) {
		refreshOrder();
	}
	/**
	 * This method refreshes the bookOrder list for each book.
	 */
	public void refreshOrder(){
		ord.setList(new Book("",null,0,0,null,Book.g.AP,0));
		Book chosen = this.getSelection();
		BookData.loadOrder(ordFile);
		chosen.setOrders(BookData.findDataTitle(chosen.getTitle()));
		ord.setList(chosen);
		this.setList(this.getList().toArray(new Book[this.getListSize()]));
		this.repaint();
	}
	/**
	 * This method changes the list when the books are sorted.
	 * @param b
	 */
	public void setList(Book[] b){
		if(b.length<=bookMod.getSize()){
			int i=0;
			for(i=0;i<b.length;i++){
				bookMod.set(i, b[i]);
				arr.set(i,b[i]);
			}
			while(bookMod.getSize()>b.length){
				bookMod.remove(bookMod.getSize()-1);
				arr.remove(bookMod.getSize()-1);
			}
		}else{
			int i=0;
			for(i=0;i<bookMod.getSize();i++){
				bookMod.set(i, b[i]);
				arr.set(i,b[i]);
			}
			for(;i<b.length;i++){
				bookMod.add(i, b[i]);
				arr.add(i,b[i]);
			}
		}
		bd.saveData(save,arr);
		bd.saveData(save,arr);
	}
	
	public int getSelectionIndex(){
		return bookList.getSelectedIndex();
	}
	
	public Book getSelection(){
		return (Book)bookMod.get(bookList.getSelectedIndex());
	}
	
	public void removeListIndex(int ind){
		bookMod.remove(ind);
	}
	
	public void addBook(Book b){
		bookMod.addElement(b);
		arr.add(b);
	}
	public ArrayList<Book> getList(){
		return arr;
	}
	
	public int getListSize(){
		return bookMod.getSize();
	}

}








