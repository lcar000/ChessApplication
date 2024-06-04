import java.util.Arrays;

public class UtilityGame extends ChessGame{

    private Point whiteKingPosition;
    private Point blackKingPosition;

    public UtilityGame() {
        // default

        whiteKingPosition = findKingPosition("WHITE");
        blackKingPosition = findKingPosition("BLACK");
    }
    public UtilityGame(ChessGame saved_game) {
        this.board = saved_game.board;
        this.playerTurn = saved_game.playerTurn;
        whiteKingPosition = findKingPosition("WHITE");
        blackKingPosition = findKingPosition("BLACK");
    }
    //for testing purposes
    public UtilityGame(int[][] board, String playerTurn) {
        this.board = board;
        this.playerTurn = playerTurn;
        whiteKingPosition = findKingPosition("WHITE");
        blackKingPosition = findKingPosition("BLACK");
    }

    //Assumes isValidMove called
    public boolean tryMove(Point newPosition) {
        int temp = board[newPosition.getX()][newPosition.getY()];

        movePiece(newPosition, true);

        if(kingIsInCheck()) {
            board[newPosition.getX()][newPosition.getY()] = temp;
            board[selectedPiecePosition.getX()][selectedPiecePosition.getY()] = selectedPiece;
            return false;
        }
        board[newPosition.getX()][newPosition.getY()] = temp;
        board[selectedPiecePosition.getX()][selectedPiecePosition.getY()] = selectedPiece;
        return true;
    }

    public boolean isValidMove(Point newPosition, boolean checkTest) {
        //Any time move is attempted, kings are found
        whiteKingPosition = findKingPosition("WHITE");
        blackKingPosition = findKingPosition("BLACK");
        //trying to take own piece only check this part if not a check test
        if(!checkTest) {
            if (playerTurn.equals("WHITE") && board[newPosition.getX()][newPosition.getY()] > 0 &&
                    board[newPosition.getX()][newPosition.getY()] <= 6) {
                return false;
            }
            if (playerTurn.equals("BLACK") && board[newPosition.getX()][newPosition.getY()] >= 7) {
                return false;
            }
        }

        //if pawn
        if(selectedPiece == 1 || selectedPiece == 7) {
            return pawnMove(newPosition);
        }
        //if bishop
        if(selectedPiece == 2 || selectedPiece == 8) {
            return bishopMove(newPosition);
        }
        //if knight
        if(selectedPiece == 3 || selectedPiece == 9) {
            return knightMove(newPosition);
        }
        //if rook
        if(selectedPiece == 4 || selectedPiece == 10) {
            return rookMove(newPosition);
        }
        //if queen
        if(selectedPiece == 5 || selectedPiece == 11) {
            return queenMove(newPosition);
        }
        //if king
        if(selectedPiece == 6 || selectedPiece == 12) {
            return kingMove(newPosition);
        }
        return false;
    }

    private boolean kingMove(Point newPosition) {
        int distX = Math.abs(newPosition.getX() - selectedPiecePosition.getX());
        int distY = Math.abs(newPosition.getY() - selectedPiecePosition.getY());

        if(distX == 1 && distY == 1 || distX == 0 && distY == 1 || distX == 1 && distY == 0) {
            return true;
        }
        return false;
    }

    private boolean queenMove(Point newPosition) {
        //leverages rook and bishop move set
        return rookMove(newPosition) || bishopMove(newPosition);
    }

    private boolean rookMove(Point newPosition) {
        int distX = newPosition.getX() - selectedPiecePosition.getX();
        int distY = newPosition.getY() - selectedPiecePosition.getY();

        //invalid, either row or column must be zero
        if(distX != 0 && distY != 0) {
            return false;
        }
        int x = selectedPiecePosition.getX();
        int y = selectedPiecePosition.getY();

        if(distX == 0) {
            int direction = (distY > 0) ? 1 : -1;
            y += direction;
            while(y != newPosition.getY() && y > 0) {
                if(board[x][y] != 0) {
                    return false;
                }
                y += direction;
            }
        }
        if(distY == 0) {
            int direction = (distX > 0) ? 1 : -1;
            x += direction;
            while(x != newPosition.getX() && x > 0) {
                if(board[x][y] != 0) {
                    return false;
                }
                x += direction;
            }
        }
        return true;
    }

    private boolean knightMove(Point newPosition) {
        int distX = Math.abs(newPosition.getX() - selectedPiecePosition.getX());
        int distY = Math.abs(newPosition.getY() - selectedPiecePosition.getY());

        if(distX == 1 && distY == 2 || distX == 2 && distY == 1) {
            return true;
        }
        return false;
    }

