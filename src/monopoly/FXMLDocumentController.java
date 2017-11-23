/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.DoubleBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @version 1.1
 * @author Justin McGettigan
 */
public class FXMLDocumentController implements Initializable {
    
    private Image[] sprites = new Image[5];
    
    private final double spriteSize = 0.05, spriteAdjust = 1 - spriteSize;
    
    private Stage stage;
    
    private double pressedX, pressedY;
    
    private Board boardObject;

    public void setStage(Stage s) {
        stage = s;
    }

    public Stage getStage() {
        return stage;
    }

    //private Stage stage = Monopoly.mainStage;
    //private Scene scene;
    /*Questions
        -How to refer to the scene?
            -.getScene()
            -https://stackoverflow.com/questions/13015537/javafx-class-controller-stage-window-reference
            -Do I even need to?
        -How do I detect keypresses at any time?
            -KeyListener?
            -https://stackoverflow.com/questions/29962395/how-to-write-a-keylistener-for-javafx
    
     */
    /*Implement 
        -fullscreen option
        -custom mouse cursor (hand?)
        -The board must look good in fullscreen mode
        -when lands on corner, zooms out, board rotates, zooms in
        -optional zoom feature
     */
    
    @FXML
    private BorderPane bp;

    @FXML
    private MenuBar menu;

    @FXML
    private Pane p;

    @FXML
    private ScrollPane sp;

    @FXML
    private ImageView board, sprite;

    @FXML
    private Menu xCoord, yCoord;

    @FXML
    private MenuItem small, medium, large, huge;

    @FXML
    private Slider x, y;

    @FXML
    private void changeResolution(ActionEvent event) {

    }

    /*
    @FXML
    private void changeResolution(ActionEvent event){
        System.out.println("source:" + ((Control)event.getSource()).getId());
        int[][] list = null;
        String[][] List = new String[4][2];
        List[0] = small.textProperty().get().split("x");
        List[1] = medium.textProperty().get().split("x");
        List[2] = large.textProperty().get().split("x");
        List[3] = huge.textProperty().get().split("x");
        for(String[] item : List){
            for(String i : item){
                System.out.println(i + " ");
            }
        }
        for(int i = 0; i < List.length; i++){
            for(int k = 0; i < List[0].length; k++){
                list[i][k] = Integer.valueOf(List[i][k]);
            }
        }
        
        //stage.setWidth(spriteSize);
        //stage.setHeight(spriteSize);
    }*/
 /*
    void move(KeyEvent key) {
        switch (key.getCode()) {
            case RIGHT:
                x.valueProperty().add(10);
            case LEFT:
                x.valueProperty().subtract(10);
            case UP:
                y.valueProperty().add(10);
            case DOWN:
                y.valueProperty().subtract(10);
            default:
                break;
        }
    }*/
    
    private void fitBoard() {
        board.fitHeightProperty().bind(bp.heightProperty().subtract(menu.heightProperty()));
        board.fitWidthProperty().bind(board.fitHeightProperty());
        board.xProperty().bind(bp.widthProperty().divide(2).subtract(board.fitWidthProperty().divide(2)));
    }

    private void createSprite() {
        sprites[0] = new Image("./resources/superMarioBros.jpg");
        sprite = new ImageView(sprites[0]);
        sprite.fitWidthProperty().bind(board.fitWidthProperty().multiply(spriteSize));
        sprite.fitHeightProperty().bind(board.fitHeightProperty().multiply(spriteSize));
        //sprite.setX(100);
        //sprite.setY(100);
        /*
        sprite.setX(board.getFitWidth()*0.5);
        sprite.setY(board.getFitHeight()*0.5);*/
        //System.out.println("BorderPane width: " + bp.widthProperty().get());
        //System.out.println("BorderPane height: " + bp.heightProperty().get());
        //sprite.setX(bp.getWidth() * 0.5);
        //sprite.setY(bp.getHeight() * 0.5);
        //sprite.xProperty().bind(board.fitWidthProperty().multiply(0.8));
        //sprite.yProperty().bind(board.fitHeightProperty().multiply(0.8));
        p.getChildren().add(sprite);
        sprite.toFront();
    }

