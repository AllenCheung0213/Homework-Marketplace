class Shark extends Fish {
    int attacks;

    
    public int getLength()
    {
    	return length;
    }
    
    Shark (int length, int attacks) {
      super(length, 3.75);
      this.attacks = attacks;
    }
 
    public boolean isNormalSize () {
        return (6 <= this.length);
      }
    
   public boolean isDangerToPeople()
    {
  	  if(attacks > 0)
  		  return true;
  	  return false;
    }
    
  }