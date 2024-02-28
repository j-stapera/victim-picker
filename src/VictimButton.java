import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class VictimButton extends JButton implements ActionListener {

    VictimLabel victimLabel;
    JButton victimButton;
    Victim victim;
    VictimPicker victimPicker = new VictimPicker();


    VictimButton(VictimPicker victimPicker, VictimLabel victimLabel, ArrayList<Victim> students){

        this.victimPicker = victimPicker;
        this.victimPicker.loadList(students);
        this.victimLabel = victimLabel;

        //victimButton = new JButton();
        this.setBounds(400,350,200,100);
        this.setFocusable(false);
        this.addActionListener(this);
        this.setText("Choose Victim");


    }

    /*
    the buttonspanel class would need the current victim from
    this class in order to add/substract from score and mark absent
     */
    public Victim getCurrentVictim(){
        return victim;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==this){
            victimPicker.chooseVictim();
            victimLabel.setText(victimPicker.getCurrentVictim().getName());
        }

    }


}

