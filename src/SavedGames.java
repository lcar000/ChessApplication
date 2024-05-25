import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavedGames {
    private final List<ChessGame> savedGames = new ArrayList<>();

    public SavedGames() {
        loadGamesFromFile("SAVED_GAMES.txt");
    }

    public ChessGame getGame(int index){
        return savedGames.get(index);
    }

    private void loadGamesFromFile(String saved_games) {
        try (BufferedReader reader = new BufferedReader(new FileReader(saved_games))) {
            String gameName = reader.readLine();
            String player1Name = reader.readLine();
            String player2Name = reader.readLine();
            String displayColor = reader.readLine();
            String playerTurn = reader.readLine();
            int timer = Integer.parseInt(reader.readLine());

            // Read the current state of the 2D array
            int[][] board = new int[8][8];
            for (int i = 0; i < 8; i++) {
                String[] row = reader.readLine().trim().split(" ");
                for (int j = 0; j < 8; j++) {
                    board[i][j] = Integer.parseInt(row[j]);
                }
            }

            // Create a new ChessGame object and add it to savedGames
            ChessGame game = new CurrentGame(gameName, player1Name, player2Name, displayColor, playerTurn, timer, board);
            savedGames.add(game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
