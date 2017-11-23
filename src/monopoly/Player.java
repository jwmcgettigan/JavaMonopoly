package monopoly;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @version 1.1
 * @author Justin McGettigan
 */
public class Player {
    
    private TranslateTransition translate;
    private ImageView sprite;
    private SequentialTransition seqTrans;
    private Tile[] tiles;
    
    public Player(ImageView s, Tile[] ti){
        sprite = s;
        tiles = ti;
    }
    
    public void move(Tile current, Tile target){
        seqTrans = new SequentialTransition(new PauseTransition(Duration.millis(1000)));
        for(int i = 0; i < target.getID(); i++){
            translate = new TranslateTransition(Duration.millis(1000), sprite);
            translate.setFromX(tiles[i].getX());
            translate.setToX(tiles[i+1].getX());
            seqTrans.getChildren().add(translate);
        }
        seqTrans.play();
        
        /*
        translate.setFromX(current.getX());
        translate.setFromY(current.getY());
        translate.setToX(target.getX());
        translate.setToY(target.getY());*/
        //translate.play();
    }
}
