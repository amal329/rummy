import java.util.ArrayList;

public class Player {
	public static int count = 0;
	public int id;
	public String name;
	private int cardLength = 10;
	private ArrayList<Card> cards = new ArrayList<>(cardLength);
	
	Player(String name){
		this.id = count++;
		this.name = name;
	}
	
	public void dealCard(Card c) {
		if(cards.size() < cardLength) {
			cards.add(c);
		}
	}
	
	public void showCards() {
		System.out.println(name+"'s cards are :");
		for(Card c : cards) {
			System.out.println(c.suit+"-"+c.val);
		}
	}
	
	
}
