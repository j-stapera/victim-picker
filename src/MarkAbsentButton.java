import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarkAbsentButton extends JButton implements ActionListener {
    VictimPanel victimPanel;
    MarkAbsentButton(VictimPanel victimPanel){
        this.victimPanel = victimPanel;
        this.setText("Mark Absent");
        this.addActionListener(this);
        this.setFocusable(false);
        //this.setFont(new Font("Times New Roman", Font.PLAIN,25));

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (victimPanel.getVictim().getName() != "Pick Victim") {
            Actions.markAbsent(victimPanel.getVictim(), victimPanel);
        }
    }
}