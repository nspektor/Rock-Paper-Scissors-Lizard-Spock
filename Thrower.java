import java.util.*;
/**
 * Thrower decides the computer's and the human's Throw for each round.
 * 
 * @author Nellie Spektor nas2180
 * @version 1.3
 */
public class Thrower {
	private Throw computerThrow;
	private Throw humanThrow;
	/**
	 * A String that is either "random" or "repeat"
	 */
	private String throwType; 
	/**
	 * A String that is either "computer" or "human"
	 */
	private String playerType; 

	/**
	 * Creates a Thrower that either throws randomly or repeats one throw.
	 * If the command line argument is not "random" or "repeat", the default
	 * human strategy is to be random.
	 */
	public Thrower(String throwerType, String player) {
		// TODO Auto-generated constructor stub
		throwType = throwerType;
		playerType = player;
		if(throwType.equals("random")){
			randomThrow(playerType);
		}
		if(throwType.equals("repeat")){
			humanThrow = new Throw("r");;
		}
		else{
			randomThrow(playerType); 
		}
		
	}
	
	/**
	 * Sets the player's (either human's or computer's) Throw to "r", "p", "s", "l", or "k" randomly 
	 * @param player
	 */
	public void randomThrow(String player){
		Random rand = new Random();
		int  n = rand.nextInt(5);
		String randomThrowType = "";
		if(n == 0){
			randomThrowType = "r" ;
		}
		if(n == 1){
			randomThrowType = "p" ;
		}
		if(n == 2){
			randomThrowType = "s" ;
		}
		if(n == 3){
			randomThrowType = "l" ;
		}
		if(n == 4){
			randomThrowType = "k" ;
		}
		if( player.equals("human")){
			humanThrow = new Throw(randomThrowType);
		}
		else{
			computerThrow = new Throw(randomThrowType);
		}
	}

	
	/**
	 * Gets the computer's Throw
	 * @return Throw computerThrow, which is randomly assigned
	 */
	public Throw getComputerThrow(){
		return computerThrow;
	}
	/**
	 * Gets the human's Throw
	 * @return Throw humanThrow, which is determined by the throwType
	 */
	public Throw getHumanThrow(){
		return humanThrow;
	}

}
