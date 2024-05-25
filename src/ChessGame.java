public abstract class ChessGame {
    protected int[][] board;
    protected int selectedPiece;
    protected Point selectedPiecePosition;
    protected String playerTurn;

    public ChessGame() {
        // standard starting board positions
        board = new int[][]{{10, 9, 8, 11, 12, 8, 9, 10},
                            {1, 1, 1, 1, 1, 1, 1, 1},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {1, 1, 1, 1, 1, 1, 1, 1},
                            {4, 3, 2, 5, 6, 2, 3, 4}};

        // default settings

        playerTurn = "WHITE";
    }

    public int[][] getBoard() {
        return board;
    }

    public String getPlayerTurn() {
        return playerTurn;
    }

    //Tries to select piece, true if a valid piece is at the point clicked, false if not
    public boolean selectPiece(Point p) {

        if (board[p.getX()][p.getY()] == 0) {
            return false;
        }

        if ((playerTurn.equals("WHITE")) && (board[p.getX()][p.getY()] <= 6)) {
            selectedPiece = board[p.getX()][p.getY()];
            selectedPiecePosition = p;
            playerTurn = "BLACK";
            return true;
        }

        if ((playerTurn.equals("BLACK")) && (board[p.getX()][p.getY()] >= 7)) {
            selectedPiece = board[p.getX()][p.getY()];
            selectedPiecePosition = p;
            playerTurn = "WHITE";
            return true;
        }
        return false;
    }
    public void movePiece(Point newPosition) {
        board[newPosition.getX()][newPosition.getY()] = selectedPiece;
        board[selectedPiecePosition.getX()][selectedPiecePosition.getY()] = 0;
    }
}
