
public class Player {
	public static int count = 0;
	public int id;
	public String name;
	
	Player(){
		this.id = count++;
		this.name = Reader.sc.next();
	}
}
