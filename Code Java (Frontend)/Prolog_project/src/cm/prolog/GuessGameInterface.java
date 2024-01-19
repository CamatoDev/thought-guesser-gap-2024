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
        // Fenêtre principale
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

        // Affichage de la fenêtre principale
        mainFrame.setVisible(true);
    }

    private void showCategorySelection() {
        // Fermer la fenêtre principale
        mainFrame.setVisible(false);

        // Fenêtre de sélection de catégorie
        categoryFrame = new JFrame("Choisissez une Catégorie");
        categoryFrame.setSize(450, 620);
        categoryFrame.setLayout(new FlowLayout());
        categoryFrame.setLocationRelativeTo(null);

        // Label
        JLabel instructionLabel = new JLabel("Pensez à quelque chose en fonction des différentes catégories");
        categoryFrame.add(instructionLabel);

        // Panel pour les boutons radio
        categoryPanel = new JPanel();
        categoryGroup = new ButtonGroup();
        String[] categories = {"Animaux", "Jeux vidéo", "Super héros", "Animés"};
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
                // Fermer la fenêtre de catégorie et montrer à nouveau la fenêtre principale
                categoryFrame.dispose();  // Fermer la fenêtre actuelle
                mainFrame.setVisible(true);  // Montrer la fenêtre principale
            }
        });
        categoryFrame.add(backButton);

        // Affichage de la fenêtre de catégorie
        categoryFrame.setVisible(true);
    }


    private void showQuestions() {
        // Fermer la fenêtre de catégorie
        categoryFrame.setVisible(false);

        // Fenêtre de questions
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
        JLabel question2Label = new JLabel("Question 2 : Votre choix présente-t-il les caractéristiques suivantes ?");
        questionFrame.add(question2Label);

        // Liste de caractéristiques
        String[] characteristics = {"Caractéristique 1", "Caractéristique 2", "Caractéristique 3", "Caractéristique 4", "Caractéristique 5", "Caractéristique 6", "Caractéristique 7", "Caractéristique 8", "Caractéristique 9", "Caractéristique 10"};
        JList<String> characteristicsList = new JList<>(characteristics);
        questionFrame.add(new JScrollPane(characteristicsList));

        // Bouton "Terminer"
        JButton finishButton = new JButton("Terminer");
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ajoutez ici le code pour traiter les réponses et terminer le jeu
                int option = JOptionPane.showOptionDialog(
                        null,
                        "Vous avez pensé à Element_Trouver !",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new Object[]{"Oui", "Non"},
                        "Oui");

                if (option == JOptionPane.YES_OPTION) {
                    // Code à exécuter si l'utilisateur clique sur "Oui"
                    System.exit(0);
                } else {
                    // Code à exécuter si l'utilisateur clique sur "Non"
                }
            }
        });
        questionFrame.add(finishButton);

        // Affichage de la fenêtre de questions
        questionFrame.setVisible(true);
    }
}
