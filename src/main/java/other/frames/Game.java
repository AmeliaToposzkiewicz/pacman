package other.frames;

import boards.Grid;
import other.Board;

import javax.swing.*;
import java.awt.*;


public class Game extends JFrame {
    private int gridWidth;
    private int gridHeight;

    public Game(int option) {
        gridWidth = 0;
        gridHeight = 0;

        switch (option) {
            case 1 -> {
                gridWidth = 20;
                gridHeight = 20;
                add(new Board(Grid.BOARD1, gridWidth, gridHeight));
            }
            case 2 -> {
                gridWidth = 20;
                gridHeight = 25;
                add(new Board(Grid.BOARD2, gridWidth, gridHeight));
            }
            case 3 -> {
                gridWidth = 30;
                gridHeight = 20;
                add(new Board(Grid.BOARD3, gridWidth, gridHeight));
            }
            case 4 -> {
                gridWidth = 25;
                gridHeight = 25;
                add(new Board(Grid.BOARD4, gridWidth, gridHeight));
            }
            case 5 -> {
                gridWidth = 20;
                gridHeight = 30;
                add(new Board(Grid.BOARD5, gridWidth, gridHeight));
            }
        }
        setTitle("PACMAN");
        getContentPane().setBackground(Color.BLACK);
        setSize(gridWidth * 20 + 15, gridHeight * 20 + 150);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("src/main/java/images/logo.png");
        setIconImage(image.getImage());
        setVisible(true);


    }

}
