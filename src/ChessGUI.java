import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class ChessGUI extends JFrame {

    ChessController controller = new ChessController();
    ChessBoard gameBoard;
    JPanel startMenu;
    JPanel gameMenu;
    JButton newGameButton;
    JButton loadGameButton;
    JPanel setupMenu;

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

        startMenu.add(newGameButton);
        startMenu.add(loadGameButton);

        add(startMenu);
        //setVisible(true);
    }


    private void showSetupMenu() {
        setupMenu = new JPanel(new GridLayout(6, 1));
        setSize(350, 350);

        JTextField gameName = new JTextField("Enter Game Name");
        JTextField player1 = new JTextField("Player 1");
        JTextField player2 = new JTextField("Player 2");
        JColorChooser color = new JColorChooser();
        JComboBox<String> timeControls = new JComboBox<>(new String[]{"1 Minute", "3 Minute", "10 Minute", "30 Minute"});

        JButton startGame = new JButton("Start Game");
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change color to real color object later as well as time value
                controller.setNewCurrentGame(gameName.getText(), player1.getText(), player2.getText(), String.valueOf(color.getColor()), 0);
                remove(setupMenu);
                startGame();
                revalidate();
                repaint();
            }
        });

        setupMenu.add(gameName);
        setupMenu.add(player1);
        setupMenu.add(player2);
        setupMenu.add(color);
        setupMenu.add(timeControls);
        setupMenu.add(startGame);
        add(setupMenu);
    }

    private void startGame() {
        gameBoard = new ChessBoard(controller);
        gameMenu = new JPanel(new GridLayout(5, 1));
        setSize(300, 300);
        List<String> info = controller.getGameInfo();
        JLabel gameName = new JLabel(info.get(0));
        JLabel player1 = new JLabel(info.get(1));
        JLabel player2 = new JLabel(info.get(2));
        JLabel playerTurn = new JLabel(info.get(3));
        JLabel time = new JLabel(info.get(4));

        gameMenu.add(gameName);
        gameMenu.add(player1);
        gameMenu.add(player2);
        gameMenu.add(playerTurn);
        gameMenu.add(time);

        add(gameMenu);
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
