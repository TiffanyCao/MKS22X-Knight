import java.util.*;

public class Optimize{
  public int optOriginal;
  public int numMoves; //number of moves from this square
  public ArrayList<int[]> move; //list of possible moves

  public Optimize(){ //initialize the object
    numMoves = 0;
    optOriginal = 0;
    move = new ArrayList<int[]>();
  }
}
