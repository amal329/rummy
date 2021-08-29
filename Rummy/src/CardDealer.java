
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
            Card c = null;
            try {
                c = d.pickCard();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.dealCard(c);
        }
 
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
