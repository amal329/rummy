import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
	public ArrayList<Card> cards = new ArrayList<>();
	public final String suits[] = new String[] {"D","C","S","H"};
	
	Deck() {
		for(int i=0;i<4;i++) {
			for(int j=1;j<=13;j++) {
				cards.add(new Card(j,suits[i]));
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public void printDeck() {
		for(Card c : cards) {
			System.out.println(c.suit+"-"+c.val);
		}
	}
	
	public Card pickCard() {
		Card c = cards.remove(0);
		return c;
	}
}