    @FXML
    private void sliderMovement() {
        //sprite is 0.05x0.05 large
        //0.95 * 675 = 641.25
        DoubleBinding spriteAdjustBind = board.fitWidthProperty().multiply(spriteAdjust).divide(100);
        sprite.xProperty().bind(x.valueProperty().multiply(spriteAdjustBind));
        x.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            //xCoord.setText(Integer.toString(newvalue.intValue()));
            xCoord.setText(Double.toString(sprite.getX()));
        });

        sprite.yProperty().bind(y.valueProperty().multiply(spriteAdjustBind));
        y.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            //yCoord.setText(Integer.toString(newvalue.intValue()));
            yCoord.setText(Double.toString(sprite.getY()));
        });
    }

    @FXML
    private void printDebugMessage() {
        System.out.println("Imageview width: " + board.getFitWidth());
        System.out.println("Imageview height: " + board.getFitHeight());
        System.out.println("BorderPane width: " + bp.widthProperty().get());
        System.out.println("BorderPane height: " + bp.heightProperty().get());
        System.out.println("Sprite xPos: " + sprite.getX());
        System.out.println("Sprite yPos: " + sprite.getY());
        
        //sprite.setX(board.getFitWidth() * spriteAdjust * 0.96);
        //sprite.setY(board.getFitHeight() * spriteAdjust * 0.95);
        System.out.println("Title: " + stage.titleProperty().get());
    }
    
    @FXML
    private void move1(){
        boardObject.move1();
        
    }
    @FXML
    private void move2(){
        boardObject.move2();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        try {
            //Stage stage = (Stage) bp.getScene().getWindow();
            System.out.println("Title: " + stage.titleProperty().get());
            //System.out.println(stage.titleProperty().get());
            //Scene scene = bp.getScene();
            //System.out.println("Scene height: " + scene.getHeight());
        } catch (Exception ex) {
            System.out.println("You done f'ed up.");
        }*/
        createSprite();
        fitBoard();
        //sliderMovement();
        boardObject = new Board(board, bp, sprite);
        boardObject.tilePositions();
        boardObject.initialSpritePosition();
        zooming();
        panning();
        //try to implement zoom based on mouse position
        //complicated but good references
        //https://stackoverflow.com/questions/29788184/javafx-8-dynamic-node-scaling
        
        /*
        bp.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent key) {
                if(key.getCode()==KeyCode.W){
                    System.out.println("up");
                    y.valueProperty().subtract(10);
                }
                if(key.getCode()==KeyCode.A){
                    System.out.println("left");
                    x.valueProperty().subtract(10);
                }
                if(key.getCode()==KeyCode.S){
                    System.out.println("down");
                    y.valueProperty().add(10);
                }
                if(key.getCode()==KeyCode.D){
                    System.out.println("right");
                    x.valueProperty().add(10);
                }
                /*
                switch (key.getCode()) {
                    case W: //up
                        System.out.println("up");
                        y.valueProperty().subtract(10);
                    case A: //left
                        System.out.println("left");
                        x.valueProperty().subtract(10);
                    case S: //down
                        System.out.println("down");
                        y.valueProperty().add(10);
                    case D: //right
                        System.out.println("right");
                        x.valueProperty().add(10);
                    default:
                        break;
                }
            }
        });*/
        //System.out.println("Parent of sprite is: " + sprite.parentProperty().get());
    }
    
    private void zooming(){ //make zoom smoother if possible and determine limits
        bp.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                double zoomFactor = 1.05;
                double deltaY = event.getDeltaY();
                if (deltaY < 0) {
                    zoomFactor = 2.0 - zoomFactor;
                }
                p.setScaleX(p.getScaleX() * zoomFactor);
                p.setScaleY(p.getScaleY() * zoomFactor);
                event.consume();
            }
        });
    }
    
    private void panning(){ //determine limits
        p.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pressedX = event.getX();
                pressedY = event.getY();
            }
        });
        p.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                p.setTranslateX(p.getTranslateX() + event.getX() - pressedX);
                p.setTranslateY(p.getTranslateY() + event.getY() - pressedY);
                event.consume();
            }
        });
    }

}
