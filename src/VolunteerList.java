import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

public class VolunteerList extends JComboBox implements ActionListener {

    //array list to hold the list of victims
    ArrayList<Victim> victims = new ArrayList<>();
    // reference to victims and victim panel obkects
    VictimPicker vp;
    VictimPanel vPanel;

    //constructor
    VolunteerList(VictimPicker vp, VictimPanel vPanel){
        //initialize the references to victim picker and victim panel objects
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

    //implementations for handling selections events
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            //get the name of the selected victim
            String selectedName = (String) this.getSelectedItem();
            //call the select volunteer
            Actions.selectVolunteer(vp, vPanel, selectedName, victims);
        }
    }

}
