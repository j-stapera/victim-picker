import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarkAbsentButton extends JButton implements ActionListener {
    VictimPanel victimPanel;
    JButton thisButton;
    boolean markedAbsent;
    MarkAbsentButton(VictimPanel victimPanel){
        thisButton = this;
        this.victimPanel = victimPanel;
        this.setText("Mark Absent");
        this.addActionListener(this);
        this.setFocusable(false);
        //this.setFont(new Font("Times New Roman", Font.PLAIN,25));
        markedAbsent = false;

    }

    public void reset(){
        markedAbsent = false;
        thisButton.setText("Mark Absent");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!victimPanel.getVictim().getName().equals("Pick Victim")) {
            if (!markedAbsent) {
                markedAbsent = true;
                Actions.markAbsent(victimPanel.getVictim(), victimPanel);
                thisButton.setText("Marked!");
            } else {
                markedAbsent = false;
                Actions.unmarkAbsent(victimPanel.getVictim(),victimPanel);
                thisButton.setText("Mark Absent");
            }

        }
    }
}