package boards;

import java.awt.*;

public class TileGrid {
    private final int CELL_SIZE = 20;
    private Tile[][] map;
    private Ball[][] balls;


    public TileGrid(int[][] grid, int width, int height) {
        map = new Tile[width][height];
        balls = new Ball[width][height];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (grid[j][i] == 0) {
                    map[i][j] = new Tile(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE, Color.BLACK);
                    balls[i][j] = new Ball(i * CELL_SIZE + 10, j * CELL_SIZE + 10, 4, 4, Color.YELLOW);
                } else if (grid[j][i] == 1) {
                    map[i][j] = new Tile(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE, Color.BLUE);
                }
            }
        }
    }

    public void drawTiles(Graphics g) {
        for (Tile[] tiles : map) {
            for (Tile t : tiles) {
                t.drawComponent(g);
            }
        }
    }

    public void drawBalls(Graphics g) {
        for (Ball[] ball : balls) {
            for (Ball b : ball) {
                if (b != null) {
                    b.drawComponent(g);
                }
            }
        }
    }

    public Tile getTile(int x, int y) {
        return this.map[x][y];
    }

    public Ball getBall(int x, int y) {
        return this.balls[x][y];
    }

    public void removeBalls(int x, int y) {
        this.balls[x][y] = null;
    }

    public void addBall(int x, int y, Ball ball) {
        this.balls[x][y] = ball;
    }

}
