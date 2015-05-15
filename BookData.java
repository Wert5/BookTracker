import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class BookData {

	public static final String ORIGINAL="OrigDataBase.txt";
	public static final String TITLE="TitleData.txt";
	private static ArrayList<Book> orig = new ArrayList<Book>(1000);
	
	public BookData(){
		loadData();
	}
	
	public ArrayList<Book> loadData(){
		int starTemp=0;
		int count=0;
		String bookTitle, isbn, grade;
		int roomNumber,numberbooks;
		double price;
		Book.g enumGrade;
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(ORIGINAL);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            String line="";
            String[] parts={" "};
            line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            line = bufferedReader.readLine();
			while(line != null) {
					if(line.charAt(0)!='/'){
	                    parts=line.split("\t");
	                    if(parts.length<1){
	                    	break;
	                    }
	                    if(parts.length<6){
	                    	isbn="none";
	                    }else{
	                    	isbn=parts[5];
	                    }
	                    if(parts[4].length()!=0&&parts[4].charAt(0)!='$'){
	                    	price=Double.parseDouble(parts[4].substring(1,parts[4].length()));
	                    }else{
	                    	price=0;
	                    }
	                    numberbooks=Integer.parseInt(parts[3]);
	                    roomNumber=Integer.parseInt(parts[2].split("/")[0]);
	                    grade=(parts[1]);
	                    bookTitle=parts[0];
	                    //to change grade to enum
		            	if (grade.equals("9")){
		            		enumGrade=Book.g.NINE;}
		            	else if (grade.equals("10")){
		            		enumGrade=Book.g.TEN;}
		            	else if (grade.equals("11")){
		            		enumGrade=Book.g.ELEVEN;}
		            	else if (grade.equals("12")){
		            		enumGrade=Book.g.TWELVE;}
		            	else if (grade.equals("AP")){
		            		enumGrade=Book.g.AP;}
		            	else {
		            		enumGrade=Book.g.TEN;}
		            	
		            	
		            	BookOrder tempOrder=new BookOrder(roomNumber,numberbooks,"");
			            Book cycle=new Book(bookTitle, tempOrder, numberbooks, price, isbn, enumGrade); //,int tot,double p,String i,g grd
			            orig.add(cycle);
					}else{
						System.out.println(line);
					}
		            line = bufferedReader.readLine();
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
