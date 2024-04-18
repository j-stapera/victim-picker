import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddVictimButton extends JButton implements ActionListener {

    //private ArrayList<VictimPanel> victimPanels;
    private VictimNumber numOfVictims;

    AddVictimButton (VictimNumber numOfVictims) {
        this.numOfVictims = numOfVictims;
        //this.victimPanels = victimPanels;

        this.setBounds(625,500,150,75);
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