import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChessController {

    private CurrentGame currentGame;
    private UtilityGame utilityGame;
    private Point boardClick;
    private SavedGames savedGames = new SavedGames();
    private boolean pieceSelected = false;
    private String playerTurn;

    private List<String> gameInfo = new ArrayList<>();

    public ChessController() {

    }

    public void setNewCurrentGame(String gameName, String player1Name, String player2Name, Color displayColor, int time) {
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
        //playerTurn = currentGame.getPlayerTurn();
        gameInfo.add(currentGame.getGameName());
        gameInfo.add(currentGame.getPlayer1Name());
        gameInfo.add(currentGame.getPlayer2Name());
        gameInfo.add(currentGame.playerTurn);
        gameInfo.add(String.valueOf(currentGame.getTimer()));
    }

    public String[] getSavedGames() {
        return savedGames.getSavedGames();
    }

    public void saveGame(String fileName) {
        currentGame.saveGameToFile(fileName);
    }

    public String getBoardClick() {
        return boardClick.toString();
    }
    public void newBoardClick(int x, int y) {

        boardClick = new Point(x, y);

        //If piece selected and valid move, moves piece
        if(pieceSelected && utilityGame.isValidMove(boardClick)) {
            currentGame.movePiece(boardClick);
            pieceSelected = false;
            playerTurn = currentGame.getPlayerTurn();
            gameInfo.set(3, playerTurn);
        } else {
            //if valid piece clicked, it is selected.
            pieceSelected = currentGame.selectPiece(boardClick);
        }
    }

    public boolean isPieceSelected() {
        return pieceSelected;
    }

    //Helper function for debugging, might delete
    public int[][] getGameBoard() {
        return currentGame.getBoard();
    }

    public String getPlayerTurn() {
        return playerTurn;
    }

    public List<String> getGameInfo(){
        return gameInfo;
    }

    public Color getGameDisplayColor() {
        return currentGame.getDisplayColor();
    }
}
