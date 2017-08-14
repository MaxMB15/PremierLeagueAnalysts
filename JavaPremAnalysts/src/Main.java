public class Main {
	public static void main(String[] args){
		SourceCode sc = new SourceCode(SourceCode.getURL("https://www.premierleague.com/players?se=79&cl=43"));
		System.out.println(sc.toString());
		System.out.println(sc.getNodesByName("tr").toString());
	}
}
