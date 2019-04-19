package comp1110.ass2.gui;

import comp1110.ass2.RailroadInk;
import gittest.B;
import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * A very simple viewer for tile placements in the Railroad Ink game.
 * <p>
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various tile placements.
 */
public class Viewer extends Application {
    /* board layout */
    private static final int VIEWER_WIDTH = 1024;
    private static final int VIEWER_HEIGHT = 768;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group controls = new Group();
    TextField textField;

    private final Group board = new Group();
    private final Group tiles = new Group();
    private final Group tempTiles = new Group();


    private int TILE_LENGTH = 70; //Defining each Tile length
    private int BOARD_WIDTH = TILE_LENGTH*9; //Defining board width
    private int BOARD_HEIGHT = TILE_LENGTH*9; //defining board height
    private int BOARD_X_OFFSET = 20; //Setting offset for the board
    private int BOARD_Y_OFFSET = 20;
    private static final Paint SUBBOARD_FILL = Color.DARKGREY;
    private static final Paint SUBBOARD_TILE = Color.GREY;
    public static final String HighExit = Viewer.class.getResource(URI_BASE + "HighExit.png").toString();
    public static final String RailExit = Viewer.class.getResource(URI_BASE + "RailExit.png").toString();


    private int ROLL_POS_OFFSET = (BOARD_X_OFFSET + BOARD_WIDTH);

    RailroadInk logic;


