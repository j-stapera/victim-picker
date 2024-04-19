import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemovePointButton extends JButton implements ActionListener {
    VictimPanel victimPanel;
    RemovePointButton(VictimPanel victimPanel){
        this.victimPanel = victimPanel;
        this.setText("Remove Point");
        this.addActionListener(this);
        this.setFocusable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        victimPanel.getVictim().subtractScore();
        victimPanel.updatePoints();
    }
}
