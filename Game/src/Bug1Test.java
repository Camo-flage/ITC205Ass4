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
	private static Game game_;
	
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
		player_ = new Player("Camo", 117);
	}
	
	//Test Method on Game 1
	@Test
	public void testingMatch1Bug()
	{
		when(die1_.getValue()).thenReturn(DiceValue.SPADE);
	    when(die2_.getValue()).thenReturn(DiceValue.CLUB);
	    when(die3_.getValue()).thenReturn(DiceValue.HEART);

	    game_ = new Game(die1_, die2_, die3_);
	    System.out.println("Start Balance: " + player_.getBalance());
	    
	    DiceValue selection = DiceValue.HEART;
	    int balance = player_.getBalance();
	    int bet = 10;
	    int winning = game_.playRound(player_, selection, bet);
	    
	    assertEquals(10, winning);
	    System.out.println("Player: " + player_.getName());
	    System.out.println("Bet: " + bet);
	    System.out.println("Selected: " + selection);
	    System.out.println();

	    int withoutBet = (balance - bet);
	    System.out.println("Balance without bet: " + withoutBet);
	    System.out.println("Rolled: " + game_.getDiceValues());
	    System.out.println("Winnings: " + winning);
	    System.out.println("Given: Winnings " + winning + " and Bet " + bet);
	    System.out.println("Balance after 1 match: " + player_.getBalance());
	    System.out.println("*****************************************");
	}
	
	//Test Method on Game 1
	@Test
	public void testingMatch2Bug()
	{
		when(die1_.getValue()).thenReturn(DiceValue.HEART);
	    when(die2_.getValue()).thenReturn(DiceValue.CLUB);
	    when(die3_.getValue()).thenReturn(DiceValue.HEART);

	    game_ = new Game(die1_, die2_, die3_);
	    System.out.println("Start Balance: " + player_.getBalance());
	    
	    DiceValue selection = DiceValue.HEART;
	    int balance = player_.getBalance();
	    int bet = 10;
	    int winnings = game_.playRound(player_, selection, bet);
	    
	    assertEquals(20, winnings);
	    System.out.println("Player: " + player_.getName());
	    System.out.println("Bet: " + bet);
	    System.out.println("Selected: " + selection);
	    System.out.println();
 
	    int withoutBet = (balance - bet);
	    System.out.println("Balance without bet: " + withoutBet);
	    System.out.println("Rolled: " + game_.getDiceValues());
	    System.out.println("Winnings: " + winnings);
	    System.out.println("Given: Winnings " + winnings + " and Bet " + bet);
	    System.out.println("Balance after 2 match: " + player_.getBalance());
	    System.out.println("*****************************************");
	}
	
	//Test Method on Game 2
	@Test
	public void testingMatch3Bug()
	{
		when(die1_.getValue()).thenReturn(DiceValue.HEART);
	    when(die2_.getValue()).thenReturn(DiceValue.HEART);
	    when(die3_.getValue()).thenReturn(DiceValue.HEART);

	    game_ = new Game(die1_, die2_, die3_);
	    System.out.println("Start Balance: " + player_.getBalance());
	    
	    DiceValue selection = DiceValue.HEART;
	    int balance = player_.getBalance();
	    int bet = 10;
	    int winnings = game_.playRound(player_, selection, bet);
	    
	    assertEquals(30, winnings);
	    System.out.println("Player: " + player_.getName());
	    System.out.println("Bet: " + bet);
	    System.out.println("Selected: " + selection);
	    System.out.println();

	    int withoutBet = (balance - bet);
	    System.out.println("Balance without bet: " + withoutBet);
	    System.out.println("Rolled: " + game_.getDiceValues());
	    System.out.println("Winnings: " + winnings);
	    System.out.println("Given: Winnings " + winnings + " and Bet " + bet);
	    System.out.println("Balance after 3 match: " + player_.getBalance());
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
