package other;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keys extends KeyAdapter {

    private Board board;

    public Keys(Board board) {
        this.board = board;

    }

    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();

        if (keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_UP) {
            if (board.getTileGrid().getTile(board.getPacman().getTileX(), board.getPacman().getTileY() - 1).getColor().equals(Color.BLACK)) {
                board.getPacman().move(0, -1);
                board.getPacman().setIndex(3);
                board.setLastPressedKey(3);
            }
        }
        if (keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN) {
            if (board.getTileGrid().getTile(board.getPacman().getTileX(), board.getPacman().getTileY() + 1).getColor().equals(Color.BLACK)) {
                board.getPacman().move(0, 1);
                board.getPacman().setIndex(4);
                board.setLastPressedKey(4);
            }
        }
        if (keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_LEFT) {
            if (board.getTileGrid().getTile(board.getPacman().getTileX() - 1, board.getPacman().getTileY()).getColor().equals(Color.BLACK)) {
                board.getPacman().move(-1, 0);
                board.getPacman().setIndex(1);
                board.setLastPressedKey(1);
            }
        }
        if (keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT) {
            if (board.getTileGrid().getTile(board.getPacman().getTileX() + 1, board.getPacman().getTileY()).getColor().equals(Color.BLACK)) {
                board.getPacman().move(1, 0);
                board.getPacman().setIndex(2);
                board.setLastPressedKey(2);
            }
        }
    }
}
