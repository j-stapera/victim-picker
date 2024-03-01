import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VolunteerButton extends JButton implements ActionListener {
    /**
     * Creates a button with text Volunteer
     * !!IMPLEMENTATION MISSING!!
     */
    // consider changing to a JCheckbox since it would be similar behavior but less backend
    // OR when button is clicked JIcon of checkmark appears
    VolunteerButton(){
        this.setBounds(425, 465,150,35);
        this.setText("Volunteer");
        this.setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this)
        {

        }
    }
}
