import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPointButton extends JButton implements ActionListener {

    private VictimPanel victimPanel;
    private ScoreboardPanel sbPanel;
    AddPointButton(VictimPanel victimPanel, ScoreboardPanel sbPanel) {
        this.sbPanel = sbPanel;
        this.victimPanel = victimPanel;
        this.setText("Add Point");
        this.addActionListener(this);
        this.setFocusable(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (victimPanel.getVictim().getName() != "Pick Victim") {
            Actions.addPoint(victimPanel.getVictim(), victimPanel);
            Actions.updateScoreboard(sbPanel);
        }

    }
}
