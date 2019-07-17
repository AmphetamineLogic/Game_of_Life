package life;


class Generator {
    private Universe universe;
    private int size;
    private char[][] currentGeneration;
    private char[][] nextGeneration;

    private int numberOfGenerations;

    Generator (Universe universe, int numberOfGenerations) {
        this.universe = universe;
        this.size = universe.getSize();
        this.numberOfGenerations = numberOfGenerations;

        this.currentGeneration = new char[size][size];
        this.nextGeneration = new char[size][size];
        char[][] temp = universe.getMap();

        for (int i = 0; i < size; i++) {
            currentGeneration[i] = temp[i].clone();
            nextGeneration[i] = temp[i].clone();
        }
    }

    void evolute() {
        for (int i = 1; i <= numberOfGenerations; i++) {
            createNextGen();
            universe.printStateWithStats(i);
        }
    }

    private void createNextGen() {
        int neighboursCounter;
        this.currentGeneration = universe.getMap().clone();
        char currentCell;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                currentCell = currentGeneration[i][j];
                neighboursCounter = 0;
                // counting neighbours
                for (int k = (i - 1) ; k <= (i + 1) ; k++) {
                    for (int l = (j - 1) ; l <= (j + 1) ; l++) {
//                        System.out.printf("i: %d j: %d k: %d l: %d\n", i, j, k, l);

                        if (currentGeneration[(k + size) % size][(l + size) % size] == 'O' && !(i == k && j == l)) {
//                            System.out.println(currentGeneration[(k + size) % size][(l + size) % size] + " Neighbour at: " + (k + size) % size + " " + (l + size) % size);
                            neighboursCounter++;
                        }
                        else {
//                            System.out.println(currentGeneration[(k + size) % size][(l + size) % size] + " Nobody at " + (k + size) % size + " " + (l + size) % size);
                        }
                    }
                }
                if ((neighboursCounter == 2 || neighboursCounter == 3) && isAlive(currentCell)) {
                    // alive, 2..3 neighbours
                    nextGeneration[i][j] = currentCell;
//                    System.out.println("Cell is OK: " + i + " " + j + " Neighbours: " + neighboursCounter);
                }
                else if ((neighboursCounter < 2 || neighboursCounter > 3) && isAlive(currentCell)) {
                    // alive, but suffering of boredom or overpopulation
                    nextGeneration[i][j] = invertCell(currentCell);
//                    System.out.println("Cell will die: " + i + " " + j + " Neighbours: " + neighboursCounter);
                }
                else if (neighboursCounter == 3 && !isAlive(currentCell)) {
                    // resurrection
                    nextGeneration[i][j] = invertCell(currentCell);
//                    System.out.println("Cell will resurrect: " + i + " " + j + " Neighbours: " + neighboursCounter);
                }
                else {
//                    System.out.println("Cell stays dead: " + i + " " + j + " Neighbours: " + neighboursCounter);
                }
            }
        }

        universe.setMap(nextGeneration);
    }

    private char invertCell(char currentState) {
        char newState;
        if (currentState == 'O') {
            newState = ' ';
        }
        else {
            newState = 'O';
        }
        return newState;
    }

    private boolean isAlive(char cell) {
        if (cell == 'O') {
            return true;
        }
        else {
            return false;
        }
    }


}
