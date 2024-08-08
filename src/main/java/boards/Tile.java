package boards;

import java.awt.*;

public class Tile extends Component {

    public Tile(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void drawComponent(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

}
