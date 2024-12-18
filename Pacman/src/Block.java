//import java.awt.*;
//
//public class Block {
//    int x;
//    int y;
//    int startX;
//    int startY;
//
//    int width;
//    int height;
//    Image image;
//    char direction='U';  // U, D,L,R
//    int velocityX=0;
//    int velocityY=0;
//
//
//    Block(Image image,int x, int y,int width ,int height){
//        this.image=image;
//        this.x=x;
//        this.y=y;
//        this.width=width;
//        this.height=height;
//        this.startX=x;
//        this.startY=y;
//
//    }
//    void updateDirection(char direction){
//        this.direction=direction;
//        updateVelocity();
//    }
//    void updateVelocity(){
//        if(this.direction=='U'){
//            this.velocityX=0;
//            this.velocityY= -32/4; // tileSize/4
//        }
//        else if(this.direction=='D'){
//            this.velocityX=0;
//            this.velocityY=0;
//        }
//    }
//
//}
