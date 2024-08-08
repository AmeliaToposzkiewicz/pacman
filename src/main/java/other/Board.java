package other;

import boards.TileGrid;
import ghosts.BlueGhost;
import ghosts.Enemy;
import ghosts.OrangeGhost;
import ghosts.RedGhost;
import other.frames.Menu;
import other.threads.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Board extends JPanel implements ActionListener, Runnable {
    private final int CELL_SIZE = 20;
    private TileGrid tileGrid;
    private int width;
    private int height;
    private int lastPressedKey;
    private int livesValue;
    private int pointsValue;
    private int timeValue;
    private boolean running;
    private boolean timeStopped;
    private boolean ghostStopped;
    private boolean immortal;

    private Pacman pacman;
    private RedGhost redGhost;
    private OrangeGhost orangeGhost;
    private BlueGhost blueGhost;
    private Enemy[] enemies;


    private Thread timeThread;
    private Thread livesThread;
    private Thread pointsThread;
    private Thread ghostMovementThread;
    private Thread specialBallsThread;
    private Thread pacmanAnimationThread;
    private Thread drawComponents;

    private JButton menuButton;


    public Board(int[][] grid, int width, int height) {
        this.width = width;
        this.height = height;
        this.tileGrid = new TileGrid(grid, width, height);

        initializeCharacters();
        initializeValues();

        addKeyListener(new Keys(this));
        setFocusable(true);
        setLayout(null);

        menuButton = new JButton("MENU");
        menuButton.setBounds((width * CELL_SIZE) - 100, (height * CELL_SIZE), 100, 110);
        styleButton(menuButton);
        menuButton.addActionListener(this);
        add(menuButton);

        initializeThreads();
        startThreads();

    }

    private void initializeCharacters() {
        this.pacman = new Pacman(16, 16);
        this.redGhost = new RedGhost(3, 3, tileGrid, width, height);
        this.orangeGhost = new OrangeGhost(16, 3, tileGrid, width, height);
        this.blueGhost = new BlueGhost(3, 16, tileGrid, width, height);
        this.enemies = new Enemy[]{redGhost, orangeGhost, blueGhost};
    }

    private void initializeValues() {
        this.lastPressedKey = 1;
        this.livesValue = 3;
        this.pointsValue = 0;
        this.timeValue = 100;

        this.running = true;
        this.timeStopped = false;
        this.ghostStopped = false;
        this.immortal = false;
    }

    private void initializeThreads() {
        Time time = new Time(this);
        this.timeThread = new Thread(time);

        Lives lives = new Lives(this);
        this.livesThread = new Thread(lives);

        EatBall points = new EatBall(this);
        this.pointsThread = new Thread(points);

        GhostMovement ghostMovement = new GhostMovement(this);
        this.ghostMovementThread = new Thread(ghostMovement);

        CreateSpecialBalls createSpecialBalls = new CreateSpecialBalls(this);
        this.specialBallsThread = new Thread(createSpecialBalls);

        PacmanAnimation pacmanAnimation = new PacmanAnimation(this);
        this.pacmanAnimationThread = new Thread(pacmanAnimation);

        this.drawComponents = new Thread(this);
    }

    private void startThreads() {
        timeThread.start();
        livesThread.start();
        pointsThread.start();
        ghostMovementThread.start();
        specialBallsThread.start();
        pacmanAnimationThread.start();
        drawComponents.start();
    }


    @Override
    public void run() {
        while (isRunning()) {
            redraw();
        }
    }

    private void redraw() {
        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, (width * CELL_SIZE) - 100, height * CELL_SIZE + 150);
        tileGrid.drawTiles(g);
        tileGrid.drawBalls(g);
        pacman.drawPacman(g);
        redGhost.drawEnemy(g);
        orangeGhost.drawEnemy(g);
        blueGhost.drawEnemy(g);
        drawTime(g);
        drawLives(g);
        drawScore(g);
    }

    private void drawLives(Graphics g) {
        g.setColor(Color.RED);
        for (int i = 0; i < getLivesValue(); i++) {
            g.fillOval((CELL_SIZE * i) + 10, (height * CELL_SIZE) + 10, CELL_SIZE, CELL_SIZE);
        }
    }

    private void drawTime(Graphics g) {
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        g.setColor(Color.BLACK);
        g.drawString("Time: " + timeValue, 10, (height * CELL_SIZE) + 60);
    }

    private void drawScore(Graphics g) {
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        g.setColor(Color.BLACK);
        g.drawString("Score: " + pointsValue, 10, (height * CELL_SIZE) + 90);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == menuButton) {
            setRunning(false);
            JOptionPane.showMessageDialog(null, "You are going to leave the game, your score will not be saved.",
                    "WARNING", JOptionPane.WARNING_MESSAGE);

            JFrame frame = (JFrame) SwingUtilities.windowForComponent(menuButton);
            frame.setVisible(false);
            SwingUtilities.invokeLater(() -> new Menu());
        }
    }

    private void styleButton(JButton button) {
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.YELLOW);
    }


    public void removeSecond() {
        this.timeValue--;
    }

    public void removeLive() {
        this.livesValue--;
    }

    public void addLive() {
        if (getLivesValue() < 6) {
            this.livesValue++;
        }
    }

    public void addPoints(int amount) {
        this.pointsValue += amount;
    }


    public int getTimeValue() {
        return timeValue;
    }

    public int getLivesValue() {
        return livesValue;
    }

    public int getPointsValue() {
        return pointsValue;
    }

    public int getLastPressedKey() {
        return lastPressedKey;
    }

    public void setLastPressedKey(int lastPressedKey) {
        this.lastPressedKey = lastPressedKey;
    }


    public TileGrid getTileGrid() {
        return tileGrid;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }


    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isTimeStopped() {
        return timeStopped;
    }

    public void setTimeStopped(boolean timeStopped) {
        this.timeStopped = timeStopped;
    }

    public boolean isGhostStopped() {
        return ghostStopped;
    }

    public void setGhostStopped(boolean isGhostStopped) {
        this.ghostStopped = isGhostStopped;
    }

    public boolean isImmortal() {
        return immortal;
    }

    public void setImmortal(boolean immortal) {
        this.immortal = immortal;
    }

}
