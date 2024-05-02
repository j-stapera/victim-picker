import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddVictimButton extends JButton implements ActionListener {

    //private ArrayList<VictimPanel> victimPanels;
    private VictimNumber numOfVictims;

    AddVictimButton (VictimNumber numOfVictims) {
        this.numOfVictims = numOfVictims;
        //this.victimPanels = victimPanels;

        this.setBounds(335,525,150,50);
        this.setFocusable(false);
        this.addActionListener(this);
        this.setText("Add Victim");

        //One victim by default on screen
        //numOfVictims = 1;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        numOfVictims.addVictim();
    }
}