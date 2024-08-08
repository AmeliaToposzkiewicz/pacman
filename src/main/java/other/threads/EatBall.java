package other.threads;

import boards.Ball;
import other.Board;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class EatBall implements Runnable {

    private Board board;

    public EatBall(Board board) {
        this.board = board;
    }

    @Override
    public void run() {
        while (board.isRunning()) {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
            handleEating();
        }
    }

    private void handleEating() {

        if (board.getTileGrid().getBall(board.getPacman().getTileX(), board.getPacman().getTileY()) != null) {
            Ball currentBall = board.getTileGrid().getBall(board.getPacman().getTileX(), board.getPacman().getTileY());
            board.getTileGrid().removeBalls(board.getPacman().getTileX(), board.getPacman().getTileY());

            if (currentBall.getColor().equals(Color.YELLOW)) {
                board.addPoints(1);
            } else if (currentBall.getColor().equals(Color.GREEN)) {
                board.addPoints(30);
            } else if (currentBall.getColor().equals(Color.MAGENTA)) {
                board.setTimeStopped(true);
            } else if (currentBall.getColor().equals(Color.CYAN)) {
                board.setGhostStopped(true);
            } else if (currentBall.getColor().equals(Color.RED)) {
                board.addLive();
            } else if (currentBall.getColor().equals(Color.WHITE)) {
                board.setImmortal(true);
            }
        }
    }
}
