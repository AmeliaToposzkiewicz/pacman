package other;

import javax.swing.*;
import java.awt.*;

public class Pacman {
    private final String FULL_PATH = "src/main/java/images/characters/pacman/pacmanfull.jpg";
    private final String LEFT_PATH = "src/main/java/images/characters/pacman/pacmanleft.jpg";
    private final String RIGHT_PATH = "src/main/java/images/characters/pacman/pacmanright.jpg";
    private final String UP_PATH = "src/main/java/images/characters/pacman/pacmanup.jpg";
    private final String DOWN_PATH = "src/main/java/images/characters/pacman/pacmandown.jpg";
    private final int CELL_SIZE = 20;
    private int tileX;

    private int tileY;

    private Image[] images;

    private int index;
    private final String monitor = new String();

    public Pacman(int tileX, int tileY) {
        this.tileX = tileX;
        this.tileY = tileY;
        Image full = new ImageIcon(FULL_PATH).getImage();
        Image left = new ImageIcon(LEFT_PATH).getImage();
        Image right = new ImageIcon(RIGHT_PATH).getImage();
        Image up = new ImageIcon(UP_PATH).getImage();
        Image down = new ImageIcon(DOWN_PATH).getImage();
        this.images = new Image[]{full, left, right, up, down};
        this.index = 2;

    }

    public void move(int dx, int dy) {
        tileX += dx;
        tileY += dy;
    }

    public void drawPacman(Graphics g) {
        g.drawImage(images[index], this.tileX * CELL_SIZE, this.tileY * CELL_SIZE, null);
    }

    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setIndex(int index) {
        synchronized (monitor) {
            this.index = index;
        }
    }

}
