package ghosts;

import boards.Ball;
import boards.SpecialBall;
import boards.TileGrid;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Enemy {
    private final int CELL_SIZE = 20;
    private int tileX;
    private int tileY;
    private TileGrid tileGrid;
    private int width;
    private int height;
    private Image[] images;
    private int index;
    private char direction;

    public Enemy(int tileX, int tileY, TileGrid tileGrid, int width, int height) {
        this.tileX = tileX;
        this.tileY = tileY;
        this.tileGrid = tileGrid;
        this.width = width;
        this.height = height;
        this.images = new Image[2];
        this.index = 0;
        this.direction = 'L';
    }

    public void move() {
        direction = selectDirection();

        switch (direction) {
            case 'L' -> {
                if (checkTile(tileX - 1, tileY)) {
                    tileX -= 1;
                    setIndex(0);
                }
            }
            case 'R' -> {
                if (checkTile(tileX + 1, tileY)) {
                    tileX += 1;
                    setIndex(1);
                }
            }
            case 'U' -> {
                if (checkTile(tileX, tileY - 1)) {
                    tileY -= 1;
                }
            }
            case 'D' -> {
                if (checkTile(tileX, tileY + 1)) {
                    tileY += 1;
                }
            }
        }
    }

    private char selectDirection() {
        int random;
        int newX = tileX;
        int newY = tileY;
        Set<Character> options = new HashSet<>();

        char backwards = 'R';

        switch (direction) {
            case 'L' -> backwards = 'R';
            case 'R' -> backwards = 'L';
            case 'U' -> backwards = 'D';
            case 'D' -> backwards = 'U';

        }

        char newDirection = backwards;

        while (newDirection == backwards || !checkTile(newX, newY)) {

            if (options.size() == 3) {
                options.clear();
                newDirection = backwards;
                break;
            }

            random = (int) (Math.random() * 4) + 1;

            if (random == 1) {
                newDirection = 'L';
                newX -= 1;
            } else if (random == 2) {
                newDirection = 'R';
                newX += 1;
            } else if (random == 3) {
                newDirection = 'U';
                newY -= 1;
            } else if (random == 4) {
                newDirection = 'D';
                newY += 1;
            }

            if (newDirection != backwards) {
                options.add(newDirection);
            }
        }
        return newDirection;
    }

    private boolean checkTile(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height && tileGrid.getTile(x, y).getColor().equals(Color.BLACK);
    }

    public void createSpecialBall(TileGrid tileGrid) {
        Random random = new Random();
        int num = random.nextInt(3); // {0,1,2,3}

        if (num == 1) {
            int option = random.nextInt(5) + 1; // {1,2,3,4,5}

            switch (option) {
                case 1 -> {
                    Ball ball = new SpecialBall(getTileX() * CELL_SIZE + 5, getTileY() * CELL_SIZE + 5, 10, 10, Color.GREEN);
                    tileGrid.addBall(getTileX(), getTileY(), ball);
                }
                case 2 -> {
                    Ball ball = new SpecialBall(getTileX() * CELL_SIZE + 5, getTileY() * CELL_SIZE + 5, 10, 10, Color.MAGENTA);
                    tileGrid.addBall(getTileX(), getTileY(), ball);
                }
                case 3 -> {
                    Ball ball = new SpecialBall(getTileX() * CELL_SIZE + 5, getTileY() * CELL_SIZE + 5, 10, 10, Color.CYAN);
                    tileGrid.addBall(getTileX(), getTileY(), ball);
                }
                case 4 -> {
                    Ball ball = new SpecialBall(getTileX() * CELL_SIZE + 5, getTileY() * CELL_SIZE + 5, 10, 10, Color.RED);
                    tileGrid.addBall(getTileX(), getTileY(), ball);
                }
                case 5 -> {
                    Ball ball = new SpecialBall(getTileX() * CELL_SIZE + 5, getTileY() * CELL_SIZE + 5, 10, 10, Color.WHITE);
                    tileGrid.addBall(getTileX(), getTileY(), ball);
                }
            }
        }
    }

    public void drawEnemy(Graphics g) {
        g.drawImage(images[getIndex()], this.tileX * 20, this.tileY * 20, null);
    }

    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setImages(String leftSide, String rightSide) {
        this.images[0] = new ImageIcon(leftSide).getImage();
        this.images[1] = new ImageIcon(rightSide).getImage();
    }

}
