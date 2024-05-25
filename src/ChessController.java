import java.util.ArrayList;
import java.util.List;

public class ChessController {

    private CurrentGame currentGame;
    private UtilityGame utilityGame;
    private Point boardClick;
    private SavedGames savedGames;
    private boolean pieceSelected = false;
    private String playerTurn;

    private List<String> gameInfo = new ArrayList<>();

    public ChessController() {
        //default
    }

    public void setNewCurrentGame(String gameName, String player1Name, String player2Name, String displayColor, int time) {
        currentGame = new CurrentGame(gameName, player1Name, player2Name, displayColor, time);
        utilityGame = new UtilityGame();
        gameInfo.add(gameName);
        gameInfo.add(player1Name);
        gameInfo.add(player2Name);
        gameInfo.add(currentGame.playerTurn);
        gameInfo.add(String.valueOf(time));
    }

    public void loadSavedGame(int gameIndex) {
        currentGame = new CurrentGame((CurrentGame) savedGames.getGame(gameIndex));
        utilityGame = new UtilityGame(savedGames.getGame(gameIndex));
    }

    public String getBoardClick() {
        return boardClick.toString();
    }
    public void newBoardClick(int x, int y) {
        //if piece currently selected tries to move piece
        if(isPieceSelected()) {
            boardClick.setX(x);
            boardClick.setY(y);
            //Checks validity of move before updating game board
            if(utilityGame.isValidMove(boardClick)) {
                currentGame.movePiece(boardClick);
                pieceSelected = false;
                playerTurn = currentGame.getPlayerTurn();
            }

        }
        boardClick = new Point(x, y);
        //if valid piece clicked, that piece is selected
        if(currentGame.selectPiece(boardClick)) {
            pieceSelected = true;
        }
    }

    public boolean isPieceSelected() {
        return pieceSelected;
    }

    public String getPlayerTurn() {
        return playerTurn;
    }

    public List<String> getGameInfo(){
        return gameInfo;
    }
}
