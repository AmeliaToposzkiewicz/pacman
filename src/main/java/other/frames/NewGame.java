package other.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGame extends JFrame implements ActionListener {
    private JButton firstBoard;
    private JButton secondBoard;
    private JButton thirdBoard;
    private JButton fourthBoard;
    private JButton fifthBoard;
    private JButton menuButton;

    public NewGame() {
        JLabel info = new JLabel("SELECT BOARD:");
        info.setFont(new Font(Font.MONOSPACED, Font.BOLD, 35));
        info.setForeground(Color.YELLOW);
        info.setHorizontalAlignment(SwingConstants.CENTER);

        firstBoard = new JButton();
        firstBoard.setFocusPainted(false);  // focus no longer visible on the button
        secondBoard = new JButton();
        thirdBoard = new JButton();
        fourthBoard = new JButton();
        fifthBoard = new JButton();

        menuButton = new JButton("MENU");
        menuButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        menuButton.setBackground(Color.BLUE);
        menuButton.setForeground(Color.WHITE);

        styleButton(firstBoard, "src/main/java/images/boards/board1.png");
        styleButton(secondBoard, "src/main/java/images/boards/board2.png");
        styleButton(thirdBoard, "src/main/java/images/boards/board3.png");
        styleButton(fourthBoard, "src/main/java/images/boards/board4.png");
        styleButton(fifthBoard, "src/main/java/images/boards/board5.png");

        firstBoard.addActionListener(this);
        secondBoard.addActionListener(this);
        thirdBoard.addActionListener(this);
        fourthBoard.addActionListener(this);
        fifthBoard.addActionListener(this);

        menuButton.addActionListener(this);

        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.add(firstBoard);
        buttonPanel1.add(secondBoard);
        buttonPanel1.add(thirdBoard);
        buttonPanel1.setBackground(Color.YELLOW);

        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.add(fourthBoard);
        buttonPanel2.add(fifthBoard);
        buttonPanel2.setBackground(Color.YELLOW);


        setLayout(new GridLayout(4, 1));
        add(info);
        add(buttonPanel1);
        add(buttonPanel2);
        add(menuButton);

        setTitle("PACMAN");
        getContentPane().setBackground(Color.BLACK);
        setSize(450, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("src/main/java/images/logo.png");
        setIconImage(image.getImage());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == firstBoard) {
            setVisible(false);
            SwingUtilities.invokeLater(() -> new Game(1));
        } else if (source == secondBoard) {
            setVisible(false);
            SwingUtilities.invokeLater(() -> new Game(2));
        } else if (source == thirdBoard) {
            setVisible(false);
            SwingUtilities.invokeLater(() -> new Game(3));
        } else if (source == fourthBoard) {
            setVisible(false);
            SwingUtilities.invokeLater(() -> new Game(4));
        } else if (source == fifthBoard) {
            setVisible(false);
            SwingUtilities.invokeLater(() -> new Game(5));
        } else if (source == menuButton) {
            setVisible(false);
            SwingUtilities.invokeLater(() -> new Menu());
        }

    }

    private void styleButton(JButton button, String path) {
        ImageIcon icon = new ImageIcon(path);
        button.setIcon(icon);
        button.setSize(50, 50);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
    }
}
