import java.util.Arrays;
import java.util.Collections;

public class Test {
	public static void main(String[] args) {
		Deck d = new Deck();
		d.shuffle();
		
		Player a = new Player("a");
		Player b = new Player("b");
		Player c = new Player("c");
		
		Stock s= new Stock();
		
		CardDealer cd = new CardDealer();
		cd.addPlayer(a);
		cd.addPlayer(b);
		cd.addPlayer(c);
		
		cd.distributeCards(d,s);
		
		System.out.println(d.cards.size());
	}
}
