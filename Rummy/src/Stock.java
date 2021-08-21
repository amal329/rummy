
public class Stock {
	private int cardLength = 22;
	private Card[] cards = new Card[cardLength];
	
	public void dealCard(Card c) {
		if(cards.length < cardLength) {
			cards[cards.length] = c;
		}
	}
}
