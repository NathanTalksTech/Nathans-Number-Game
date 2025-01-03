import javax.swing.*;

public class InstructionsPanel {

    public static void instructionsPanel() {
        JFrame instructionsFrame = new JFrame();
        JPanel instructionsPanel = new JPanel();
        instructionsFrame.setBounds(100, 100, 600, 150);
        instructionsFrame.add(instructionsPanel);
        instructionsFrame.setTitle("Instructions");
        instructionsPanel.setLayout(null);

        JLabel instructions = new JLabel("<html>Welcome to Nathan's Fun Number game!" +
                "<br>Your objective is to guess a number from 1 to 100." +
                "<br>You will have 10 attempts to guess the number. After those attempts are up, a button to reveal the answer will appear." +
                "<br>Lock in an answer by pressing space or using the arrows next to the number field." +
                "<br>Don't contact anyone for any bugs, I ain't fixing nothin'");
        instructions.setBounds(10, -68, 600, 250);
        instructionsPanel.add(instructions);

        instructionsFrame.setVisible(true);
    }
}
