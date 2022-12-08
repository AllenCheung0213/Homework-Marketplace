import java.util.LinkedList;

public class EventLL implements ISet {
	
	LinkedList<String> guests = new LinkedList<String>();
	
	public EventLL(LinkedList<String> guestList)
	{
		guests = guestList;
	}
	
	public void addElt(String elt)
	{
		guests.add(elt);
			
	}
	public boolean hasElt(String elt)
	{
	for(String thisString : guests)
	{
		if(thisString.equals(elt))
			return true;
	}
	return false;
	}
	public int size()
	{
	return guests.size();	
	}

}
