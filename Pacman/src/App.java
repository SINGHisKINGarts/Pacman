import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int rowCount=21;
        int columnCount=19;
        int tileSize=32;
        int boardWidth =columnCount*tileSize;
        int boardHeight =rowCount*tileSize;

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PacMan pacmanGame=new PacMan();
        frame.add(pacmanGame);
        frame.pack();
        pacmanGame.requestFocus(); // explained the reason of it in pacman constructor
        frame.setVisible(true);


    }
}
