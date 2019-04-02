package pl.orlowski;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import pl.orlowski.Board;

public class GameController {

    private StackPane stackPane;
    private VBox vBox = new VBox();
    private pl.orlowski.Board board = new pl.orlowski.Board();

    public GameController(StackPane stackPane) {
        this.stackPane = stackPane;
    }

    public StackPane getMainMenu() {
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30.0);

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
