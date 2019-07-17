package life;

import java.util.Random;
import java.util.Scanner;


public class Main {
    private static char[][] universe;
    private static int size;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Universe universe = new Universe(scanner.nextInt(), scanner.nextLong());
        Generator generator = new Generator(universe, scanner.nextInt());
        generator.evolute();
        universe.printState();
    }
}
