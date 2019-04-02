package pl.orlowski;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.Arrays;

public class Board {

    private Image cross = new Image("krzyzyk.jpg");
    private Image circle = new Image("kolko.jpg");
    private Image imageback = new Image("plansza.jpg");
    private Image emptyImg = new Image("emptyImg.jpg");

    private Button[][] buttons = new Button[3][3];
    private GridPane gridPane;
    private char[][] board = new char[][]{
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'},
    };

    private char lastChar = '-';

    public Board() {
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
                button.setGraphic(new ImageView(emptyImg)); // tutaj pusty obrazek
                int tempRow = i;
                int tempColumn = j;

                button.setOnMouseClicked(action -> {
                    if (board[tempRow][tempColumn] == '-') {

                        button.setGraphic(new ImageView(getTurn()));
                        board[tempRow][tempColumn] = lastChar;
                        System.out.println(tempRow + " - " + tempColumn);
                        boolean isEnd = GameProcessor.checkResult(board);
                        if (isEnd) {
                            clearBoard();
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
//        showBoard.setOnMouseClicked(a -> ticTacToe.showBoard(board));
        return showBoard;
    }

    public void clearBoard() {
        buttons = new Button[3][];
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
