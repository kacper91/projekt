package pl.orlowski;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Board {

    private Image cross = new Image("krzyzyk.jpg");
    private Image circle = new Image("kolko.jpg");
    private Image imageback = new Image("plansza.jpg");
    private char lastChar = '-';

    private char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'},
    };

    private Button[][] buttons = new Button[3][3];

    private GridPane gridPane;

    public Board() {
        generateButton();
        createGridPane();
    }

    public Scene getScene() {
        return new Scene(gridPane, 600, 900, Color.BLACK);
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

        for(int i = 0; i < buttons.length; i++) {
            for(int j = 0; j < buttons.length; j++) {
                grid.add(buttons[i][j], i * 20, j * 20);
            }
        }
    }

    private void generateButton() {
        for(int i =0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                Button button = new Button();
                button.setBackground(null);
                button.setPrefWidth(200);
                button.setPrefHeight(20);
                int tempRow = i;
                int tempColumn = j;
                button.setOnMouseClicked(action -> {
                    if(board[tempRow][tempColumn] == '-') {
                        button.setGraphic(new ImageView(getTurn()));
                        board[tempRow][tempColumn] = lastChar;
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
            return getCircle();
        } else if(lastChar == 'o') {
            lastChar = 'x';
            return getCross();
        } else {
            lastChar = 'o';
            return getCross();
        }
    }

    public Image getCross() {
        return cross;
    }

    public Image getCircle() {
        return circle;
    }
}
