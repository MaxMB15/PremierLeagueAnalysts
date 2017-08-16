import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		SourceCode sc = new SourceCode(SourceCode.getURL("https://www.premierleague.com/players?se=79&cl=43"));
		System.out.println(sc.toString());
		ArrayList<SourceCode> scarray = sc.getNodesByName("tr");
		ArrayList<String> list = scarray.get(0).getTextByTag("th");
		for(String sca : list){
			System.out.println(sca);			
		}
	}
}
