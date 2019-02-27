public class Driver{
  public static void main(String[] args){
    /*KnightBoard k = new KnightBoard(5, 5);
    System.out.println("---Testing Solve---");
    System.out.println("*printing 5x5 board:");
    System.out.println(k);
    System.out.println("\n*testing solve0(0, 0): should return true");
    System.out.println(k.solve0(0, 0));
    System.out.println(k);
    k.reset();

    System.out.println("\n*testing solve0(4, 4): should return true");
    System.out.println(k.solve0(4, 4));
    System.out.println(k);
    k.reset();

    System.out.println("\n*testing countSolutions(0, 0): should return 2432");
    System.out.println(k.countSolutions(0, 0));
    k.reset();
    System.out.println("\n*testing countSolutions(4, 4): should return 2432");
    System.out.println(k.countSolutions(4, 4));
    */

    KnightBoard one = new KnightBoard(1, 1);
    KnightBoard two = new KnightBoard(2, 4);
    KnightBoard three = new KnightBoard(3, 3);
    KnightBoard four = new KnightBoard(4, 6);
    KnightBoard five = new KnightBoard(5, 5);
    KnightBoard six = new KnightBoard(6, 3);
    KnightBoard seven = new KnightBoard(7, 10);
    KnightBoard eight = new KnightBoard(8, 4);

    /*System.out.println("*printing 1x1:\n" + one);
    System.out.println("*printing solve0(0,0):\n" + one.solve0(0,0));
    System.out.println(one);
    System.out.println("*printing 2x4:\n" + two);
    System.out.println("*printing solve0(0,0):\n" + two.solve0(0,0));
    System.out.println(two);
    System.out.println("*printing 3x3:\n" + three);
    System.out.println("*printing solve0(0,0):\n" + three.solve0(0,0));
    System.out.println(three);
    System.out.println("*printing 4x6:\n" + four);
    System.out.println("*printing solve0(0,0):\n" + four.solve0(0,0));
    System.out.println(four);
    System.out.println("*printing 5x5:\n" + five);
    System.out.println("*printing solve0(0,0):\n" + five.solve0(0,0));
    System.out.println(five);
    System.out.println("*printing 6x3:\n" + six);
    System.out.println("*printing solve0(0,0):\n" + six.solve0(0,0));
    System.out.println(six);
    System.out.println("*printing 7x10:\n" + seven);
    System.out.println("*printing solve0(0,0):\n" + seven.solve0(0,0));
    System.out.println(seven);
    System.out.println("*printing 8x4:\n" + eight);
    System.out.println("*printing solve0(0,0):\n" + eight.solve0(0,0));
    System.out.println(eight);

    one.reset();
    two.reset();
    three.reset();
    four.reset();
    five.reset();
    six.reset();
    seven.reset();
    eight.reset();

    System.out.println("1x1 countSolutions(0, 0): " + one.countSolutions(0, 0));
    System.out.println("2x4 countSolutions(0, 0): " + two.countSolutions(0, 0));
    System.out.println("3x3 countSolutions(0, 0): " + three.countSolutions(0, 0));
    System.out.println("4x6 countSolutions(0, 0): " + four.countSolutions(0, 0));
    System.out.println("5x5 countSolutions(0, 0): " + five.countSolutions(0, 0));
    System.out.println("6x3 countSolutions(0, 0): " + six.countSolutions(0, 0));
    //took too long- System.out.println("7x10 countSolutions(0, 0): " + seven.countSolutions(0, 0));
    //took too long- System.out.println("8x4 countSolutions(0, 0): " + eight.countSolutions(0, 0));

//FOR TESTING OPTIMIZATION

    four.reset();
    five.reset();

    System.out.println(four.optBoard());
    System.out.println(four.optOriginal());
    System.out.println(four);
    System.out.println(four.optM(four.opt[0][0].move));
    System.out.println(four.optM(four.opt[1][2].move));

    four.makeMove2(0, 0, 1);
    System.out.println(four);
    System.out.println(four.optBoard());
    System.out.println(four.optOriginal());

    System.out.println(four.optM(four.opt[1][2].move));
    System.out.println(four.optM(four.sort(1, 2, four.opt[1][2].move)));
    System.out.println(four.optM(four.opt[2][3].move));
    System.out.println(four.optM(four.sort(2, 3, four.opt[2][3].move)));
    System.out.println(four.findS(four.opt[1][2].move));
    System.out.println(four.findS(four.opt[2][3].move));
    System.out.println(four.optM(four.opt[3][3].move));
    System.out.println(four.optM(four.sort(3, 3, four.opt[3][3].move)));
    System.out.println(four.findS(four.opt[3][3].move));
    four.makeMove2(2, 1, 2);
    System.out.println(four.optBoard());
    System.out.println(four);
    System.out.println(four.optM(four.opt[0][0].move));
    System.out.println(four.optM(four.opt[3][3].move));
    four.undoMove2(2, 1);
    System.out.println(four);
    System.out.println(four.optM(four.opt[0][0].move));
    System.out.println(four.optM(four.opt[3][3].move));
    System.out.println(four.optBoard());
    four.makeMove2(1, 2, 2);
    System.out.println(four);
    System.out.println(four.optBoard());
    System.out.println(four.optM(four.opt[0][0].move));
    four.makeMove2(2, 1, 3);
    System.out.println(four);
    System.out.println(four.optOriginal());
    System.out.println(four.optM(four.opt[0][0].move));
    System.out.println(four.optM(four.opt[3][3].move));
    System.out.println(four.optM(four.opt[1][3].move));

    four.reset();
    System.out.println(four);
    System.out.println(four.optBoard());
    System.out.println(four.optM(four.opt[0][0].move));
    System.out.println(four.solve(0, 0));
    System.out.println(four);
    four.solve0(0, 0);
    System.out.println(four);
    System.out.println(four.optBoard());
    System.out.println(four.optM(four.opt[0][0].move));

    System.out.println(five);
    System.out.println(five.optM(0, 0));
    System.out.println(five.solve(0, 0));
    System.out.println(five);
    five.solve0(0, 0);
    System.out.println(five);
    System.out.println(five.optBoard());
    System.out.println(five.optM(0, 0));

    System.out.println("*printing 1x1:\n" + one);
    System.out.println("*printing solve(0,0):\n" + one.solve(0,0));
    System.out.println(one);
    System.out.println("*printing 2x4:\n" + two);
    System.out.println("*printing solve(0,0):\n" + two.solve(0,0));
    System.out.println(two);
    System.out.println("*printing 3x3:\n" + three);
    System.out.println("*printing solve(0,0):\n" + three.solve(0,0));
    System.out.println(three);
    System.out.println("*printing 4x6:\n" + four);
    System.out.println("*printing solve(0,0):\n" + four.solve(0,0));
    System.out.println(four);
    System.out.println("*printing 5x5:\n" + five);
    System.out.println("*printing solve(0,0):\n" + five.solve(0,0));
    System.out.println(five);
    System.out.println("*printing 6x3:\n" + six);
    System.out.println("*printing solve(0,0):\n" + six.solve(0,0));
    System.out.println(six);
    //System.out.println("*printing 7x10:\n" + seven);
    //System.out.println("*printing solve(0,0):\n" + seven.solve(0,0));
    //System.out.println(seven);
    System.out.println("*printing 8x4:\n" + eight);
    System.out.println("*printing solve(0,0):\n" + eight.solve(0,0));
    System.out.println(eight);
*/

    for(int i = 0; i < 5; i++){
      runTest(i);
    }

    for(int i = 1; i < 6; i++){
      KnightBoard test = new KnightBoard(i, i);
      System.out.println(test.solve0(0, 0));
      System.out.println(test);
      test.reset();
      System.out.println(test.solve(0, 0));
      System.out.println(test);
      test.reset();
      System.out.println(test.countSolutions(0, 0));
    }

    KnightBoard test = new KnightBoard(4, 6);
    System.out.println(test.solve0(0, 0));
    System.out.println(test);
    test.reset();
    System.out.println(test.solve(0, 0));
    System.out.println(test);
    test.reset();
    System.out.println(test.countSolutions(0, 0));
}
    //testcase must be a valid index of your input/output array
    public static void runTest(int i){

    KnightBoard b;
    int[]m =   {4,5,5,5,5};
    int[]n =   {4,5,4,5,5};
    int[]startx = {0,0,0,1,2};
    int[]starty = {0,0,0,1,2};
    int[]answers = {0,304,32,56,64};
    if(i >= 0 ){
      try{
        int correct = answers[i];
        b = new KnightBoard(m[i%m.length],n[i%m.length]);

        int ans  = b.countSolutions(startx[i],starty[i]);

        if(correct==ans){
          System.out.println("PASS board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans);
        }else{
          System.out.println("FAIL board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans+" vs "+correct);
        }
      }catch(Exception e){
        System.out.println("FAIL Exception case: "+i);

      }
    }
  }



}
