public class UtilityGame extends ChessGame{

    public UtilityGame() {
        // default
    }
    public UtilityGame(ChessGame saved_game) {
        this.board = saved_game.board;
        this.playerTurn = saved_game.playerTurn;
    }

    public boolean isValidMove(Point newPosition) {
        //to do = all moves allowed for testing
        return true;
    }
    public boolean isKingInCheck() {
        //to do
        return false;
    }
}
