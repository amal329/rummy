import java.util.ArrayList;

public class Player {
	public static int count = 0;
	public int id;
	public String name;
	private int cardLength = 10;
	private int score = 0;
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
	
	public int getScore()
	{
		return this.score;
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
	
	public void arrangeCards()
	{
		boolean wantToArrange = false;
		System.out.println("\n"+this.name+", Do you want to ararnge the cards?\n[Y]es or [N]o");
		String arrange = Reader.sc.nextLine();
		Reader.sc.nextLine();
		if(arrange.equalsIgnoreCase("Y"))
			wantToArrange = true;
		while(wantToArrange)
		{
			this.showCards();
			System.out.println("\nEnter Index of card you want to change Position:");
			int currentPosition = Reader.sc.nextInt();
			Reader.sc.nextLine();
			System.out.println("Enter Index of position at which you want to place the card:");
			int placingPosition = Reader.sc.nextInt();
			Reader.sc.nextLine();
			this.cards.add(placingPosition-1,cards.remove(currentPosition-1));
			this.showCards();
			System.out.println("\nDo you want to Stop ararnging the cards?\n[Y]es or [N]o");
			String arrange1 = Reader.sc.nextLine();
			Reader.sc.nextLine();
			if((arrange1.equalsIgnoreCase("Y")))
				wantToArrange = false;
		}
		
	}
	
	public boolean makesSet(Card c1,Card c2,Card c3)
	{
		if(c1.val == c2.val && c2.val == c3.val )
		{
			return true;
		}
		else if(c1.suit.equals(c2.suit) && c2.suit.equals(c3.suit) )
		{
			if(c1.val == c2.val+1 && c2.val == c3.val+1)
			{
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean makesSet(Card c1,Card c2,Card c3,Card c4)
	{
		if(c1.val == c2.val && c2.val == c3.val && c3.val == c4.val)
		{
			return true;
		}
		else if(c1.suit.equals(c2.suit) && c2.suit.equals(c3.suit))
		{
			if(c1.val+1 == c2.val && c2.val+1 == c3.val && c3.val+1 == c4.val)
			{
				return true;
			}
			return false;
		}
		return false;
	}
	
	
	public void calculateScore()
	{
		
		if(!(makesSet(this.cards.get(0),this.cards.get(1),this.cards.get(2))))
		{
			this.score = this.score + this.cards.get(0).score+this.cards.get(1).score+this.cards.get(2).score;
		}
		if(!(makesSet(this.cards.get(3),this.cards.get(4),this.cards.get(5))))
		{
			this.score = this.score + this.cards.get(3).score+this.cards.get(4).score+this.cards.get(5).score;
		}
		if(!(makesSet(this.cards.get(6),this.cards.get(7),this.cards.get(8),this.cards.get(9))))
		{
			this.score = this.score + this.cards.get(6).score+this.cards.get(7).score+this.cards.get(8).score+this.cards.get(9).score;
		}
	}
	
	
}
