package cm.prolog;

import javax.swing.SwingUtilities;

public class Lancer {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuessGameInterface());
    }

}
