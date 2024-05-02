import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemovePointButton extends JButton implements ActionListener {
    VictimPanel victimPanel;
    ScoreboardPanel sbPanel;
    RemovePointButton(VictimPanel victimPanel, ScoreboardPanel sbPanel){
        this.sbPanel = sbPanel;
        this.victimPanel = victimPanel;
        this.setText("Remove Point");
        this.addActionListener(this);
        this.setFocusable(false);
        //this.setFont(new Font("Times New Roman", Font.PLAIN,18));

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!victimPanel.getVictim().getName().equals("Pick Victim")) {
            Actions.removePoint(victimPanel.getVictim(), victimPanel);
            Actions.updateScoreboard(sbPanel);
        }
    }
}
