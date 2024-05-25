import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessBoard extends JFrame implements MouseListener {
    private final ChessController controller;
    private final JPanel boardPanel;
    private final JLabel testPointLabel;

    public ChessBoard(ChessController controller) {
        this.controller = controller;
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

        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
            }
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("X: " + x + " Y: " + y);
        controller.newBoardClick(x,y);
        testPointLabel.setText(controller.getBoardClick());
    }

    //Unused methods from mouse listener
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
