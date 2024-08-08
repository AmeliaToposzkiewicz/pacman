package other.end;

import other.Board;
import other.frames.Menu;

import javax.swing.*;

public class EndGame {
    private static ScoreVector scoreList = new ScoreVector();
    private int totalPoints;
    private Board board;

    public EndGame(int totalPoints, Board board) {
        this.totalPoints = totalPoints;
        this.board = board;

        String username = JOptionPane.showInputDialog(
                null,
                "Your score is: " + totalPoints + ". Enter your username (20 characters max): ",
                "GAME OVER",
                JOptionPane.PLAIN_MESSAGE
        );

        if (username == null || username.isBlank() || username.length() > 20) {

            JOptionPane.showMessageDialog(
                    null,
                    "Your result was not saved :(",
                    "SAVED",
                    JOptionPane.ERROR_MESSAGE
            );
        } else {
            User user = new User(username, totalPoints);
            scoreList.addRecord(user);

            JOptionPane.showMessageDialog(
                    null,
                    "Your result has been saved :)",
                    "SAVED",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        JFrame frame = (JFrame) SwingUtilities.windowForComponent(board);
        frame.setVisible(false);
        SwingUtilities.invokeLater(() -> new Menu());

    }

}
