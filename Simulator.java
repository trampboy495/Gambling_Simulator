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
		int noOfDaysWon=0;
		int noOfDaysLost=0;
		int amountWon=0;
		int amountLost=0;
		while(noOfDays < 30){
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
			if(noOfDays==20){
				System.out.println("Total amount won and lost in 20 days is "+amountWon+" "+amountLost+" respectively");
			}
			if(Stake > 100){
				noOfDaysWon++;
			}
			else{
				noOfDaysLost++;
			}
			Stake=100;
		}
		System.out.println("No of days won and lost in one month are "+noOfDaysWon+" "+noOfDaysLost+" respectively");
	}
	public static void main(String[]args) {
		new Simulator();
		gamble();
	}
}
