import java.util.LinkedList;

/**
 * ShowManager2 handles some interactions with ShowSummary objects
 * @author trstecko && acheung
 *
 */

class ShowManager2 {
	
	ShowManager2() {}

	//public ShowSummary organizeShows(LinkedList<Show> shows)
	//{
	//	return null;
	//}
	/**
	 * Intakes a list of shows and returns the list of shows with only non-special daytime,primetime, or latenight shows.
	 * 
	 * @param a list of shows
	 * @return a list of daytime, primetime, and latenight shows which are not specials
	 */
	/*
	 * Subtasks:
	 * create 7 new lists of shows, one list for non-special shows, 3 lists for daytime, primetime, and latenight shows, 
	 * - 3 lists of non-special shows at daytime, primetime, or latenight.
	 * Go through each show from the list of shows in the argument
	 * if the show is not a special, it is added to the listOfNonSpecials
	 * The show is added to list of day time, prime time, or late night depending on what time it is broadcasted
	 * Go through the listOfDayTime.For each show, if the listOfNonSpecials also contains it,
	 * - add the show to the listOfDayTimeAndNonSpecials
	 *  - Do the previous step for listOfPrimeTimeAndNonSpecials && listOfLateNightAndNonSpecials aswell
	 * Return a new ShowSummary with the three final lists as arguments
	 */
	public ShowSummary organizeShows(LinkedList<Show> fullShowList)
	{
		LinkedList<Show> listOfNonSpecials = new LinkedList<Show>();
		LinkedList<Show> listOfDayTime = new LinkedList<Show>();
		LinkedList<Show> listOfPrimeTime = new LinkedList<Show>();
		LinkedList<Show> listOfLateNight = new LinkedList<Show>();
		LinkedList<Show> listOfDayTimeAndNonSpecials = new LinkedList<Show>();
		LinkedList<Show> listOfPrimeTimeAndNonSpecials = new LinkedList<Show>();
		LinkedList<Show> listOfLateNightAndNonSpecials = new LinkedList<Show>();
		for(Show thisShow : fullShowList)
		{
			if(thisShow.broadcastTime >= 600 && thisShow.broadcastTime < 1700)
				listOfDayTime.add(thisShow);
			if(thisShow.broadcastTime >= 1700 && thisShow.broadcastTime < 2200)
				listOfPrimeTime.add(thisShow);
			if(thisShow.broadcastTime >= 2200 || thisShow.broadcastTime < 100)
				listOfLateNight.add(thisShow);
			if(!(thisShow.isSpecial))
				listOfNonSpecials.add(thisShow);
		}
		for(Show thisShow : listOfNonSpecials)
		{
			if(linkedListContains(listOfDayTime, thisShow))
				listOfDayTimeAndNonSpecials.add(thisShow);
			if(linkedListContains(listOfPrimeTime, thisShow))
				listOfPrimeTimeAndNonSpecials.add(thisShow);
			if(linkedListContains(listOfLateNight, thisShow))
				listOfLateNightAndNonSpecials.add(thisShow);
		}
		return new ShowSummary(listOfDayTimeAndNonSpecials, listOfPrimeTimeAndNonSpecials, listOfLateNightAndNonSpecials);
	}
	/**
	 * a helper method for the organizeShows() method
	 * 
	 * Intakes a list of shows and a show. Returns true if the list of Shows contains the intaken show
	 * @param LinkedList<Show> listOfShows
	 * @param Show aShow
	 * @return True if the listOfShows contains aShow
	 */
	private boolean linkedListContains(LinkedList<Show> listOfShows, Show aShow)
	{
		boolean hasMatched = false;
		for(Show thisShow : listOfShows)
		{
			if(thisShow.equals(aShow))
				hasMatched = true;
		}
		return hasMatched;
	}

	
}
