import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * An instance of this class creates a clickable JButton
 * when clicked, it produces the name of a random person of type Victim
 */
public class VictimButton extends JButton implements ActionListener {

    private final VictimLabel victimLabel;
    private final VictimPicker victimPicker;

    /**
     * Creates a victim button that when clicked returns the name of
     * a randomly chosen victim
     * @param vp
     * the current victim picker being used across all classes within the Jframe
     * @param vl
     * JLabel used to display name of victim
     * @param students
     * list of students available to pick from
     */
    VictimButton(VictimPicker vp, VictimLabel vl, ArrayList<Victim> students){
        this.victimPicker = vp;
        this.victimPicker.loadList(students);
        this.victimLabel = vl;

        //victimButton = new JButton();
        this.setBounds(400,350,200,100);
        this.setFocusable(false);
        this.addActionListener(this);
        this.setText("Choose Victim");

        // guaranteed first victim, causes errors otherwise
        vp.chooseVictim();
        victimLabel.updateText(vp.getCurrentVictim());


    }


    /**
     * if button clicked is from this class
     * then select a victim and display it
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==this){
            victimPicker.chooseVictim();

            victimLabel.updateText(victimPicker.getCurrentVictim());
        }

    }


}

