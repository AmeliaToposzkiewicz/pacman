package other.frames;

import other.end.ScoreVector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class HighScores extends JFrame implements ActionListener {
    private JButton menuButton;

    public HighScores() {
        menuButton = new JButton("MENU");
        menuButton.setFocusPainted(false);  // focus no longer visible on the button
        styleButton(menuButton);
        menuButton.addActionListener(this);

        JLabel info = new JLabel("LIST OF PLAYERS AND THEIR SCORES:");
        info.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        info.setForeground(Color.YELLOW);
        info.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new FlowLayout());
        add(menuButton);
        add(info);

        Vector<String> scores = ScoreVector.getHighScores();

        if (scores != null) {
            JList<String> jList = new JList<>(scores);
            jList.setCellRenderer(new HighScoresCellRenderer());
            JScrollPane jScrollPane = new JScrollPane(jList);
            add(jScrollPane);
        } else {
            JLabel noData = new JLabel("NO DATA TO DISPLAY!");
            noData.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            noData.setForeground(Color.RED);
            noData.setHorizontalAlignment(SwingConstants.CENTER);
            add(noData);
        }

        setTitle("PACMAN");
        getContentPane().setBackground(Color.BLACK);
        setSize(540, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("src/main/java/images/logo.png");
        setIconImage(image.getImage());
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == menuButton) {
            setVisible(false);
            SwingUtilities.invokeLater(() -> new Menu());
        }
    }

    private void styleButton(JButton button) {
        button.setSize(30, 30);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
    }
}
