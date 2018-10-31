/*
 * Zachary Miller
 * assignment 3.1
 * LotteryTest.java
 * The purpose of this program is to get user input and create an instance of the lottery class and display the results
 * 6/27/2018
 * bellevue university
 */
import javax.swing.*;
public class LotteryTest {

	public static void main(String[] args) {
		Lottery lotto = new Lottery();
		String rawInput;
		int intInput = 0;
		boolean inputStatus;
		int inputLength;
		int[] userGuess = new int[4];
		int[] winningNumbers = new int[4];
		boolean playAgain = false;
		do
		{
			inputLength=01;
			inputStatus=false;
		while(inputStatus==false || inputLength!=4)
		{
			rawInput = JOptionPane.showInputDialog(null, "Please enter your guesses as one number (ex. 1234): ");
			try {
				if(rawInput.length()!=4)
				{
					inputLength = rawInput.length();
					
				}
				else
					inputLength=4;
				intInput = Integer.parseInt(rawInput);
				inputStatus=true;
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "I'm sorry but the number you entered seemed to be incorrect. Please try again.");
				inputStatus=false;
				
			}
			catch(NullPointerException e)
			{
				System.exit(0);
			}
		}
		
		lotto.setWinningNumbers();
		lotto.setUserGuess(intInput);
		lotto.determineMatches();
		lotto.setPoints();
		userGuess = lotto.getUserGuess();
		winningNumbers = lotto.getWinningNumbers();
		JOptionPane.showMessageDialog(null, "Your guesses were: "+ userGuess[0]+", "+userGuess[1]+", "+userGuess[2]+", and "+userGuess[3]+
				"\n\n The winning numbers were: "+winningNumbers[0]+", "+winningNumbers[1]+", "+winningNumbers[2]+", and "+winningNumbers[3]+
				"\nYou scored a total of "+lotto.getPoints()+" this round and have a cumulative total of "+lotto.getCumPoints());
		int playAgainResponse = JOptionPane.showConfirmDialog(null, "Would you like to play again?");
		switch(playAgainResponse)
		{
		case 0:
			playAgain=true;
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Congratulations you won a total of "+lotto.getCumPoints()+" points! Thank you for playing and please play again soon");
			playAgain=false;
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Congratulations you won a total of "+lotto.getCumPoints()+" points! Thank you for playing and please play again soon");
			playAgain=false;
			break;
		}
		}while(playAgain==true);
	}

}
