import java.util.Arrays;
import java.util.Collections;

public class Test {
	public static void main(String[] args) {
		Deck d = new Deck();
		d.shuffle();
		
		Player a = new Player("a");
		Player b = new Player("b");
		Player c = new Player("c");
		
		Stock stock = new Stock();
		
		CardDealer cd = new CardDealer();
		cd.addPlayer(a);
		cd.addPlayer(b);
		cd.addPlayer(c);
		
		cd.distributeCards(d,stock);
		
		boolean gameStart = true;
		
		Card displayCard = stock.getTopCard();
		
		while(gameStart)
		{
			for(int i=0;i<3;i++)
			{
				Card returnedCard = cd.players.get(i).decidingOnCard(displayCard);
				System.out.print("The Returned Card is ");
				returnedCard.displayTheCard();
				if((returnedCard.val == displayCard.val) && returnedCard.suit.equals(displayCard.suit))
				{
					stock.addCardToEnd(returnedCard);
					displayCard = stock.getTopCard();
					System.out.println("A Card is picked from Stock ");
					displayCard = cd.players.get(i).decidingOnCard(displayCard);
				}
				else
				{
					displayCard = returnedCard;
				}
				
				System.out.println("Do you want to Drop The Cards\n[Y]es   or [N]o");
				String quit = Reader.sc.nextLine();
				Reader.sc.nextLine();
				if(quit.equalsIgnoreCase("Y"))
				{
					gameStart=false;
					break;
				}
				System.out.println("\n***************\n");
				
					
				
				
			}
		}
		
		System.out.println("GAME OVER");
	}
}
