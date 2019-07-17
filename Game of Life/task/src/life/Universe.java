package life;

import java.util.Random;

class Universe {
    private char[][] map;
    private int size;

    Universe(int size, long seed) {
        this.size = size;
        Random random = new Random(seed);
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
//            System.out.print("|\n");
        }
//        System.out.println("-----------------");
    }
}
