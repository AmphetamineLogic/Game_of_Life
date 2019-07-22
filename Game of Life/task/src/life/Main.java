package life;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import life.*;

import javax.swing.*;


public class Main extends JFrame {

    private static Scanner scanner = new Scanner(System.in);
    static JLabel generationLabel;
    static JLabel aliveCounterLabel;
    static MyPanel field;
    static final int fieldWidth = 500;
    static final int fieldHeight = 500;

    public Main () {
        super("Game of life");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(fieldWidth + 10, fieldHeight + 50);
        JPanel statsPanel = new JPanel();
        field = new MyPanel();


        setVisible(true);
        generationLabel = new JLabel("Generation #0");
        aliveCounterLabel = new JLabel("Alive: 0");
        setLayout(new BorderLayout());
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));

        statsPanel.add(generationLabel);
        statsPanel.add(aliveCounterLabel);
        add(statsPanel, BorderLayout.NORTH);
        add(field, BorderLayout.CENTER);
        field.setSize(fieldWidth, fieldHeight);
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.drawRect(5,5,getWidth()-10,getHeight()-10);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int numberOfGenerations = 100;
        final int universeSize = 100;

        Universe universe = new Universe(universeSize);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
        Thread.sleep(500);

        Generator generator = new Generator(universe, numberOfGenerations);
        generator.evolute();
        universe.printState();
    }
}
