package ghosts;

import boards.TileGrid;

public class OrangeGhost extends Enemy {
    private final String LEFT_SIDE = "src/main/java/images/characters/ghosts/ghost2L.jpg";
    private final String RIGHT_SIDE = "src/main/java/images/characters/ghosts/ghost2R.jpg";


    public OrangeGhost(int x, int y, TileGrid tileGrid, int width, int height) {
        super(x, y, tileGrid, width, height);
        setImages(LEFT_SIDE, RIGHT_SIDE);
    }
}
