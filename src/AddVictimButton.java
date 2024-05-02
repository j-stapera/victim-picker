import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


//this class represents a custom JButton that when clicked adds a victim
public class AddVictimButton extends JButton implements ActionListener {

    //private ArrayList<VictimPanel> victimPanels;
    //declare an instance variable to hold the number of victims
    private VictimNumber numOfVictims;

    //constructor for the AddVictimButton class
    AddVictimButton (VictimNumber numOfVictims) {
        //initialize the numofvictims instance variable with the passed Victimnumber object
        this.numOfVictims = numOfVictims;
        //this.victimPanels = victimPanels;
        //set the position and size of the button on the JFrame
        this.setBounds(335,525,150,50);
        //ensure the button doesnt receive focus
        this.setFocusable(false);
        //handles button clicks
        this.addActionListener(this);
        //set the display on the button
        this.setText("Add Victim");

        //One victim by default on screen
        //numOfVictims = 1;

    }

    //action listener implementation for handling button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        //when button is clicked \, call the addvictim method of the numofvictims object
        numOfVictims.addVictim();
    }
}