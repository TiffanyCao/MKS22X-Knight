public class Driver{
  public static void main(String[] args) {
    /*KnightBoard k = new KnightBoard(5, 5);
    System.out.println("---Testing Solve---");
    System.out.println("*printing 5x5 board:");
    System.out.println(k);
    System.out.println("\n*testing solve(0, 0): should return true");
    System.out.println(k.solve(0, 0));
    System.out.println(k);
    k.empty();

    System.out.println("\n*testing solve(4, 4): should return true");
    System.out.println(k.solve(4, 4));
    System.out.println(k);
    k.empty();

    System.out.println("\n*testing countSolutions(0, 0): should return 2432");
    System.out.println(k.countSolutions(0, 0));
    k.empty();
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
    System.out.println("*printing 7x10:\n" + seven);
    System.out.println("*printing solve(0,0):\n" + seven.solve(0,0));
    System.out.println(seven);
    System.out.println("*printing 8x4:\n" + eight);
    System.out.println("*printing solve(0,0):\n" + eight.solve(0,0));
    System.out.println(eight);

    one.empty();
    two.empty();
    three.empty();
    four.empty();
    five.empty();
    six.empty();
    seven.empty();
    eight.empty();

    System.out.println("1x1 countSolutions(0, 0): " + one.countSolutions(0, 0));
    System.out.println("2x4 countSolutions(0, 0): " + two.countSolutions(0, 0));
    System.out.println("3x3 countSolutions(0, 0): " + three.countSolutions(0, 0));
    System.out.println("4x6 countSolutions(0, 0): " + four.countSolutions(0, 0));
    System.out.println("5x5 countSolutions(0, 0): " + five.countSolutions(0, 0));
    System.out.println("6x3 countSolutions(0, 0): " + six.countSolutions(0, 0));
    //took too long- System.out.println("7x10 countSolutions(0, 0): " + seven.countSolutions(0, 0));
    //took too long- System.out.println("8x4 countSolutions(0, 0): " + eight.countSolutions(0, 0));

  }
}
