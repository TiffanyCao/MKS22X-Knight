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
  *blank boards display 0's as underscores
  *you get a blank board if you never called solve or
  *when there is no solution
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

  public boolean makeMove(int r, int c, int type, int count){
    if(type == 0){
      if((r + moves[0][0] >= 0 && r + moves[0][0] < board.length) &&
         (c + moves[0][1] >= 0 && c + moves[0][1] < board[r].length) &&
         board[r + moves[0][0]][c + moves[0][1]] == 0){
        board[r + moves[0][0]][c + moves[0][1]] = count;
        return true;
      }
    }
    if(type == 1){
      if((r + moves[1][0] >= 0 && r + moves[1][0] < board.length) &&
         (c + moves[1][1] >= 0 && c + moves[1][1] < board[r].length) &&
         board[r + moves[1][0]][c + moves[1][1]] == 0){
        board[r + moves[1][0]][c + moves[1][1]] = count;
        return true;
      }
    }
    if(type == 2){
      if((r + moves[2][0] >= 0 && r + moves[2][0] < board.length) &&
         (c + moves[2][1] >= 0 && c + moves[2][1] < board[r].length) &&
         board[r + moves[2][0]][c + moves[2][1]] == 0){
        board[r + moves[2][0]][c + moves[2][1]] = count;
        return true;
      }
    }
    if(type == 3){
      if((r + moves[3][0] >= 0 && r + moves[3][0] < board.length) &&
         (c + moves[3][1] >= 0 && c + moves[3][1] < board[r].length) &&
         board[r + moves[3][0]][c + moves[3][1]] == 0){
        board[r + moves[3][0]][c + moves[3][1]] = count;
        return true;
      }
    }
    if(type == 4){
      if((r + moves[4][0] >= 0 && r + moves[4][0] < board.length) &&
         (c + moves[4][1] >= 0 && c + moves[4][1] < board[r].length) &&
         board[r + moves[4][0]][c + moves[4][1]] == 0){
        board[r + moves[4][0]][c + moves[4][1]] = count;
        return true;
      }
    }
    if(type == 5){
      if((r + moves[5][0] >= 0 && r + moves[5][0] < board.length) &&
         (c + moves[5][1] >= 0 && c + moves[5][1] < board[r].length) &&
         board[r + moves[5][0]][c + moves[5][1]] == 0){
        board[r + moves[5][0]][c + moves[5][1]] = count;
        return true;
      }
    }
    if(type == 6){
      if((r + moves[6][0] >= 0 && r + moves[6][0] < board.length) &&
         (c + moves[6][1] >= 0 && c + moves[6][1] < board[r].length) &&
         board[r + moves[6][0]][c + moves[6][1]] == 0){
        board[r + moves[6][0]][c + moves[6][1]] = count;
        return true;
      }
    }
    if(type == 7){
      if((r + moves[7][0] >= 0 && r + moves[7][0] < board.length) &&
         (c + moves[7][1] >= 0 && c + moves[7][1] < board[r].length) &&
         board[r + moves[7][0]][c + moves[7][1]] == 0){
        board[r + moves[7][0]][c + moves[7][1]] = count;
        return true;
      }
    }
    return false;
  }

  public boolean undoMove(int r, int c, int type){
    if(type == 0){
      if((r + moves[0][0] >= 0 && r + moves[0][0] < board.length) &&
         (c + moves[0][1] >= 0 && c + moves[0][1] < board[r].length) &&
         board[r + moves[0][0]][c + moves[0][1]] != 0){
        board[r + moves[0][0]][c + moves[0][1]] = 0;
        return true;
      }
    }
    if(type == 1){
      if((r + moves[1][0] >= 0 && r + moves[1][0] < board.length) &&
         (c + moves[1][1] >= 0 && c + moves[1][1] < board[r].length) &&
         board[r + moves[1][0]][c + moves[1][1]] != 0){
        board[r + moves[1][0]][c + moves[1][1]] = 0;
        return true;
      }
    }
    if(type == 2){
      if((r + moves[2][0] >= 0 && r + moves[2][0] < board.length) &&
         (c + moves[2][1] >= 0 && c + moves[2][1] < board[r].length) &&
         board[r + moves[2][0]][c + moves[2][1]] != 0){
        board[r + moves[2][0]][c + moves[2][1]] = 0;
        return true;
      }
    }
    if(type == 3){
      if((r + moves[3][0] >= 0 && r + moves[3][0] < board.length) &&
         (c + moves[3][1] >= 0 && c + moves[3][1] < board[r].length) &&
         board[r + moves[3][0]][c + moves[3][1]] != 0){
        board[r + moves[3][0]][c + moves[3][1]] = 0;
        return true;
      }
    }
    if(type == 4){
      if((r + moves[4][0] >= 0 && r + moves[4][0] < board.length) &&
         (c + moves[4][1] >= 0 && c + moves[4][1] < board[r].length) &&
         board[r + moves[4][0]][c + moves[4][1]] != 0){
        board[r + moves[4][0]][c + moves[4][1]] = 0;
        return true;
      }
    }
    if(type == 5){
      if((r + moves[5][0] >= 0 && r + moves[5][0] < board.length) &&
         (c + moves[5][1] >= 0 && c + moves[5][1] < board[r].length) &&
         board[r + moves[5][0]][c + moves[5][1]] != 0){
        board[r + moves[5][0]][c + moves[5][1]] = 0;
        return true;
      }
    }
    if(type == 6){
      if((r + moves[6][0] >= 0 && r + moves[6][0] < board.length) &&
         (c + moves[6][1] >= 0 && c + moves[6][1] < board[r].length) &&
         board[r + moves[6][0]][c + moves[6][1]] != 0){
        board[r + moves[6][0]][c + moves[6][1]] = 0;
        return true;
      }
    }
    if(type == 7){
      if((r + moves[7][0] >= 0 && r + moves[7][0] < board.length) &&
         (c + moves[7][1] >= 0 && c + moves[7][1] < board[r].length) &&
         board[r + moves[7][0]][c + moves[7][1]] != 0){
        board[r + moves[7][0]][c + moves[7][1]] = 0;
        return true;
      }
    }
    return false;
  }

  public boolean isFull(){
    for(int i = 0; i < board.length; i++){
      for(int y = 0; y < board[i].length; y++){
        if(board[i][y] == 0) return false;
      }
    }
    return true;
  }

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
  *@return boolean if the board can be solved or not
  */
  public boolean solve(int startRow, int startCol){
    if((startRow < 0 || startRow >= board.length) ||
       (startCol < 0 || startCol >= board[0].length)){
      throw new IllegalArgumentException();
    }
    if(!isEmpty()) return false;
    return solveH(startRow, startCol, 1);
  }

  public boolean solveH(int r, int c, int count){
    if(isFull()) return true;
    for(int i = 0; i < moves.length; i++){
      if(makeMove(r, c, i, count)){
        if(solveH(r + moves[i][0], c + moves[i][1], count+1)){
          return true;
        }
        undoMove(r, c, i);
      }
    }
    return false;
  }

  public static void main(String[] args){

    KnightBoard one = new KnightBoard(5, 5);
    System.out.println(one);
  }
}
