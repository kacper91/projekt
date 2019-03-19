package pl.orlowski;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private Image imageback = new Image("plansza.jpg");
    private boolean turn = false;

    private char mark;
    private int end;

    private FlowPane figures = new FlowPane(Orientation.HORIZONTAL);


    char[][] plansza = new char[3][3];

    public void createGame() {

        for (int w = 0; w < plansza.length; w++) {
            for (int k = 0; k < plansza.length; k++) {
                plansza[w][k] = '-';
                System.out.print(plansza[w][k] + "\t");
            }
            System.out.println("\n");
        }
    }

    public void showBoard() {
        for (int w = 0; w < plansza.length; w++) {
            for (int k = 0; k < plansza.length; k++) {
                System.out.print(plansza[w][k] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n\n");
    }


    public int checkHorizontal() { //poziom[w][k]
        if ((plansza[0][0] == plansza[0][1] && plansza[0][1] == plansza[0][2]) ||
                (plansza[1][0] == plansza[1][1] && plansza[1][1] == plansza[1][2]) ||
                (plansza[2][0] == plansza[2][1] && plansza[2][1] == plansza[2][2])) {
            System.out.println("Wygrales-poziom");

        } else {

            System.out.println("jednak nie wygrales");
        }return end = 1;
    }

    public int checkVertical() { //pion
        if ((plansza[0][0] == plansza[1][0] && plansza[1][0] == plansza[2][0]) ||
                (plansza[0][1] == plansza[1][1] && plansza[1][1] == plansza[2][1]) ||
                (plansza[0][2] == plansza[1][2] && plansza[1][2] == plansza[2][2])) {

            System.out.println("Wygrales-pion");
        }return end = 1;

    }

    public int checkCross() { //skos
        if ((plansza[0][0] == plansza[1][1] && plansza[1][1] == plansza[2][2]) ||
                (plansza[2][0] == plansza[1][1] && plansza[1][1] == plansza[0][2])) {
            System.out.println("Wygrales-skos");
        }return end =1;

    }

    public void endGame(){

        if(end==1){
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