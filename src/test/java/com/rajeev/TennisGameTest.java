package com.rajeev;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {
	
	private String expectedScreOnDisplay;
	private TennisGame tennisGame;
	private static Player1 firstPlayer;
	private static Player2 secondPlayer;
	
	@Before
	public  void setUp()
	{
		// when uncomment following lines then uncomment corresponding lines in test cases also
		//firstPlayer = new Player1("player1");
		//secondPlayer = new Player2("player2");
		firstPlayer = new Player1("Björn Borg");
		secondPlayer = new Player2("John McEnroe");
		tennisGame = new TennisGame( firstPlayer, secondPlayer);
	}
	
	// test cases when both the players have same points
	@Test
	public void testWhenMatchStartsThenScoreOnScoreboardIsLoveAll()
	{
		expectedScreOnDisplay = "Love All";
		assertEquals(this.expectedScreOnDisplay , tennisGame.getCurrentScore());
	}
	
	@Test
	public void testWhenBothPlayersHave_1_PointThenScoreOnScoreboardIsFifteenAll()
	{
		expectedScreOnDisplay = "Fifteen All"; 
		doPlayersScoreSetting(2 , 2);
	}
	
	@Test
	public void testWhenBothPlayersHave_2_PointsThenScoreOnScoreboardIsThirtyAll()
	{
		expectedScreOnDisplay = "Thirty All"; 
		doPlayersScoreSetting(2 , 2);
	}
	
	@Test
	public void testWhenBothPlayersHave_3_PointsThenScoreOnScoreboardIsDeuce()
	{
		expectedScreOnDisplay = "Deuce"; 
		doPlayersScoreSetting(3 , 3);
	}
	
	@Test
	public void testWhenBothPlayersHave_4_PointsThenScoreOnScoreboardIsDeuce()
	{
		expectedScreOnDisplay = "Deuce"; 
		doPlayersScoreSetting(4 , 4);
	}
	
	@Test
	public void testWhenBothPlayersHave_7_PointsThenScoreOnScoreboardIsDeuce()
	{
		expectedScreOnDisplay = "Deuce";
		doPlayersScoreSetting(7 , 7);
	}
	
	// test cases when both the players have different points but <= 3
	@Test
	public void testWhenFirstPlayerHas_1_PointAndSecondPlayerHas_0_Point()
	{
		expectedScreOnDisplay = "Fifteen Love"; 
		tennisGame.wonPoint(firstPlayer);
		assertEquals(this.expectedScreOnDisplay , tennisGame.getCurrentScore());
	}
	
	@Test
	public void testWhenFirstPlayerHas_0_PointAndSecondPlayerHas_1_Point()
	{
		expectedScreOnDisplay = "Love Fifteen"; 
		tennisGame.wonPoint(secondPlayer);
		assertEquals(this.expectedScreOnDisplay , tennisGame.getCurrentScore());
	}
	
	@Test
	public void testWhenFirstPlayerHas_1_PointAndSecondPlayerHas_2_Points()
	{
		expectedScreOnDisplay = "Fifteen Thirty"; 
		doPlayersScoreSetting(1 , 2);
	}
	
	@Test
	public void testWhenFirstPlayerHas_0_PointAndSecondPlayerHas_3_Points()
	{
		expectedScreOnDisplay = "Love Forty"; 
		doPlayersScoreSetting(0 , 3);
	}
	
	@Test
	public void testWhenFirstPlayerHas_1_PointAndSecondPlayerHas_3_Points()
	{
		expectedScreOnDisplay = "Fifteen Forty"; 
		doPlayersScoreSetting(1 , 3);
	}
	
	// test cases when either of player has points >=4
	@Test
	public void testWhenFirstPlayerHas_4_PointsAndSecondPlayerHas_3_Points()
	{
		//expectedScreOnDisplay = "Advantage player1";
		expectedScreOnDisplay = "Advantage Björn Borg"; 
		doPlayersScoreSetting(4 , 3);
	}
	
	@Test
	public void testWhenFirstPlayerHas_4_PointsAndSecondPlayerHas_6_Points()
	{
		//expectedScreOnDisplay = "Win for player2";
		expectedScreOnDisplay = "Win for John McEnroe"; 
		doPlayersScoreSetting(4 , 6);
	}
	
	@Test
	public void testWhenFirstPlayerHas_4_PointsAndSecondPlayerHas_0_Points()
	{
		//expectedScreOnDisplay = "Win for player1";
		expectedScreOnDisplay = "Win for Björn Borg"; 
		doPlayersScoreSetting(4 , 0);
	}
	
	@Test
	public void testWhenFirstPlayerHas_7_PointsAndSecondPlayerHas_8_Points()
	{
		//expectedScreOnDisplay = "Advantage player2";
		expectedScreOnDisplay = "Advantage John McEnroe"; 
		doPlayersScoreSetting(7 , 8);
	}
	
	@Test
	public void testWhenFirstPlayerHas_9_PointsAndSecondPlayerHas_11_Points()
	{
		//expectedScreOnDisplay = "Win for player2";
		expectedScreOnDisplay = "Win for John McEnroe";
		doPlayersScoreSetting(9 , 11);
	}
	
	/**This method sets scores for both the players accordingly passed parameters.
	 * @param firstPlayerScore to set score of first player
	 * @param secondPlayerScore to set score of second player
	 */
	public void doPlayersScoreSetting(int firstPlayerScore , int secondPlayerScore)
	{
		int maxScore = Math.max(firstPlayerScore, secondPlayerScore);
        for (int i = 0; i < maxScore; i++) 
        {
            if (i < firstPlayerScore)
            	tennisGame.wonPoint(firstPlayer);
            if (i < secondPlayerScore)
            	tennisGame.wonPoint(secondPlayer);
        }
        
        assertEquals(this.expectedScreOnDisplay , tennisGame.getCurrentScore());
	}

}
