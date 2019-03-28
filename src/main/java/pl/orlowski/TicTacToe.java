package pl.orlowski;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private Image imageback = new Image("plansza.jpg");

    private int end;

    private FlowPane figures = new FlowPane(Orientation.HORIZONTAL);

    public void showBoard(char[][] board) {

        for (int w = 0; w < board.length; w++) {
            for (int k = 0; k < board.length; k++) {
                System.out.print(board[k][w] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");

        System.out.println("checkHorizontal: " + checkHorizontal(board));
        System.out.println("checkX: " + checkX(board));
        System.out.println("checkVertical: " + checkVertical(board));

    }

    public boolean checkVertical(char[][] board) { //pion

        for (int i = 0; i < board.length; i++) {
            char sum = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '-') {
                    sum += board[i][j];
                }
            }
            if (sum == (120 * board.length) || sum == (111 * board.length)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkHorizontal(char[][] board) { //poziom

        for (int j = 0; j < board.length; j++) {
            char sum = 0;
            for (int i = 0; i < board[j].length; i++) {
                if (board[i][j] != '-') {
                    sum += board[i][j];
                }
            }
            if (sum == (120 * board.length) || sum == (111 * board.length)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkX(char[][] board) {
        // x      0   2,0
        //    xo       1,1
        // 0     x    0,2

        char sum = 0;
        for (int i = 0; i < board.length; i++) {
            sum += board[i][i];
        }
        if (sum == (120 * board.length) || sum == (111 * board.length)) {

            return true;
        }
        sum = 0;


        for (int i = board.length - 1, j = 0; i >= 0; i--, j++) {
//            System.out.println("i = " + i + " j = " + j);
            sum += board[i][j];
        }
        if (sum == (120 * board.length) || sum == (111 * board.length)) {
            return true;
        }
        return false;

    }

    public void checkResult(char[][] board) {
        if (checkHorizontal(board)) {
            end = true;
        }

        if (checkVertical(board)) {

        }

        if (checkX(board)){

        }


    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GameController gameController = new GameController();
        Board board = new Board();
        primaryStage.setTitle("Kolko i Krzyzyk");
        primaryStage.setScene(gameController.startGame());
        primaryStage.show();

    }


}


//przycisk startujacy gre/
//reset gry
//alert gdy ktoras z metod sprawdzajacych jest true