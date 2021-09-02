
public class CardDealer extends Thread{
    Player p;
    Deck d;
 
    public CardDealer(Player p, Deck d) {
        this.p = p;
        this.d = d;
    }
 
    @Override
    public void run() {
        for(int j=0;j<10;j++) {
            try {
//            	Thread.sleep((int)(Math.random()*400)+10);
                Card c = d.pickCard();
                p.dealCard(c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
