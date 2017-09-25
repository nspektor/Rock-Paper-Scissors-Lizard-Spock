/**
 * Round determines the winner of each round of RPSLK and summarizes the results.
 * 
 * @author Nellie Spektor nas2180
 * @version 1.3
 */
public class Round{
	private Throw humanThrow;
	private Throw compThrow;
	private String winner; 
	private String roundSummary;
	
	/**
	 * Creates a Round with the Throws from the user and computer
	 * calls the decideWinner() and makeRoundSummary() methods
	 * @param user
	 * @param comp
	 */
	public Round(Throw user, Throw comp) {
		// TODO Auto-generated constructor stub
		humanThrow = user;
		compThrow = comp;
		decideWinner();
		makeRoundSummary();
	}

	/**
	 * Decides who wins this round using the fields compThrow and userThrow.
	 * Each Throw has a parameter which says which other Throw types it beats.
	 * fills the String winner with "computer", "tie", or "human"
	 * 
	 * While "tie" is technically not a winner, it is held in the winner field for simplicity.
	 */
	public void decideWinner(){ 
		if(compThrow.doesBeat(humanThrow)){
			winner = "computer"; 
		}
		else if(humanThrow.getThrowType().equals(compThrow.getThrowType())){
			winner = "tie";
		}
		else{
			winner = "human";
		}
	}
	
	/**
	 * Fills the roundSummary instance variable with an explanation of who won the round and why
	 */
	public void makeRoundSummary(){
		String summary = "";
		if( winner.equals("human")){
			summary += "You won because " + humanThrow.getThrowType() + " beats " + compThrow.getThrowType() + ".\n";
		}
		if( winner.equals("computer")){
			summary += "The computer won because " + compThrow.getThrowType() + " beats " + humanThrow.getThrowType() + ".\n";
		}
		if( winner.equals("tie")){
			summary += "You both chose " + compThrow.getThrowType() + ", so you tied this round\n.";
		}
		roundSummary = summary;
	}
	
	/**
	 * Gets the round winner which was set by decideWinner()
	 * Used by GameResult.
	 * @return String winner
	 */
	public String getRoundWinner(){
		return winner;
	}
	
	/**
	 * Gets the round summary which was set by makeRoundSummary()
	 * Used by Talker to tell the user the results of the round.
	 * @return String roundSummary
	 */
	public String getRoundSummary(){
		return roundSummary;
	}
}
