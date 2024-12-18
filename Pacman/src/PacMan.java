import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;


public class PacMan extends JPanel implements ActionListener,KeyListener{
    private int rowCount=21;
    private int columnCount=19;
    private int tileSize=32;
    private int boardWidth =columnCount*tileSize;
    private int boardHeight =rowCount*tileSize;
    private Image wallImage;
    private Image blueGhostImage;
    private Image redGhostImage;
    private Image pinkGhostImage;
    private Image orangeGhostImage;

    private Image pacmanUpImage;
    private Image pacmanDownImage;
    private Image pacmanLeftImage;
    private Image pacmanRightImage;

    //X- wall, O-skip, P-pacman
    // ' ' - food,
    // Ghosts- b-blue,p-pink,o-orange,r-red
    private String[] tileMap = {
            "XXXXXXXXXXXXXXXXXXX",
            "X        X        X",
            "X XX XXX X XXX XX X",
            "X                 X",
            "X XX X XXXXX X XX X",
            "X    X       X    X",
            "XXXX XXXX XXXX XXXX",
            "OOOX X       X XOOO",
            "XXXX X XXrXX X XXXX",
            "O       bpo       O",
            "XXXX X XXXXX X XXXX",
            "OOOX X       X XOOO",
            "XXXX X XXXXX X XXXX",
            "X        X        X",
            "X XX XXX X XXX XX X",
            "X  X     P     X  X",
            "XX X X XXXXX X X XX",
            "X    X   X   X    X",
            "X XXXXXX X XXXXXX X",
            "X                 X",
            "XXXXXXXXXXXXXXXXXXX"
    };
    HashSet<Block> walls;
    HashSet<Block> foods;
    HashSet<Block> ghosts;
    Block pacman;

    Timer gameLoop;

    PacMan() {
        setPreferredSize(new Dimension(boardWidth,boardHeight));
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);
        // this above statement so that the Jpanel listens to the keylistener

        // load images
        wallImage=new ImageIcon(getClass().getResource("./wall.png")).getImage();
        blueGhostImage=new ImageIcon(getClass().getResource("./blueGhost.png")).getImage();
        redGhostImage=new ImageIcon(getClass().getResource("./redGhost.png")).getImage();
        pinkGhostImage=new ImageIcon(getClass().getResource("./pinkGhost.png")).getImage();
        orangeGhostImage=new ImageIcon(getClass().getResource("./orangeGhost.png")).getImage();

        pacmanUpImage=new ImageIcon(getClass().getResource("./pacmanUp.png")).getImage();
        pacmanLeftImage=new ImageIcon(getClass().getResource("./pacmanLeft.png")).getImage();
        pacmanDownImage=new ImageIcon(getClass().getResource("./pacmanDown.png")).getImage();
        pacmanRightImage=new ImageIcon(getClass().getResource("./pacmanRight.png")).getImage();

        loadMap();
        gameLoop= new Timer(50,this);
        gameLoop.start();


    }

    public void loadMap(){
        walls=new HashSet<Block>();
        foods=new HashSet<Block>();
        ghosts=new HashSet<Block>();

        for (int r=0;r<rowCount;r++){
            for(int c=0;c<columnCount;c++){
                String row=tileMap[r];
                char tileMapChar=row.charAt(c);

                int x=c*tileSize;
                int y=r*tileSize;
                if(tileMapChar== 'X'){
                    Block wall=new Block(wallImage,x,y,tileSize,tileSize);
                    walls.add(wall);
                }
                else if(tileMapChar== 'b'){
                    Block ghost=new Block(blueGhostImage,x,y,tileSize,tileSize);
                    ghosts.add(ghost);
                }

                else if(tileMapChar== 'o'){
                    Block ghost=new Block(orangeGhostImage,x,y,tileSize,tileSize);
                    ghosts.add(ghost);
                }
                else if(tileMapChar== 'p'){
                    Block ghost=new Block(pinkGhostImage,x,y,tileSize,tileSize);
                    ghosts.add(ghost);
                }
                else if(tileMapChar== 'r'){
                    Block ghost=new Block(redGhostImage,x,y,tileSize,tileSize);
                    ghosts.add(ghost);
                }
                else if(tileMapChar== 'P'){
                    pacman=new Block(pacmanRightImage,x,y,tileSize,tileSize);
                }
                else if(tileMapChar== ' '){
                    Block food=new Block(null,x+14,y+14,4,4);
                    foods.add(food);
                }




            }
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        g.drawImage(pacman.image,pacman.x, pacman.y,pacman.width,pacman.height,null);

        for(Block ghost:ghosts){
            g.drawImage(ghost.image,ghost.x,ghost.y,ghost.width,ghost.height,null);
        }
        g.setColor(Color.WHITE);
        for(Block food:foods){
            g.fillRect(food.x,food.y,food.width,food.height);
        }
        for(Block wall:walls){
            g.drawImage(wall.image,wall.x,wall.y,wall.width,wall.height,null);
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    //when in constructor PacMan the keylistener is called with "this"
    // it goes to these functions of the key listener for performing actions

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("KeyEvent: "+ e.getKeyCode());
    }
}
