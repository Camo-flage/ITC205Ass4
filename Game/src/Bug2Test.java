//ITC205 Assignment 4
//Files Added By: Cameron Brierley, ID:11497472
//Program Created By: J. Tulip

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Bug2Test
{
	//Declared Variable
	private static Player player_;
	
	//Set Up for testing
	@Before
	public void setUp() throws Exception
	{
	    player_ = new Player("Test", 0);
	}

	//Testing Bug 2
	@Test
	public void testingBug2()
	{	
		int bet = 10;
		System.out.println("The bet for all players is: " + bet);
		System.out.println();
		
	    player_ = new Player("George", 50);
	    System.out.println(player_.getName() + ":");
	    System.out.println("Balance: " + player_.getBalance());
	    System.out.println("Does this Balance exceed the limit? " + player_.balanceExceedsLimitBy(bet));
	    System.out.println();
	    
	    player_ = new Player("Angus", 10);
	    System.out.println(player_.getName() + ":");
	    System.out.println("Balance: " + player_.getBalance());
	    System.out.println("Does this Balance exceed the limit? " + player_.balanceExceedsLimitBy(bet));
	    System.out.println();
	    
	    player_ = new Player("Sharon", 0);
	    System.out.println(player_.getName() + ":");
	    System.out.println("Balance: " + player_.getBalance());
	    System.out.println("Does this Balance exceed the limit? " + player_.balanceExceedsLimitBy(bet));
	}
	
	//After method resets variable
	@After
	public void reset() throws Exception
	{
		player_ = null;
	}
}
