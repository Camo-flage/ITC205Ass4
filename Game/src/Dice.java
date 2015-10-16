public class Dice {
			
	private DiceValue value;
	
	public Dice() {
		value =  DiceValue.getRandom();
	}
	
	public DiceValue getValue() {
		return value;
	}

	//Bug 3 Location (resolved)
	public DiceValue roll() {
		return value = DiceValue.getRandom();
	}		
	
	public String toString() {
		return value.toString();
	}
}
