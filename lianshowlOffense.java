public class lianshowlOffense implements Offense {
	
  lianshowlPeople pyro = new lianshowlPeople (0, 0, false);
  
  public PyroMove getInitialPosition()
  {
    return new PyroMove(this.pyro.getX(), this.pyro.getY(), this.pyro.getStatus());
  }
  
  public PyroMove move()		//must be a non-neighboring cell
  {
    updateInfo();
    if (ignite(this.pyro.getX(), this.pyro.getY()))
    {
      this.pyro.setStatus(true);
    }
    else
    {
      this.pyro.setStatus(false);
      boolean bool = movePyro();
    }
    return new PyroMove(this.pyro.getX(), this.pyro.getY(), this.pyro.getStatus());
  }
  
  public void updateInfo()
  {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (Game.getOccupancyStatus(i, j) == 3)
        {
          this.pyro.setX(i);
          this.pyro.setY(j);
          break;
        }
      }
    }
  }
  
  public long randomize()			//move randomly
  {
    return UniformRandom.uniform(1L, 4L);
  }
  
  public boolean movePyro()		//determine how the pyro will move
  {
    boolean b = true;
    if (randomize() == 1L)
    {
      if ((!moveDown()) && 
        (!moveLeft()) && 
        (!moveRight()) && 
        (!moveUp())) {
        b = false;
      }
    }
    else if (randomize() == 2L)
    {
      if ((!moveLeft()) && 
        (!moveDown()) && 
        (!moveRight()) && 
        (!moveUp())) {
        b = false;
      }
    }
    else if (randomize() == 3L)
    {
      if ((!moveRight()) && 
        (!moveLeft()) && 
        (!moveDown()) && 
        (!moveUp())) {
        b = false;
      }
    }
    else if ((!moveUp()) && 
      (!moveRight()) && 
      (!moveLeft()) && 
      (!moveDown())) {
      b = false;
    }
    return b;
  }
  
  public boolean moveX()
  {
    if ((!moveRight()) && 
      (!moveLeft())) {
      return false;
    }
    return true;
  }
  
  public boolean moveY()
  {
    if ((!moveDown()) && 
      (!moveUp())) {
      return false;
    }
    return true;
  }
  
  public boolean moveLeft()
  {
    int i = this.pyro.getX() - 1;
    if (i < 0) {
      return false;
    }
    int j = Game.getOccupancyStatus(i, this.pyro.getY());
    if ((j == 1) || (j == 2)) {
      return false;
    }
    this.pyro.setX(i);
    return true;
  }
  
  public boolean moveRight()
  {
    int i = this.pyro.getX() + 1;
    if (i > 7) {
      return false;
    }
    int j = Game.getOccupancyStatus(i, this.pyro.getY());
    if ((j == 1) || (j == 2)) {
      return false;
    }
    this.pyro.setX(i);
    return true;
  }
  
  public boolean moveUp()
  {
    int i = this.pyro.getY() - 1;
    if (i < 0) {
      return false;
    }
    int j = Game.getOccupancyStatus(this.pyro.getX(), i);
    if ((j == 1) || (j == 2)) {
      return false;
    }
    this.pyro.setY(i);
    return true;
  }
  
  public boolean moveDown()
  {
    int i = this.pyro.getY() + 1;
    if (i > 7) {
      return false;
    }
    int j = Game.getOccupancyStatus(this.pyro.getX(), i);
    if ((j == 1) || (j == 2)) {
      return false;
    }
    this.pyro.setY(i);
    return true;
  }
  
  public boolean ignite(int a, int b)
  {
    int i = Game.getTreeStatus(a, b);
    if (i == 1) {
      return true;
    }
    return false;
  }
}
