import java.util.LinkedList;

/**
 * A show summary is a collection of all the shows that air during a day
 * the show summary contains lists of shows, divinding them based on their broadcast time
 * 
 * @author trstecko && acheung
 *
 */

class ShowSummary {
	
	LinkedList<Show> daytime;
	LinkedList<Show> primetime;
	LinkedList<Show> latenight;
	
	ShowSummary() 
	{
		this.daytime = new LinkedList<Show>();
		this.primetime = new LinkedList<Show>();
		this.latenight = new LinkedList<Show>();
	}
	
	ShowSummary(LinkedList<Show> daytime, LinkedList<Show> primetime, LinkedList<Show> latenight)
	{
		this.daytime = daytime;
		this.primetime = primetime;
		this.latenight = latenight;
	}
	
	/**
	 * compares this ShowSummary with an otherShowSummary
	 * The showSummaries are considered equal if:
	 * Each pair of corresponding lists have the same size
	 * Each pair of corresponding lists have the same shows in the same order
	 * @param otherShowSummary
	 * @return True if the ShowSummaries are equal
	 */
	public boolean equals(Object objectOtherShowSummary)
	{
		ShowSummary otherShowSummary = (ShowSummary)(objectOtherShowSummary);
		if(otherShowSummary.daytime.size() == daytime.size())
			if(otherShowSummary.primetime.size() == primetime.size())
				if(otherShowSummary.latenight.size() == latenight.size())
					if(listOfShowsAreSameOrder(daytime, otherShowSummary.daytime))
						if(listOfShowsAreSameOrder(primetime, otherShowSummary.primetime))
							if(listOfShowsAreSameOrder(latenight, otherShowSummary.latenight))
								return true;
		return false;
	}
	
	/**
	 * Compares two lists of shows and returns a boolean for whether or not the lists
	 * - have the same shows in the same order
	 * 
	 * @param LinkedList<Show> list1 
	 * @param LinkedList<Show> list2
	 * @return Returns True if list1 and list2 have the same shows in the same order
	 */
	
	/*
	 * Subtasks:
	 * If list1 and list2 are of different sizes, return false
	 * create a boolean representing if the lists are the same so far in iteration
	 * Iterate though list 1.
	 * If either the title or broadcast times are different between the show in list 1 and the equivalent show in list2, set the boolean to false
	 * return the boolean representing whether or not they are the same.
	 */
	private boolean listOfShowsAreSameOrder(LinkedList<Show> list1, LinkedList<Show>list2)
	{
		if(list1.size() != list2.size())
			return false;
		
		boolean sameSoFar = true;
		for(int i = 0; i < list1.size(); i++)
		{
			if(list1.get(i).title != list2.get(i).title || list1.get(i).broadcastTime != list2.get(i).broadcastTime)
				sameSoFar = false;
		}
		return sameSoFar;
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
