package other.threads;

import ghosts.Enemy;
import other.Board;
import other.end.EndGame;

import java.util.concurrent.TimeUnit;

public class Lives implements Runnable {
    private Board board;

    public Lives(Board board) {
        this.board = board;
    }


    @Override
    public void run() {
        while (board.isRunning()) {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }

            handleImmortal();
            handleCollision();
        }
    }


    private void handleImmortal() {
        if (board.isImmortal()) {
            try {
                TimeUnit.MILLISECONDS.sleep(10000);
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
            board.setImmortal(false);
        }
    }

    private void handleCollision() {
        if (isCollision()) {
            board.removeLive();
            if (board.getLivesValue() == 0) {
                int totalPoints = board.getPointsValue();
                board.setRunning(false);
                EndGame endGame = new EndGame(totalPoints, board);

            }
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
        }
    }

    private boolean isCollision() {
        for (Enemy e : board.getEnemies()) {
            if ((board.getPacman().getTileX() == e.getTileX()) && (board.getPacman().getTileY() == e.getTileY())) {
                return true;
            }
        }
        return false;
    }
}
