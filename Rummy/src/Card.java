
public class Card {
	public int val;
	public String suit;
	
	Card(int val,String suit){
		this.val = val;
		this.suit = suit;
	}
	
	public void displayTheCard()
	{
		System.out.println(this.suit+"-"+this.val);
	}
}
