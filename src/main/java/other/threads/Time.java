package other.threads;

import other.Board;
import other.end.EndGame;

import java.util.concurrent.TimeUnit;

public class Time implements Runnable {
    private Board board;

    public Time(Board board) {
        this.board = board;
    }

    @Override
    public void run() {
        while (board.isRunning()) {
            handleTime();
        }
    }

    private void handleTime() {
        if (board.getTimeValue() == 0) {
            int totalPoints = board.getPointsValue();
            board.setRunning(false);
            EndGame endGame = new EndGame(totalPoints, board);
        }
        if (board.isTimeStopped()) {
            try {
                TimeUnit.MILLISECONDS.sleep(10000);
                board.setTimeStopped(false);
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
        } else {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
            board.removeSecond();
        }
    }

}
