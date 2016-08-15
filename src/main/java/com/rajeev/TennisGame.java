package com.rajeev;

/** This class is used to determine the current score to display on scoreboard for Tennis Game.
 *  This class works for any player name i.e. player1 and player2 OR Björn Borg and  John McEnroe(as per requirement).
 *  
 * @author rajeev
 *
 */
public class TennisGame {
	

	private Player1 firstPlayer;
	private Player2 secondPlayer;

	/** parameterized constructor for this class 
	 * @param firstPlayer is Player1
	 * @param secondPlayer is Player2
	 */
	TennisGame(Player1 firstPlayer, Player2 secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
	}
	
	
	/** This method determines and updates 'scoreOnDisplay' based on individual player's score.
	 * @return scoreOnDisplay as String that displays on scoreboard.
	 */
	public String getCurrentScore() {
		String scoreOnDisplay = ""; 
		int temp = 0 ;

		// if block is executed when both the players have same score.
		if (firstPlayer.score == secondPlayer.score) {
			switch (firstPlayer.score) {

			case 0:                // when match starts , both the players have 0-0 score
				scoreOnDisplay = "Love All"; 
				break;

			case 1:               
				scoreOnDisplay = "Fifteen All"; //if both the players have 1-1 score
				break;

			case 2:				  
				scoreOnDisplay = "Thirty All"; //if both the players have 2-2 score
				break;

			default:			 // if both the players have same scores like 3-3 , 4-4 , 5-5 , 6-6....
				scoreOnDisplay = "Deuce";

			}
		} 
		// else if block is executed when both the players have different score like 0-1,1-2,1-3,2-3, 1-0,2-1,3-1,3-2
		else if ((firstPlayer.score >=0 && firstPlayer.score <=3) && (secondPlayer.score >=0 && secondPlayer.score <=3))
        {
			
			for(int i = 0 ; i <=1 ; i++)// this for loop is  executed only two times 
			{
				if(i == 0) // first time set the temp value with first player score value 
					temp = firstPlayer.score;
				else
				{
					scoreOnDisplay += " ";  
					temp = secondPlayer.score; // for second time set the temp value with second player score value 
				}
				
				switch(temp)// according to temp value concatenate scoreOnDisplay  with respective String value.
                {            
                    case 0:
                        scoreOnDisplay+="Love";
                        break;
                    case 1:
                        scoreOnDisplay+="Fifteen";
                        break;
                    case 2:
                        scoreOnDisplay+="Thirty";
                        break;
                    case 3:
                        scoreOnDisplay+="Forty";
                        break;
                }
			}
			
        }
		// else  block is executed when one of the player has score >=4 
		else {
			
			// calculating difference of scores of both the players
            int checkDiffOfScore = firstPlayer.score - secondPlayer.score ;
            
            if (checkDiffOfScore == 1) // if difference is 1 , first player has advantage.
            	scoreOnDisplay ="Advantage " + firstPlayer.name;
            
            else if (checkDiffOfScore == -1)  // if difference is -1 , second player has advantage.
            	scoreOnDisplay ="Advantage " + secondPlayer.name;
            
            else if (checkDiffOfScore >= 2) // if difference is >=2 , first player wins.
            	scoreOnDisplay = "Win for " + firstPlayer.name;
            
            else // otherwise second player wins.
            	scoreOnDisplay ="Win for " + secondPlayer.name;
		}

		return scoreOnDisplay;
	}

	/** This method increments the player's score when a player wins a point.
	 * @param playerName
	 */
	public void wonPoint(Player player) {
		
		if (player instanceof Player1)
			firstPlayer.score++;  // Increase the score of Player1 by 1 after winning a point.
		else
			secondPlayer.score++;  // Increase the score of Player2 by 1 after winning a point.

	}

}
