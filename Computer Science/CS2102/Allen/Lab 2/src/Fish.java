class Fish extends AbsAnimal {
    double salinity; 

    Fish (int length, double salinity) {
      super(length);
      this.salinity = salinity;
    }

    public boolean isNormalSize () {
        return 1 <= this.length && this.length <= 15;
      }
    
   public boolean isDangerToPeople()
    {
  	  return false;
    }
    
  }
