package cm.prolog;

import javax.swing.*;
import java.awt.*;

public class execution {
    public static void main(String[] args) {
        // Cr�ation de la fen�tre
        JFrame frame = new JFrame("Guess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 620);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Ajout du titre
        JLabel titleLabel = new JLabel("Guess Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Champ de saisie
        JTextField textField = new JTextField();
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height));

        // Bouton
        JButton button = new JButton("Submit");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Ajout des composants au panel
        panel.add(Box.createRigidArea(new Dimension(0, 50))); // Espace avant le titre
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espace entre le titre et le champ de saisie
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espace entre le champ de saisie et le bouton
        panel.add(button);

        // Ajout du panel � la fen�tre
        frame.getContentPane().add(panel);

        // Affichage de la fen�tre
        frame.setVisible(true);
    }
}