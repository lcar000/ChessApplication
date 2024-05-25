import java.util.ArrayList;
import java.util.List;

public class CurrentGame extends ChessGame{

    private final String gameName;
    private final String player1Name;
    private final String player2Name;
    private final String displayColor;
    private final int timer;

    private List<String> gameInfo;

    public CurrentGame() {
        //default settings
        gameName = null;
        player1Name = "Player 1";
        player2Name = "Player 2";
        displayColor = "DEFAULT";
        playerTurn = "White";
        timer = 0;
    }

    public CurrentGame(CurrentGame saved_game) {
        this.gameName = saved_game.gameName;
        this.player1Name = saved_game.player1Name;
        this.player2Name = saved_game.player2Name;
        this.displayColor = saved_game.displayColor;
        this.playerTurn = saved_game.playerTurn;
        this.timer = saved_game.timer;
        this.board = saved_game.board;;
    }

    public CurrentGame(String gameName, String player1Name, String player2Name, String displayColor, int time) {
        this.gameName = gameName;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.displayColor = displayColor;
        playerTurn = "White";
        this.timer = time;
    }

    public CurrentGame(String gameName, String player1Name, String player2Name, String displayColor, String playerTurn, int time, int[][] savedBoard) {
        this.gameName = gameName;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.displayColor = displayColor;
        this.playerTurn = playerTurn;
        this.timer = time;
        this.board = savedBoard;
    }

}
