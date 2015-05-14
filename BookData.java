import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Book.g;


public class BookData {
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
            String temp="";
            String a="";
            BookOrder b=null;
            int c=0;
            double d=0.0;
            String e="";
            Book.g f=null;
            Book cycle=new Book(a, b, c, d, e, f); 
            orig.add(cycle);
            
            // Always close files.
            bufferedReader.close();            
        }
		
        catch(FileNotFoundException ex) {
			System.out.println(
                "Unable to open file '" + 
                ORIGINAL + "'");                
        }
		catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + ORIGINAL + "'");                   
	            // Or we could just do this: 
	            // ex.printStackTrace();
	    }
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
