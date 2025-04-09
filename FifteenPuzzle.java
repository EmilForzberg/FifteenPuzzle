package inlämningsuppgifter.uppgift3.fifteenPuzzleV3Classes;

/**

    ** Importera alla Java-klasser för GUI och samt andra subklasser.

    1. Dela upp allt i klasser;

        a. För att starta och hantera spelets spelmiljö (GUI).
            - En main-klass. -> FifteenPuzzle

        b. Regler för spelet. Kontrollerar två brickor intill varandra.
            - "Spelregler" -> GameLogic

        c. Spelets "spelplan" (rutnät) och brickor
            - "Spelplan" -> GameGrid: Spelrutan där brickorna ska vara
            i. Brickor ("Tiles") -> GameTile: Varje bricka i spelrutan.
            ii. Klickhanterare för GameTile -> GameTileClickHandler: Klick-ili-klickande och GameLogic

        d. En funktion eller metod för att starta ett nytt spel.
            - "Starta nytt spel" -> NewGameHandler.
            i. Blanda brickor -> GameTileShuffler: Blandar brickor i slumpmässig ordning (algoritm om du orkar?)

        e. Kontroll om spelet är vunnet
            - "Användaren vann spelet" -> WinnerWinnerChickenDinner

    2. Extra funktioner? Highscore, tidtagning, algoritm? ... Imorgon...

 */


import javax.swing.*;
import java.awt.*;

public class FifteenPuzzle extends JFrame {

    private final GameGrid gameGrid;
    private final NewGameHandler newGameHandler;

    public FifteenPuzzle() {

        setTitle("15-Puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        gameGrid = new GameGrid();
        newGameHandler = new NewGameHandler(gameGrid);

        add(gameGrid.getGameGridPanel(), BorderLayout.CENTER);

        JButton newGameButton = new JButton("Start New Game");
        newGameButton.addActionListener(sng -> newGameHandler.startNewGame());
        add(newGameButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new FifteenPuzzle();
    }
}
