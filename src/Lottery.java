/*
 * Zachary Miller
 * assignment 3.1
 * Lottery.java
 * The purpose of this program is to determine the winning numbers and compare the users guesses to the winning numbers and then determine the amount of points they will recieve
 * 6/27/2018
 * bellevue university
 */import java.util.*;
public class Lottery {
	int[] winningNumbers = new int [4];
	int[] userGuess = new int[4];
	Random rand = new Random();
	int pointsWon,cumPointsWon=0,matches;
	public void setWinningNumbers()
	{
		for(int i=0;i<=3;i++)
		{
			winningNumbers[i]=rand.nextInt(9);
		}
	}
	
	public int[] getWinningNumbers()
	{
		return winningNumbers;
	}
	public void setUserGuess(int guess)
	{
		int temp = guess;
		ArrayList<Integer> array = new ArrayList<Integer>();
		do {
			array.add(temp%10);
			temp/=10;
		}while(temp>0);

		for(int i=0;i<=3;i++)
		{
			switch(i)
			{
			case 0:
				userGuess[i]=array.get(3);
				break;
			case 1:
				userGuess[i]=array.get(2);
				break;
			case 2:
				userGuess[i]=array.get(1);
				break;
			case 3:
				userGuess[i]=array.get(0); 
				break;
			}
		}
	}
	public int[] getUserGuess()
	{
		return userGuess;
	}
	public void determineMatches()
	{
		matches=0;
		for(int i=0;i<=3;i++)
		{
			if(userGuess[i]==winningNumbers[i])
			{	
				matches+=1;
			}
		}
	}
	
	public void setPoints()
	{
		pointsWon=0;
		switch(matches)
		{
		case 0:
			pointsWon=0;
			break;
		case 1:
			pointsWon=5;
			break;
		case 2:
			pointsWon=100;
			break;
		case 3:
			pointsWon=2000;
			break;
		case 4:
			pointsWon=1000000;
			break;
		}
		setCumPoints(pointsWon);
	}
	
	public int getPoints()
	{
		return pointsWon;
	}
	
	public void setCumPoints(int points)
	{
		cumPointsWon=cumPointsWon+points;
	}
	public int getCumPoints()
	{
		return cumPointsWon;
	}

}
