package pl.orlowski;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class TicTacToe extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameController guiController = new GameController(new StackPane());


        StackPane mainMenu = guiController.getMainMenu();
        Scene scene = new Scene(mainMenu, 1000, 1000, Color.BLACK);

        primaryStage.setTitle("Kolko i Krzyzyk");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showBoard(char[][] board) {

        for (int w = 0; w < board.length; w++) {
            for (int k = 0; k < board.length; k++) {
                System.out.print(board[k][w] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");

//        System.out.println("checkHorizontal: " + checkHorizontal(board));
//        System.out.println("checkX: " + checkX(board));
//        System.out.println("checkVertical: " + checkVertical(board));

    }
}
