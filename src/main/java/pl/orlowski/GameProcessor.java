package pl.orlowski;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class GameProcessor {

    public static boolean checkResult(char[][] board) {
        if (checkHorizontal(board) || checkVertical(board) || checkX(board)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            ButtonType buttonTypeOne = new ButtonType("Exit");
            ButtonType buttonTypeTwo = new ButtonType("Reset");

            alert.setTitle("Result");
            alert.setContentText("End of game");
            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
            ButtonType buttonType = alert.showAndWait().get();

            if (buttonTypeOne.equals(buttonType)) {
                System.exit(-1);
            }
            if (buttonTypeTwo.equals(buttonType)) {
                return true;
            }
        }
        return false;
    }


    public static boolean checkVertical(char[][] board) { //pion

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

    public static boolean checkHorizontal(char[][] board) { //poziom

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

    public static boolean checkX(char[][] board) {


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
}
