package life;

import java.util.Random;
import java.util.Scanner;


public class Main {
    private static char[][] universe;
    private static int size;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        size = scanner.nextInt();
        initializeUniverse(scanner.nextInt());
        printUniverse();
    }

    private static void initializeUniverse(int seed) {
        universe = new char[size][size];
        Random random = new Random(seed);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (random.nextBoolean()) {
                    universe[i][j] = 'O';
                }
                else {
                    universe[i][j] = ' ';
                }
            }
        }
    }

    private static void printUniverse() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(universe[i][j]);
            }
            System.out.println();
        }
    }
}
