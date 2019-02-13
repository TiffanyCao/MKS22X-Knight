public class KnightBoard{

  private int[][] board;

/**A constructor of the knight board
*@param int startingRows
*@param int startingCols
*@throws IllegalArgumentException when either parameter is negative.
*Initialize the board to the correct size and make them all 0's
*/
public KnightBoard(int startingRows,int startingCols){
  if(startingRows < 0 || startingCols < 0) throw new IllegalArgumentException();
  board = new int[startingRows][startingCols];
  empty(); //make all 0's
}

/**A method that clears the board and makes it all 0's
*/
public void empty(){
  for(int i = 0; i < board.length; i++){
    for(int y = 0; y < board[i].length; y++){
      board[i][y] = 0;
    }
  }
}

/**A method that prints out the board
*@return the board in string form
blank boards display 0's as underscores
you get a blank board if you never called solve or
when there is no solution
*/
public String toString(){
  String result = "";
  if(board.length * board[0].length >= 10){ //if there are two-digit numbers
    for(int i = 0; i < board.length; i++){
      for(int y = 0; y < board[i].length; y++){
        if(board[i][y] < 10) result += " " + board[i][y] + " ";
        if(board[i][y] >= 10) result += board[i][y] + " ";
        if(y == board[i].length - 1) result += "\n";
      }
    }
  }else{
    for(int i = 0; i < board.length; i++){ //if there aren't two-digit numbers
      for(int y = 0; y < board[i].length; y++){
        result += " " + board[i][y];
        if(y == board[i].length - 1) result += "\n";
      }
    }
  }
  return result;
}


}
