package ghosts;

import boards.TileGrid;

public class RedGhost extends Enemy {
    private final String LEFT_SIDE = "src/main/java/images/characters/ghosts/ghost1L.jpg";
    private final String RIGHT_SIDE = "src/main/java/images/characters/ghosts/ghost1R.jpg";


    public RedGhost(int x, int y, TileGrid tileGrid, int width, int height) {
        super(x, y, tileGrid, width, height);
        setImages(LEFT_SIDE, RIGHT_SIDE);
    }
}
