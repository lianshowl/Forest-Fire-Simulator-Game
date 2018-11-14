public class lianshowlDefense implements Defense {

	  lianshowlPeople[] fighters = new lianshowlPeople[2];		//2 firemen
	  
	  public lianshowlDefense()
	  {
	    this.fighters[0] = new lianshowlPeople(6, 7, false);			//must start here
	    this.fighters[1] = new lianshowlPeople(7, 7, false);			//must start here
	  }
	  
	  public FighterMove getInitialPosition(int pos)
	  {
	    return new FighterMove(this.fighters[(pos - 1)].getX(), this.fighters[(pos - 1)].getY(), this.fighters[(pos - 1)].getStatus());
	  }
	  
	  public FighterMove move(int pos)
	  {
	    int i = pos - 1;
	    updateInfo();
	    if (douse(this.fighters[i].getX(), this.fighters[i].getY()))
	    {
	      this.fighters[i].setStatus(true);
	    }
	    else
	    {
	      this.fighters[i].setStatus(false);
	      moveFighter(pos);
	    }
	    return new FighterMove(this.fighters[i].x, this.fighters[i].y, this.fighters[i].status);
	  }
	  
	  public void updateInfo()
	  {
	    for (int i = 0; i < 2; i++) {
	      for (int j = 0; j < 8; j++) {
	        for (int k = 0; k < 8; k++) {
	          if (Game.getOccupancyStatus(j, k) == i + 1)
	          {
	            this.fighters[i].setX(j);
	            this.fighters[i].setY(k);
	            break;
	          }
	        }
	      }
	    }
	  }
	  
	  public long randomize()		//moves randomly
	  {
	    return UniformRandom.uniform(1L, 4L);
	  }
	  
	  
	  public boolean moveFighter(int m)
	  {
	    boolean b = true;
	    if (randomize() == 1L)
	    {
	      if ((!moveDown(m)) && 
	        (!moveLeft(m)) && 
	        (!moveRight(m)) && 
	        (!moveUp(m))) {
	        b = false;
	      }
	    }
	    else if (randomize() == 2L)
	    {
	      if ((!moveLeft(m)) && 
	        (!moveDown(m)) && 
	        (!moveRight(m)) && 
	        (!moveUp(m))) {
	        b = false;
	      }
	    }
	    else if (randomize() == 3L)
	    {
	      if ((!moveRight(m)) && 
	        (!moveLeft(m)) && 
	        (!moveDown(m)) && 
	        (!moveUp(m))) {
	        b = false;
	      }
	    }
	    else if ((!moveUp(m)) && 
	      (!moveRight(m)) && 
	      (!moveLeft(m)) && 
	      (!moveDown(m))) {
	      b = false;
	    }
	    return b;
	  }
	  
	  public boolean moveX(int x)		//checking to see movement to the x coord
	  {
	    if ((!moveRight(x)) && 
	      (!moveLeft(x))) {
	      return false;
	    }
	    return true;
	  }
	  
	  public boolean moveY(int y)		//checking to see movement to the y coord
	  {
	    if ((!moveDown(y)) && 
	      (!moveUp(y))) {
	      return false;
	    }
	    return true;
	  }
	  
	  public boolean moveLeft(int l)			//checking to see if can move left
	  {
	    int i = l - 1;
	    int j = this.fighters[i].getX() - 1;
	    if (j < 0) {
	      return false;
	    }
	    int k = Game.getOccupancyStatus(j, this.fighters[i].getY());		//seeing if there is anything in this cell
	    if ((l == 1) && 
	      (k == 2)) {
	      return false;
	    }
	    if ((l == 2) && 
	      (k == 1)) {
	      return false;
	    }
	    this.fighters[i].setX(j);
	    return true;
	  }
	  
	  public boolean moveRight(int r)			//checking to see if can move right
	  {
	    int i = r - 1;
	    int j = this.fighters[i].getX() + 1;
	    if (j > 7) {
	      return false;
	    }
	    int k = Game.getOccupancyStatus(j, this.fighters[i].getY());	//seeing if there is anything in this cell
	    if ((r == 1) && 
	      (k == 2)) {
	      return false;
	    }
	    if ((r == 2) && 
	      (k == 1)) {
	      return false;
	    }
	    this.fighters[i].setX(j);
	    return true;
	  }
	  
	  public boolean moveUp(int up)
	  {
	    int i = up - 1;
	    int j = this.fighters[i].getY() - 1;
	    if (j < 0) {
	      return false;
	    }
	    int k = Game.getOccupancyStatus(this.fighters[i].getX(), j);		//seeing if there is anything in this cell
	    if ((up == 1) && 
	      (k == 2)) {
	      return false;
	    }
	    if ((up == 2) && 
	      (k == 1)) {
	      return false;
	    }
	    this.fighters[i].setY(j);
	    return true;
	  }
	  
	  public boolean moveDown(int d)
	  {
	    int i = d - 1;
	    int j = this.fighters[i].getY() + 1;
	    if (j > 7) {
	      return false;
	    }
	    int k = Game.getOccupancyStatus(this.fighters[i].getX(), j);  //seeing if there is anything in this cell
	    if ((d == 1) && 
	      (k == 2)) {
	      return false;
	    }
	    if ((d == 2) && 
	      (k == 1)) {
	      return false;
	    }
	    this.fighters[i].setY(j);
	    return true;
	  }
	  
	  public boolean douse(int a, int b)				//checking if they can douse the tree
	  {
	    int i = Game.getTreeStatus(a, b);
	    if ((i == 0) || (i == -3) || (i == -4)) {
	      return false;
	    }
	    return true;
	  }
}

