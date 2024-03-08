import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VolunteerComboBox extends JButton implements ActionListener {
    /**
     * Creates a ComboBox = A component that combineds a button or a editable field and a drop-down list
     * !!IMPLEMENTATION MISSING!!
     */
    ArrayList<Victim> students;

    Victim victim;

    private final VictimPicker victimPicker;
    private final VictimLabel victimLabel;

    // consider changing to a JCheckbox since it would be similar behavior but less backend
    // OR when button is clicked JIcon of checkmark appears

    JComboBox volunteerCB;

    VolunteerComboBox(String[] names , VictimPicker vp, ArrayList<Victim> students, VictimLabel vl){

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
            // Get the selected item from the JComboBox
            String selectedName = (String) volunteerCB.getSelectedItem();
            //search for the corresponding student in the array list
            for (Victim student : students) {
                if (student.getName().equals(selectedName)) {
                    victim = student;
                    victimPicker.setCurrentVictim(victim);
                    victimPicker.volunteerPT(victim);
                    //victimLabel.setText(victim.getName() + " - " + victim.getScore() + " pts");
                    victimLabel.updateText(victim);
                    break; // Exit the loop once the student is found
                }
            }
        }
    }
}
