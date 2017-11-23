/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

/**
 * @version 1.1
 * @author Justin McGettigan
 */
public class Board{
    
    private ImageView board, sprite;
    private BorderPane bp;
    private Tile[] tiles;
    private Player player;
    private TranslateTransition[] translate;
    private double xRatio, yRatio;
    
    public Board(){
        
    }
    
    public Board(ImageView b, BorderPane bP, ImageView s){
        board = b;
        bp = bP;
        sprite = s;
        translate = new TranslateTransition[9];
        tiles = new Tile[40];
        
    }
    
    private void initializeTiles(){
        double bWidth = board.getFitWidth(), bHeight = board.getFitHeight();
        double normal = 0.1, corner = 0.11;
        System.out.println("Board Width: " + bWidth);
        System.out.println("Board Height: " + bHeight);
        /*
        for(int i = 0; i < tiles.length; i++){
            tiles[i] = new Tile(i);
            if(i < 1){
                tiles[i].setCoord(bWidth*-corner, 0);
            } else if(i < 10){
                tiles[i].setCoord(tiles[i-1].getX()-(bWidth*normal), 0);
            } else if(i < 11){
                tiles[i].setCoord(tiles[i-1].getX()-(bWidth*corner), 0);
            } else if(i < 20){
                tiles[i].setCoord(tiles[i-1].getX(), bHeight*normal);
            } else if(i < 21){
                tiles[i].setCoord(tiles[i-1].getX(), tiles[i-1].getY()-(bHeight*corner));
            } else if(i < 30){
                tiles[i].setCoord(tiles[i-1].getX()+(bWidth*normal), tiles[i-1].getY());
            } else if(i < 31){
                tiles[i].setCoord(tiles[i-1].getX()+(bWidth*corner), tiles[i-1].getY());
            } else if(i < 40){
                tiles[i].setCoord(tiles[i-1].getX(), tiles[i-1].getY()+(bHeight*normal));
            }
        }*/
    }
    
    public void tilePositions(){
        xRatio = 0.95;
        yRatio = 0.95;
        
        //tiles[1].setXRatio(0.834);
        //tiles[1].setYRatio(0.83);
        
        //tiles[0].setX(board.getFitWidth()*0.95);
        //tiles[0].setY(board.getFitHeight()*0.95);
        
        /*
        tiles[0].setTranlateSpriteByX(board.getFitWidth()*-0.11);
        for(int i = 1; i < 9; i++){
            tiles[i].setTranlateSpriteByX(board.getFitWidth()*-0.1);
        }
        tiles[9].setTranlateSpriteByX(board.getFitWidth()*-0.11);
        for(int i = 10; i < 19; i++){
            tiles[i].setTranlateSpriteByY(board.getFitWidth()*-0.1);
        }
        tiles[19].setTranlateSpriteByY(board.getFitWidth()*-0.11);
        for(int i = 20; i < 29; i++){
            tiles[i].setTranlateSpriteByX(board.getFitWidth()*-0.11);
        }
        tiles[29].setTranlateSpriteByX(board.getFitWidth()*-0.11);
        for(int i = 30; i < 39; i++){
            tiles[i].setTranlateSpriteByY(board.getFitWidth()*-0.11);
        }
        tiles[39].setTranlateSpriteByY(board.getFitWidth()*0.11);*/
    }
    
    public void initialSpritePosition(){
        //sprite.setX(board.getFitWidth() * xRatio);
        //sprite.setY(board.getFitHeight() * yRatio);
        
        sprite.xProperty().bind(board.fitWidthProperty().multiply(xRatio-0.025));
        sprite.yProperty().bind(board.fitHeightProperty().multiply(yRatio-0.025));
        
    }
    
    
    /*
    assign coord value to each tile.
    from(current position)
    to(target position)
    
    move(from, to);
    move(current, target)
    
    //translate[0].setFromX(tile[0]);
    translate[0].setToX(tile[1]);
    translate.play();
    
    translate[1].setFromX(translate[0].getToX());
    translate[1].setToX(tile[2]);
    
    translate.setFromX(tile before moving);
    translate.setToX(tile after moving);
    translate.play();
    */
    
    /*
    0->1
    
    [1->9]
    
    9->10
    10->11
    
    [11->19]
    
    19->20
    20->21
    
    [21->29]
    
    29->30
    30->31
    
    [31->39]
    
    39->0
    */
    
    /*
      
    20->21->22->23->24->25->26->27->28->29->30
    /\                                      \/
    19                                      31
    /\                                      \/
    18                                      32
    /\                                      \/
    17                                      33
    /\                                      \/
    16                                      34
    /\                                      \/
    15                                      35
    /\                                      \/
    14                                      36
    /\                                      \/
    13                                      37
    /\                                      \/
    12                                      38
    /\                                      \/
    11                                      39
    /\                                      \/
    10<-09<-08<-07<-06<-05<-04<-03<-02<-01<-00
    */
    
    /*
    
    */
    public void move1(){
        initializeTiles();
        player = new Player(sprite, tiles);
        player.move(tiles[0], tiles[20]);
        
        /*
        double bWidth = board.getFitWidth(), bHeight = board.getFitHeight();
        double[] tile = new double[10];
        for(int i = 0; i < tile.length; i++){
            tile[i] = bWidth * -(0.095*i);
        }
        SequentialTransition seqTransition = new SequentialTransition(new PauseTransition(Duration.millis(1000)));
        int target = 5;
        
        for(int i = 0; i < target; i++){
            tiles[i].getTranslate().setFromX(tile[i]);
            tiles[i].getTranslate().setToX(tile[i+1]);
            seqTransition.getChildren().add(tiles[i].getTranslate());
        }
        seqTransition.play();*/
        
        
        //translate.toXProperty().bind(board.fitWidthProperty().multiply(-0.11));
        //translate.toYProperty().bind(board.fitHeightProperty().multiply(-1));
        //translate.setAutoReverse(true);
        //translate.setCycleCount(100);
        //translate.play();
    }
    
    public void move2(){
        //translate.setFromX(board.getFitWidth()*-0.11);
        //translate.setToX(board.getFitWidth()*-0.2);
        //translate.play();
        
        //tiles[1].translate();
    }
}
