public class lianshowlPeople
{
  int x;
  int y;
  boolean status;
  
  public lianshowlPeople(int x, int y, boolean stat)
  {
    this.x = x;
    this.y = y;
    this.status = stat;
  }
  
  public String toString()
  {
    String str = "";
    if (this.status == true) {
      str = "T";
    } else {
      str = "F";
    }
    return this.x + " " + this.y + " " + str;
  }
  
  public boolean getStatus()			//info about the board
  {
    return this.status;
  }
  
  public int getX()				
  {
    return this.x;
  }
  
  public int getY()
  {
    return this.y;
  }
  
  public void setStatus(boolean stat)
  {
    this.status = stat;
  }
  
  public void setX(int x)
  {
    this.x = x;
  }
  
  public void setY(int y)
  {
    this.y = y;
  }
}