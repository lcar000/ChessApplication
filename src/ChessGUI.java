import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class ChessGUI extends JFrame {

    ChessController controller = new ChessController();
    ChessBoard gameBoard;
    JPanel startMenu;
    JPanel loadGamesMenu;
    JPanel gameMenu;
        JLabel playerTurn;
    JButton newGameButton;
    JButton loadGameButton;
    JButton saveGameButton;
    JPanel setupMenu;


    Color displayColor;

    public ChessGUI() {
        setTitle("Chess Start Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        startMenu = new JPanel(new GridLayout(2, 1));

        newGameButton = new JButton("Start a new game");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(startMenu);
                showSetupMenu();
                revalidate();
                repaint();
            }
        });
        loadGameButton = new JButton("Load a saved game");
        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(startMenu);
                showLoadGamesMenu();
                revalidate();
                repaint();
            }
        });
        startMenu.add(newGameButton);
        startMenu.add(loadGameButton);

        add(startMenu);
        //setVisible(true);
    }

    private void showLoadGamesMenu() {
        loadGamesMenu = new JPanel();
        loadGamesMenu.setLayout(new GridLayout(15, 1));
        setSize(300, 500);
        String[] gameNames = controller.getSavedGames();

        for(int i = 0; i < gameNames.length; i++) {
            JButton button = new JButton(gameNames[i]);
            int index = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.loadSavedGame(index);
                    remove(loadGamesMenu);
                    startGame();
                    revalidate();
                    repaint();
                }
            });
            loadGamesMenu.add(button);
        }
        add(loadGamesMenu);

    }


    private void showSetupMenu() {
        setupMenu = new JPanel(new GridLayout(6, 1));
        setSize(350, 350);

        JTextField gameName = new JTextField("Enter Game Name");
        JTextField player1 = new JTextField("Player 1");
        JTextField player2 = new JTextField("Player 2");

        JComboBox<String> timeControls = new JComboBox<>(new String[]{"1 Minute", "3 Minute", "10 Minute", "30 Minute"});

        //Default color is brown
        displayColor = new Color(115, 50, 20);
        JButton colorButton = new JButton("Choose Display Color");

        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = null;
                color = JColorChooser.showDialog(ChessGUI.this, "Chose Display Color", color);
                if(color != null) {
                    displayColor = color;
                }
            }
        });
        JButton startGame = new JButton("Start Game");
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change color to real color object later as well as time value
                controller.setNewCurrentGame(gameName.getText(), player1.getText(), player2.getText(), displayColor, 0);
                remove(setupMenu);
                startGame();
                revalidate();
                repaint();
            }
        });

        setupMenu.add(gameName);
        setupMenu.add(player1);
        setupMenu.add(player2);
        //setupMenu.add(displayColor);
        setupMenu.add(timeControls);
        setupMenu.add(colorButton);
        setupMenu.add(startGame);
        add(setupMenu);
    }

    private void startGame() {
        gameBoard = new ChessBoard(controller, this);
        gameMenu = new JPanel(new GridLayout(6, 1));
        setSize(300, 300);
        List<String> info = controller.getGameInfo();
        JLabel gameName = new JLabel(info.get(0));
        JLabel player1 = new JLabel(info.get(1));
        JLabel player2 = new JLabel(info.get(2));
        playerTurn = new JLabel(info.get(3));
        JLabel time = new JLabel(info.get(4));

        saveGameButton = new JButton("Save Game and Close App");

        saveGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.saveGame("SAVED_GAMES.txt");
                System.exit(0);
            }
        });

        gameMenu.add(gameName);
        gameMenu.add(player1);
        gameMenu.add(player2);
        gameMenu.add(playerTurn);
        gameMenu.add(time);
        gameMenu.add(saveGameButton, BorderLayout.SOUTH);

        add(gameMenu);
    }

    public void updateGameMenu() {
        playerTurn.setText(controller.getPlayerTurn());
        gameMenu.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ChessGUI window = new ChessGUI();
                window.setVisible(true);
            }
        });
    }
}
