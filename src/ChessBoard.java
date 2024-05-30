import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ChessBoard extends JFrame implements MouseListener {
    private final ChessController controller;
    private final ChessGUI gui;
    private final JPanel boardPanel;
    private final JLabel testPointLabel;

    private Image whitePawn;
    private Image blackPawn;
    private Image whiteBishop;
    private Image blackBishop;
    private Image whiteKnight;
    private Image blackKnight;
    private Image whiteRook;
    private Image blackRook;
    private Image whiteQueen;
    private Image blackQueen;
    private Image whiteKing;
    private Image blackKing;


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

        initializeImages();
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
                //g.drawString(pieceNameConverter(controller.getGameBoard()[row][col]), row * cellWidth, (col * cellHeight + 25));
                g.drawImage(pieceNameConverter(controller.getGameBoard()[row][col]), row * cellWidth, (col * cellHeight ), cellWidth, cellHeight, null);
            }
        }
        if(controller.getCheckMate()) {
            Font fontTwo = new Font("Arial", Font.BOLD, 40);
            g.setFont(fontTwo);
            g.setColor(Color.BLACK);
            g.drawString("CHECK MATE", 200, 300);
        }
    }

    private Image pieceNameConverter(int value) {
        if(value == 1) {
            return whitePawn;
        }
        if(value == 2) {
            return whiteBishop;
        }
        if(value == 3) {
            return whiteKnight;
        }
        if(value == 4) {
            return whiteRook;
        }
        if(value == 5) {
            return whiteQueen;
        }
        if(value == 6) {
            return whiteKing;
        }
        if(value == 7) {
            return blackPawn;
        }
        if(value == 8) {
            return blackBishop;
        }
        if(value == 9) {
            return blackKnight;
        }
        if(value == 10) {
            return blackRook;
        }
        if(value == 11) {
            return blackQueen;
        }
        if(value == 12) {
            return blackKing;
        }
        return null;
    }

    private void initializeImages() {
        //Initialize images
        try
        {
            whitePawn = ImageIO.read(new File("white-pawn.png"));
            blackPawn = ImageIO.read(new File("black-pawn.png"));
            whiteBishop = ImageIO.read(new File("white-bishop.png"));
            blackBishop = ImageIO.read(new File("black-bishop.png"));
            whiteKnight = ImageIO.read(new File("white-knight.png"));
            blackKnight = ImageIO.read(new File("black-knight.png"));
            whiteRook = ImageIO.read(new File("white-rook.png"));
            blackRook = ImageIO.read(new File("black-rook.png"));
            whiteQueen = ImageIO.read(new File("white-queen.png"));
            blackQueen = ImageIO.read(new File("black-queen.png"));
            whiteKing = ImageIO.read(new File("white-king.png"));
            blackKing = ImageIO.read(new File("black-king.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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
