import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel implements ActionListener {

    private final JButton addPointButton;
    private final JButton removePointButton;
    private final JButton markAbsentButton;
    private final TimerButtonPanel timerButtons;
    private final VictimPicker victimPicker;
    private final VictimLabel victimLabel;



    /**
     * Creates a set of 4 clickable buttons (add point, remove point, mark absent, timer panel)
     * see TimerButtonPanel for info on timer panel
     */
    // NOTE: may want to move timer panel out of buttons panel, at least in its declaration
    //       instead possibly consider having it added to the panel in main
    ButtonsPanel(VictimPicker vp, VictimLabel vl, TimerLabel timerLabel){
        this.victimPicker = vp;
        this.victimLabel = vl;

        this.setBounds(125,525,750,150);
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

        timerButtons = new TimerButtonPanel(timerLabel);
        timerButtons.setBounds(530,25,200,100);

        //adds buttons to a single panel for manipulation
        this.add(addPointButton);
        this.add(removePointButton);
        this.add(markAbsentButton);
        this.add(timerButtons);


    }



    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // increments the score for the curr victim, forces victimlabel to redraw
        if(actionEvent.getSource() == addPointButton){
            victimPicker.getCurrentVictim().addScore();
            victimLabel.updateText(victimPicker.getCurrentVictim());

        }
        //decrements the score of curr victim, forces victimlabel to redraw
        if(actionEvent.getSource() == removePointButton)
        {
            victimPicker.getCurrentVictim().subtractScore();
            victimLabel.updateText(victimPicker.getCurrentVictim());
        }
        // adds absence to absence list for curr victim
        // also changes the absent button to "Marked!" for user feedback, appears for 1 second
        if(actionEvent.getSource() == markAbsentButton){
            victimPicker.getCurrentVictim().addAbsence();

            // UGLY? Probably
            // sets text to "Marked!" then waits 1 sec then returns to original text
            markAbsentButton.setText("Marked!");
            Timer timer = new Timer( 1000, e -> markAbsentButton.setText("Mark Absent"));
            timer.setRepeats( false );
            timer.start();


        }
    }

}
