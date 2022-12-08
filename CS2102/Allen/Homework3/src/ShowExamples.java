import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * ShowExamples handles test cases for methods from ShowManager1 and ShowManager2
 * @author trstecko && acheung
 *
 */

public class ShowExamples 
{
	ShowManager1 sm1 = new ShowManager1();
	LinkedList<Show> shows = new LinkedList<Show>();
	ShowSummary report1 = new ShowSummary();

	Show startrek = new Show("Star Trek", 1800, 45.0, false);
	Show futurama = new Show("Futurama", 1900, 23.0, false);
	Show animaniacs = new Show("Animaniacs", 1630, 7.0, false);
	Show sesamestreet = new Show("Sesame Street", 900, 60.0, false);

	public ShowExamples()
	{
		shows.add(startrek);
		report1.primetime.add(startrek);

		shows.add(futurama);
		report1.primetime.add(futurama);

		shows.add(animaniacs);
		report1.daytime.add(animaniacs);

		shows.add(sesamestreet);
		report1.daytime.add(sesamestreet);
	}
	
	@Test
	public void instructorTestShowSummary_EmptyReport() {
		ShowSummary report2 = new ShowSummary();
		assertFalse(report1.equals(report2));
	}


	// 
	@Test
	public void instructorTestShowSummary_WrongOrder() {
		ShowSummary report2 = new ShowSummary();

		report2.primetime.add(futurama);
		report2.primetime.add(startrek);
		report2.daytime.add(animaniacs);
		report2.daytime.add(sesamestreet);

		assertFalse(report1.equals(report2));
	}

	@Test
	public void instructorTestShowSummary_DifferentInstances() {
		ShowSummary report2 = new ShowSummary();

		Show startrek2 = new Show("Star Trek", 1800, 60.0, true);
		Show futurama2 = new Show("Futurama", 1900, 20.0, false);
		Show animaniacs2 = new Show("Animaniacs", 1630, 9.0, true);
		Show sesamestreet2 = new Show("Sesame Street", 900, 55.0, false);

		report2.primetime.add(startrek2);
		report2.primetime.add(futurama2);
		report2.daytime.add(animaniacs2);
		report2.daytime.add(sesamestreet2);

		assertTrue(report1.equals(report2));
	}

	@Test
	public void instructorTestShowSummary_SameInstances() {
		ShowSummary report2 = report1;
		assertTrue(report1.equals(report2));
	}