    private boolean bishopMove(Point newPosition) {
        int distX = Math.abs(newPosition.getX() - selectedPiecePosition.getX());
        int distY = Math.abs(newPosition.getY() - selectedPiecePosition.getY());

        if(distX != distY) {
            //not diagonal
            return false;
        }
        int directionX = (newPosition.getX() > selectedPiecePosition.getX()) ? 1 : -1;
        int directionY = (newPosition.getY() > selectedPiecePosition.getY()) ? 1 : -1;

        int x = selectedPiecePosition.getX() + directionX;
        int y = selectedPiecePosition.getY() + directionY;

        while(x != newPosition.getX() && y != newPosition.getY() && x > 0 && y >0) {
            if(board[x][y] != 0) {
                //path obstructed
                return false;
            }
            x += directionX;
            y += directionY;
        }
        return true;
    }
    private boolean pawnMove(Point newPosition) {
        int distX = newPosition.getX() - selectedPiecePosition.getX();
        int distY = Math.abs(newPosition.getY() - selectedPiecePosition.getY());

        int direction = (playerTurn.equals("WHITE")) ? -1 : 1;

        //normal move
        if(distX == direction && distY == 0  && board[newPosition.getX()][newPosition.getY()] == 0) {
            return true;
        }
        //if first pawn move can be 2 squares
        if(distX == 2 * direction && distY == 0 && board[newPosition.getX()][newPosition.getY()] == 0
                && (selectedPiecePosition.getX() == 1 || selectedPiecePosition.getX() == 6)) {
            //check if square in between is empty
            return board[selectedPiecePosition.getX() + direction][selectedPiecePosition.getY()] == 0;
        }
        //capture move
        if(Math.abs(distX) == direction && distY == 1 && board[newPosition.getX()][newPosition.getY()] != 0) {
            return true;
        }
        return false;
    }

    public boolean kingIsInCheck() {
        //to do
        if(whiteKingPosition == null || blackKingPosition == null) {
            //King missing
            System.out.println("King Check Test: KINGS NULL");
            return false;
        }


        int originalSelectedPiece = selectedPiece;
        Point originalSelectedPiecePosition = selectedPiecePosition;

        boolean kingChecked = false;
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                if(playerTurn.equals("WHITE") && board[x][y] >= 7) {

                    selectedPiece = board[x][y];
                    //multiply by 81 due to point implementation
                    selectedPiecePosition = new Point(x * 81,y * 81);
                    if(isValidMove(whiteKingPosition, true)) {
                        selectedPiece = originalSelectedPiece;
                        selectedPiecePosition = originalSelectedPiecePosition;
                        return true;
                    }
                }
                if(playerTurn.equals("BLACK") && board[x][y] <= 6 && board[x][y] > 0) {

                    selectedPiece = board[x][y];
                    selectedPiecePosition = new Point(x * 81,y * 81);
                    if(isValidMove(blackKingPosition, true)) {
                        selectedPiece = originalSelectedPiece;
                        selectedPiecePosition = originalSelectedPiecePosition;
                        return true;
                    }
                }
            }
        }
        selectedPiece = originalSelectedPiece;
        selectedPiecePosition = originalSelectedPiecePosition;
        return false;
    }
    public boolean checkMate() {
        if(!kingIsInCheck()) {
            return false;
        }

        //Check if king can move to safety
        Point king = findKingPosition(playerTurn);
        for(int i = Math.max(0, king.getX() - 1); i <= Math.min(7, king.getX() + 1); i++) {
            for(int j = Math.max(0, king.getY() - 1); j <= Math.min(7, king.getY() + 1); j++) {
                //Excluded square king is on
                //DEBUGGING || changed to &&
                if(i != king.getX() && j != king.getY()) {
                    Point p = new Point(i * 81, j * 81);
                    if (isValidMove(p, false) && tryMove(p)) {
                        System.out.println("King can move: false determination");
                        //not checkmate
                        return false;
                    }
                }
            }
        }

        //Check if any piece can block or capture attacking piece
        //Check all pieces
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                if ((playerTurn.equals("WHITE") && board[x][y] <= 6 && board[x][y] > 0) ||
                        (playerTurn.equals("BLACK") && board[x][y] >= 7)) {

                    int originalSelectedPiece = selectedPiece;
                    Point originalSelectedPiecePosition = selectedPiecePosition;

                    selectedPiece = board[x][y];
                    selectedPiecePosition = new Point(x * 81,y * 81);

                    //check all moves for each piece
                    for(int targetX = 0; targetX < 8; targetX++) {
                        for (int targetY = 0; targetY < 8; targetY++) {
                            //Attempt valid moves that stop check
                            Point p = new Point(targetX * 81, targetY * 81);
                            if (isValidMove(p, false) && tryMove(p)) {
                                selectedPiece = originalSelectedPiece;
                                selectedPiecePosition = originalSelectedPiecePosition;
                                return false;
                            }
                        }
                    }

                    selectedPiece = originalSelectedPiece;
                    selectedPiecePosition = originalSelectedPiecePosition;
                }
            }
        }
        //no moves found - CHECKMATE
        return true;
    }

    private Point findKingPosition(String playerColor) {
        int king = playerColor.equals("WHITE") ? 6 : 12;
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                if(board[x][y] == king) {
                    //multiply by 81 because of point implementation
                    return new Point(x * 81,y * 81);
                }
            }
        }
        //king not found
        return null;
    }

}
