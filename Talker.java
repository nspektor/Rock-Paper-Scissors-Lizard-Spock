/**
 * Talker is the class in this RPSLK game responsible for communicating with the user.
 * It knows both the computer's and the user's throws. It starts the game and each round,
 * and communicates the throws and results of each round and the game to the user. 
 * 
 * @author Nellie Spektor nas2180
 * @version 1.3
 */
public class Talker {
	private Throw humanThrow;
	private Throw compThrow;
	private GameResult thisGame;
	private int totalRounds;
	private String humanType;
	
	/**
	 * Creates an instance of a Talker and takes the command line arguments for the human strategy type and the number
	 * of rounds to be played. 
	 * 
	 * @param commandLineType
	 * @param commandLineTotalRounds
	 */
	public Talker(String commandLineType, String commandLineTotalRounds){
		humanType = commandLineType;
		totalRounds = Integer.parseInt(commandLineTotalRounds);
	}
	/**
	 * Starts the RPSLK game by printing the introduction text and rules then 
	 * instantiating thisGame. 
	 * Note: rules taken from http://bigbangtheory.wikia.com/wiki/Rock_Paper_Scissors_Lizard_Spock
	 * thisGame will be where the results from each round of the game are be recorded. 
	 * Starts the first round.
	 */
	public void startGame(){
		System.out.println("UNI: nas2180\n" +
				"Hello, lets play Rock Paper Scissors Lizard Spock!\n");
		System.out.println("Rules:\n Scissors cuts Paper\n " +
				"Paper covers Rock\n " +
				"Rock crushes Lizard\n " +
				"Lizard poisons Spock\n " +
				"Spock smashes Scissors\n " +
				"Scissors decapitates Lizard\n " +
				"Lizard eats Paper\n " +
				"Paper disproves Spock\n " +
				"Spock vaporizes Rock\n " +
				"(and as it always has) Rock crushes Scissors\n");
		thisGame = new GameResult();
		playRound();
	}
	
	/**
	 * Starts a round of thisGame by setting both the human and computer Throws. 
	 * These Throws are used by the current Round to determine the winner, which gets displayed and contributed
	 * to the overall GameResult.
	 * When a round is done, if it is not the last round, playRound() is recursively called.
	 * If a round is the last, endGame is called.
	 */
	public void playRound(){
		setHumanThrow(humanType); 
		setCompThrow();
		System.out.println("Your Throw: " + humanThrow.getThrowType());
		System.out.println("The Computer's Throw: " + compThrow.getThrowType());
		Round current = new Round(humanThrow, compThrow);
		thisGame.updateScores(current);
		System.out.println(current.getRoundSummary());
		if(thisGame.getRoundNumber() < totalRounds){
			playRound();
		}
		else{
			endGame();
		}
	} 

	/**
	 * Fills the field compThrow with the Throw set by Thrower
	 * compThrow will be r, s, p, l, or k
	 */
	public void setCompThrow(){
		Thrower compThrower = new Thrower("random", "computer");
		compThrow = compThrower.getComputerThrow();
	}
	
	/**
	 * Fills the field humanThrow with the Throw set by Thrower
	 * humanThrow will be r, s, p, l, or k
	 */
	public void setHumanThrow(String strategy){
		Thrower humanThrower = new Thrower(strategy, "human");
		humanThrow = humanThrower.getHumanThrow();
	}
	
	/**
	 * Ends the game by getting the Game Summary for the GameResult thisGame and telling the user this summary.
	 */
	public void endGame(){
		String gameSummary = thisGame.getGameSummary(humanType);
		System.out.println(gameSummary);
	}
}
