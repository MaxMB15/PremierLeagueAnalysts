import java.io.IOException;

public class Main {
	public static void main(String[] args){
		//first must get all data from the day/games before.
		//New static class to get data
		try {
			System.out.println(getPremData.getUrlSourceCode("https://www.premierleague.com/players?se=79&cl=43"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
