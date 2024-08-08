package other.frames;

import javax.swing.*;
import java.awt.*;

public class HighScoresCellRenderer extends JLabel implements ListCellRenderer {

    public HighScoresCellRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        setText((String) value);
        setPreferredSize(new Dimension(350, 30));

        setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

        if (isSelected) {
            setBackground(Color.RED);
            setForeground(Color.WHITE);
        } else {
            setBackground(Color.GRAY);
            setForeground(Color.YELLOW);
        }
        return this;
    }
}
