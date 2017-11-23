/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * @version 1.1
 * @author Justin McGettigan
 */
public class Tile{
    
    private double x, y;
    private int ID;
    
    public Tile(int num) {
        ID = num;
    }
    
    public void setCoord(double X, double Y){
        x = X;
        y = Y;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public int getID(){
        return ID;
    }
    
    /*
    public void setXRatio(double x){
        xRatio = x;
    }
    
    public void setYRatio(double y){
        yRatio = y;
    }
    
    public double getXRatio(){
        return xRatio;
    }
    
    public double getYRatio(){
        return yRatio;
    }
    */
    
    /*
    public void translate(){
        translate.play();
    }
    
    public void setTranlateSpriteByX(double num){
        translate.setByX(num);
    }
    
    public void setTranlateSpriteByY(double num){
        translate.setByY(num);
    }*/
}
