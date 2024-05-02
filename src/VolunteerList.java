import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

public class VolunteerList extends JComboBox implements ActionListener {

    ArrayList<Victim> victims = new ArrayList<>();
    VictimPicker vp;
    VictimPanel vPanel;

    VolunteerList(VictimPicker vp, VictimPanel vPanel){
        this.vp=vp;
        this.vPanel=vPanel;
        this.setFocusable(false);
        this.addActionListener(this);

        //Load internal list of victims to pass to dropbox
        for(Victim victim : vp.getVictims()){
            victims.add(victim);
        }

        //Sort 'victims' so that they are in alphabetical order
        //Makes them easier to lookup in the dropbox
        victims.sort(Comparator.comparing(Victim::getName));

        victims.add(0, new Victim("Pick Victim"));

        //Load each 'victim' into the dropbox
        for(Victim v : victims){
            this.addItem(v.getName());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            String selectedName = (String) this.getSelectedItem();
            Actions.selectVolunteer(vp, vPanel, selectedName, victims);
        }
    }

}
