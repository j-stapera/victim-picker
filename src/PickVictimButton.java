import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PickVictimButton extends JButton implements ActionListener {
    private final PickVictimButton button;
    private final VictimPanel victimPanel;
    PickVictimButton(VictimPanel victimPanel){
        this.victimPanel = victimPanel;
        this.setText("Pick Victim");
        this.addActionListener(this);
        this.setFocusable(false);
        button = this;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Victim temp = victimPanel.getVictimPicker().chooseVictim();
        button.setText(temp.getName());
        victimPanel.setVictim(temp);
        victimPanel.updatePoints();
        button.repaint();
    }
}