//ITC205 Assignment 4
//Files Added By: Cameron Brierley, ID:11497472
//Program Created By: J. Tulip

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Bug3Test
{
	//Declares variables
	private List<Dice> testDice_;
	private static Dice die1_;
	private static Dice die2_;
	private static Dice die3_;
	
	private static Game testGame_;
	private static Player player_;
	private int bet_;

	private int winnings_;
	private int gameCounter_;
	private int winCount_;
	private int lossCount_;
	
	//Before test set up
	@Before
	public void setUp() throws Exception
	{
		die1_ = new Dice();
		die2_ = new Dice();
		die3_ = new Dice();
		
		testDice_ = new ArrayList<Dice>();
		testDice_.add(die1_);
		testDice_.add(die2_);
		testDice_.add(die3_);
		
		testGame_ = new Game(die1_,die2_, die3_);
		player_ = new Player("TEST", 50);
		bet_ = 5;
		winnings_ = 0;
		gameCounter_ = 0;
		winCount_ = 0;
		lossCount_ = 0;
	}

	//Test Bug 3
	@Test
	public void testingBug3()
	{
		List<DiceValue> dieValues_ = testGame_.getDiceValues();
		
		while (player_.balanceExceedsLimitBy(bet_) && player_.getBalance() < 200 && gameCounter_ < 1000)
		{
			DiceValue pick_ = DiceValue.getRandom();
			System.out.println(player_.getName() + " bet " + bet_ + " on the die of " + pick_);
			
			winnings_ = testGame_.playRound(player_, pick_, bet_);
			dieValues_ = testGame_.getDiceValues();
			System.out.println("The game rolled: " + dieValues_.get(0) + " " + dieValues_.get(1) + " " + dieValues_.get(2));
			
			if (dieValues_.get(0).equals(pick_) || dieValues_.get(1).equals(pick_) || dieValues_.get(2).equals(pick_))
			{
				winCount_++;
			} 
			
			else
			{
				lossCount_++;
			}

			if (winnings_ > 0)
			{
				System.out.println(player_.getName() + " won! Balance is now: " + player_.getBalance() + "\n");
			}
			
			else 
			{
				System.out.println(player_.getName() + " lost! Balance is now: " + player_.getBalance() + "\n");
			}
		}
		
		System.out.println("Win Count= " + winCount_);
		System.out.println("Lose Count= " + lossCount_);
		System.out.println(String.format("Overall win rate = %.1f%%", (float) (winCount_ * 100) / (winCount_ + lossCount_)));
	}
	
	//After method resets variables
	@After
	public void reset() throws Exception
	{
		die1_ = null;
		die2_ = null;
		die3_ = null;
		testDice_ = null;
		
		testGame_ = null;
		player_ = null;
		bet_ = 0;
		winnings_ = 0;
		gameCounter_ = 0;
		winCount_ = 0;
		lossCount_ = 0;
	}
}
