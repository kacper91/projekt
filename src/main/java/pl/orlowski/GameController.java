package pl.orlowski;

import javafx.scene.Scene;
import pl.orlowski.TicTacToe;
import javafx.stage.Stage;

public class GameController {

    private Board board = new Board();

    public Scene startGame() {
        // switch
        return board.getScene();
    }
}

