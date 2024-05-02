import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarkAbsentButton extends JButton implements ActionListener {
    VictimPanel victimPanel;
    JButton thisButton;
    MarkAbsentButton(VictimPanel victimPanel){
        thisButton = this;
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

            this.setText("Marked!");
            Timer timer = new Timer(2000, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    // Change the button text back to the original
                    thisButton.setText("Mark Absent");
                }
            });
            timer.setRepeats(false); // Only execute once
            timer.start();
        }
    }
}