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
		System.out.print("|");
		for(Card c : cards) {
			System.out.print(" "+c.suit+"-"+c.val+" |");
		}
	}
	
	
	
	public Card decidingOnCard(Card displayCard)
	{
		System.out.println("\n"+this.name+"'s Turn");
		this.showCards();
		System.out.print("\nThe card is :");
		displayCard.displayTheCard();
		System.out.println("Do you want this Card\n[Y]es   or [N]o");
		String decision = Reader.sc.nextLine();
		Reader.sc.nextLine();
		if(decision.equalsIgnoreCase("Y"))
		{
			displayCard = this.replaceCard(displayCard);
			this.showCards();
		}
		
		return displayCard;
	}
	
	
	public Card replaceCard(Card cardToReplace)
	{
		this.showCards();
		System.out.print("\nEnter the position of card to Discard:");
		int position = Reader.sc.nextInt();
		Reader.sc.nextLine();
		Card cardToDiscard = this.cards.remove(position-1);
		this.cards.add(cardToReplace);
		return cardToDiscard;
		
	}
	
	
}
