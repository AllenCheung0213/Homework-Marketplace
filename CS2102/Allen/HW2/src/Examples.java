import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class Examples {
    public Examples(){}
    SoccerTeam soccerTeamCheck = new SoccerTeam("WPI", "maroon", false, 4, 6);
    SoccerTeam soccerTeamCheck2 = new SoccerTeam("RPI", "bad", true, 6, 4);
    SoccerTeam soccerTeamCheck3 = new SoccerTeam("WPI", "maroon", true, 4, 6);
    SoccerTeam soccerTeamCheck4 = new SoccerTeam("RPI", "bad", false, 6, 4);
    SoccerTeam soccerTeamCheck5 = new SoccerTeam("WPI", "maroon", true, 10, 1);
    SoccerTeam soccerTeamCheck6 = new SoccerTeam("WPI", "maroon", false, 10, 1);
    LegoRobotTeam robotsTeamCheck = new LegoRobotTeam("WPI","goat cheese", 7);
    LegoRobotTeam robotsTeamCheck2 = new LegoRobotTeam("RPI","bad", 10);
    LegoRobotTeam robotsTeamCheck3 = new LegoRobotTeam("RPI","bad", 3);
    SoccerResult soccerResultCheck = new SoccerResult(soccerTeamCheck,
            soccerTeamCheck2, 10.5,15.2);
    SoccerResult soccerResultCheck2 = new SoccerResult(soccerTeamCheck,
            soccerTeamCheck2, 158,10.2);
    SoccerResult soccerResultCheck3 = new SoccerResult(soccerTeamCheck,
            soccerTeamCheck2, 158,600);
    SoccerResult soccerResultCheck4 = new SoccerResult(soccerTeamCheck,
            soccerTeamCheck2, 150,150);
    SoccerResult soccerResultCheck5 = new SoccerResult(soccerTeamCheck,
            soccerTeamCheck2, 12,10);
    SoccerResult soccerResultCheck6 = new SoccerResult(soccerTeamCheck,
            soccerTeamCheck2, 12,150);
    LegoRobotResult robotsResultCheck = new LegoRobotResult(robotsTeamCheck,
            robotsTeamCheck2, 3.1, 5, true, 3.2, 2, false);
    LegoRobotResult robotsResultCheck2 = new LegoRobotResult(robotsTeamCheck,
            robotsTeamCheck2, 3.1, 9, true, 3.2, 2, false);
    LegoRobotResult robotsResultCheck3 = new LegoRobotResult(robotsTeamCheck,
            robotsTeamCheck, 3.1, 9, true, 3.2, 9, false);
    LegoRobotResult robotsResultCheck4 = new LegoRobotResult(robotsTeamCheck,
            robotsTeamCheck, 16.1, 5, true, 3.2, 2, false);
    LegoRobotResult robotsResultCheck5 = new LegoRobotResult(robotsTeamCheck,
            robotsTeamCheck, 16.1, 5, true, 19.6, 2, false);
    LegoRobotResult robotsResultCheck6 = new LegoRobotResult(robotsTeamCheck,
            robotsTeamCheck, 16.1, 9, true, 19.6, 10, false);
    LegoRobotResult robotsResultCheck7 = new LegoRobotResult(robotsTeamCheck,
            robotsTeamCheck, 16, 5, true, 16, 2, false);
    LegoRobotResult robotsResultCheck8 = new LegoRobotResult(robotsTeamCheck,
            robotsTeamCheck, 15, 8, true, 10.3, 8, false);
    LegoRobotResult robotsResultCheck9 = new LegoRobotResult(robotsTeamCheck,
            robotsTeamCheck2, 4.1, 4, false, 4.1, 4, false);
    LegoRobotResult robotsResultCheck10 = new LegoRobotResult(robotsTeamCheck,
            robotsTeamCheck2, 4.1, 4, false, 16.1, 4, false);

    Match soccerMatchCheck = new Match(soccerTeamCheck, soccerTeamCheck2, soccerResultCheck5);
    Match soccerMatchCheck2 = new Match(soccerTeamCheck, soccerTeamCheck2, soccerResultCheck);
    Match soccerMatchCheck3 = new Match(soccerTeamCheck, soccerTeamCheck2, soccerResultCheck2);
    Match soccerMatchCheck4 = new Match(soccerTeamCheck, soccerTeamCheck2, soccerResultCheck6);

    Match robotsMatchCheck = new Match(robotsTeamCheck, robotsTeamCheck2, robotsResultCheck);
    Match robotsMatchCheck2 = new Match(robotsTeamCheck, robotsTeamCheck2, robotsResultCheck2);
    Match robotsMatchCheck3 = new Match(robotsTeamCheck, robotsTeamCheck2, robotsResultCheck4);
    Match robotsMatchCheck4 = new Match(robotsTeamCheck, robotsTeamCheck2, robotsResultCheck10);

    //testing isValid() for Soccer Result
    @Test public void testSoccerResultIsValid (){ assertTrue(soccerResultCheck.isValid());}
    @Test public void testSoccerResultIsNotValid_OneOver(){ assertFalse(soccerResultCheck2.isValid());}
    @Test public void testSoccerResultIsNotValid_BothOver(){ assertFalse(soccerResultCheck3.isValid());}
    @Test public void testSoccerResultIsNotValid_Edge(){ assertFalse(soccerResultCheck4.isValid());}
    //Testing isValid() for Robot Result
    @Test public void testRobotResultIsValid(){ assertTrue(robotsResultCheck.isValid());}
    @Test public void testRobotResultIsNotValid_OneTaskGreater(){ assertFalse(robotsResultCheck2.isValid());}
    @Test public void testRobotResultIsNotValid_BothTaskGreater(){ assertFalse(robotsResultCheck3.isValid());}
    @Test public void testRobotResultIsNotValid_OnePointGreater(){ assertFalse(robotsResultCheck4.isValid());}
    @Test public void testRobotResultIsNotValid_BothPointGreater(){ assertFalse(robotsResultCheck5.isValid());}
    @Test public void testRobotResultIsNotValid_EverythingCombined(){ assertFalse(robotsResultCheck6.isValid());}
    @Test public void testRobotResultIsNotValid_PointsEdge(){ assertTrue(robotsResultCheck7.isValid());}
    @Test public void testRobotResultIsNotValid_TaskEdge(){ assertFalse(robotsResultCheck8.isValid());}
    //Testing getScore()
    @Test public void testGetScore(){ assertEquals(4.2, robotsResultCheck.getScore(3.2, 1, false), 1);}
    @Test public void testGetScore_Fell(){ assertEquals(1.2, robotsResultCheck.getScore(5.2, 1, true), 1);}
    @Test public void testGetScore_FellNegatives(){ assertEquals(-0.8, robotsResultCheck.getScore(3.2, 1, true), 1);}
    //Testing getWinner() for Soccer Result
    @Test public void testSoccerResultGetWinnerFirstOneBigger(){ assertEquals(soccerTeamCheck, soccerResultCheck2.getWinner());}
    @Test public void testSoccerResultGetWinnerSecondOneBigger(){ assertEquals(soccerTeamCheck2, soccerResultCheck3.getWinner());}
    /*No Ties but just as a check*/@Test public void testSoccerResultGetWinnerEdgeCase(){ assertEquals(soccerTeamCheck2, soccerResultCheck4.getWinner());}
    //Testing getWinner() for Robot Result
    @Test public void testRobotResultGetWinnerFirstOneBigger(){ assertEquals(robotsTeamCheck, robotsResultCheck2.getWinner());}
    @Test public void testRobotResultGetWinnerSecondOneBigger(){ assertEquals(robotsTeamCheck2, robotsResultCheck.getWinner());}
    /*No Ties but just as a check*/@Test public void testRobotResultGetWinnerEdgeCase(){ assertEquals(robotsTeamCheck2, robotsResultCheck9.getWinner());}
    //Testing winner() for Soccer Result
    @Test public void testSoccerResultWinnerOneIsValid(){ assertEquals(soccerTeamCheck, soccerMatchCheck.winner());}
    @Test public void testSoccerResultWinnerTwoIsValid(){ assertEquals(soccerTeamCheck2, soccerMatchCheck2.winner());}
    @Test public void testSoccerResultWinnerOneIsNotValid(){ assertNull(soccerMatchCheck3.winner());}
    @Test public void testSoccerResultWinnerSecondIsNotValid(){ assertNull(soccerMatchCheck4.winner());}
    //Testing winner() for Robot Result
    @Test public void testRobotResultWinnerOneIsValid(){ assertNotEquals(robotsTeamCheck, robotsMatchCheck2.winner());}
    @Test public void testRobotResultWinnerTwoIsValid(){ assertEquals(robotsTeamCheck2, robotsMatchCheck.winner());}
    @Test public void testRobotResultWinnerOneIsNotValid(){ assertNull(robotsMatchCheck3.winner());}
    @Test public void testRobotResultWinnerTwoIsNotValid(){ assertNull(robotsMatchCheck4.winner());}
    //Testing expectToBeat() for Soccer Team
    @Test public void testSoccerTeamExpectToBeatFirstWinsWithRitual(){ assertTrue(soccerTeamCheck3.expectToBeat(soccerTeamCheck4));}
    @Test public void testSoccerTeamExpectToBeatSecondWinsWithRitual(){ assertTrue(soccerTeamCheck2.expectToBeat(soccerTeamCheck));}
    @Test public void testSoccerTeamExpectToBeatFirstWinsBothWithRitual(){ assertTrue(soccerTeamCheck5.expectToBeat(soccerTeamCheck4));}
    @Test public void testSoccerTeamExpectToBeatSecondWinsBothWithRitual(){ assertTrue(soccerTeamCheck2.expectToBeat(soccerTeamCheck3));}
    @Test public void testSoccerTeamExpectToBeatFirstWinsBothWithoutRitual(){ assertTrue(soccerTeamCheck6.expectToBeat(soccerTeamCheck4));}
    @Test public void testSoccerTeamExpectToBeatSecondWinsBothWithoutRitual(){ assertTrue(soccerTeamCheck4.expectToBeat(soccerTeamCheck));}
    @Test public void testSoccerTeamExpectToBeatEdgeCase(){ assertFalse(soccerTeamCheck.expectToBeat(soccerTeamCheck));}
    //Testing expectToBeat for Robot Team
    @Test public void testRobotTeamExpectToBeatFirstWins(){ assertTrue(robotsTeamCheck.expectToBeat(robotsTeamCheck3));}
    @Test public void testRobotTeamExpectToBeatSecondWins(){ assertTrue(robotsTeamCheck2.expectToBeat(robotsTeamCheck));}
    @Test public void testRobotTeamExpectToBeatEdgeCase(){ assertFalse(robotsTeamCheck.expectToBeat(robotsTeamCheck));}
    InitialRound iRound = new InitialRound(new LinkedList<Match>());
    AdvancedRound aRound = new AdvancedRound(new LinkedList<Match>(), new
            LinkedList<IContestant>());
    Tournament tnmt = new Tournament(new LinkedList<IWinner>());
    //Testing getMatchWinners for initial Round
    @Test public void  testGetMatchWinnersvoid(){
        InitialRound newIRound = new InitialRound(new LinkedList<Match>());
    }
    
    SoccerTeam soccerTeam700 = new SoccerTeam("team700", "blue", false , 7, 7);
    SoccerTeam soccerTeam701 = new SoccerTeam("team701", "blue", false , 7, 7);
    SoccerResult team700Beats701 = new SoccerResult (soccerTeam700, soccerTeam701, 4, 2);
    Match team700Beats701Match = new Match(soccerTeam700, soccerTeam701, team700Beats701);
    
    SoccerTeam soccerTeam702 = new SoccerTeam("team702", "blue", false , 7, 7);
    SoccerTeam soccerTeam703 = new SoccerTeam("team703", "blue", false , 7, 7);
    SoccerResult team703Beats702 = new SoccerResult (soccerTeam702, soccerTeam703, 1, 6);
    Match team703Beats702Match = new Match(soccerTeam702, soccerTeam703, team703Beats702);
    
    SoccerTeam soccerTeam704 = new SoccerTeam("team704", "blue", false , 7, 7);
    SoccerTeam soccerTeam705 = new SoccerTeam("team705", "blue", false , 7, 7);
    SoccerResult team704Beats705 = new SoccerResult (soccerTeam704, soccerTeam705, 6, 0);
    Match team704Beats705Match = new Match(soccerTeam704, soccerTeam705, team704Beats705);
    
    LinkedList<Match> list1 = new LinkedList<Match>() {{
    	 add(team700Beats701Match);
    	 add(team703Beats702Match);
    	 add(team704Beats705Match);
    }};
  
    LinkedList<IContestant> list2 = new LinkedList<IContestant>() {{
        add(soccerTeam700);
        add(soccerTeam703);
        add(soccerTeam704);
    }};
    
    AdvancedRound advRound1 = new AdvancedRound (list1, list2);
    // testing getMatchWinners() on advanced round for soccer teams
    @Test public void checkSoccerGetMatchWinners() {assertEquals(advRound1.getMatchWinners() , list2);}
   // testing getNumWinners() on advanced round for soccer teams
    @Test public void checkSoccerGetNumWinners() {assertEquals(advRound1.getNumWinners(), 3);}
    // testing isWinner for soccer teams for correctly identifying past winners
    @Test public void checkSoccerIsWinnerWinner() {assertTrue(advRound1.isWinner(soccerTeam700));}
    // testing isWinner for soccer teams for correctly identifying teams that aren't winners
    @Test  public void checkSoccerIsWinnerLoser() {assertFalse(advRound1.isWinner(soccerTeam701));}
    
    
    InitialRound initRound1 = new InitialRound(list1);
    // testing getMatchWinners() on initial round for soccer teams
    @Test public void checkSoccerGetMatchWinnersInit() {assertEquals(initRound1.getMatchWinners() , list2);}
   // testing getNumWinners() on initial round for soccer teams
    @Test public void checkSoccerGetNumWinnersInit() {assertEquals(initRound1.getNumWinners(), 3);}
    
    LegoRobotTeam robotTeam600 = new LegoRobotTeam("WPI", "Engineers", 27);
    LegoRobotTeam robotTeam601 = new LegoRobotTeam("WPI", "Engineers", 27);
    LegoRobotResult robot601Beats600 = new LegoRobotResult(robotTeam600, robotTeam601,
    		3, 3, false,
            7, 7, false);
    Match robot601Beats600Match = new Match(robotTeam600, robotTeam601, robot601Beats600);
    
    LegoRobotTeam robotTeam602 = new LegoRobotTeam("WPI", "Engineers", 27);
    LegoRobotTeam robotTeam603 = new LegoRobotTeam("WPI", "Engineers", 27);
    LegoRobotResult robot603Beats602 = new LegoRobotResult(robotTeam602, robotTeam603,
            3, 3, false,
            7, 7, false);
    Match robot603Beats602Match = new Match(robotTeam602, robotTeam603, robot603Beats602);
    
    LegoRobotTeam robotTeam604 = new LegoRobotTeam("WPI", "Engineers", 27);
    LegoRobotTeam robotTeam605 = new LegoRobotTeam("WPI", "Engineers", 27);
    LegoRobotResult robot605Beats604= new LegoRobotResult(robotTeam604, robotTeam605,
    		3, 3, false,
            7, 7, false);
    Match robot605Beats604Match = new Match(robotTeam604, robotTeam605, robot605Beats604);
    
    LinkedList<Match> list600 = new LinkedList<Match>() {{
   	 add(robot601Beats600Match);
   	 add(robot603Beats602Match);
   	 add(robot605Beats604Match);
   }};
   
   LinkedList<IContestant> list601 = new LinkedList<IContestant>() {{
       add(robotTeam601);
       add(robotTeam603);
       add(robotTeam605);
   }};
   AdvancedRound advRound2 = new AdvancedRound (list600, list601);
   //testing getMatchWinners() for advanced round for robot teams
   @Test public void checkRobotGetMatchWinners() {assertEquals(advRound2.getMatchWinners() , list601);} 
   //testing getNumWinners() for advanced round for robot teams
   @Test public void checkRobotGetNumWinners() {assertEquals(advRound2.getNumWinners(), 3);}
   
   InitialRound initRound2 = new InitialRound (list600);
   // testing getMatchWinners for initial round for robot teams
   @Test public void checkRobotGetMatchWinnersInit() {assertEquals(initRound2.getMatchWinners() , list601);}
   // testing getNumWinners for initial round for robot teams
   @Test public void checkRobotGetNumWinnersInit() {assertEquals(initRound2.getNumWinners(), 3);}
   
   // testing isWinner for robot teams for correctly identifying past winners
   @Test public void checkRobotIsWinnerWinner() {assertTrue(advRound2.isWinner(robotTeam601));}
   // testing isWinner for robot teams for correctly identifying teams that aren't winners
   @Test  public void checkRobotIsWinnerLoser() {assertFalse(advRound2.isWinner(robotTeam600));}
   
   
   Match robot601Beats600Match2 = new Match(robotTeam600, robotTeam601, robot601Beats600);
   
   LegoRobotResult robot601Beats602 = new LegoRobotResult(robotTeam602, robotTeam601,
           3, 3, false,
           7, 7, false);
   Match robot601Beats602Match = new Match(robotTeam602, robotTeam603, robot603Beats602);
   
   LegoRobotResult robot601Beats604= new LegoRobotResult(robotTeam604, robotTeam601,
   		3, 3, false,
           7, 7, false);
   Match robot601Beats604Match = new Match(robotTeam604, robotTeam605, robot605Beats604);
   
   LinkedList<Match> matchesRound1 = new LinkedList<Match>(){{
		add(robot601Beats600Match2);
		add(robot601Beats602Match);
		add(robot601Beats604Match);
	   }};
   
   IWinner Round1init = new InitialRound(matchesRound1);
   
   LegoRobotTeam robotTeam606 = new LegoRobotTeam("WPI", "Engineers", 27);
   LegoRobotResult robot601Beats606 = new LegoRobotResult(robotTeam600, robotTeam601,
   		3, 3, false,
           7, 7, false);
   Match robot601Beats606Match = new Match(robotTeam606, robotTeam601, robot601Beats606);
   
   LegoRobotTeam robotTeam607 = new LegoRobotTeam("WPI", "Engineers", 27);
   LegoRobotResult robot601Beats607 = new LegoRobotResult(robotTeam600, robotTeam601,
   		3, 3, false,
           7, 7, false);
   Match robot601Beats607Match = new Match(robotTeam607, robotTeam601, robot601Beats607);
   
   LegoRobotTeam robotTeam608 = new LegoRobotTeam("WPI", "Engineers", 27);
   LegoRobotResult robot601Beats608 = new LegoRobotResult(robotTeam600, robotTeam601,
   		3, 3, false,
           7, 7, false);
   Match robot601Beats608Match = new Match(robotTeam608, robotTeam601, robot601Beats608);
   
   LinkedList<Match> matchesRound2 = new LinkedList<Match>(){{
		add(robot601Beats606Match);
		add(robot601Beats607Match);
		add(robot601Beats608Match);
	   }};
	   LinkedList<IContestant> winnersRound2 = new LinkedList<IContestant>(){{
			add(robotTeam601);
			add(robotTeam606);
			add(robotTeam607);
		   }};
   IWinner Round2adv = new AdvancedRound(matchesRound2, winnersRound2);
   
   LinkedList<IWinner> RoundsList = new LinkedList<IWinner>(){{
		add(Round1init);
		add(Round2adv);
	   }};
	   Tournament Tourney1 = new Tournament(RoundsList);
	   //testing finalWinnerIsValid on a robot team where the answer should be true
   @Test public void checkFinalWinnerIsValidRobotTrue() {assertTrue(Tourney1.finalWinnerIsValid(robotTeam601));}
 //testing finalWinnerIsValid on a robot team where the answer should be false;
   @Test public void checkFinalWinnerIsValidRobotFalse() {assertFalse(Tourney1.finalWinnerIsValid(robotTeam606));}
   
   SoccerTeam soccerTeam7014 = new SoccerTeam("team7014", "blue", false , 7, 7);
   SoccerTeam soccerTeam7015 = new SoccerTeam("team7015", "blue", false , 7, 7);
   SoccerResult team7014Beats7015 = new SoccerResult (soccerTeam7014, soccerTeam7015, 6, 0);
   Match team7014Beats7015Match = new Match(soccerTeam7014, soccerTeam7015, team7014Beats7015);
   
   SoccerTeam soccerTeam7024 = new SoccerTeam("team7024", "blue", false , 7, 7);
   SoccerTeam soccerTeam7025 = new SoccerTeam("team7025", "blue", false , 7, 7);
   SoccerResult team7024Beats7025 = new SoccerResult (soccerTeam7024, soccerTeam7025, 6, 0);
   Match team7024Beats7025Match = new Match(soccerTeam7024, soccerTeam7025, team7024Beats7025);
   
   SoccerTeam soccerTeam7035 = new SoccerTeam("team7035", "blue", false , 7, 7);
   SoccerResult team7024Beats7035 = new SoccerResult (soccerTeam7024, soccerTeam7035, 6, 0);
   Match team7024Beats7035Match = new Match(soccerTeam7024, soccerTeam7035, team7024Beats7035);
   
   LinkedList<Match> matchesRound1Soccer = new LinkedList<Match>(){{
		add(team7014Beats7015Match);
		add(team7024Beats7025Match);
		add(team7024Beats7035Match);
	   }};
	IWinner Round1SoccerInit = new InitialRound(matchesRound1Soccer);
	
	SoccerTeam soccerTeam7045 = new SoccerTeam("team7045", "blue", false , 7, 7);
	   SoccerResult team7024Beats7045 = new SoccerResult (soccerTeam7024, soccerTeam7045, 6, 0);
	   Match team7024Beats7045Match = new Match(soccerTeam7024, soccerTeam7045, team7024Beats7045);
   
	   SoccerTeam soccerTeam7055 = new SoccerTeam("team7055", "blue", false , 7, 7);
	   SoccerResult team7024Beats7055 = new SoccerResult (soccerTeam7024, soccerTeam7055, 6, 0);
	   Match team7024Beats7055Match = new Match(soccerTeam7024, soccerTeam7055, team7024Beats7055);
   
	   SoccerTeam soccerTeam7065 = new SoccerTeam("team7065", "blue", false , 7, 7);
	   SoccerResult team7024Beats7065 = new SoccerResult (soccerTeam7024, soccerTeam7065, 6, 0);
	   Match team7024Beats7065Match = new Match(soccerTeam7024, soccerTeam7065, team7024Beats7065);
   
	   LinkedList<Match> matchesRound2Soccer = new LinkedList<Match>(){{
			add(team7024Beats7045Match);
			add(team7024Beats7055Match);
			add(team7024Beats7065Match);
		   }};
		   LinkedList<IContestant> PreviousSoccerWinners = new LinkedList<IContestant>(){{
				add(soccerTeam7024);
				add(soccerTeam7014);
				add(soccerTeam7035);
			   }};
	IWinner Round2Socceradv = new AdvancedRound (matchesRound2Soccer, PreviousSoccerWinners);
	
	LinkedList<IWinner> RoundsListSoccer = new LinkedList<IWinner>(){{
		add(Round1SoccerInit);
		add(Round2Socceradv);
	   }};
	   Tournament Tourney2 = new Tournament(RoundsListSoccer); 
	   //testing finalWinnerIsValid on a soccer team where the answer should be true
	   @Test public void checkFinalWinnerIsValidSoccerTrue() {assertTrue(Tourney2.finalWinnerIsValid(soccerTeam7024));}
	 //testing finalWinnerIsValid on a soccer team where the answer should be false;
	   @Test public void checkFinalWinnerIsValidSoccerFalse() {assertFalse(Tourney2.finalWinnerIsValid(soccerTeam7014));}
}

	







