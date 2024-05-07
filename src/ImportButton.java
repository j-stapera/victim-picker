import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class represents a custom JButton used to import data into victim picker and question picker
public class ImportButton extends JButton implements ActionListener {
    //instance vp
    VictimPicker vp;
    //instance qp
    QuestionPicker qp;
    //constructor
    ImportButton(VictimPicker vp, QuestionPicker qp){
        //intialize the victim picker and qp references with the passed objects
        this.vp = vp;
        this.qp = qp;
        //set the position and size of the button on the JFrame
        this.setBounds(0,0,200,50);
        //initializing the focus variable for later use
        this.setFocusable(false);
        //handles button clicks
        this.addActionListener(this);
        //sets the displayed on the button
        this.setText("Import");
    }

    //implementation for handling button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        //check if the source of the action event is this import button
        if(e.getSource()==this){
            //if the button is clicked , call the methods to import victims and questions using the action class
            Actions.importVictims(vp);
            Actions.importQuestions(qp);
            //action to import stuff to file(s)
        }
    }
}
