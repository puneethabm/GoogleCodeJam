import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	private static Scanner in = null;

	private static final String BAD_MAGICIAN = "Bad magician!";
	private static final String VOLUNTEER_CHEATED = "Volunteer cheated!";

	public static void main(String args[]) throws Exception {
		in = new Scanner(System.in);

		int T = in.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int answerOne = in.nextInt();
			HashSet<Integer> arragementOne = readCardArrangement(answerOne);

			int answerTwo = in.nextInt();
			HashSet<Integer> arragementTwo = readCardArrangement(answerTwo);

			arragementOne.retainAll(arragementTwo);

			int resultSize = arragementOne.size();
			String result = null;
			
			if (resultSize == 0) {
				result = VOLUNTEER_CHEATED;
			} else if (resultSize > 1) {
				result = BAD_MAGICIAN;
			} else {
				for (int elem : arragementOne) { result = Integer.toString(elem); }
			}

			displayOutput(t, result);
		}
	}

	/* Utilities */

	private static HashSet<Integer> readCardArrangement(int rowNum)
			throws Exception {
		HashSet<Integer> rowArrangment = new HashSet<Integer>();

		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (i == rowNum) {
					rowArrangment.add(in.nextInt());
				} else {
					in.nextInt();
				}
			}
		}
		return rowArrangment;
	}
	
	private static void displayOutput(int t, String message) {
		System.out.println(MessageFormat.format("Case #{0}: {1}",t,message));
	}

}
