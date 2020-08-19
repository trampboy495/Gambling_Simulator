import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
public class Simulator{
	static int Stake;
	static int gamblerWon=1;
	int gamblerLost=0;
	static int[] monthlyStats;
	public Simulator(){
		this.Stake=100;
		monthlyStats=new int[30];
	}
	public static void sort(){
		ArrayList<Integer> list=new ArrayList<Integer>(30);
		for(int i:monthlyStats){
			list.add(i);
		}
		Arrays.sort(monthlyStats);
		int luckiestDay=list.indexOf(monthlyStats[29])+1;
		int unluckiestDay=list.indexOf(monthlyStats[0])+1;
		System.out.println("The luckiest and Unluckiest day of gambler is "+luckiestDay+","+unluckiestDay+
					 " and amounts won and lost are "+monthlyStats[29]+","+Math.abs(monthlyStats[0])+" respectively");
	}
	public static void gamble(){
		Random rand=new Random();
		int lowerLimit=Stake/2;
		int upperLimit=Stake+50;
		int temp=Stake;
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
			monthlyStats[noOfDays]=temp-Stake;
			noOfDays++;
			if(noOfDays==20){
				System.out.println("Total amount won and lost in 20 days is "+amountWon+","+amountLost+" respectively");
			}
			int i=temp-Stake;
			if(Stake > 100){
				noOfDaysWon++;
			}
			else{
				noOfDaysLost++;
			}
			Stake=100;
		}
		System.out.println("No of days won and lost in one month are "+noOfDaysWon+","+noOfDaysLost+" respectively");
		sort();
	}
	public static void main(String[]args) {
		new Simulator();
		gamble();
	}
}
