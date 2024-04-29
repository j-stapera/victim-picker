import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Creates a ComboBox - A component that combines a button or an editable field and a drop-down list
 */
public class VolunteerComboBox extends JButton implements ActionListener {

    Vector<String> names = new Vector<>();

    Victim victim;

    private final VictimPicker victimPicker;
    private final VictimPanel victimPanel;


    // consider changing to a JCheckbox since it would be similar behavior but less backend
    // OR when button is clicked JIcon of checkmark appears
    JComboBox volunteerCB;

    /**
     * Creates a combobox that lists the curr victims
     * Allows for manual selection of a victim
     * @param vp
     * victim picker associated with the victims
     */
    VolunteerComboBox(VictimPicker vp, VictimPanel vPanel){

        for (Victim v : vp.getVictims()) {
            names.add(v.getName());
        }
        volunteerCB = new JComboBox(names);

        this.victimPicker = vp;
        this.victimPanel = vPanel;

        this.add(volunteerCB);
        //this.setText("Volunteer");
        this.setFocusable(false);

        volunteerCB.addActionListener(this);
    }

    void UpdateVolunteerList() {
        names.clear();
        for (Victim v : victimPicker.getVictims()) {
            names.add(v.getName());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == volunteerCB) {
            String selectedName = (String) volunteerCB.getSelectedItem();
            Actions.selectVolunteer(victimPicker, selectedName, victimPanel);
        }
    }
}
