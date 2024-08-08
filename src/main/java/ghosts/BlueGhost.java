package ghosts;

import boards.TileGrid;

public class BlueGhost extends Enemy {

    private final String LEFT_SIDE = "src/main/java/images/characters/ghosts/ghost3L.jpg";
    private final String RIGHT_SIDE = "src/main/java/images/characters/ghosts/ghost3R.jpg";

    public BlueGhost(int x, int y, TileGrid tileGrid, int width, int height) {
        super(x, y, tileGrid, width, height);
        setImages(LEFT_SIDE, RIGHT_SIDE);
    }
}
