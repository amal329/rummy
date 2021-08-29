import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Deck d = new Deck();
        d.shuffle();
 
        Player a = new Player("a");
        Player b = new Player("b");
        Player c = new Player("c");
 
        ArrayList<Player> players = new ArrayList<>();
        players.add(a);
        players.add(b);
        players.add(b);
 
        Stock stock = new Stock();
 
        CardDealer cd1 = new CardDealer(a,d);
        CardDealer cd2 = new CardDealer(b,d);
        CardDealer cd3 = new CardDealer(c,d);
 
        cd1.start();
        cd2.start();
        cd3.start();
 
        cd1.join();
        cd2.join();
        cd3.join();
 
        while(d.cards.size() > 0){
            Card card = d.pickCard();
            stock.dealCard(card);
        }
 
 
 
 
        boolean gameStart = true;
 
        Card displayCard = stock.getTopCard();
        
        a.showCards();
        a.arrangeCards();
        b.showCards();
        b.arrangeCards();
        c.showCards();
        c.arrangeCards();
        while(gameStart)
        {
            for(int i=0;i<3;i++)
            {
                Card returnedCard = players.get(i).decidingOnCard(displayCard);
                System.out.print("The Returned Card is ");
                returnedCard.displayTheCard();
                if((returnedCard.val == displayCard.val) && returnedCard.suit.equals(displayCard.suit))
                {
                    stock.addCardToEnd(returnedCard);
                    displayCard = stock.getTopCard();
                    System.out.println("A Card is picked from Stock ");
                    displayCard = players.get(i).decidingOnCard(displayCard);
                }
                else
                {
                    displayCard = returnedCard;
                }
 
                players.get(i).arrangeCards();
 
                System.out.println("Do you want to Drop The Cards\n[Y]es   or [N]o");
                String quit = Reader.sc.nextLine();
                Reader.sc.nextLine();
                if(quit.equalsIgnoreCase("Y"))
                {
                	players.remove(i);
                	for(Player p:players)
                	{
                		p.arrangeCards();
                	}
                    gameStart=false;
                    break;
                }
                System.out.println("\n***************\n");
 
 
 
 
            }
        }
 
        System.out.println("GAME OVER");
    }
}
