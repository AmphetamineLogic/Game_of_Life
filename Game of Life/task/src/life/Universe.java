package life;

import java.io.IOException;
import java.util.Random;
import javax.swing.*;

class Universe {
    private char[][] map;
    private int size;

    Universe(int size) {
        this.size = size;
        Random random = new Random(System.currentTimeMillis());
        map = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size ; j++) {
                if (random.nextBoolean()) {
                    map[i][j] = 'O';
                }
                else {
                    map[i][j] = ' ';
                }
            }
        }
    }

    void setMap(char[][] nextGeneration) {
        for (int i = 0; i < size; i++) {
            map[i] = nextGeneration[i].clone();
        }
    }

    char[][] getMap() {
        return map;
    }

    int getSize() {
        return size;
    }

    void printState() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    int countAlive() {
        int alive = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 'O') {
                    alive++;
                }
            }
        }
        return alive;
    }

    void printStateWithStats(int generation) {

            clearConsole();
            Main.generationLabel.setText("Generation #" + generation);
            Main.aliveCounterLabel.setText("Alive: " + countAlive());
            System.out.printf("Generation #%d\nAlive: %d\n", generation, countAlive());
            printState();

    }

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

}
