package cm.prolog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessGameInterface {
    private JFrame mainFrame;
    private JPanel categoryPanel;
    private ButtonGroup categoryGroup;
    private JFrame categoryFrame;
    private JTextField choiceTextField;

    public GuessGameInterface() {
        initializeUI();
    }

    private void initializeUI() {
        // Fen�tre principale
        mainFrame = new JFrame("Guess Game");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(450, 620);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setLocationRelativeTo(null);

        // Label du titre
        JLabel titleLabel = new JLabel("Guess Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainFrame.add(titleLabel);

        // Bouton "Commencer"
        JButton startButton = new JButton("Commencer");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCategorySelection();
            }
        });
        mainFrame.add(startButton);

        // Bouton "Quitter"
        JButton quitButton = new JButton("Quitter");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainFrame.add(quitButton);

        // Affichage de la fen�tre principale
        mainFrame.setVisible(true);
    }

    private void showCategorySelection() {
        // Fermer la fen�tre principale
        mainFrame.setVisible(false);

        // Fen�tre de s�lection de cat�gorie
        categoryFrame = new JFrame("Choisissez une Cat�gorie");
        categoryFrame.setSize(450, 620);
        categoryFrame.setLayout(new FlowLayout());
        categoryFrame.setLocationRelativeTo(null);

        // Label
        JLabel instructionLabel = new JLabel("Pensez � quelque chose en fonction des diff�rentes cat�gories");
        categoryFrame.add(instructionLabel);

        // Panel pour les boutons radio
        categoryPanel = new JPanel();
        categoryGroup = new ButtonGroup();
        String[] categories = {"Animaux", "Jeux vid�o", "Super h�ros", "Anim�s"};
        for (String category : categories) {
            JRadioButton radioButton = new JRadioButton(category);
            categoryGroup.add(radioButton);
            categoryPanel.add(radioButton);
        }
        categoryFrame.add(categoryPanel);

        // Bouton "Suivant"
        JButton nextButton = new JButton("Suivant");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showQuestions();
            }
        });
        categoryFrame.add(nextButton);

        // Bouton "Retour"
        JButton backButton = new JButton("Retour");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermer la fen�tre de cat�gorie et montrer � nouveau la fen�tre principale
                categoryFrame.dispose();  // Fermer la fen�tre actuelle
                mainFrame.setVisible(true);  // Montrer la fen�tre principale
            }
        });
        categoryFrame.add(backButton);

        // Affichage de la fen�tre de cat�gorie
        categoryFrame.setVisible(true);
    }


    private void showQuestions() {
        // Fermer la fen�tre de cat�gorie
        categoryFrame.setVisible(false);

        // Fen�tre de questions
        JFrame questionFrame = new JFrame("Questions");
        questionFrame.setSize(450, 620);
        questionFrame.setLayout(new FlowLayout());
        questionFrame.setLocationRelativeTo(null);

        // Label question 1
        JLabel question1Label = new JLabel("Question 1 : Avez-vous fait votre choix ?");
        questionFrame.add(question1Label);

        // Champ de texte
        choiceTextField = new JTextField(20);
        questionFrame.add(choiceTextField);

        // Label question 2
        JLabel question2Label = new JLabel("Question 2 : Votre choix pr�sente-t-il les caract�ristiques suivantes ?");
        questionFrame.add(question2Label);

        // Liste de caract�ristiques
        String[] characteristics = {"Caract�ristique 1", "Caract�ristique 2", "Caract�ristique 3", "Caract�ristique 4", "Caract�ristique 5", "Caract�ristique 6", "Caract�ristique 7", "Caract�ristique 8", "Caract�ristique 9", "Caract�ristique 10"};
        JList<String> characteristicsList = new JList<>(characteristics);
        questionFrame.add(new JScrollPane(characteristicsList));

        // Bouton "Terminer"
        JButton finishButton = new JButton("Terminer");
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ajoutez ici le code pour traiter les r�ponses et terminer le jeu
                int option = JOptionPane.showOptionDialog(
                        null,
                        "Vous avez pens� � Element_Trouver !",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new Object[]{"Oui", "Non"},
                        "Oui");

                if (option == JOptionPane.YES_OPTION) {
                    // Code � ex�cuter si l'utilisateur clique sur "Oui"
                    System.exit(0);
                } else {
                    // Code � ex�cuter si l'utilisateur clique sur "Non"
                }
            }
        });
        questionFrame.add(finishButton);

        // Affichage de la fen�tre de questions
        questionFrame.setVisible(true);
    }
}
