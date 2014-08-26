import java.text.MessageFormat;
import java.util.Scanner;

public class Solution {
	private static Scanner in = null;
	
	private static double initialRate = 2.0;
	private static double intitialTimeSpent = 0.0;
	
	public static void main(String args[]) throws Exception {
		in = new Scanner(System.in);

		int T = in.nextInt();
		
		for (int t = 1; t <= T; t++) {
			double C = in.nextDouble();
			double F = in.nextDouble();
			double X = in.nextDouble();
			
			double result = cookieProductionTime(C,F,X);
			
			displayOutput(t, result);
		}
	}

	/* Utilities */
	
	private static double cookieProductionTime(double C,double F, double X){
		
		double rate = initialRate;
		double timeSpent = intitialTimeSpent;
		
		double currentEstimateTime = estimateProductionTime(rate, timeSpent, X);
		double newEstimateTime = currentEstimateTime;
		
		while(currentEstimateTime >= newEstimateTime) {
			currentEstimateTime = newEstimateTime;
			
			// Buy a cookie farm - update the timeSpent and rate
			timeSpent = timeSpent + (C / rate);
			rate = rate + F;
			
			newEstimateTime = estimateProductionTime(rate, timeSpent, X);
		}
		
		return currentEstimateTime;
	}
	
	private static double estimateProductionTime(double rate, double timeSpent, double X){		
		double timeToX = X / rate;
		return timeSpent + timeToX;
	}
	
	private static void displayOutput(int t, double result) {
		System.out.print(MessageFormat.format("Case #{0}: ",t));
        System.out.printf("%1$.7f\n", result);
	}

}
