import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class BookData {
	int starTemp=0;
	int count=0;
	String bookTitle, isbn, grade;
	int roomNumber,numberbooks;
	double price;
	Book.g enumGrade;

	public static final String ORIGINAL="OrigDataBase.txt";
	public static final String TITLE="TitleData.txt";
	private static ArrayList<Book> orig = new ArrayList<Book>(50000);
	
	public BookData(){
		loadData();
	}
	
	public ArrayList<Book> loadData(){
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(ORIGINAL);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            String line="";
            String[] parts=null;
            while((line = bufferedReader.readLine()) != null) {
                parts=line.split("\t");
                }
            for (int i=0;i<parts.length;i++){ //Separates parts
            	String tempString=parts[i];
            	count=0;
            	starTemp=tempString.length();
            	for (int j=tempString.length();j>0;j++){ //one character at a time
	            	if (tempString.substring(i-1,i)=="/t"){ //Separate isbn, title, etc
	            		if (count==0){
	            			isbn=tempString.substring(i,starTemp);
	            			count++;
	            			starTemp=i;
	            		}
	            		else if (count==1){
	            			price=Double.parseDouble(tempString.substring(i,starTemp));
	            			count++;
	            			starTemp=i;
	            		}
	            		else if (count==2){
	            			numberbooks=Integer.parseInt(tempString.substring(i+1,starTemp));
	            			count++;
	            			starTemp=i;
	            		}
	            		else if (count==3){
	            			roomNumber=Integer.parseInt(tempString.substring(i,starTemp));
	            			count++;
	            			starTemp=i;
	            		}
	            		else if (count==4){ 
	            			grade=(tempString.substring(i,starTemp));
	            			count++;
	            			starTemp=i;
	            		}
	            		else{ 
	            			bookTitle=tempString.substring(0,i);
	            		}
	            	}
            	}
            	//to change grade to enum
            	if (grade=="9")
            		enumGrade=Book.g.NINE;
            	if (grade=="10")
            		enumGrade=Book.g.TEN;
            	if (grade=="11")
            		enumGrade=Book.g.ELEVEN;
            	if (grade=="12")
            		enumGrade=Book.g.TWELVE;
            	if (grade=="AP")
            		enumGrade=Book.g.AP;
            	
            	BookOrder tempOrder=new BookOrder(roomNumber,numberbooks,"");
	            Book cycle=new Book(bookTitle, tempOrder, numberbooks, price, isbn, enumGrade); //,int tot,double p,String i,g grd
	            orig.add(cycle);
	            }
	            
            // Always close files.
            bufferedReader.close();            
        }
		
        catch(FileNotFoundException ex) {
			System.out.println(
                "Unable to open file '" + 
                ORIGINAL + "'"+ex.getMessage());                
        }
		catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + ORIGINAL + "'"+ex.getMessage());                   
	            // Or we could just do this: 
	            // ex.printStackTrace();
	    }
		return orig;
	}
	
	public static ArrayList<Book> getOrig() {
		return orig;
	}

	public void findDataTitle(){
		
		int count=4;
		while (count>0){
			
		}
		
	}
	
	public void findDataISBN(){
		
	}
	
	public void findDataAuthor(){
		
	}
}
