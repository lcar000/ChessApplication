import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class ChessBoard extends JFrame implements MouseListener {
    private final ChessController controller;
    private final ChessGUI gui;
    private final JPanel boardPanel;
    private final JLabel testPointLabel;

    public ChessBoard(ChessController controller, ChessGUI gui) {
        this.controller = controller;
        this.gui = gui;

        setTitle("Chess Board");
        setSize(650, 685);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //testPointLabel.setHorizontalAlignment(SwingConstants.CENTER);

        boardPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGrid(g);
            }
        };
        testPointLabel = new JLabel("Click to get point");
        boardPanel.add(testPointLabel, BorderLayout.SOUTH);

        add(boardPanel);
        boardPanel.addMouseListener(this);
        setVisible(true);
    }

    private void drawGrid(Graphics g) {

        int cellWidth = boardPanel.getWidth() / 8;
        int cellHeight = boardPanel.getHeight() / 8;

        //Draws squares
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    if(controller.getGameDisplayColor().equals(new Color(115, 50, 20))) {
                        g.setColor(new Color(213, 154, 125));
                    } else {
                        g.setColor(Color.WHITE);
                    }
                } else {
                    g.setColor(controller.getGameDisplayColor());
                }
                g.fillRect(row * cellWidth, col * cellHeight, cellWidth, cellHeight);
            }
        }
        //Sets up font
        Font font = new Font("Arial", Font.BOLD, 13);
        g.setFont(font);

        //Draws pieces in correct square
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                g.setColor(Color.BLACK);
                g.drawString(pieceNameConverter(controller.getGameBoard()[row][col]), row * cellWidth, (col * cellHeight + 25));
            }
        }
    }

    private String pieceNameConverter(int value) {
        if(value == 1) {
            return "White Pawn";
        }
        if(value == 2) {
            return "White Bishop";
        }
        if(value == 3) {
            return "White Knight";
        }
        if(value == 4) {
            return "White Rook";
        }
        if(value == 5) {
            return "White Queen";
        }
        if(value == 6) {
            return "White King";
        }
        if(value == 7) {
            return "Black Pawn";
        }
        if(value == 8) {
            return "Black Bishop";
        }
        if(value == 9) {
            return "Black Knight";
        }
        if(value == 10) {
            return "Black Rook";
        }
        if(value == 11) {
            return "Black Queen";
        }
        if(value == 12) {
            return "Black King";
        }
        return "";
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        controller.newBoardClick(x,y);
        gui.updateGameMenu();
        //Redraws based on updated state
        repaint();

        testPointLabel.setText(controller.getBoardClick());
    }

    //Unused methods from mouse listener
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
