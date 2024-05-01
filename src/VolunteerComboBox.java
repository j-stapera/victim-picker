import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Creates a ComboBox - A component that combines a button or an editable field and a drop-down list
 */
public class VolunteerComboBox extends JButton implements ActionListener {

    ArrayList<Victim> students;

    Victim victim;

    private final VictimPicker victimPicker;
    private final VictimLabel victimLabel;

    // consider changing to a JCheckbox since it would be similar behavior but less backend
    // OR when button is clicked JIcon of checkmark appears
    JComboBox volunteerCB;

    /**
     * Creates a combobox that lists the curr victims
     * Allows for manual selection of a victim
     * @param names
     * List of student names
     * @param vp
     * victim picker associated with the victims
     * @param students
     * List of victims in victimPicker
     * @param vl
     * VictimLabel used to display the curr victim
     */
    VolunteerComboBox(String[] names , VictimPicker vp, ArrayList<Victim> students, VictimLabel vl){
    // TODO: Refactor this constructor. Why are we passing in names if we already have a list of victims??
    //       We can get this same info from just doing victim.getname()
        volunteerCB = new JComboBox(names);

        this.students = students;
        this.victimPicker = vp;
        this.victimLabel = vl;
        this.victimPicker.loadList(students);

        this.add(volunteerCB);
        this.setBounds(400, 465,200,35);
        this.setText("Volunteer");
        this.setFocusable(false);

        volunteerCB.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == volunteerCB) {
            String selectedName = (String) volunteerCB.getSelectedItem();
            //Actions.selectVolunteer(victimPicker, victimLabel, selectedName, students);
        }
    }
}
