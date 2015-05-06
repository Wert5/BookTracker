import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


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
            String[] parts;
            while((line = bufferedReader.readLine()) != null) {
                parts=line.split("\t");
                System.out.println(parts.length);
                if(parts.length>0)
                System.out.println(parts[0]);
            }    

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
}
