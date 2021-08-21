
public class Deck {
	public Card[] cards = new Card[52];
	public final String suits[] = new String[] {"D","C","S","H"};
	
	Deck() {
		int ind = 0;
		for(int i=0;i<4;i++) {
			for(int j=1;j<=13;j++) {
				cards[ind++] = new Card(j,suits[i]);
			}
		}
	}
}
