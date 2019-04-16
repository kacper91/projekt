package pl.orlowski;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Arrays;

public class Board {

    private Image cross = new Image("krzyzyk.jpg");
    private Image circle = new Image("kolko.jpg");
    private Image imageback = new Image("plansza.jpg");
    private Button[][] buttons = new Button[3][3];
    private GridPane gridPane;
  private Stage stage;
    private char[][] board = new char[][]{
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'},
    };

    private char lastChar = '-';


    public Board(Stage stage) {
    this.stage = stage;
        generateButton();
        createGridPane();
    }

    private void generateButton() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                Button button = new Button();
                button.setBackground(null);
                button.setPrefWidth(200);
                button.setPrefHeight(200);
                button.setGraphic(new ImageView()); // tutaj pusty obrazek
                int tempRow = i;
                int tempColumn = j;

                button.setOnMouseClicked(action -> {
                    if (board[tempRow][tempColumn] == '-') {

                        button.setGraphic(new ImageView(getTurn()));
                        board[tempRow][tempColumn] = lastChar;
                      //  System.out.println(tempRow + " - " + tempColumn);
                        boolean isEnd = GameProcessor.checkResult(board);
                        if (isEnd) {
                            System.out.println( "Restarting app!" );
                            stage.close();
                            Platform.runLater( () -> {
                                try {
                                    new TicTacToe().start( new Stage() );
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });

                        }
                    } else {
                        System.out.println("Choose another field");
                    }

                });
                buttons[i][j] = button;
            }
        }
    }

    private Image getTurn() {
        if(lastChar == 'x') {
            lastChar = 'o';
            return circle;
        } else if(lastChar == 'o') {
            lastChar = 'x';
            return cross;
        } else {
            lastChar = 'x';
            return cross;
        }
    }

    private void createGridPane() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.setPadding(new Insets(0, 0, 0, 0));
        grid.setHgap(0);
        grid.setVgap(0);
        BackgroundSize backgroundSize = new BackgroundSize(600, 600, false, false, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

        Background background = new Background(backgroundImage);
        grid.setBackground(background);
        grid.add(createBtnShowBoard(), 20,80);

        for(int i = 0; i < buttons.length; i++) {
            for(int j = 0; j < buttons.length; j++) {
                grid.add(buttons[i][j], i * 20, j * 20);
            }
        }

        gridPane = grid;
    }

    private Button createBtnShowBoard() {
        Button showBoard = new Button();
        showBoard.setText("Show Board");
//        showBoard.setBackground(null);
        showBoard.setPrefHeight(50);
        showBoard.setPrefWidth(100);
        showBoard.setOnMouseClicked(a -> showBoard(board));
        return showBoard;
    }

    private void showBoard(char[][] board) {

        for (int w = 0; w < board.length; w++) {
            for (int k = 0; k < board.length; k++) {
                System.out.print(board[k][w] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");

//        System.out.println("checkHorizontal: " + GameProcessor.checkResult(board));
//        System.out.println("checkX: " + GameProcessor.checkX(board));
//        System.out.println("checkVertical: " + GameProcessor.checkVertical(board));

    }

    public void clearBoard() {
        buttons = new Button[3][3];
        board = new char[][]{
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'},
        };
        generateButton();
        createGridPane();
    }

    public GridPane getGridPane() {
        return gridPane;
    }
}
