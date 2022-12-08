import java.util.LinkedList;

/**
 * ShowManager1 handles some interactions with ShowSummary objects
 * @author trstecko && acheung
 *
 */

class ShowManager1 {
	
	ShowManager1() {}

	/**
	 * Intakes a list of shows and returns the list of shows with only non-special daytime,primetime, or latenight shows.
	 * 
	 * @param a list of shows
	 * @return a list of daytime, primetime, and latenight shows which are not specials
	 */
	/* Subtasks:
	 * create a new organized list of shows
	 * go through each show in the list of shows from the argument,
	 * adding the show to the organized list if it is not a special and if it is primetime,daytime, or latenight.
	 * return the organized list of shows
	*/
	public ShowSummary organizeShows(LinkedList<Show> fullShowList)
	{
		LinkedList<Show> listOfNonSpecialsRightTime = new LinkedList<Show>();
		for(Show thisShow : fullShowList)
		{
			if(!(thisShow.isSpecial))
				if(thisShow.broadcastTime >= 600 || thisShow.broadcastTime < 100 )
					listOfNonSpecialsRightTime.add(thisShow);
		}
		return new ShowSummary(showByTimeSlot("daytime", listOfNonSpecialsRightTime),showByTimeSlot("primetime", listOfNonSpecialsRightTime),showByTimeSlot("latenight", listOfNonSpecialsRightTime));
	}
	
	/**
	 * a helper method for the organizeShows() method
	 * 
	 * @param String slot - the time slot of the wanted shows. daytime, primetime, or latenight
	 * @param LinkedList<Show> - the list of shows 
	 * @return LinkedList<Show> - the list of shows from the showList whose timeslot matches the one from the argument 
	 */
	
	private LinkedList<Show> showByTimeSlot(String slot, LinkedList<Show> showList)
	{
		LinkedList<Show> listOfShows = new LinkedList<Show>();
		if(slot.equals("daytime"))
		{
			for(Show thisShow: showList)
				if(thisShow.broadcastTime >= 600 && thisShow.broadcastTime < 1700)
					listOfShows.add(thisShow);
		}
		if(slot.equals("primetime"))
		{
			for(Show thisShow: showList)
				if(thisShow.broadcastTime >= 1700 && thisShow.broadcastTime < 2200)
					listOfShows.add(thisShow);
		}
		if(slot.equals("latenight"))
		{
			for(Show thisShow: showList)
				if(thisShow.broadcastTime >= 2200 || thisShow.broadcastTime < 100)
					listOfShows.add(thisShow);
		}
		return listOfShows;
	}
}
