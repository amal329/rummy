import java.util.ArrayList;

public class CardDealer {
	ArrayList<Player> players = new ArrayList<>(3);
	
	public void addPlayer(Player p) {
		players.add(p);
	}
	
	public void distributeCards(Deck d,Stock s) {
		for(int i=0;i<3;i++) {
			Player p = players.get(i);
			
			for(int j=0;j<10;j++) {
				Card c = d.pickCard();
				p.dealCard(c);
			}
		}
		
		for(int i=0;i<22;i++) {
			Card c = d.pickCard();
			s.dealCard(c);
		}
	}
}
