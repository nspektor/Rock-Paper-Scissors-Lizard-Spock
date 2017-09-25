/**
 * GameResult determines the winner of the entire RPSLK game and summarizes the results
 * 
 * @author Nellie Spektor nas2180
 * @version 1.3
 */
public class GameResult {

	private int humanWins;
	private int compWins;
	private int ties;
	private int humanPercent;
	private int compPercent;
	private int tiesPercent;
	private int numRounds;
	
	/**
	 * Creates a GameResult Object, setting all variables to 0, because no rounds have been played yet
	 */
	public GameResult() {
		// TODO Auto-generated constructor stub
		humanWins = 0;
		compWins = 0;
		ties = 0;
		numRounds = 0;
		humanPercent = 0;
		compPercent = 0;
		tiesPercent = 0;
	}

	/**
	 * Updates the variables that keep track of wins after each round's winner has been decided.
	 * also updates the number of rounds (numRounds)
	 * 
	 * @param thisRound
	 */
	public void updateScores(Round thisRound){
		String roundWinner = thisRound.getRoundWinner();
		if( roundWinner.equals("human")){
			humanWins ++;
		}
		else if( roundWinner.equals("computer")){
			compWins ++;
		}
		else if( roundWinner.equals("tie")){
			ties ++;
		}
		numRounds ++;
	}
	
	/**
	 * Gets the number of Rounds that have been played.
	 * @return int numRounds
	 */
	public int getRoundNumber(){
		return numRounds;
	}
	
	/**
	 * Decides winner of the game by deciding whether the user(human) or the computer got the most wins,
	 * or if they won an equal amount of times, says that the game was a tie.
	 * 
	 * Creates a String that describes the results of the Game, including who won and how many rounds were won, lost or tied by the user.
	 * Includes what the percentage of each round result was.
	 * 
	 * @return String summary
	 */
	public String getGameSummary(String humanStrategy){
		String summary = "\n";
		if(humanStrategy.equals("repeat") || humanStrategy.equals("random")){
			summary += "The human's (your) strategy was: " + humanStrategy;
		}
		else{
			summary += "You entered an invalid strategy (" + humanStrategy +") so we set your strategy to 'random'";
		}
		summary += "\nYou played " +  numRounds + " rounds.\n\n";
		if (humanWins > compWins){
			summary += "You won!";
		}
		if (compWins > humanWins){
			summary += "You lost :(";
		}
		if (compWins == humanWins){
			summary += "You tied!";
		}
		calcPercents();
		summary += "\nYou won " + humanWins + " times, which is " + humanPercent + "% of the rounds.\n";
		summary += "You lost " + compWins + " times, which is " + compPercent + "% of the rounds.\n";
		summary += "You tied " + ties + " times, which is " + tiesPercent + "% of the rounds.\n";
		return summary;
	}
	
	/**
	 * Calculates the percentages of each round result (human win, computer win, and tie) and puts these values in
	 * the *Percent fields.
	 * done at the end of the game, to create the summary.
	 */
	public void calcPercents(){
		humanPercent = (humanWins * 100) / numRounds;
		compPercent = (compWins * 100) / numRounds;
		tiesPercent = (ties * 100) / numRounds;
	}

}
