/**
 * Throw is a move in the game.
 * Throw can be of type rock, paper, scissors, lizard, or spock.
 * 
 * @author Nellie Spektor nas2180
 * @version 1.3
 */
public class Throw {

	private boolean sleep;
	private boolean valid = false;
	private String throwType;
	/** 
	 * beats is an array that holds the throwTypes that the current Throw's throwType beats.
	 * for example, a Throw with throwType = "rock" would have beats = ["scissors", "lizard"] because rock crushes scissors and lizard.
	 */
	private String[] beats;  

	
	/** 
	 * Creates a Throw with the throwType indicated by the input (determinted by Thrower)
	 * depending on the input, the rest of parameters are set.
	 * 
	 * throwType is set to what the input stands for
	 * beats is set to an array of what the throwType beats, according to the rules of RPSLK
	 * Sleep is only set to true when input = "z"
	 * Valid is only set to false if input is not "r", "p", "s", "l", "k" or "z"
	 * 
	 * @param input
	 */
	public Throw(String input) {
		// TODO Auto-generated constructor stub
		if( input.equals("r")) {
			throwType = "rock";
			beats = new String[]{"scissors", "lizard"};
			sleep = false;
			valid = true;
		}
		if( input.equals("p")) {
			throwType = "paper";
			beats = new String[]{"rock", "spock"};
			sleep = false;
			valid = true;
		}
		if( input.equals("s")) {
			throwType = "scissors";
			beats = new String[]{"paper", "lizard"};
			sleep = false;
			valid = true;
		}
		if( input.equals("l")) {
			throwType = "lizard";
			beats = new String[]{"spock", "paper"};
			sleep = false;
			valid = true;
		}
		if( input.equals("k")) {
			throwType = "spock";
			beats = new String[]{"rock", "scissors"};
			sleep = false;
			valid = true;
		}
		if( input.equals("z")) {
			sleep = true;
			valid = true;
		}
	}
	
	/**
	 * Gets the value of Valid 
	 * @return true if input was invalid
	 * 	 	   false if input was valid
	 */
	public boolean getValidity(){
		return valid;
	}
	
	/**
	 * gets the value of Sleep 
	 * @return true if input is "z"
	 *         false if input is not "z"
	 */
	public boolean isSleep(){
		return sleep;
	}
	
	/**
	 * Gets the throwType String, which can be:
	 * "rock", "paper", "scissors", "lizard", or "spock"
	 * @return String
	 */
	public String getThrowType(){
		return throwType;
	}
	
	/**
	 * Gets the beats array of Strings, which has two elements
	 * the two elements are ThrowTypes ("rock", "paper", "scissors", "lizard", or "spock")
	 * @return beats String[]
	 */
	public String[] whatItBeats(){
		return beats;
	}
	
	/**
	 * Decides if this Throw beats its opponent
	 * @return true if this Throw's beats[] contains the opponent's throwType 
	 *         false if it does not
	 */
	public boolean doesBeat(Throw opponent){
		for(String i : beats){
			if( i.equals(opponent.getThrowType())){
				return true;
			}
		}
		return false;
	}

}
