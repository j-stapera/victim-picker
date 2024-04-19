import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPointButton extends JButton implements ActionListener {

    VictimPanel victimPanel;
    AddPointButton(VictimPanel victimPanel) {
        this.victimPanel = victimPanel;
        this.setText("Add Point");
        this.addActionListener(this);
        this.setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        victimPanel.getVictim().addScore();
        victimPanel.updatePoints();

    }
}
