package application;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;

public class Board extends GridPane implements Observer{
	private Button boardView[][] = new Button[5][7];
	private int space = 60;
	private URL url;
	private Image Tot, Hum, BTom,background;
	private int squareSize = 20;
	private Controller controller;
	Board() {
		InitBoard();
		url = getClass().getResource("/application/images/");
		Tot = new Image(url+"Tot.png",squareSize,squareSize,true,true);
		BTom = new Image(url+"BTom.png",squareSize,squareSize,true,true);
		Hum = new Image(url+"Hum.png",squareSize,squareSize,true,true);
		background = new Image(url+"board.jpg",squareSize,squareSize,true,true);
	}

	Board(Controller controller) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("Board.fxml"));
		this.controller=controller;
		InitBoard();
		url = getClass().getResource("/application/images/");
		Tot = new Image(url+"Tot.png",squareSize,squareSize,true,true);
		BTom = new Image(url+"BTom.png",squareSize,squareSize,true,true);
		Hum = new Image(url+"Hum.png",squareSize,squareSize,true,true);
		background = new Image(url+"board.jpg",squareSize,squareSize,true,true);
		updateBoard(controller.getData().getBoardData());
		add(root,0,0);
		
	}
	
	@Override
	public void update(Observable s, Object arg) {
		updateBoard(controller.getData().getBoardData());
	}
	
	public void InitBoard() {
//        setBackground(new Background( new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT)));
		for (int i=0; i<5; i++) {
			for (int j=0; j<7; j++) {
				boardView[i][j] = new Button();
				if (i==0 && j==0 || i==0 && j==1|| i==1 && j==0 || i==3 && j==0 || i==4 && j==0 || i==4 && j==1 )
					continue;
				add(boardView[i][j],i,j);
				getStylesheets().add(getClass().getResource("boardStyle.css").toExternalForm());
				setVgap(space);
				setHgap(space);
			}
		}
	}
	
	public void updateBoard(String[][] boardData) {
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				if (boardData[i][j].equals("Tot")) {
					boardView[j][i].setGraphic(new ImageView(Tot));
				}
				if (boardData[i][j].equals("Hum")) {
					boardView[j][i].setGraphic(new ImageView(Hum));
				}
				if (boardData[i][j].equals("BTom")) {
					boardView[j][i].setGraphic(new ImageView(BTom));
				}
			}
		}
	}
}
