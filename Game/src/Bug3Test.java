//ITC205 Assignment 4
//Files Added By: Cameron Brierley, ID:11497472
//Program Created By: J. Tulip

import static org.mockito.Mockito.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Bug3Test
{
	//Declares variables
	private static Game testGame_;
	
	private static Dice die1_;
	private static Dice die2_;
	private static Dice die3_;
	private static Player player_;
	
	//Before test set up
	@Before
	public void setUp() throws Exception
	{
		die1_ = mock(Dice.class);
	    die2_ = mock(Dice.class);
	    die3_ = mock(Dice.class);
		player_ = new Player("TEST", 50);	
	}

	//Test Bug 3
	@Test
	public void testingBug3()
	{
		when(die1_.getValue()).thenReturn(DiceValue.getRandom());
	    when(die2_.getValue()).thenReturn(DiceValue.getRandom());
	    when(die3_.getValue()).thenReturn(DiceValue.getRandom());

	    testGame_ = new Game(die1_, die2_, die3_);
	    System.out.println("Player: " + player_.getName());
	    System.out.println("Start Balance: " + player_.getBalance());
	    
	    DiceValue selection = DiceValue.CROWN;
	    int balance = player_.getBalance();
	    int bet = 10;
	    int winning = testGame_.playRound(player_, selection, bet);
	  
	    System.out.println("Selected: " + selection);
	    int betBalance = (balance - bet);
	    System.out.println("New Balance: " + betBalance);
	    System.out.println();
	    
	    System.out.println("Rolled: " + testGame_.getDiceValues());
	    System.out.println("Winnings: " + winning);
	    System.out.println("Awarded: Winnings " + winning + " and Bet " + bet);
	    
	    int totalWin = winning + bet;
	    System.out.println("Total Winning: " + totalWin);
	    System.out.println();
	    
	    System.out.println("But the total balance after 1 match is: " + player_.getBalance());
	    System.out.println("The player has lost: " + bet);
	    System.out.println("*****************************************");
	}
	
	//After method resets variables
	@After
	public void reset() throws Exception
	{
		die1_ = null;
		die2_ = null;
		die3_ = null;
		player_ = null;
	}
}
