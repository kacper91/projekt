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

 private char[][] board = new char[3][3];

    public void createGame() {

        for (int w = 0; w < board.length; w++) {
            for (int k = 0; k < board.length; k++) {
                board[w][k] = '-';
                System.out.print(board[w][k] + "\t");
            }
            System.out.println("\n");
        }
    }

    public void showBoard() {
        Board board = new Board();

        for (int w = 0; w < board.getBoard().length; w++) {
            for (int k = 0; k < board.getBoard().length; k++) {
                System.out.print(board.getBoard()[w][k] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");

    }


    public int checkHorizontal() { //poziom[w][k]
        if ((board[0][0] == board[0][1] && board[0][1] == board[0][2]) ||
                (board[1][0] == board[1][1] && board[1][1] == board[1][2]) ||
                (board[2][0] == board[2][1] && board[2][1] == board[2][2])) {
            System.out.println("Wygrales-poziom");

        } else {

            System.out.println("jednak nie wygrales");
        }
        return end = 1;
    }

    public int checkVertical() { //pion
        if ((board[0][0] == board[1][0] && board[1][0] == board[2][0]) ||
                (board[0][1] == board[1][1] && board[1][1] == board[2][1]) ||
                (board[0][2] == board[1][2] && board[1][2] == board[2][2])) {

            System.out.println("Wygrales-pion");
        }
        return end = 1;

    }

    public int checkCross() { //skos
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[2][0] == board[1][1] && board[1][1] == board[0][2])) {
            System.out.println("Wygrales-skos");
        }
        return end = 1;

    }

    public void endGame() {

        if (end == 1) {
            System.out.println("Koniec gry. Wygrałeś");

        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GameController gameController = new GameController();

        primaryStage.setTitle("Kolko i Krzyzyk");
        primaryStage.setScene(gameController.startGame());
        primaryStage.show();

    }


}