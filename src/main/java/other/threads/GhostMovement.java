package other.threads;

import ghosts.Enemy;
import other.Board;

import java.util.concurrent.TimeUnit;


public class GhostMovement implements Runnable {

    private Board board;

    public GhostMovement(Board board) {
        this.board = board;
    }

    @Override
    public void run() {
        while (board.isRunning()) {
            moveGhosts();
        }
    }

    public void moveGhosts() {
       if (board.isGhostStopped()) {
            try {
                TimeUnit.MILLISECONDS.sleep(10000);
                board.setGhostStopped(false);
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
        } else {
            try {
                TimeUnit.MILLISECONDS.sleep(140);
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
            for (Enemy e : board.getEnemies()) {
                e.move();
            }
        }
    }
}
