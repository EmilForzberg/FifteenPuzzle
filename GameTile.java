package inlämningsuppgifter.uppgift3.fifteenPuzzleV3Classes;

import javax.swing.*;

// Klass som är brickor
class GameTile {
    private final JButton button;

    // Konstruktor som skapar knapp med specifikt nummer.
    public GameTile(String label) {
        button = new JButton(label);
    }

    public JButton getButton() {
        return button;
    }

    // Kontroll om brickan är tom.
    public boolean isEmpty() {
        return button.getText().isEmpty();
    }
}