	@Test
	public void instructorTestOrganizeShows() 
	{
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);
	}
	
	// Tests the equals() method of the ShowSummary with equal objects. Should be true 
	
	@Test
	public void testEqualsWhenSame()
	{
		Show Shrek = new Show("shrek", 2000, 200, true);
		Show ScoobyDoo = new Show("scoobydoo", 1500, 20, false);
		Show SpongeBob = new Show("spongebob", 2300, 20, false);
		Show AdventureTime = new Show("adventuretime", 2100, 25, false);
				
		LinkedList<Show> showListDay = new LinkedList<Show>();
		showListDay.add(ScoobyDoo);
		LinkedList<Show> showListPrime = new LinkedList<Show>();
		showListPrime.add(Shrek);
		showListPrime.add(AdventureTime);
		LinkedList<Show> showListLate = new LinkedList<Show>();
		showListLate.add(SpongeBob);
		
		ShowSummary summary1 = new ShowSummary(showListDay, showListPrime, showListLate);
		ShowSummary summary2 = new ShowSummary(showListDay, showListPrime, showListLate);
		
		assertTrue(summary1.equals(summary2));
	}
	
	// Tests the equals() method of the ShowSummary with non equal objects. Should be False
	@Test
	public void testEqualsWhenDifferent()
	{
		Show Shrek = new Show("shrek", 2000, 200, true);
		Show ScoobyDoo = new Show("scoobydoo", 1500, 20, false);
		Show SpongeBob = new Show("spongebob", 2300, 20, false);
		Show AdventureTime = new Show("adventuretime", 2100, 25, false);
		Show Shrek2 = new Show("shrek2", 2020, 200, true);
		Show ScoobyDoo2 = new Show("scoobydoo2", 1502, 20, false);
		Show SpongeBob2 = new Show("spongebob2", 2302, 20, false);
		Show AdventureTime2 = new Show("adventuretime2", 2102, 25, false);
		
		LinkedList<Show> showListDay = new LinkedList<Show>();
		showListDay.add(ScoobyDoo);
		LinkedList<Show> showListPrime = new LinkedList<Show>();
		showListPrime.add(Shrek);
		showListPrime.add(AdventureTime);
		LinkedList<Show> showListLate = new LinkedList<Show>();
		showListLate.add(SpongeBob);
		
		LinkedList<Show> showListDay2 = new LinkedList<Show>();
		showListDay.add(ScoobyDoo2);
		LinkedList<Show> showListPrime2 = new LinkedList<Show>();
		showListPrime.add(Shrek2);
		showListPrime.add(AdventureTime2);
		LinkedList<Show> showListLate2 = new LinkedList<Show>();
		showListLate.add(SpongeBob2);
		
		ShowSummary summary1 = new ShowSummary(showListDay, showListPrime, showListLate);
		ShowSummary summary2 = new ShowSummary(showListDay2, showListPrime2, showListLate2);
		
		assertFalse(summary1.equals(summary2));
	}
	
	// Tests that the organizeShows() of ShowManager1 organizes a list of Shows to match the expected value
	@Test
	public void testShowManager1Organize()
	{
		
		Show Shrek = new Show("shrek", 2000, 200, true);
		Show ScoobyDoo = new Show("scoobydoo", 1500, 20, false);
		Show SpongeBob = new Show("spongebob", 2300, 20, false);
		Show AdventureTime = new Show("adventuretime", 2100, 25, false);
		LinkedList<Show> showList = new LinkedList<Show>();
		showList.add(Shrek);
		showList.add(ScoobyDoo);
		showList.add(SpongeBob);
		showList.add(AdventureTime);

		LinkedList<Show> showListDay = new LinkedList<Show>();
		showListDay.add(ScoobyDoo);
		LinkedList<Show> showListPrime = new LinkedList<Show>();
		showListPrime.add(AdventureTime);
		LinkedList<Show> showListLate = new LinkedList<Show>();
		showListLate.add(SpongeBob);
		ShowSummary expectedOutcome = new ShowSummary(showListDay, showListPrime, showListLate);
		
		ShowManager1 testManager = new ShowManager1();
		
		assertTrue(expectedOutcome.equals(testManager.organizeShows(showList)));
		
	}
	
	//Tests that the organizeShows() of ShowManager1 returns an all-empty ShowSummary when all inputs are specials
	@Test
	public void testShowManager1OrganizeSpecials()
	{
		
		Show Shrek = new Show("shrek", 2000, 200, true);
		Show ScoobyDoo = new Show("scoobydoo", 1500, 20, true);
		Show SpongeBob = new Show("spongebob", 2300, 20, true);
		Show AdventureTime = new Show("adventuretime", 2100, 25, true);
		LinkedList<Show> showList = new LinkedList<Show>();
		showList.add(Shrek);
		showList.add(ScoobyDoo);
		showList.add(SpongeBob);
		showList.add(AdventureTime);

		LinkedList<Show> showListDay = new LinkedList<Show>();
		LinkedList<Show> showListPrime = new LinkedList<Show>();
		LinkedList<Show> showListLate = new LinkedList<Show>();
		ShowSummary expectedOutcome = new ShowSummary(showListDay, showListPrime, showListLate);
		
		ShowManager1 testManager = new ShowManager1();
		
		assertTrue(expectedOutcome.equals(testManager.organizeShows(showList)));
		
	}
	

	// Tests that the organizeShows() of ShowManager2 organizes a list of Shows to match the expected value
	@Test
	public void testShowManager2Organize()
	{
		
		Show Shrek = new Show("shrek", 2000, 200, true);
		Show ScoobyDoo = new Show("scoobydoo", 1500, 20, false);
		Show SpongeBob = new Show("spongebob", 2300, 20, false);
		Show AdventureTime = new Show("adventuretime", 2100, 25, false);
		LinkedList<Show> showList = new LinkedList<Show>();
		showList.add(Shrek);
		showList.add(ScoobyDoo);
		showList.add(SpongeBob);
		showList.add(AdventureTime);

		LinkedList<Show> showListDay = new LinkedList<Show>();
		showListDay.add(ScoobyDoo);
		LinkedList<Show> showListPrime = new LinkedList<Show>();
		showListPrime.add(AdventureTime);
		LinkedList<Show> showListLate = new LinkedList<Show>();
		showListLate.add(SpongeBob);
		ShowSummary expectedOutcome = new ShowSummary(showListDay, showListPrime, showListLate);
		
		ShowManager2 testManager = new ShowManager2();
		
		assertTrue(expectedOutcome.equals(testManager.organizeShows(showList)));	
	}
	
	//Tests that the organizeShows() of ShowManager2 returns an all-empty ShowSummary when all inputs are specials
		@Test
		public void testShowManager2OrganizeSpecialsSpecials()
		{
			
			Show Shrek = new Show("shrek", 2000, 200, true);
			Show ScoobyDoo = new Show("scoobydoo", 1500, 20, true);
			Show SpongeBob = new Show("spongebob", 2300, 20, true);
			Show AdventureTime = new Show("adventuretime", 2100, 25, true);
			LinkedList<Show> showList = new LinkedList<Show>();
			showList.add(Shrek);
			showList.add(ScoobyDoo);
			showList.add(SpongeBob);
			showList.add(AdventureTime);

			LinkedList<Show> showListDay = new LinkedList<Show>();
			LinkedList<Show> showListPrime = new LinkedList<Show>();
			LinkedList<Show> showListLate = new LinkedList<Show>();
			ShowSummary expectedOutcome = new ShowSummary(showListDay, showListPrime, showListLate);
			
			ShowManager2 testManager = new ShowManager2();
			
			assertTrue(expectedOutcome.equals(testManager.organizeShows(showList)));
			
		}
	//Tests that the organizeShows() of ShowManager2 returns an all-empty ShowSummary with empty inputs
		@Test
		public void testShowManager2OrganizeEmpty()
		{
					
			LinkedList<Show> showList = new LinkedList<Show>();

			LinkedList<Show> showListDay = new LinkedList<Show>();
			LinkedList<Show> showListPrime = new LinkedList<Show>();
			LinkedList<Show> showListLate = new LinkedList<Show>();
			ShowSummary expectedOutcome = new ShowSummary(showListDay, showListPrime, showListLate);
					
			ShowManager2 testManager = new ShowManager2();
					
			assertTrue(expectedOutcome.equals(testManager.organizeShows(showList)));
			}
	//Tests that the organizeShows() of ShowManager1 returns an all-empty ShowSummary with empty inputs
		@Test
		public void testShowManager1OrganizeEmpty()
		{
						
			LinkedList<Show> showList = new LinkedList<Show>();
			LinkedList<Show> showListDay = new LinkedList<Show>();
			LinkedList<Show> showListPrime = new LinkedList<Show>();
			LinkedList<Show> showListLate = new LinkedList<Show>();
			ShowSummary expectedOutcome = new ShowSummary(showListDay, showListPrime, showListLate);
							
			ShowManager1 testManager = new ShowManager1();
							
			assertTrue(expectedOutcome.equals(testManager.organizeShows(showList)));
			}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	

}
