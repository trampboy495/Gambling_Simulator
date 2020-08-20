import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class Simulator{
	static int stake;
	static int gamblerWon=1;
	int gamblerLost=0;
	static int[] monthlyStats;

	public Simulator(){
		this.stake = 100;
		monthlyStats = new int[30];
	}

	public static void sort(){
		ArrayList<Integer> list = new ArrayList<Integer>(30);
		for(int data : monthlyStats){
			list.add(data);
		}
		Arrays.sort(monthlyStats);
		int luckiestDay = list.indexOf(monthlyStats[29])+1;
		int unluckiestDay = list.indexOf(monthlyStats[0])+1;
		System.out.println("The luckiest and Unluckiest day of gambler is Day "+luckiestDay+" and "+unluckiestDay+" respectively");

	}

	public static void gamble(){
		int monthCounter = 1;
		while(1 == 1){
			System.out.print("Month "+monthCounter+" of gambling" + "\n________________________________\n\n");
			System.out.print("Day \t Total Amount \t Amount Won or Lost \n");
			Random rand=new Random();
			int lowerLimit = stake / 2;
			int upperLimit = stake + 50;
			int noOfDays = 0;
			int noOfDaysWon = 0;
			int noOfDaysLost = 0;
			int amountWon = 0;
			int amountLost = 0;
			int amountWonIn20Days = 0;
			int amountLostIn20Days = 0;
			while(noOfDays < 30){
				while(stake > lowerLimit && stake < upperLimit){
					int random = rand.nextInt(2);
					if(random == gamblerWon){
						stake++;
						amountWon++;
					}
					else{
						stake--;
						amountLost++;
					}
				}
				monthlyStats[noOfDays] = amountWon - amountLost;
				if(stake > 100){
					noOfDaysWon++;
				}
				else{
					noOfDaysLost++;
				}
				noOfDays++;
				System.out.print(noOfDays+" \t "+monthlyStats[noOfDays - 1]+" \t\t 50 \n");
				if(noOfDays == 20){
					amountWonIn20Days = amountWon;
					amountLostIn20Days = amountLost;
				}
				stake = 100;
			}
			System.out.println("Total amount won and lost in 20 days is "+amountWonIn20Days+","+amountLostIn20Days+" respectively");
			System.out.println("No of days won and lost in one month are "+noOfDaysWon+","+noOfDaysLost+" respectively");
			sort();
			if(noOfDaysLost > noOfDaysWon){
				break;
			}
			monthCounter++;
			System.out.print("\n\n");
		}
	}
	public static void main(String[]args) {
		new Simulator();
		gamble();
	}
}
