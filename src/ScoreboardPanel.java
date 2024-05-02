import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ScoreboardPanel extends JPanel {

    private VictimPicker victimPicker;
    private ScoreboardButton sbButton;

    ScoreboardPanel(VictimPicker vp) {
        this.victimPicker = vp;
        setLayout(new BorderLayout());

        // Create and initialize the scoreboard components
        JTextArea scoreboardTextArea = new JTextArea();
        scoreboardTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(scoreboardTextArea);
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> {
            // Close the scoreboard panel when the close button is clicked
            sbButton.setEnabled(true);  //toggle sbButton back on when scoreboard is closed
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        });

        // Add components to the panel
        add(scrollPane, BorderLayout.CENTER);
        add(closeButton, BorderLayout.SOUTH);

        // Update scoreboard when the panel is created
        updateScoreboard();
    }

    void updateScoreboard() {
        // Sort victims based on their scores
        ArrayList<Victim> victims = victimPicker.getVictims(); // retrieve victim list
        victims.sort(Comparator.comparingInt(Victim::getScore).reversed());

        // Display top five victims in the scoreboard
        StringBuilder scoreboardText = new StringBuilder("Top Five Victims:\n");
        for (int i = 0; i < Math.min(5, victims.size()); i++) {
            Victim victim = victims.get(i);
            scoreboardText.append(String.format("%d. %s | Score: %d\n",
                    i + 1, victim.getName(), victim.getScore()));
        }

        // Set the text of the scoreboard
        ((JTextArea) ((JScrollPane) getComponent(0)).getViewport().getView()).setText(scoreboardText.toString());
    }

    //Class needs a reference to the scoreboard button so it can toggle it
    //back on when the scoreboard is closed
    void setScoreboardButton(ScoreboardButton sbButton){
        this.sbButton = sbButton;
    }

}
