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
		int stakeLimit=Stake/2;
		while(Stake > stakeLimit){
			int r=rand.nextInt(2);
			if(r==gamblerWon){
				Stake++;
			}
			else{
				Stake--;
			}
		}
	}
	public static void main(String[]args) {
		new Simulator();
		gamble();
	}
}
