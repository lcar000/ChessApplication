import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChessTest {
  @Test
  //check various point coordinates
  public void point1() {
    Point point = new Point(81, 164);
    assertEquals(1, point.getX());
    assertEquals(2, point.getY());
  }
  @Test
  public void point2() {
    Point point2 = new Point(640, 648);
    assertEquals(7, point2.getX());
    assertEquals(8, point2.getY());
  }

  //check that setX() and setY() work as intended
  @Test
  public void setXAndYTest() {
    Point point = new Point(0, 0);
    point.setX(250);
    point.setY(420);
    assertEquals(3, point.getX());
    assertEquals(5, point.getY());
  }


  //------------------------------------------------------PAWN TESTS------------------------------------------------------\\
  /*
   * test pawn moves
   */
  @Test
  public void pawnValidMove() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 7},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(0, 568);
    Point newPosition = new Point(81, 568);
    setBoard.selectedPiece = 7;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void pawnValidMove2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {7, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 3, 0);
    Point newPosition = new Point(true, 4, 0);
    setBoard.selectedPiece = 7;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void pawnValidMove3() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 7, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 6, 2);
    Point newPosition = new Point(true, 7, 2);
    setBoard.selectedPiece = 7;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }



  /*
   * test valid two space moves for pawn
   */
  @Test
  public void pawnValidDoubleMove() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {7, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 1, 0);
    Point newPosition = new Point(true, 3, 0);
    setBoard.selectedPiece = 7;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void pawnValidDoubleMove2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 7},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 1, 7);
    Point newPosition = new Point(true, 3, 7);
    setBoard.selectedPiece = 7;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void pawnValidDoubleMove3() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 7, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 1, 3);
    Point newPosition = new Point(true, 3, 3);
    setBoard.selectedPiece = 7;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }



  /*
   * Test valid pawn attacks
   */
  @Test
  public void pawnValidAttack() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 7, 0, 0, 0, 0},
                                {0, 0, 0, 0, 1, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 1, 3);
    Point newPosition = new Point(true, 2, 4);
    setBoard.selectedPiece = 7;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void pawnValidAttack2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 7, 0, 0, 0, 0},
                                {0, 0, 1, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 1, 3);
    Point newPosition = new Point(true, 2, 2);
    setBoard.selectedPiece = 7;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  


  /*
   * Test invalid pawn moves
   */
  @Test
  public void pawnInvalidPawnMove() {
    //create a new board
    int[][] board = new int[][]{{7, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 0, 0);
    Point newPosition = new Point(true, 1, 1);
    setBoard.selectedPiece = 7;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void pawnInvalidPawnMove2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 7, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 3, 3);
    Point newPosition = new Point(true, 2, 3);
    setBoard.selectedPiece = 7;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void pawnInvalidPawnMove3() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 7, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 5, 6);
    Point newPosition = new Point(true, 5, 7);
    setBoard.selectedPiece = 7;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }



  /*
   * test invalid two space moves for pawn
   */
  @Test
  public void pawnInvalidDoubleMove() {
    //create a new board
    int[][] board = new int[][]{{7, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 0, 0);
    Point newPosition = new Point(true, 2, 0);
    setBoard.selectedPiece = 7;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void pawnInvalidDoubleMove2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 7, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 3, 5);
    Point newPosition = new Point(true, 5, 5);
    setBoard.selectedPiece = 7;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void pawnInvalidDoubleMove3() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 7, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 4, 2);
    Point newPosition = new Point(true, 6, 2);
    setBoard.selectedPiece = 7;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }



  //------------------------------------------------------KNIGHT TESTS------------------------------------------------------\\
  /*
   * Knight valid move test
   */
  @Test
  public void KnightValidMove() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 3, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 3, 3);
    Point newPosition = new Point(true, 2, 5);
    setBoard.selectedPiece = 3;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void KnightValidMove2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 3, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 3, 3);
    Point newPosition = new Point(true, 4, 5);
    setBoard.selectedPiece = 3;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void KnightValidMove3() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 3, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 3, 3);
    Point newPosition = new Point(true, 2, 1);
    setBoard.selectedPiece = 3;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void KnightValidMove4() {
    //create a new board
    int[][] board = new int[][]{{0, 3, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 0, 1);
    Point newPosition = new Point(true, 2, 2);
    setBoard.selectedPiece = 3;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }


  
  /*
   * Knight Valid attack moves
   */
  @Test
  public void KnightValidAttack() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 7, 0, 0, 0, 0},
                                {0, 3, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 7, 1);
    Point newPosition = new Point(true, 6, 3);
    setBoard.selectedPiece = 3;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void KnightValidAttack2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 9, 0, 0},
                                {0, 9, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 2, 1);
    Point newPosition = new Point(true, 3, 3);
    setBoard.selectedPiece = 9;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }



  /*
   * Invalid knight moves
   */
  @Test
  public void KnightInvalidMove() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 3},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 0, 7);
    Point newPosition = new Point(true, 7, 0);
    setBoard.selectedPiece = 3;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void KnightInvalidMove2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 3, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 3, 1);
    Point newPosition = new Point(true, 4, 2);
    setBoard.selectedPiece = 3;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }



  /*
   * Invalid knight attacks
   */
  @Test
  public void KnightInvalidAttack() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 3, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 7, 1);
    Point newPosition = new Point(true, 6, 3);
    setBoard.selectedPiece = 3;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void KnightInvalidAttack2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 9, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 7, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 3, 2);
    Point newPosition = new Point(true, 4, 4);
    setBoard.selectedPiece = 9;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }



  //------------------------------------------------------ROOK TESTS------------------------------------------------------\\
  /*
    * Test valid Rook moves
    */
  @Test
  public void RookValidMove() {
    //create a new board
    int[][] board = new int[][]{{10, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 0, 0);
    Point newPosition = new Point(true, 7, 0);
    setBoard.selectedPiece = 10;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void RookValidMove2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {10, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 4, 0);
    Point newPosition = new Point(true, 4, 7);
    setBoard.selectedPiece = 10;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }



  /*
   * Valid Rook attacks
   */
  @Test
  public void RookValidAttack() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 3, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 10, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 4, 4);
    Point newPosition = new Point(true, 4, 0);
    setBoard.selectedPiece = 10;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void RookValidAttack2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 3, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 10, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 4, 4);
    Point newPosition = new Point(true, 4, 0);
    setBoard.selectedPiece = 10;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }



  /*
   * Rook invalid move
   */
  @Test
  public void RookInvalidMove() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 10, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 2,  1);
    Point newPosition = new Point(true, 4, 3);
    setBoard.selectedPiece = 10;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void RookInvalidMove2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {10, 0, 0, 0, 1, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 3, 0);
    Point newPosition = new Point(true, 3, 7);
    setBoard.selectedPiece = 10;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void RookInvalidMove3() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 7, 0, 0, 10, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 5, 5);
    Point newPosition = new Point(true, 5, 0);
    setBoard.selectedPiece = 10;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }



  /*
   * Rook invalid attack
   */
  @Test
  public void RookInvalidAttack() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 10, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 2,  1);
    Point newPosition = new Point(true, 4, 3);
    setBoard.selectedPiece = 10;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void RookInvalidAttack2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 10, 0, 7, 0, 1, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 4, 2);
    Point newPosition = new Point(true, 4, 6);
    setBoard.selectedPiece = 10;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void RookInvalidAttack3() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 1, 0, 1, 0, 10, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 4, 6);
    Point newPosition = new Point(true, 4, 2);
    setBoard.selectedPiece = 10;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }



  //------------------------------------------------------BISHOP TESTS------------------------------------------------------\\
  /*
   * Bishop valid move
   */
  @Test
  public void BishopValidMove() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 2, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 1, 1);
    Point newPosition = new Point(true, 5, 5);
    setBoard.selectedPiece = 2;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void BishopValidMove2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 2, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 6, 1);
    Point newPosition = new Point(true, 7, 0);
    setBoard.selectedPiece = 2;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }



  /*
   * Bishop valid attack
   */
  @Test
  public void BishopValidAttack() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 7, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 2, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 5, 1);
    Point newPosition = new Point(true, 4, 2);
    setBoard.selectedPiece = 2;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void BishopValidAttack2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {10, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 2, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 4, 3);
    Point newPosition = new Point(true, 1, 0);
    setBoard.selectedPiece = 2;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }



  /*
   * Bishop valid move
   */
  @Test
  public void BishopInvalidMove() {
    //create a new board
    int[][] board = new int[][]{{2, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 0, 0);
    Point newPosition = new Point(true, 0, 1);
    setBoard.selectedPiece = 2;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void BishopInvalidMove2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 1, 0, 0, 0, 0, 0},
                                {0, 2, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 3, 1);
    Point newPosition = new Point(true, 1, 1);
    setBoard.selectedPiece = 2;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void BishopInvalidMove3() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {1, 0, 0, 0, 0, 0, 0, 0},
                                {0, 2, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 7, 1);
    Point newPosition = new Point(true, 6, 0);
    setBoard.selectedPiece = 2;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }



  /*
   * Bishop invalid attack
   */
  @Test
  public void BishopInvalidAttack() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 10, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 2, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 5, 1);
    Point newPosition = new Point(true, 1, 5);
    setBoard.selectedPiece = 2;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void BishopInvalidAttack2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 2, 0, 0, 0, 0},
                                {0, 0, 0, 0, 1, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 7, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 3, 3);
    Point newPosition = new Point(true, 6, 6);
    setBoard.selectedPiece = 2;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }



  //------------------------------------------------------QUEEN TESTS------------------------------------------------------\\
  /*
   * Queen valid moves
   */
  @Test
  public void QueenValidMove() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 11, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 4, 3);
    Point newPosition = new Point(true, 0, 3);
    setBoard.selectedPiece = 11;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void QueenValidMove2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 11}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 7, 7);
    Point newPosition = new Point(true, 0, 0);
    setBoard.selectedPiece = 11;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void QueenValidMove3() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 11, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 5, 1);
    Point newPosition = new Point(true, 7, 1);
    setBoard.selectedPiece = 11;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }



  /*
   * Queen valid attacks
   */
  @Test
  public void QueenValidAttack() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 11, 0, 0, 1, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 4, 3);
    Point newPosition = new Point(true, 4, 6);
    setBoard.selectedPiece = 11;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void QueenValidAttack2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 11, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 1, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 1, 1);
    Point newPosition = new Point(true, 5, 5);
    setBoard.selectedPiece = 11;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void QueenValidAttack3() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {5, 0, 0, 0, 0, 0, 0, 0},
                                {0, 11, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 6, 1);
    Point newPosition = new Point(true, 5, 0);
    setBoard.selectedPiece = 11;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }



  /*
   * Queen Invalid Moves
   */
  @Test
  public void QueenInvalidMove() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 11, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 3, 4);
    Point newPosition = new Point(true, 2, 6);
    setBoard.selectedPiece = 11;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void QueenInvalidMove2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 7, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 11, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 5, 5);
    Point newPosition = new Point(true, 0, 0);
    setBoard.selectedPiece = 11;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void QueenInvalidMove3() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 1, 0, 0, 11},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 4, 7);
    Point newPosition = new Point(true, 4, 0);
    setBoard.selectedPiece = 11;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }



  /*
   * Queen Invalid attacks
   */
  @Test
  public void QueenInvalidAttack() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 11, 1, 0, 1, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 2, 2);
    Point newPosition = new Point(true, 2 , 5);
    setBoard.selectedPiece = 11;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void QueenInvalidAttack2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 4, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 1, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 11, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 6, 2);
    Point newPosition = new Point(true, 2 , 6);
    setBoard.selectedPiece = 11;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "BLACK";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }



  //------------------------------------------------------KING TESTS------------------------------------------------------\\
  /*
   * King Valid moves 
   */
  @Test
  public void KingValidMove() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 6, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 2, 4);
    Point newPosition = new Point(true, 2, 5);
    setBoard.selectedPiece = 6;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void KingValidMove2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 6, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 5, 2);
    Point newPosition = new Point(true, 4, 1);
    setBoard.selectedPiece = 6;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }



  /*
   * King valid attack
   */
  @Test
  public void KingValidAttack() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 6, 0, 0, 0},
                                {0, 0, 0, 0, 0, 8, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 2, 4);
    Point newPosition = new Point(true, 3, 5);
    setBoard.selectedPiece = 6;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }
  @Test
  public void KingValidAttack2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 6, 10, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 5, 1);
    Point newPosition = new Point(true, 5, 2);
    setBoard.selectedPiece = 6;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(true, test);
  }



  /*
   * King Invalid Moves
   */
  @Test
  public void KingInvalidMove() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 6, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 5, 5);
    Point newPosition = new Point(true, 5, 3);
    setBoard.selectedPiece = 6;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, true);
    assertEquals(false, test);
  }
  @Test
  public void KingInvalidMove2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 6, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 5, 5);
    Point newPosition = new Point(true, 3, 3);
    setBoard.selectedPiece = 6;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, true);
    assertEquals(false, test);
  }



  /*
   * King Invalid Attack
   */
  @Test
  public void KingInvalidAttack() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 6, 2, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 5, 1);
    Point newPosition = new Point(true, 5, 2);
    setBoard.selectedPiece = 6;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.isValidMove(newPosition, false);
    assertEquals(false, test);
  }
  @Test
  public void KingInvalidAttack2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 6, 0, 0, 0, 0},
                                {0, 0, 0, 0, 7, 0, 0, 0},
                                {0, 0, 0, 0, 10, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 2, 3);
    Point newPosition = new Point(true, 3, 4);
    setBoard.selectedPiece = 6;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.tryMove(newPosition);
    assertEquals(false, test);
  }
  


  //------------------------------------------------------CHECK TESTS------------------------------------------------------\\
  @Test
  public void CheckTest() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 8, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 6, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 6, 3);
    Point newPosition = new Point(true, 7, 3);
    setBoard.selectedPiece = 6;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    //try move prevent check not isValid
    boolean test = setBoard.tryMove(newPosition);
    assertEquals(false, test);
  }
  @Test
  public void CheckTest2() {
    //create a new board
    int[][] board = new int[][]{{0, 0, 6, 0, 0, 0, 0, 10},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};

    //create a game with board
    UtilityGame setBoard = new UtilityGame(board, "WHITE");  
    ChessController game = new ChessController();
    game.setNewCurrentGame(setBoard);

    //make move and assert
    Point startingPosition = new Point(true, 0, 2);
    setBoard.selectedPiece = 6;
    setBoard.selectedPiecePosition = startingPosition;
    setBoard.playerTurn = "WHITE";
    boolean test = setBoard.kingIsInCheck();
    assertEquals(true, test);
  }
}
