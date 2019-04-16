package pl.orlowski;

import javafx.scene.image.ImageView;

import java.util.Random;

public class Gameplay {

    Board element = new Board(board);

    public void gamePlay() {

        Random randomA = new Random();
        int a = randomA.nextInt(2);
        Random randomB = new Random();
        int b = randomB.nextInt(2);

        if (element[a][b] == '-'){
            button.setGraphic(new ImageView(getTurn()));

        }

    }

}
