package inlämningsuppgifter.uppgift3.fifteenPuzzleV3Classes;

// Startar ett nytt spel.
public class NewGameHandler {
    private final GameGrid gameGrid;

    // Konstruktor som kopplar NewGameHandler till GameGrid.
    public NewGameHandler(GameGrid gameGrid) {
        this.gameGrid = gameGrid;
    }

    // Metod för att starta ett nytt spel.
    public void startNewGame() {

        // Blandar brickor.
        GameTileShuffler.shuffleTiles(gameGrid.getGameTiles());

        // Uppdaterar visningen.
        gameGrid.refreshGrid();
    }
}

