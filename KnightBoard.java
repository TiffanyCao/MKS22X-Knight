public class KnightBoard{

  private int[][] board;

/**
@throws IllegalArgumentException when either parameter is negative.
Initialize the board to the correct size and make them all 0's
*/
public KnightBoard(int startingRows,int startingCols){
  if(startingRows < 0 || startingCols < 0) throw new IllegalArgumentException();
  board = new int[startingRows][startingCols];
}


}
