package other.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    private JButton newGameButton;
    private JButton highScoresButton;
    private JButton exitButton;
    private JButton howToPlayButton;

    public Menu() {
        JLabel welcome = new JLabel("WELCOME TO PACMAN!");
        welcome.setFont(new Font(Font.MONOSPACED, Font.BOLD, 35));
        welcome.setForeground(Color.YELLOW);
        welcome.setHorizontalAlignment(SwingConstants.CENTER);

        newGameButton = new JButton("NEW GAME");
        highScoresButton = new JButton("HIGH SCORES");
        howToPlayButton = new JButton("HOW TO PLAY");
        exitButton = new JButton("EXIT");
        newGameButton.setFocusPainted(false);  // focus no longer visible on the button

        styleButton(newGameButton);
        styleButton(highScoresButton);
        styleButton(howToPlayButton);
        styleButton(exitButton);

        newGameButton.addActionListener(this);
        highScoresButton.addActionListener(this);
        howToPlayButton.addActionListener(this);
        exitButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newGameButton);
        buttonPanel.add(highScoresButton);
        buttonPanel.add(howToPlayButton);
        buttonPanel.add(exitButton);
        buttonPanel.setBackground(Color.YELLOW);

        JLabel picture = new JLabel();
        ImageIcon menu = new ImageIcon("src/main/java/images/menu.png");
        picture.setIcon(menu);
        picture.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new GridLayout(3, 1));
        add(welcome);
        add(buttonPanel);
        add(picture);

        setTitle("PACMAN");
        ImageIcon logo = new ImageIcon("src/main/java/images/logo.png");
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.BLACK);
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == exitButton) {
            Menu.this.dispose();  // close menu frame
            System.exit(0);  // exit code 0 - normal exit
        } else if (source == newGameButton) {
            setVisible(false);
            SwingUtilities.invokeLater(() -> new NewGame());
        } else if (source == highScoresButton) {
            setVisible(false);
            SwingUtilities.invokeLater(() -> new HighScores());
        } else if (source == howToPlayButton) {
            setVisible(false);
            SwingUtilities.invokeLater(() -> new Instructions());
        }

    }

    private void styleButton(JButton button) {
        button.setSize(50, 50);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
    }
}
