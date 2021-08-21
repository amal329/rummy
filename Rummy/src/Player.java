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
		System.out.print("| ");
		for(Card c : cards) {
			System.out.print(" "+c.suit+"-"+c.val+" |");   // Karthikeya Changed the way of cards appearing. 
		}
	}
	
	
}
