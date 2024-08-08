package other.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructions extends JFrame implements ActionListener {
    JButton menuButton;

    public Instructions() {
        menuButton = new JButton("MENU");
        menuButton.setFocusPainted(false);  // focus no longer visible on the button
        styleButton(menuButton);
        menuButton.addActionListener(this);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("characters", createCharactersPanel());
        tabbedPane.add("information", createInformationPanel());
        tabbedPane.add("balls", createBallsPanel());
        tabbedPane.setPreferredSize(new Dimension(520, 300));

        setLayout(new FlowLayout());

        add(tabbedPane);
        add(menuButton);

        setTitle("PACMAN");
        getContentPane().setBackground(Color.ORANGE);
        setSize(550, 400);
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

    public void styleButton(JButton button) {
        button.setSize(30, 30);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
    }

    private JPanel createCharactersPanel() {
        JPanel characters = new JPanel();
        characters.setBackground(Color.BLACK);
        characters.setLayout(new FlowLayout());

        JLabel pacmanIcon = new JLabel(new ImageIcon("src/main/java/images/characters/pacman/pacmanright.jpg"));

        JLabel pacman = new JLabel(" - YOUR PLAYER");
        pacman.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        pacman.setForeground(Color.WHITE);

        JPanel introPacman = new JPanel();
        introPacman.setBackground(Color.BLACK);
        introPacman.add(pacmanIcon);
        introPacman.add(pacman);

        JLabel keys = new JLabel("use W, S, A, D or UP, DOWN, LEFT, RIGHT keys to move");
        keys.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        keys.setForeground(Color.WHITE);

        JLabel ghostIcon = new JLabel(new ImageIcon("src/main/java/images/characters/ghosts/ghost1R.jpg"));

        JLabel enemy = new JLabel(" - ENEMIES");
        enemy.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        enemy.setForeground(Color.WHITE);

        JPanel introEnemies = new JPanel();
        introEnemies.setBackground(Color.BLACK);
        introEnemies.add(ghostIcon);
        introEnemies.add(enemy);

        JLabel collision1 = new JLabel("if you touch a ghost, you will loose 1 life, after ");
        collision1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        collision1.setForeground(Color.WHITE);

        JLabel collision2 = new JLabel("collision you have 3 seconds of immortality");
        collision2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        collision2.setForeground(Color.WHITE);

        JPanel collision = new JPanel();
        collision.setBackground(Color.BLACK);
        collision.setLayout(new GridLayout(2, 1));
        collision.add(collision1);
        collision.add(collision2);

        characters.add(introPacman);
        characters.add(keys);
        characters.add(introEnemies);
        characters.add(collision);
        return characters;
    }


    private JPanel createInformationPanel() {
        JPanel information = new JPanel();
        information.setBackground(Color.BLACK);
        information.setLayout(new FlowLayout());

        JLabel livesIcon1 = new JLabel(new ImageIcon("src/main/java/images/life.png"));
        JLabel livesIcon2 = new JLabel(new ImageIcon("src/main/java/images/life.png"));
        JLabel livesIcon3 = new JLabel(new ImageIcon("src/main/java/images/life.png"));

        JLabel lives = new JLabel(" - YOU HAVE 3 LIVES");
        lives.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        lives.setForeground(Color.WHITE);

        JPanel introLives = new JPanel();
        introLives.setBackground(Color.BLACK);
        introLives.add(livesIcon1);
        introLives.add(livesIcon2);
        introLives.add(livesIcon3);
        introLives.add(lives);

        JLabel livesInfo = new JLabel("after loosing the last one, the game is over");
        livesInfo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        livesInfo.setForeground(Color.WHITE);

        JLabel time = new JLabel("'Time: 12' - DISPLAY REMAINING TIME");
        time.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        time.setForeground(Color.WHITE);

        JLabel timeInfo = new JLabel("if the time runs out, the game is over");
        timeInfo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        timeInfo.setForeground(Color.WHITE);

        JLabel score = new JLabel("'Score: 3' - DISPLAY CURRENT SCORE");
        score.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        score.setForeground(Color.WHITE);

        information.add(introLives);
        information.add(livesInfo);
        information.add(time);
        information.add(timeInfo);
        information.add(score);
        return information;
    }

    private JPanel createBallsPanel() {
        JPanel balls = new JPanel();
        balls.setBackground(Color.BLACK);
        balls.setLayout(new FlowLayout());

        JLabel ballIcon = new JLabel(new ImageIcon("src/main/java/images/ball.png"));

        JLabel ball = new JLabel(" - NORMAL BALL");
        ball.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        ball.setForeground(Color.WHITE);

        JPanel introBall = new JPanel();
        introBall.setBackground(Color.BLACK);
        introBall.add(ballIcon);
        introBall.add(ball);

        JLabel ballInfo = new JLabel("it adds 1 point to your score");
        ballInfo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        ballInfo.setForeground(Color.WHITE);

        JLabel specialBallsIcon = new JLabel(new ImageIcon("src/main/java/images/specialballs.png"));

        JLabel specialBalls = new JLabel(" - SPECIAL BALLS");
        specialBalls.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        specialBalls.setForeground(Color.WHITE);

        JPanel introSpecialBalls = new JPanel();
        introSpecialBalls.setBackground(Color.BLACK);
        introSpecialBalls.add(specialBallsIcon);
        introSpecialBalls.add(specialBalls);

        JLabel greenBall = new JLabel("GREEN - adds 30 points to your score");
        greenBall.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        greenBall.setForeground(Color.WHITE);

        JLabel magentaBall = new JLabel("MAGENTA - stops time for 10s (time doesn't add up)");
        magentaBall.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        magentaBall.setForeground(Color.WHITE);

        JLabel cyanBall = new JLabel("CYAN - stops ghosts for 10s (time doesn't add up)");
        cyanBall.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        cyanBall.setForeground(Color.WHITE);

        JLabel redBall = new JLabel("RED - adds 1 life (you can have a maximum of 6 lives)");
        redBall.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        redBall.setForeground(Color.WHITE);

        JLabel whiteBall = new JLabel("WHITE - makes you immortal for 10s (time doesn't add up)");
        whiteBall.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        whiteBall.setForeground(Color.WHITE);

        balls.add(introBall);
        balls.add(ballInfo);
        balls.add(introSpecialBalls);
        balls.add(greenBall);
        balls.add(magentaBall);
        balls.add(cyanBall);
        balls.add(redBall);
        balls.add(whiteBall);
        return balls;
    }
}
