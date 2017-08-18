import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		//Make a source code object
		SourceCode sc = new SourceCode(SourceCode.getURL("https://www.premierleague.com/players?se=79&cl=43"));
		//print it
		System.out.println(sc.toString());
		
		ArrayList<SourceCode> scarray = sc.getNodesByName("tr");
		ArrayList<String> list = scarray.get(4).getTextByTag("span");
		for(String s : list){
			System.out.println(s);			
		}

	}
}
