package boards;

import java.awt.*;

public class Ball extends Component {

    public Ball(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void drawComponent(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }
}
