import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    static int randomNumber = (int) (Math.random() * 99 + 1);
    static int guesses;
    static int guess;
    static boolean locked;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setTitle("Epic Number Game");
        frame.setSize(425, 250);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(null);

        JLabel title = new JLabel("Welcome to Nathan's epic guessing game!");
        title.setBounds(10, 5, 350, 25);
        panel.add(title);

        JLabel answer = new JLabel();
        answer.setBounds(10, 40, 500, 100);
        panel.add(answer);

        JLabel guessesCount = new JLabel("Your guesses: " + guesses);
        guessesCount.setBounds(10, 30, 450, 50);
        panel.add(guessesCount);

        JLabel guessStatus = new JLabel();
        guessStatus.setBounds(10, 55, 500, 35);
        panel.add(guessStatus);

        JButton refresh = new JButton("Refresh game");
        refresh.setBounds(10, 150, 110, 35);
        panel.add(refresh);

        JButton revealAnswer = new JButton("Reveal Answer");
        revealAnswer.setBounds(280, 150, 125, 35);
        revealAnswer.setVisible(false);
        panel.add(revealAnswer);

        JButton viewInstructions = new JButton("View Instructions");
        viewInstructions.setBounds(280, 3, 125, 35);
        panel.add(viewInstructions);

        JSpinner guessField = new JSpinner();
        guessField.setBounds(10, 25, 55, 25);
        panel.add(guessField);

        viewInstructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InstructionsPanel.instructionsPanel();
            }
        });

        revealAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer.setText("The random number was " + randomNumber + ".");
            }
        });

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomNumber = (int) (Math.random() * 99 + 1);
                answer.setText("");
                guesses = 0;
                guessesCount.setText("Your guesses: " + guesses);
                revealAnswer.setVisible(false);
                locked = false;
                guessStatus.setText("");
            }
        });
        guessField.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (!locked) {
                    guess = (int) guessField.getValue();
                    if (guess > 100 || guess < 1) {
                        guessStatus.setText("Invalid guess. Guesses are between 1 and 100 only.");
                    } else {
                        guesses++;
                        guessesCount.setText("Your guesses: " + guesses);
                        if (guess == randomNumber) {
                            guessStatus.setText("Correct! The random number is " + randomNumber);
                        } else if (guess > randomNumber) {
                            guessStatus.setText(guess + " is higher than the random number.");
                        } else if (guess < randomNumber) {
                            guessStatus.setText(guess + " is lower than the random number.");
                        }
                    }
                    if (guesses == 10) {
                        revealAnswer.setVisible(true);
                        guessStatus.setText("Sorry! You didn't guess the number in time!");
                        locked = true;
                    }
                    if (guess == randomNumber) {
                        locked = true;
                    }
                }
            }
        });
        frame.setVisible(true);
    }
}