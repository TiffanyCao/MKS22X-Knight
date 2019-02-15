public class KnightBoard{

  private int[][] board;
  private int[][] moves = {{-2, -1},
                           {-2, 1},
                           {-1, -2},
                           {1, -2},
                           {2, -1},
                           {2, 1},
                           {-1, 2},
                           {1, 2}};

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
  *-blank boards display 0's as underscores
  *-you get a blank board if you never called solve or when there is no solution
  *-boards with more than or equal to ten squares will have two-digit numbers,
  * so single-digit numbers will have a space before then
  */
  public String toString(){
    String result = "";
    if(board.length * board[0].length >= 10){ //if there are two-digit numbers
      for(int i = 0; i < board.length; i++){
        for(int y = 0; y < board[i].length; y++){
          if(board[i][y] < 10) result += " " + board[i][y] + " "; //space in front of single-digit numbers
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

  /**A helping method that makes a move for the knight
  *it marks the square on the board with the move number
  *@param int r is the current row
  *@param int c is the current column
  *@param int count is the move number
  *@return boolean false if the square is out of bounds or already has a number
  *                true if a move is possible
  */
  public boolean makeMove(int r, int c, int count){
    if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
    if(board[r][c] != 0) return false;
    board[r][c] = count;
    return true;
  }

  /**A helping method that removes a move for the knight
  *it unmarks the square on the board with a 0
  *@param int r is the current row
  *@param int c is the current column
  *@return boolean false if the square is out of bounds or doesn't have a number (is 0)
  *                true if unmarking is possible
  */
  public boolean undoMove(int r, int c){
    if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
    if(board[r][c] == 0) return false;
    board[r][c] = 0;
    return true;
  }

  /**A method that checks if the board is full or completed
  *@return boolean
  */
  public boolean isFull(){
    for(int i = 0; i < board.length; i++){
      for(int y = 0; y < board[i].length; y++){
        if(board[i][y] == 0) return false;
      }
    }
    return true;
  }

  /**A method that checks if the board is empty
  *@return boolean
  */
  public boolean isEmpty(){
    for(int i = 0; i < board.length; i++){
        for(int y = 0; y < board[i].length; y++){
          if(board[i][y] != 0) return false;
        }
    }
    return true;
  }


  /**A method for solving a knight board and labels the placing
  *should work on boards where the number of squares is under 100
  *@param int startRow
  *@param int startCol
  *@return boolean if the board can be solved or not
  *@throws IllegalArgumentException if the starting position is out of bounds
  */
  public boolean solve(int startRow, int startCol){
    if((startRow < 0 || startRow >= board.length) ||
       (startCol < 0 || startCol >= board[0].length)){
      throw new IllegalArgumentException();
    }
    if(!isEmpty()) return false; //if the board already has numbers
    return solveH(startRow, startCol, 1); //calls to helper function
  }

  /**A helper recursive method for solving a knight board and labels the placing
  *@param int r
  *@param int c
  *@param int count is the move number
  *@return boolean if the board can be solved or not
  */
  private boolean solveH(int r, int c, int count){
    if(count > board.length*board[0].length) return true;
    for(int i = 0; i < moves.length; i++){
      if(makeMove(r, c, count)){
        if(solveH(r + moves[i][0], c + moves[i][1], count+1)){
          return true;
        }
        undoMove(r, c);
      }
    }
    return false;
  }

  public static void main(String[] args){

    KnightBoard one = new KnightBoard(5, 5);
    System.out.println("---Testing Solve---");
    System.out.println("*printing 5x5 board:");
    System.out.println(one);
    System.out.println("\n*testing solve(0, 0): should return true");
    System.out.println(one.solve(0, 0));
    System.out.println(one);

  }
}
