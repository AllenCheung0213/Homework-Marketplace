import java.util.LinkedList;

// A class for storing guests at a (potentially large) event

  class EventGuests {
     ISet guests;
    public EventGuests(LinkedList<String> guestList, String type)
    {
    	if(type.equals("LL"))
    	{
    		guests = new EventLL(guestList);
    	}
    	
    	if(type.equals("BST"))
    	{
    		guests = new EventBST(guestList);
    	}
    	
    	if(type.equals("AVL"))
    	{
    		guests = new EventAVL(guestList);
    	}
    }

  }