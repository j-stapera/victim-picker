import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PickVictimButton extends JButton implements ActionListener {

    //instance variable holds refence to the victim panel
    private final VictimPanel victimPanel;
    //constructor
    PickVictimButton(VictimPanel victimPanel){
        //initialize the victim instance variable with the passed victimpanel object
        this.victimPanel = victimPanel;
        //set the text displayed on the button
        this.setText("Pick Victim");
        //add the actionlistener to handle button clicks
        this.addActionListener(this);
        this.setFocusable(false);
    }
    // implementation for handling button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        //when the button is clicked, call the selectVictim method from the Actions class
        //passing the VictimPicker from the VictimPanel and the VictimPanel itself
        Actions.selectVictim(victimPanel.getVictimPicker(), victimPanel);

    }
}