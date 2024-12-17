import java.awt.*;

public class Block {
    int x;
    int y;
    int startX;
    int startY;

    int width;
    int height;
    Image image;

    Block(Image image,int x, int y,int width ,int height){
        this.image=image;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.startX=x;
        this.startY=y;

    }

}
