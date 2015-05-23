import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class BookData {

	public static final String ORIGINAL="OrigDataBase.txt";
	public static final String TITLE="TitleData.txt";
	private static ArrayList<Book> orig = new ArrayList<Book>(1000);
	
	public BookData(){
		//fix();
	}
	
	private void fix(){
		String bookTitle, isbn, grade;
		int roomNumber,total;
		double price;
		Book.g enumGrade;
		int missingbooks;
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader("dataBase.txt");

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            String line="";
            String[] parts={" "};
            line = bufferedReader.readLine();
            line = bufferedReader.readLine();
			while(line != null) {
					if(line.charAt(0)!='/'){
	                    parts=line.split("\t");
	                    if(parts.length<1){
	                    	break;
	                    }
	                    if (parts.length==0) {
	                     	missingbooks=0;
	                     }else{
	                    	 try {
	                    		 missingbooks=Integer.parseInt(parts[6]);
	                    		 //System.out.println(missingbooks);
	                    		}
	                    		catch(Exception exception) {
	                    		   missingbooks=0;
	                    		   
	                    		}
	                     }
	                    //add finding missing
	                    if(parts.length<6){
	                    	isbn="none";
	                    }else{
	                    	isbn=parts[5];
	                    }
	                    if(parts[4].length()!=0&&parts[4].charAt(0)=='$'){
	                    	System.out.println(parts[4]);
	                    	price=Double.parseDouble(parts[4].substring(1,parts[4].length()));
	                    }else{
	                    	price=0;
	                    }
	                    total=Integer.parseInt(parts[3]);
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
		            	
		            	
		            	BookOrder tempOrder=new BookOrder(roomNumber,total,"");
			            Book cycle=new Book(bookTitle, tempOrder,missingbooks, price, isbn, enumGrade,missingbooks); //,int tot,double p,String i,g grd
			            orig.add(cycle);
					}else{
						System.out.println(line);
					}
		            line = bufferedReader.readLine();
		            saveData("dataBase.txt",orig);
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
	}
	
	public ArrayList<Book> loadData(String file){
		String bookTitle, isbn, grade;
		int roomNumber,total;
		double price;
		Book.g enumGrade;
		int missingbooks;
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(file);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            String line="";
            String[] parts={" "};
            line = bufferedReader.readLine();
            line = bufferedReader.readLine();
			while(line != null) {
					if(line.charAt(0)!='/'){
	                    parts=line.split("\t");
	                    System.out.println(Arrays.toString(parts));
	                    if(parts.length<1){
	                    	break;
	                    }
	                    if (parts.length==0) {
	                     	missingbooks=0;
	                     }else{
	                    	 try {
	                    		 missingbooks=Integer.parseInt(parts[7]);
	                    		}
	                    		catch(ArrayIndexOutOfBoundsException exception) {
	                    		   missingbooks=0;
	                    		   
	                    		}
	                     }
	                    //add finding missing
	                    if(parts.length<7){
	                    	isbn="none";
	                    }else{
	                    	isbn=parts[6];
	                    }
	                    if(parts[5].length()!=0){
	                    	price=Double.parseDouble(parts[5].substring(0,parts[5].length()));
	                    }else{
	                    	price=0;
	                    }
	                    total=Integer.parseInt(parts[3]);
	                    roomNumber=Integer.parseInt(parts[2].split("/")[0]);
	                    grade=(parts[1]);
	                    bookTitle=parts[0];
	                    //to change grade to enum
		            	if (grade.equals("NINE")){
		            		enumGrade=Book.g.NINE;}
		            	else if (grade.equals("TEN")){
		            		enumGrade=Book.g.TEN;}
		            	else if (grade.equals("ELEVEN")){
		            		enumGrade=Book.g.ELEVEN;}
		            	else if (grade.equals("TWELVE")){
		            		enumGrade=Book.g.TWELVE;}
		            	else if (grade.equals("AP")){
		            		enumGrade=Book.g.AP;}
		            	else {
		            		enumGrade=Book.g.TEN;}
		            	
		            	
		            	BookOrder tempOrder=new BookOrder(roomNumber,Integer.parseInt(parts[4]),"");
			            Book cycle=new Book(bookTitle, tempOrder,total, price, isbn, enumGrade,missingbooks); //,int tot,double p,String i,g grd
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
	//can be used to edit existing file with the same fileName, or append to a new file
	public void saveData(String fileName, ArrayList<Book> books){
		try {
            // FileReader reads text files in the default encoding.
            FileWriter fileSaveNew= new FileWriter(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedWriter bufferedSaveNew = new BufferedWriter(fileSaveNew);
            //turns Book object into strings
            String add2File="";
            String title,isbn;
			Book.g grade;
			int missing;
			double price;
			BookOrder tempH;
			ArrayList<BookOrder> arrayRoom;
			int total, room,num;
            for (Book b:books){
            	title=b.getTitle();
            	total=b.getStore().getNum();
            	price=b.getPrice();
            	isbn=b.getIsbn();
            	grade=b.getGrade();
            	tempH=b.getStore();
            	room=tempH.getRoom();
            	num=b.getStore().getNum();
            	missing=b.getMissing();
            	add2File=title+"\t"+grade+"\t"+room+"\t"+total+"\t"+num+"\t"+price+"\t"+isbn+"\t"+missing;
            	//System.out.println(add2File);
        	    FileWriter fw = new FileWriter(fileName,true); //the true will append the new data
        	    fw.write("\n"+add2File);//appends the string to the file
        	    fw.close();
        	}
		}catch(IOException ioe)
    	{
    	    System.err.println("IOException: " + ioe.getMessage());
    	}
		
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
