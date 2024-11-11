package inlämningsuppgifter.uppgift3.fifteenPuzzleV3Classes;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// GameGrid hanterar spelplanen (dvs alla tiles) i en 4x4 layout och förbereder alla tiles.
// GameGrid skapar och lägger till tiles i GUI samt uppdatera grid-layouten.
class GameGrid {

    private final JPanel gridPanel; // Spelplan (4x4)
    private final List<GameTile> tiles; // Lista av tiles
    private final GameTileClickHandler tileClickHandler; // ActionListener

    public GameGrid() {
        gridPanel = new JPanel(new GridLayout(4, 4));
        tiles = new ArrayList<>();
        tileClickHandler = new GameTileClickHandler(tiles, this);

        // Anropar metod nedanför för att skapa och placera brickor på spelplanen.
        prepareTiles();
    }

    // Skapar brickor från 1 till 15
    private void prepareTiles() {
        for (int i = 1; i <= 15; i++) {
            GameTile tile = new GameTile(String.valueOf(i));
            tile.getButton().addActionListener(tileClickHandler);
            tiles.add(tile);
            gridPanel.add(tile.getButton());
        }

        // Skapar en tom bricka
        GameTile emptyTile = new GameTile("");
        emptyTile.getButton().setEnabled(false);
        tiles.add(emptyTile);
        gridPanel.add(emptyTile.getButton());
    }

    // Returnerar gridPanel för att lägga till i main.
    public JPanel getGameGridPanel() {
        return gridPanel;
    }

    // Returnerar listan med alla brickor på spelplanen (NGH)
    public List<GameTile> getGameTiles() {
        return tiles;
    }

    // Tömmer och återskapar GUI
    public void refreshGrid() {
        gridPanel.removeAll(); // Tar bort
        for (GameTile tile : tiles) {
            gridPanel.add(tile.getButton()); // Lägger tillbaka
        }

        gridPanel.revalidate(); // Säkerställer layoutförändringar
        gridPanel.repaint(); // "Återskapar" spelplanen.
    }
}
