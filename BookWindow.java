import java.awt.*; 
2 import java.awt.event.*; 
3 import javax.swing.*; 
4 
 
5 public class BookWindow extends JFrame { 
6 	/** 
7 	 *  
8 	 */ 
9 	private static final long serialVersionUID = 1L; 
10 	private SortButtons sort=new SortButtons(this); 
11 	private JList bookList; 
12 	private DefaultListModel bookMod; 
13 	private JScrollPane scroll; 
14 	 
15 	public BookWindow(){ 
16 		super(); 
17 		this.setTitle("BookTester BETA (Secure Information, DO NOT RELEASE)"); 
18 		this.setSize(1200,800); 
19 		this.setResizable(false); 
20 		this.setLocation(40, 50); 
21 		JLabel h = new JLabel("Hello"); 
22 		h.setVisible(true); 
23 		//b.addLayoutComponent(h, BorderLayout.NORTH); 
24 		this.setLayout(new GridBagLayout()); 
25 		addComponents(); 
26 		addWindowListener(new WindowAdapter() { 
27 		  	public void windowClosing(WindowEvent e) { 
28 			   System.exit(0); 
29 		  	} //windowClosing 
30 		} ); 
31 	} 

	
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
