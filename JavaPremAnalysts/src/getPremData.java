import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class getPremData {
	/*static String[] getLatestData(){
		//need to format data to decode
		
	}*/
	static String getUrlSourceCode(String url) throws IOException {
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
}
