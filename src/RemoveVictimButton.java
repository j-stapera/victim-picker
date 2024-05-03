import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RemoveVictimButton extends JButton implements ActionListener {
    //private ArrayList<VictimPanel> victimPanels;
    //instance victim variable
    private VictimNumber numOfVictims;

    RemoveVictimButton (VictimNumber numOfVictims) {
        //initialize the num of victms instance varable with the passed object
        this.numOfVictims = numOfVictims;
        //this.victimPanels = victimPanels;
        //set postiion on gui
        this.setBounds(717,525,150,50);
        this.setFocusable(false);
        this.addActionListener(this);
        //set text
        this.setText("Remove Victim");

        //One victim by default on screen
        //victimPanels.get(0).setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //when the button is clicked call the removeVictim method of the numOfVictims object
        numOfVictims.removeVictim();
    }
}