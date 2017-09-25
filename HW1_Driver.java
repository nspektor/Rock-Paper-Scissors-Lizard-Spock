/**
 * Drives the game by creating a Talker and running startGame()
 * 
 * @author Nellie Spektor nas2180
 * @version 1.3
 */
public class HW1_Driver {

	/**
	 * Creates a Talker with arguments from command line and starts the game
	 * args[0] = human type ("repeat", "random", or invalid)
	 * args[1] = number of rounds as a String, I have been using 1000 for testing
	 * 
	 * When the human is a randomizer, the percentages hover around:
	 * 	38% win
	 *  45% lose
	 *  15% tie
	 *  
	 * When the human is a repeater, the percentages hover around:
	 * 	40% win
	 *  40% lose
	 *  20% tie
	 *  
	 * When the command line argument is not "random" or "repeat", the human is by default a randomizer
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Talker rpsTalker = new Talker(args[0], args[1]);
		rpsTalker.startGame();
	}

}