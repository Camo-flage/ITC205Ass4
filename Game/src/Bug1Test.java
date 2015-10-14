//ITC205 Assignment 4
//Files Added By: Cameron Brierley, ID:11497472
//Program Created By: J. Tulip

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Bug1Test 
{
	//Declared variables
	private static Game testGame_;
	
	private static Dice die1_;
	private static Dice die2_;
	private static Dice die3_;
	private static Player player_;
	
	//Before test setup
	@Before
	public void setUp() throws Exception
	{
		die1_ = mock(Dice.class);
		die2_ = mock(Dice.class);
		die3_ = mock(Dice.class);
		player_ = new Player("TEST", 0);
	}
	
	//Test Method on Game 1
	@Test
	public void testingGameBug1()
	{
		when(die1_.getValue()).thenReturn(DiceValue.HEART);
	    when(die2_.getValue()).thenReturn(DiceValue.CLUB);
	    when(die3_.getValue()).thenReturn(DiceValue.SPADE);

	    testGame_ = new Game(die1_, die2_, die3_);
	    System.out.println("Start Balance: " + player_.getBalance());
	    
	    DiceValue selection = DiceValue.SPADE;
	    int balance = player_.getBalance();
	    int bet = 5;
	    int winning = testGame_.playRound(player_, selection, bet);
	    
	    assertEquals(5, winning);
	    System.out.println("Player: " + player_.getName());
	    System.out.println("Bet: " + bet);
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
	    
	    System.out.println("But the total balance after 2 matches is: " + player_.getBalance());
	    System.out.println("The player has lost: " + bet);
	    System.out.println("*****************************************");
	}
	
	//Test Method on Game 2
	@Test
	public void testingGameBug2()
	{
		when(die1_.getValue()).thenReturn(DiceValue.SPADE);
	    when(die2_.getValue()).thenReturn(DiceValue.CLUB);
	    when(die3_.getValue()).thenReturn(DiceValue.SPADE);

	    testGame_ = new Game(die1_, die2_, die3_);
	    System.out.println("Start Balance: " + player_.getBalance());
	    
	    DiceValue selection = DiceValue.SPADE;
	    int balance = player_.getBalance();
	    int bet = 5;
	    int winning = testGame_.playRound(player_, selection, bet);
	    
	    assertEquals(10, winning);
	    System.out.println("Player: " + player_.getName());
	    System.out.println("Bet: " + bet);
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
	    
	    System.out.println("But the total balance after 2 matches is: " + player_.getBalance());
	    System.out.println("The player has lost: " + bet);
	    System.out.println("*****************************************");
	}
	
	//Test Method on Game 3
	@Test
	public void testingGameBug3()
	{
		when(die1_.getValue()).thenReturn(DiceValue.SPADE);
	    when(die2_.getValue()).thenReturn(DiceValue.SPADE);
	    when(die3_.getValue()).thenReturn(DiceValue.SPADE);

	    testGame_ = new Game(die1_, die2_, die3_);
	    System.out.println("Start Balance: " + player_.getBalance());
	    
	    DiceValue selection = DiceValue.SPADE;
	    int balance = player_.getBalance();
	    int bet = 5;
	    int winning = testGame_.playRound(player_, selection, bet);
	    
	    assertEquals(15, winning);
	    System.out.println("Player: " + player_.getName());
	    System.out.println("Bet: " + bet);
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
	    
	    System.out.println("But the total balance after 2 matches is: " + player_.getBalance());
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
