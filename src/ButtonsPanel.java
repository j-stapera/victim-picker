import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel implements ActionListener {

    JButton addPointButton;
    JButton removePointButton;
    JButton markAbsentButton;
    JButton startTimerButton;
    VictimPicker victimPicker;



    /**
     * Creates a set of 4 clickable buttons (add point, remove point, mark absent, start timer)
     * !!IMPLEMENTATION OF ACTIONS MISSING!!
     */
    ButtonsPanel(VictimPicker vp){
        this.victimPicker = vp;

        this.setBounds(150,525,700,150);
        this.setLayout(null);
        //this.setBackground(Color.BLACK);

        addPointButton = new JButton("Add Point");
        addPointButton.setFocusable(false);
        addPointButton.setBounds(20,50,150,50);
        addPointButton.addActionListener(this);


        removePointButton = new JButton("Remove Point");
        removePointButton.setFocusable(false);
        removePointButton.setBounds(190,50,150,50);
        removePointButton.addActionListener(this);

        markAbsentButton = new JButton("Mark Absent");
        markAbsentButton.setFocusable(false);
        markAbsentButton.setBounds(360,50,150,50);
        markAbsentButton.addActionListener(this);

        startTimerButton = new JButton("Start Timer");
        startTimerButton.setFocusable(false);
        startTimerButton.setBounds(530,50,150,50);

        this.add(addPointButton);
        this.add(removePointButton);
        this.add(markAbsentButton);
        this.add(startTimerButton);


    }



    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == addPointButton){
            victimPicker.getCurrentVictim().addScore();
            System.out.println(victimPicker.getCurrentVictim().getName() + ": " +
                    victimPicker.getCurrentVictim().getScore());
        }
        if(actionEvent.getSource() == removePointButton)
        {
            victimPicker.getCurrentVictim().subtractScore();
            System.out.println(victimPicker.getCurrentVictim().getName() + ": " +
                    victimPicker.getCurrentVictim().getScore());
        }
        if(actionEvent.getSource() == markAbsentButton){
            victimPicker.getCurrentVictim().addAbsence();
        }
    };

}
