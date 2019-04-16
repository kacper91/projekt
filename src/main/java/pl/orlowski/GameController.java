package pl.orlowski;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameController {

    private StackPane stackPane = new StackPane();
    private VBox vBox = new VBox();
    private Board board;
    private Stage stage;

    public GameController(Stage stage) {
        this.stage = stage;
        this.board = new Board(stage);
    }

    public void startGame(Stage stage) {

        StackPane mainMenu = getMainMenu();
        Scene scene = new Scene(mainMenu, 1000, 1000, Color.BLACK);

        stage.setTitle("Kolko i Krzyzyk");
        stage.setScene(scene);
        stage.show();
    }

    public void restart() {
        board = new Board(stage);
        vBox = new VBox();

        startGame(stage);
    }

    public StackPane getMainMenu() {
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30.0);

        Button restartGameButton = new Button();
        restartGameButton.setText("Restart Game");
        restartGameButton.setOnAction(event -> {
            System.out.println( "Restarting app!" );
            stage.close();
            Platform.runLater( () -> {
                try {
                    new TicTacToe().start( new Stage() );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });

        Button startGameButton = new Button();
        startGameButton.setText("Start new game");
        startGameButton.setOnAction(event -> {
            vBox.getChildren().clear();
            generateGameBoard();
        });

        Button endGameButton = new Button();
        endGameButton.setText("End game");
        endGameButton.setOnAction(event -> System.exit(-1));

        vBox.getChildren().addAll(startGameButton, endGameButton);
        stackPane.getChildren().add(vBox);

        return stackPane;
    }

    public void generateGameBoard() {
        vBox.getChildren().clear();
        stackPane.getChildren().clear();
        stackPane.getChildren().add(board.getGridPane());
    }

}
