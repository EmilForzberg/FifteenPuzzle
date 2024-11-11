package inlämningsuppgifter.uppgift3.fifteenPuzzleV3Classes;

import javax.swing.*;
import java.util.List;

// Kontrollerar om användaren har vunnit.
public class WinnerWinnerChickenDinner {

    // Kontrollerar om brickorna är i "vinnande ordning" dvs 1-15 med en tom bricka i slutet.
    public static void checkWinCondition(List<GameTile> tiles) {
        for (int i = 0; i < 15; i++) {
            if (!tiles.get(i).getButton().getText().equals(String.valueOf(i + 1))) {
                // Om en bricka inte är på rätt plays avslutas metod.
                // Om loopen avslutas utan att "retuneras" visas meddelande.
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Congratulations! You won the game!");
    }
}
