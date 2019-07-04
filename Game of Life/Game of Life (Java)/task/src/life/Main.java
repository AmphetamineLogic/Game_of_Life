package life;

import java.util.Random;
import java.util.Scanner;
import life.*;


public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Universe universe = new Universe(scanner.nextInt());

        final int numberOfGenerations = 100;
        Generator generator = new Generator(universe, numberOfGenerations);
        generator.evolute();
        universe.printState();
    }
}
