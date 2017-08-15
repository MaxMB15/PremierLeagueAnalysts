import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class SourceCode {
	//The point of this class is to Handle the output recieved from source code from html documents
	
	private String htmlCode = "NULL";
	private String[] htmlCodeArray = new String[0];
	public SourceCode(URL url){
		try {
			htmlCode = getUrlSourceCode(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		codeToArray();
	}
	public SourceCode(String code){
		htmlCode = code;
		codeToArray();
	}
	
	//will get the outer most nodes (so not including nodes with the same name inside of the node) and make an 
	//arrayList of source code
	public ArrayList<SourceCode> getNodesByName(String tag){
		//blank arrayList used to fill up for the return
		ArrayList<SourceCode> returnList = new ArrayList<SourceCode>();
		String htmlCodeTemp = "";
		boolean copying = false;
		//depth must be zero to stop appending lines of html code
		int depth = 0;
		//go through code
		for(int i = 0;i<htmlCodeArray.length;i++){
			if(htmlCodeArray[i].contains("<"+tag)){
				while(!(htmlCodeArray[i].contains("</"+tag) && depth == 0)){
					//if infinite loop throw format exception
					if(i<htmlCodeArray.length-1){
						new SourceCodeFormatException();
					}
					//if there is an inside node
					if(htmlCodeArray[i].contains("</"+tag)){
						depth--;
						//if SourceCode is only one line
						if(depth<0){
							htmlCodeTemp+=htmlCodeArray[i];
							break;
						}
					}
					if(htmlCodeArray[i].contains("<"+tag)&&copying){
						depth++;
					}
					//add code to temp
					htmlCodeTemp+=htmlCodeArray[i]+"\n";
					i++;
					copying = true;
				}
				returnList.add(new SourceCode(htmlCodeTemp));
				//clear for next find
				htmlCodeTemp = "";
				copying = false;
			}
			
			
			
		}
		
		
		return returnList;
	}
	
	
	
	private void codeToArray(){
		htmlCodeArray = htmlCode.split("\n");
	}
	public String getCode(){
		return htmlCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	private String getUrlSourceCode(URL WebPage) throws IOException {
		//Make a connection with URL Object
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
	public String toString(){
		int i = 0;
		String returnString = "";
		for(String s: htmlCodeArray){
			returnString += i+".\t"+s+"\n";
			i++;
		}
		returnString += "\n";
		return returnString;
	}
	public String getAttributeValue(String attribute){
		for(String line : htmlCodeArray){
			if(line.contains(attribute+"=")){
				for(String s : line.split(" ")){
					if(s.contains(attribute+"=")){
						return s.split("=")[1];
					}
				}
			}
		}
		return null;
	}
	
	
	
	
	
	@SuppressWarnings("serial")
	class SourceCodeFormatException extends Exception{
		public SourceCodeFormatException(){
			super("The html Document is invalid!");
		}
	}
	
	//So no need to import another library
	static URL getURL(String url){
		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
