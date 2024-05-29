import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CurrentGame extends ChessGame{

    private final String gameName;
    private final String player1Name;
    private final String player2Name;
    private final Color displayColor;
    private final int timer;

    private List<String> gameInfo;

    public CurrentGame() {
        //default settings
        gameName = null;
        player1Name = "Player 1";
        player2Name = "Player 2";
        //Default is brown
        displayColor = new Color(115, 50, 20);
        playerTurn = "WHITE";
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

    public CurrentGame(String gameName, String player1Name, String player2Name, Color displayColor, int time) {
        this.gameName = gameName;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.displayColor = displayColor;
        playerTurn = "WHITE";
        this.timer = time;
    }

    public CurrentGame(String gameName, String player1Name, String player2Name, Color displayColor, String playerTurn, int time, int[][] savedBoard) {
        this.gameName = gameName;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.displayColor = displayColor;
        this.playerTurn = playerTurn;
        this.timer = time;
        this.board = savedBoard;
    }

    public String getGameName() {
        return gameName;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public  String getPlayer2Name() {
        return player2Name;
    }


    public Color getDisplayColor() {
        return displayColor;
    }

    public int getTimer() {
        return timer;
    }

    public void saveGameToFile(String fileName) {
        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(gameName);
            writer.println(player1Name);
            writer.println(player2Name);
            writer.println(displayColor.getRGB());
            writer.println(timer);
            writer.println(playerTurn);

            //current board state
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    writer.print(board[i][j] + " ");
                }
                writer.println();
            }
        } catch (IOException e) {
            System.out.println("Failed to save game");
        }
    }

}
