package inlämningsuppgifter.uppgift3.fifteenPuzzleV3Classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

// Hanterar klick på tiles för att utföra drag.
class GameTileClickHandler implements ActionListener {
    private final List<GameTile> tiles;
    private final GameGrid gameGrid;

    // Konstruktor som kopplar ihop GameTileClicker med listan av GameTile och GameGrid.
    public GameTileClickHandler(List<GameTile> tiles, GameGrid gameGrid) {
        this.tiles = tiles;
        this.gameGrid = gameGrid;
    }

    // Metod som körs när en tile klickas på.
    @Override
    public void actionPerformed(ActionEvent e) {

        // Hittar den klickade brickan genom att jämföra knappen som klickats med knapparna i tiles.
        GameTile clickedTile = tiles.stream()
                .filter(t -> t.getButton() == e.getSource())
                .findFirst()
                .orElse(null);

        // Om en bricka har blivit klickad...
        if (clickedTile != null) {
            int clickedIndex = tiles.indexOf(clickedTile); // ...hämta index för den klickade brickan...
            int emptyIndex = tiles.indexOf(tiles.stream().filter(GameTile::isEmpty).findFirst().get());
            // ...hämta index för den tomma brickan.

            // Flyttar bricka om den är intill en tom bricka...
            if (GameLogic.isAdjacent(clickedIndex, emptyIndex)) {

                // ...om brickan ligger intill den tomma, byt plats på den i listan.
                Collections.swap(tiles, clickedIndex, emptyIndex);

                // Uppdaterar spelplanen och utseende
                gameGrid.refreshGrid();

                // Kollar om användaren har vunnit
                WinnerWinnerChickenDinner.checkWinCondition(tiles);
            }
        }
    }
}