    private void makeBoard(){
        Rectangle background = new Rectangle(BOARD_WIDTH,BOARD_HEIGHT);
        background.setFill(SUBBOARD_FILL);
        background.setLayoutX(BOARD_X_OFFSET);
        background.setLayoutY(BOARD_Y_OFFSET);
        board.getChildren().add(background); //Setting up board by calling Rectangle

        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                Rectangle piece = new Rectangle(TILE_LENGTH, TILE_LENGTH);
                piece.setFill(Color.WHITE);
                piece.setStroke(SUBBOARD_TILE);
                piece.setLayoutX(col*TILE_LENGTH + BOARD_X_OFFSET + TILE_LENGTH);
                piece.setLayoutY(row*TILE_LENGTH +BOARD_Y_OFFSET +TILE_LENGTH);
                board.getChildren().add(piece); //Setting the Grid for Tile placements
            }
        }

        Image HE = new Image(HighExit);
        Image RE = new Image(RailExit);

        for (int row = 0; row < 7; row++){   //Setting up the Board exits depending on row and column
            for (int col = 0 ; col < 7; col++){
                if (row == 0) {
                    if (col == 1 || col == 5){
                        ImageView hExit = new ImageView(HE);
                        hExit.setX(BOARD_X_OFFSET+TILE_LENGTH*(col+1));
                        hExit.setY(BOARD_Y_OFFSET);
                        hExit.setFitWidth(TILE_LENGTH);
                        hExit.setFitHeight(TILE_LENGTH);
                        board.getChildren().add(hExit);
                    }
                    if (col == 3){
                        ImageView rExit = new ImageView(RE);
                        rExit.setX(BOARD_X_OFFSET+TILE_LENGTH*(col+1));
                        rExit.setY(BOARD_Y_OFFSET);
                        rExit.setFitWidth(TILE_LENGTH);
                        rExit.setFitHeight(TILE_LENGTH);
                        board.getChildren().add(rExit);
                    }

                }

                if (row == 6) {
                    if (col == 1 || col == 5){
                        ImageView hExit = new ImageView(HE);
                        hExit.setRotate(hExit.getRotate() + 180);
                        hExit.setX(BOARD_X_OFFSET+TILE_LENGTH*(col+1));
                        hExit.setY(BOARD_Y_OFFSET+ 8*TILE_LENGTH);
                        hExit.setFitWidth(TILE_LENGTH);
                        hExit.setFitHeight(TILE_LENGTH);
                        board.getChildren().add(hExit);
                    }
                    if (col == 3){
                        ImageView rExit = new ImageView(RE);
                        rExit.setRotate(rExit.getRotate() + 180);
                        rExit.setX(BOARD_X_OFFSET+TILE_LENGTH*(col+1));
                        rExit.setY(BOARD_Y_OFFSET + 8*TILE_LENGTH);
                        rExit.setFitWidth(TILE_LENGTH);
                        rExit.setFitHeight(TILE_LENGTH);
                        board.getChildren().add(rExit);
                    }

                }

                if (col == 0){
                    if (row == 1 ||row == 5){
                        ImageView rExit = new ImageView(RE);
                        rExit.setRotate(rExit.getRotate() + 270);
                        rExit.setX(BOARD_X_OFFSET);
                        rExit.setY(BOARD_Y_OFFSET+TILE_LENGTH*(row+1));
                        rExit.setFitWidth(TILE_LENGTH);
                        rExit.setFitHeight(TILE_LENGTH);
                        board.getChildren().add(rExit);
                    }
                    if (row == 3){
                        ImageView hExit = new ImageView(HE);
                        hExit.setRotate(hExit.getRotate() + 270);
                        hExit.setX(BOARD_X_OFFSET);
                        hExit.setY(BOARD_Y_OFFSET+TILE_LENGTH*(row+1));
                        hExit.setFitWidth(TILE_LENGTH);
                        hExit.setFitHeight(TILE_LENGTH);
                        board.getChildren().add(hExit);
                    }
                }

                if (col == 6){
                    if (row == 1 ||row == 5){
                        ImageView rExit = new ImageView(RE);
                        rExit.setRotate(rExit.getRotate() + 90);
                        rExit.setX(BOARD_X_OFFSET+TILE_LENGTH*8);
                        rExit.setY(BOARD_Y_OFFSET+TILE_LENGTH*(row+1));
                        rExit.setFitWidth(TILE_LENGTH);
                        rExit.setFitHeight(TILE_LENGTH);
                        board.getChildren().add(rExit);
                    }
                    if (row == 3){
                        ImageView hExit = new ImageView(HE);
                        hExit.setRotate(hExit.getRotate() + 90);
                        hExit.setX(BOARD_X_OFFSET+TILE_LENGTH*8);
                        hExit.setY(BOARD_Y_OFFSET+TILE_LENGTH*(row+1));
                        hExit.setFitWidth(TILE_LENGTH);
                        hExit.setFitHeight(TILE_LENGTH);
                        board.getChildren().add(hExit);
                    }
                }
            }
        }

    }

    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     */



    void makePlacement(String placement) {
        // FIXME Task 4: implement the simple placement viewer
        tiles.getChildren().clear(); //clear board before placing

        int counter = 0; //For string slicing
        String [] sPlacement = new String[placement.length()/5]; //Counting number of pieces to place it into String Array
        for (int sub=0; sub < (placement.length()/5); sub++){
            sPlacement [sub] = placement.substring(counter, counter+5);
            counter = counter+5;
        }

        for (int i= 0; i < sPlacement.length; i++){
          Image pType = new Image(Viewer.class.getResource(URI_BASE + sPlacement[i].substring(0,2) +".png").toString()); // loading the image of the piece called
          ImageView tile = new ImageView(pType);
          int col = Integer.parseInt(sPlacement[i].substring(3,4)); //Determining column of string by slicing
          char row = sPlacement[i].charAt(2);   //Determining row of string by slicing
          tile.setX(BOARD_X_OFFSET+TILE_LENGTH*(col+1)); //Setting offset of Col
          tile.setY(BOARD_Y_OFFSET+TILE_LENGTH*(Character.getNumericValue(row)-9)); //Setting offset of row
          tile.setFitWidth(TILE_LENGTH); //Setting width and height of tile
          tile.setFitHeight(TILE_LENGTH);
          switch (sPlacement[i].substring(4,5)){ //Set tile into various orientation
              default:
                  break;
              case "1":
                  tile.setRotate(tile.getRotate() + 90);
                  break;
              case "2":
                  tile.setRotate(tile.getRotate() + 180);
                  break;
              case "3":
                  tile.setRotate(tile.getRotate() + 270);
                   break;
              case "4":
                  tile.nodeOrientationProperty().setValue(NodeOrientation.RIGHT_TO_LEFT);
                  break;
              case "5":
                  tile.nodeOrientationProperty().setValue(NodeOrientation.RIGHT_TO_LEFT);
                  tile.setRotate(tile.getRotate() + 90);
                  break;
              case "6":
                  tile.nodeOrientationProperty().setValue(NodeOrientation.RIGHT_TO_LEFT);
                  tile.setRotate(tile.getRotate() + 180);
                  break;
              case "7":
                  tile.nodeOrientationProperty().setValue(NodeOrientation.RIGHT_TO_LEFT);
                  tile.setRotate(tile.getRotate() + 270);
                  break;
          }


          tiles.getChildren().add(tile);
        }
    }


    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        tiles.getChildren().clear();
        Label label1 = new Label("Placement:");
        textField = new TextField();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(e -> {
            makePlacement(textField.getText());
            textField.clear();
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }


    private void generateRoll() {
        Button rollButton = new Button("Roll Dices!");
        rollButton.setOnAction(e -> {rollPlacementHolder();
        });

        HBox roll = new HBox();
        roll.getChildren().add(rollButton);
        roll.setSpacing(10);
        roll.setLayoutX(ROLL_POS_OFFSET + (VIEWER_WIDTH - ROLL_POS_OFFSET)/2);
        roll.setLayoutY(20);
        controls.getChildren().add(roll);

    }

    private void rollPlacementHolder() {
        tempTiles.getChildren().clear();
        String rolled = logic.generateDiceRoll();
        Image piece1 = new Image(Viewer.class.getResource(URI_BASE + rolled.substring(0,2) +".png").toString());
        Image piece2 = new Image(Viewer.class.getResource(URI_BASE + rolled.substring(2,4) +".png").toString());
        Image piece3 = new Image(Viewer.class.getResource(URI_BASE + rolled.substring(4,6) +".png").toString());
        Image piece4 = new Image(Viewer.class.getResource(URI_BASE + rolled.substring(6,8) +".png").toString());
        ImageView tempTile1 = new ImageView(piece1);
        ImageView tempTile2 = new ImageView(piece2);
        ImageView tempTile3 = new ImageView(piece3);
        ImageView tempTile4 = new ImageView(piece4);
        tempTile1.setX(ROLL_POS_OFFSET + (VIEWER_WIDTH - ROLL_POS_OFFSET)/3);
        tempTile1.setY(50);
        tempTile1.setFitWidth(TILE_LENGTH);
        tempTile1.setFitHeight(TILE_LENGTH);

        tempTile2.setX((ROLL_POS_OFFSET + (VIEWER_WIDTH - ROLL_POS_OFFSET)/3)*2);
        tempTile2.setY(50);
        tempTile2.setFitWidth(TILE_LENGTH);
        tempTile2.setFitHeight(TILE_LENGTH);

        tempTile3.setX(ROLL_POS_OFFSET + (VIEWER_WIDTH - ROLL_POS_OFFSET)/3);
        tempTile3.setY(TILE_LENGTH + 70);
        tempTile3.setFitWidth(TILE_LENGTH);
        tempTile3.setFitHeight(TILE_LENGTH);

        tempTile4.setX((ROLL_POS_OFFSET + (VIEWER_WIDTH - ROLL_POS_OFFSET)/3)*2);
        tempTile4.setY(TILE_LENGTH + 70);
        tempTile4.setFitWidth(TILE_LENGTH);
        tempTile4.setFitHeight(TILE_LENGTH);

        tempTiles.getChildren().add(tempTile1);
        tempTiles.getChildren().add(tempTile2);
        tempTiles.getChildren().add(tempTile3);
        tempTiles.getChildren().add(tempTile4);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("StepsGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
        root.getChildren().add(controls);
        root.getChildren().add(board);
        root.getChildren().add(tiles);

        makeControls();
        makeBoard();
        generateRoll();


        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
