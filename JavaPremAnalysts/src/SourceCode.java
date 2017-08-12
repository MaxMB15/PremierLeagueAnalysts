import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class SourceCode {
	//The point of this class is to Handle the output recieved from source code from
	//html documents
	
	private String htmlCode = "NULL";
	private String[] htmlCodeArray = new String[0];
	public SourceCode(String url){
		htmlCode = url;
		codeToArray();
	}
	
	//will get the outer most nodes (so not including nodes with the same name inside 
	//of the node) and make an arrayList of source code
	public ArrayList<SourceCode> getNodesByName(String tag){
		//blank arrayList used to fill up for the return
		ArrayList<SourceCode> returnList = new ArrayList<SourceCode>();
		String htmlLine = "";
		//depth must be zero to stop appending lines of html code
		int depth = 0;
		
		while()
		
		
		return returnList;
	}
	
	
	
	private void codeToArray(){
		htmlCodeArray = htmlCode.split("\n");
	}
	public String getCode(){
		return htmlCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	private String getUrlSourceCode(String url) throws IOException {
		//Make a new URL object and make a connection
        URL WebPage = new URL(url);
        URLConnection connection = WebPage.openConnection();
        
        //Read InputStream
        BufferedReader data = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        //Temp string holder
        String inputLine = "";
        String returnString = "";
        while ((inputLine = data.readLine()) != null){
        	returnString += inputLine + "\n";
        }
        data.close();
        return returnString;
    }
	
	@SuppressWarnings("serial")
	class SourceCodeFormatException extends Exception{
		public SourceCodeFormatException(){
			super("The html Document is invalid!");
		}
	}
}
