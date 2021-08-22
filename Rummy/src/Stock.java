import java.util.ArrayList;


public class Stock {
	private int cardLength = 22;
	private ArrayList<Card> cards = new ArrayList<Card>(cardLength);
	
	public void dealCard(Card c) {
		if(cards.size() < cardLength) {
			cards.add(c);
		}
	}
	
	public Card getTopCard()
	{
		return this.cards.remove(0);
	}
	
	public void addCardToEnd(Card cardToAddToEnd)
	{
		cards.add(cardToAddToEnd);
	}
	
}
