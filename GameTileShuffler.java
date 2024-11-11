package inlämningsuppgifter.uppgift3.fifteenPuzzleV3Classes;

import java.util.Collections;
import java.util.List;

// Hanterar blandning av brickor när man startar nytt spel.
public class GameTileShuffler {

    // Metod för att blanda brickor
    public static void shuffleTiles(List<GameTile> tiles) {

        // Blandar slumpmässigt om brickor i listan.
        Collections.shuffle(tiles);
    }
}

