package other.threads;

import ghosts.Enemy;
import other.Board;

import java.util.concurrent.TimeUnit;

public class CreateSpecialBalls implements Runnable {
    private Board board;

    public CreateSpecialBalls(Board board) {
        this.board = board;
    }

    @Override
    public void run() {
        while (board.isRunning()) {
            try {
                TimeUnit.MILLISECONDS.sleep(5000);
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
            createBall();
        }
    }

    private void createBall() {
        for (Enemy e : board.getEnemies()) {
            e.createSpecialBall(board.getTileGrid());
        }
    }
}
