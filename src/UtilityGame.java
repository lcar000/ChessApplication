import java.util.Arrays;

public class UtilityGame extends ChessGame{

    public UtilityGame() {
        // default
    }
    public UtilityGame(ChessGame saved_game) {
        this.board = saved_game.board;
        this.playerTurn = saved_game.playerTurn;
    }

    public boolean isValidMove(Point newPosition) {

        //trying to take own piece
        if(playerTurn.equals("WHITE") && board[newPosition.getX()][newPosition.getY()] > 0 &&
                                         board[newPosition.getX()][newPosition.getY()] <= 6) {
            return false;
        }
        if(playerTurn.equals("BLACK") && board[newPosition.getX()][newPosition.getY()] >= 7) {
            return false;
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
        //leverages rook and bishop moveset
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
            while(y != newPosition.getY()) {
                if(board[x][y] != 0) {
                    return false;
                }
                y += direction;
            }
        }
        if(distY == 0) {
            int direction = (distX > 0) ? 1 : -1;
            x += direction;
            while(x != newPosition.getX()) {
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

        while(x != newPosition.getX() && y != newPosition.getY()) {
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
        if(Math.abs(distX) == 1 && distY == 1 && board[newPosition.getX()][newPosition.getY()] != 0) {
            return true;
        }
        return false;
    }

    public boolean isKingInCheck() {
        //to do
        return false;
    }

}
