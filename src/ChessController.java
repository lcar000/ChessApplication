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
    private boolean CheckMate = false;

    public ChessController() {

    }

    //for testing purposes
    public void setNewCurrentGame(UtilityGame board) {
        Color color = new Color(0, 0, 0);
        currentGame = new CurrentGame("Demo", "Player 1", "Player 2", color, 10);
        utilityGame = board;
        gameInfo.add("Demo");
        gameInfo.add("Player 1");
        gameInfo.add("Player 2");
        gameInfo.add(currentGame.playerTurn);
        gameInfo.add("10");
        pieceSelected = true;
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
//        if(utilityGame.checkMate()) {
//            System.out.println("CHECKMATE!");
//        }
        if(pieceSelected && utilityGame.isValidMove(boardClick, false)) {
//            System.out.println("Checkmate Testing");
//            if(utilityGame.checkMate()) {
//                CheckMate = true;
//                System.out.println("CHECKMATE!");
//            }
            if(utilityGame.tryMove(boardClick)) {
                currentGame.movePiece(boardClick, false);
                utilityGame.movePiece(boardClick, false);
                //utilityGame.setPlayerTurn(currentGame.getPlayerTurn());
                pieceSelected = false;
                playerTurn = currentGame.getPlayerTurn();
                gameInfo.set(3, playerTurn);
            }
        } else {
            pieceSelected = currentGame.selectPiece(boardClick);
            utilityGame.selectPiece(boardClick);
        }
        if(utilityGame.checkMate()) {
            CheckMate = true;
            System.out.println("CHECKMATE!");
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

    public boolean getCheckMate() {
        return CheckMate;
    }

}
