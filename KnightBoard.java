import java.util.*;

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
  public Optimize[][] opt;

  /**A constructor of the knight board
  *@param int startingRows
  *@param int startingCols
  *@throws IllegalArgumentException when either parameter is negative.
  *Initialize the board to the correct size and make them all 0's
  */
  public KnightBoard(int startingRows,int startingCols){
    if(startingRows < 0 || startingCols < 0) throw new IllegalArgumentException();
    board = new int[startingRows][startingCols];
    makeZero(); //make all 0's
    opt = new Optimize[startingRows][startingCols];
    optimize(); //fill in the number of moves possible for each square
    for(int i = 0; i < opt.length; i++){
      for(int y = 0; y < opt[i].length; y++){
        sort(i, y, opt[i][y].move); //makes all the lists in order of closest to farthest from edge
      }
    }
  }

  /**A method that clears the board and makes it all 0's
  */
  public void makeZero(){
    for(int i = 0; i < board.length; i++){
      for(int y = 0; y < board[i].length; y++){
        board[i][y] = 0;
      }
    }
  }

  /**A method that clears the board and makes it all 0's and resets the optimization
  */
  public void reset(){
    makeZero(); //makes zero
    for(int i = 0; i < board.length; i++){
      for(int y = 0; y < board[i].length; y++){
        opt[i][y].numMoves = opt[i][y].optOriginal;
        possMoves(i, y);
        sort(i, y, opt[i][y].move);
      }
    }
  }

  /**A method that fills in the optimizing board with the number of possible moves for each square
  */
  public void optimize(){
    int row = opt.length;
    int col = opt[0].length;
    for(int i = 0; i < row; i++){ //initialize the opt board
      for(int y = 0; y < col; y++){
        opt[i][y] = new Optimize();
      }
    }
    if(row == col && row > 3){ //shortcut to optimizing board if the board is square and greater than a 3x3
      for(int i = 0; i < opt.length; i++){
        for(int y = 0; y < opt[i].length; y++){
          if((i == 0 || i == row - 1) && (y == 0 || y == col - 1)){ //the squares with 2 moves
            opt[i][y].numMoves = 2;
            opt[i][y].optOriginal = 2;
            possMoves(i, y);
          }else if(((i == 0  || i == row - 1) && (y == 1 || y == col - 2)) ||
                   ((i == 1 || i == row - 2) && (y == 0 || y == col - 1))){ //the squares with 3 moves
            opt[i][y].numMoves = 3;
            opt[i][y].optOriginal = 3;
            possMoves(i, y);
          }else if((i == 0 || i == row - 1 || y == 0 || y == col - 1) ||
                   ((i == 1 || i == row - 2) && (y == 1 || y == col - 2))){ //the squares with 3 moves
            opt[i][y].numMoves = 4;
            opt[i][y].optOriginal = 4;
            possMoves(i, y);
          }else if(i == 1 || i == row - 2 || y == 1 || y == col - 2){ //the squares with 4 moves
            opt[i][y].numMoves = 6;
            opt[i][y].optOriginal = 6;
            possMoves(i, y);
          }else{ //the rest of the squares have 8 moves
            opt[i][y].numMoves = 8;
            opt[i][y].optOriginal = 8;
            possMoves(i, y);
          }
        }
      }
    }else{ //all the other boards use this
      for(int i = 0; i < opt.length; i++){
        for(int y = 0; y < opt[i].length; y++){
          opt[i][y].optOriginal = possMoves(i, y); //finds all possible moves
        }
      }
    }
  }

  /**A method that figures out the number of possible moves from a given square
  *Each possible move is added to a list of possible moves for that square
  *@param int r is the current row
  *@param int c is the current column
  *@return the number of possible moves that can be made
  */
  public int possMoves(int r, int c){
    int count = 0;
    ArrayList<int[]> m = new ArrayList<int[]>();
    for(int i = 0; i < moves.length; i++){ //loops through all moves to see if it's possible
      if((r + moves[i][0] >= 0) && (r + moves[i][0] < opt.length) &&
         (c + moves[i][1] >= 0) && (c + moves[i][1] < opt[r].length) &&
         (board[r + moves[i][0]][c + moves[i][1]] == 0)){
        count++;
        int[] temp = {r + moves[i][0], c + moves[i][1]}; //adds coordinate to list
        m.add(temp);
      }
    }
    opt[r][c].move = m;
    opt[r][c].numMoves = count;
    return count;
  }

  /**A method that sorts a list of possible moves by looking at the number of moves the resulting square has
  *@param int r is the row
  *@param int c is the column
  *@return ArrayList<int[]> the ordered list, from closest to farthest from the edge
  */
  public ArrayList<int[]> sort(int r, int c, ArrayList<int[]> a){
    int size = a.size();
    ArrayList<int[]> b = new ArrayList<int[]>();
    while(a.size() != 0){
      int index = findS(a); //finds the move that will bring the knight closer to the edge
      int[] temp = a.get(index);
      b.add(temp); //add that to a new list
      a.remove(index); //remove that from the current
    }
    opt[r][c].move = b; //set the variable to the new ordered list
    return b;
  }

  /**A helper method that finds the move that will bring the knight closer to the edge
  *This is done by using the fact that squares closer to the edge have fewer possible moves
  *@param ArrayList<Integer> l is the current list of possible moves
  *@return int the index of the move that will bring the knight closest to the edge
  */
  public int findS(ArrayList<int[]> l){
    int index = 0;
    for(int i = 1; i < l.size(); i++){ //loops through list
      int[] temp = l.get(index);
      int[] temp2 = l.get(i);
      if(opt[temp2[0]][temp2[1]].numMoves < opt[temp[0]][temp[1]].numMoves){
        index = i; //if the number of moves at the resulting square of this move is smaller than the number of moves
                   //at the resulting square of the move at the previous index
      }
    }
    return index; //returns the index of the move that will bring the knight closest to the edge
  }

  /**A method that prints out the ArrayList<int[]> based on which square is given
  *the ArrayList<int[]> is the coordinate of possible moves, ordered from closest to farthest from the edge
  *@return String
  */
  public String optM(int r, int c){
    ArrayList<int[]> temp = opt[r][c].move;
    String result = "";
    for(int i = 0; i < temp.size(); i++){
      int[] tem = temp.get(i);
      result += "["+tem[0]+", "+tem[1]+"]\n"; //coordinates
    }
    return result;
  }

  /**A method that prints out the ArrayList<int[]> given
  *@return String
  */
  public String optM(ArrayList<int[]> l){
    String result = "";
    for(int i = 0; i < l.size(); i++){
      int[] tem = l.get(i);
      result += "["+tem[0]+", "+tem[1]+"]\n"; //coordinates
    }
    return result;
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

  /**A method that prints out the board which contains the current number of available moves for each square
  *@return the board in string form
  */
  public String optBoard(){
    String result = "";
    for(int i = 0; i < opt.length; i++){
      for(int y = 0; y < opt[i].length; y++){
        result += opt[i][y].numMoves + " ";
        if(y == opt[i].length - 1) result += "\n";
      }
    }
    return result;
  }

  /**A method that prints out the original optimizing board which contains the original possible moves for each square
  *@return the board in string form
  */
  public String optOriginal(){
    String result = "";
    for(int i = 0; i < opt.length; i++){
      for(int y = 0; y < opt[i].length; y++){
        result += opt[i][y].optOriginal + " ";
        if(y == opt[i].length - 1) result += "\n";
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

  /**A helping method that makes a move for the knight for an optimized board
  *it marks the square on the board with the move number
  *this method also updates the moves possible and number of moves for each square
  *@param int r is the current row
  *@param int c is the current column
  *@param int count is the move number
  *@return boolean false if the square is out of bounds or already has a number
  *                true if a move is possible
  */
  public boolean makeMove2(int r, int c, int count){
    if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
    if(board[r][c] != 0) return false;
    board[r][c] = count;
    for(int i = 0; i < board.length; i++){ //updates board
      for(int y = 0; y < board[i].length; y++){
        possMoves(i, y);
        sort(i, y, opt[i][y].move);
      }
    }
    return true;
  }

  /**A helping method that removes a move for the knight for an optimized board
  *it unmarks the square on the board with a 0
  *this method also updates the moves possible and number of moves for each square
  *@param int r is the current row
  *@param int c is the current column
  *@return boolean false if the square is out of bounds or doesn't have a number (is 0)
  *                true if unmarking is possible
  */
  public boolean undoMove2(int r, int c){
    if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
    if(board[r][c] == 0) return false;
    board[r][c] = 0;
    for(int i = 0; i < board.length; i++){ //updates board
      for(int y = 0; y < board[i].length; y++){
        possMoves(i, y);
        sort(i, y, opt[i][y].move);
      }
    }
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
  *@throws IllegalStateException if the board is not empty
  */
  public boolean solve0(int startRow, int startCol){
    if((startRow < 0 || startRow >= board.length) ||
       (startCol < 0 || startCol >= board[0].length)){
      throw new IllegalArgumentException();
    }
    if(!isEmpty()){ //if the board is not empty
      throw new IllegalStateException();
    }
    return solveH(startRow, startCol, 1); //calls to helper method
  }

  /**A helper recursive method for solving a knight board and labels the placing
  *@param int r is the current row
  *@param int c is the current column
  *@param int count is the move number
  *@return boolean if the board can be solved or not
  */
  private boolean solveH(int r, int c, int count){
    if(count > (board.length*board[0].length)) return true; //if all the squares are filled
    for(int i = 0; i < moves.length; i++){ //loops through all possible moves
      if(makeMove(r, c, count)){
        if(solveH(r + moves[i][0], c + moves[i][1], count+1)){ //if move is possible, check next move
          return true;
        }
        undoMove(r, c); //undo the move if it won't reach a solution
      }
    }
    return false;
  }

  /**A method for solving a knight board and labels the placing, with optimization
  *should work on boards where the number of squares is under 100
  *@param int startRow
  *@param int startCol
  *@return boolean if the board can be solved or not
  *@throws IllegalArgumentException if the starting position is out of bounds
  *@throws IllegalStateException if the board is not empty
  */
  public boolean solve(int startRow, int startCol){
    if((startRow < 0 || startRow >= board.length) ||
       (startCol < 0 || startCol >= board[0].length)){
      throw new IllegalArgumentException();
    }
    if(!isEmpty()){ //if the board is not empty
      throw new IllegalStateException();
    }
    if(board.length*board[0].length == 1){ //if the board is 1X1
      board[startRow][startCol] = 1;
      return true;
    }
    return solveH2(startRow, startCol, 1); //calls to helper method
  }

  /**A helper recursive method for solving a knight board and labels the placing, with optimization
  *@param int r is the current row
  *@param int c is the current column
  *@param int count is the move number
  *@return boolean if the board can be solved or not
  */
  private boolean solveH2(int r, int c, int count){
    if(count > (board.length*board[0].length)) return true; //if all the squares are filled
    if(board[r][c] != 0) return false; //if a knight can't be placed
    //possMoves(r, c);
    //sort(r, c, opt[r][c].move);
    for(int i = 0; i < opt[r][c].move.size(); i++){ //loops through all possible moves
      makeMove(r, c, count); //places the knight
      //if(solveH(r + moves[opt[r][c].move.get(i)][0], c + moves[opt[r][c].move.get(i)][1], count+1)){ //if move is possible, check next move
      int[] temp = opt[r][c].move.get(i); //get the next coordinate
      if(solveH2(temp[0], temp[1], count+1)){ //tests the coordinate
        return true;
      }
      undoMove(r, c); //undo the move if it won't reach a solution
    }
    return false;
  }

  /**A method that counts the number of possible solutions of knight board from a given starting position
  *@throws IllegalStateException when the board contains non-zero values.
  *@throws IllegalArgumentException when either parameter is negative
  *or out of bounds.
  *@param int startRow
  *@param int startCol
  *@return the number of solutions from the starting position specified
  */
  public int countSolutions0(int startRow, int startCol){
    if(!isEmpty()) throw new IllegalStateException();
    if((startRow < 0 || startRow >= board.length) ||
       (startCol < 0 || startCol >= board[0].length)){
      throw new IllegalArgumentException();
    }
    if(!isEmpty()) throw new IllegalStateException(); //if the board is not empty
    return countH(startRow, startCol, 1); //calls to helper method
  }

  /**A recursive helper method that counts all the possible knight board solutions,
  *starting from the given position
  *@param int r is current row
  *@param int c is the current column
  *@param int count is the move number
  *@return int the number of solutions
  */
  private int countH(int r, int c, int count){
    int solutions = 0; //counting the number of solutions
    if(count > (board.length*board[0].length)) return 1; //if all spaces are filled, that counts as a solution
    for(int i = 0; i < moves.length; i++){ //loops through all possible moves
      if(makeMove(r, c, count)){
        solutions += countH(r + moves[i][0], c + moves[i][1], count+1); //adds 1 if there's a solution, 0 otherwise
        undoMove(r, c); //undo the move for the testing the next possible move pattern
      }
    }
    return solutions;
  }

  /**A method that counts the number of possible solutions of knight board from a given starting position using optimization
  *@throws IllegalStateException when the board contains non-zero values.
  *@throws IllegalArgumentException when either parameter is negative
  *or out of bounds.
  *@param int startRow
  *@param int startCol
  *@return the number of solutions from the starting position specified
  */
  public int countSolutions(int startRow, int startCol){
    if(!isEmpty()) throw new IllegalStateException();
    if((startRow < 0 || startRow >= board.length) ||
       (startCol < 0 || startCol >= board[0].length)){
      throw new IllegalArgumentException();
    }
    if(!isEmpty()) throw new IllegalStateException(); //if the board is not empty
    board[startRow][startCol] = 1; //places first knight
    return countH2(startRow, startCol, 2); //calls to helper method
  }

  /**A recursive helper method that counts all the possible knight board solutions,
  *starting from the given position, using optimization
  *@param int r is current row
  *@param int c is the current column
  *@param int count is the move number
  *@return int the number of solutions
  */
  private int countH2(int r, int c, int count){
    int solutions = 0; //counting the number of solutions
    if(count > (board.length*board[0].length)) return 1; //if all spaces are filled, that counts as a solution
    for(int i = 0; i < opt[r][c].move.size(); i++){ //loops through all possible moves from this square
      int[] temp = opt[r][c].move.get(i); //gets the coordinate
      if(makeMove(temp[0], temp[1], count)){ //tests if knight can be placed on square
        solutions += countH2(temp[0], temp[1], count+1); //adds 1 if there's a solution, 0 otherwise
        undoMove(temp[0], temp[1]); //undo the move for the testing the next possible move pattern
      }
    }
    return solutions;
  }


  public static void main(String[] args){
    /*KnightBoard b1 = new KnightBoard(8, 8);
    System.out.println(b1.optBoard());
    System.out.println(b1.opt[4][2].move);

    KnightBoard b2 = new KnightBoard(7, 7);
    System.out.println(b2.optBoard());

    KnightBoard b3 = new KnightBoard(4, 4);
    System.out.println(b3.optBoard());

    KnightBoard b4 = new KnightBoard(5, 5);
    System.out.println(b4.optBoard());2  9


    KnightBoard b5 = new KnightBoard(3, 4);
    System.out.println(b5.optBoard());

    KnightBoard b6 = new KnightBoard(3, 3);
    System.out.println(b6.optBoard());
    */

    KnightBoard test = new KnightBoard(4, 3);
    test.solve0(0, 0);
    System.out.println(test);
    test.reset();
    System.out.println(test.solve(0,0));
    System.out.println(test);
    System.out.println(test.optM(test.opt[0][0].move));
    System.out.println(test.opt[0][0].move.size());
    System.out.println(test.optM(test.sort(0, 0, test.opt[0][0].move)));
    test.makeMove(0, 0, 1);
    System.out.println(test);
    int[] temp = test.opt[0][0].move.get(0);
    System.out.println("" + temp[0] + " " + temp[1]);
    test.possMoves(2, 1);
    test.sort(2, 1, test.opt[2][1].move);
    System.out.println(test.optM(test.opt[2][1].move));

    KnightBoard test2 = new KnightBoard(5, 5);
    test2.solve0(0, 0);
    System.out.println(test2);
    test2.reset();
    System.out.println(test2.solve(0, 0));
    System.out.println(test2);



  }

}
