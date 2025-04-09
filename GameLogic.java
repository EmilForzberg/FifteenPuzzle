package inlämningsuppgifter.uppgift3.fifteenPuzzleV3Classes;

// GameLogic-klassen innehåller spelmetoder och logiken i spelet.
class GameLogic {

    private final GameGrid gameGrid;

    // Konstruktor för att koppla ihop GameLogic och GameGrid.
    public GameLogic(GameGrid gameGrid) {
        this.gameGrid = gameGrid;
    }

    // Metod som kontrollerar om två positioner är intill varandra.
    public static boolean isAdjacent(int index1, int index2) {

        int row1 = index1 / 4, column1 = index1 % 4;
        int row2 = index2 / 4, column2 = index2 % 4;

        // Returnerar true om brickorna är intill varandra horisontellt
        return (Math.abs(row1 - row2) == 1 && column1 == column2) || (Math.abs(column1 - column2) == 1 && row1 == row2);
                
    }
}
