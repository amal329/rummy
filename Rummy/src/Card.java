
public class Card {
	public int val;
	public String suit;
	public int score;
	
	Card(int val,String suit){
		this.val = val;
		this.suit = suit;
		this.score = val <= 10 ? val : 10;
	}
	
	public void displayTheCard()
	{
		System.out.println(this.suit+"-"+this.val);
	}
}
