import java.util.Random;
public class Simulator{
	static int Stake;
	static int gamblerWon=1;
	int gamblerLost=0;
	public Simulator(){
		this.Stake=100;
	}
	public static void gamble(){
		Random rand=new Random();
		int lowerLimit=Stake/2;
		int upperLimit=Stake+50;
		int noOfDays=0;
		int amountWon=0;
		int amountLost=0;
		while(noOfDays < 20){
			while(Stake > lowerLimit && Stake < upperLimit){
				int r=rand.nextInt(2);
				if(r==gamblerWon){
					Stake++;
					amountWon++;
				}
				else{
					Stake--;
					amountLost++;
				}
			}
			noOfDays++;
		}
		System.out.println("amount won in 20 days is "+amountWon+" amount lost in 20 days is "+amountLost);
	}
	public static void main(String[]args) {
		new Simulator();
		gamble();
	}
}
