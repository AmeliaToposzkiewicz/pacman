package other.threads;

import other.Board;

import java.util.concurrent.TimeUnit;

public class PacmanAnimation implements Runnable {
    private Board board;


    public PacmanAnimation(Board board) {
        this.board = board;
    }

    @Override
    public void run() {
        while (board.isRunning()) {
            int lastPressedKey = board.getLastPressedKey();
            board.getPacman().setIndex(lastPressedKey);

            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
            board.getPacman().setIndex(0);
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }

        }
    }
}
