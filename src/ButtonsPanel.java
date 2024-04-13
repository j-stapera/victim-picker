import javax.swing.*;
import java.awt.*;
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

        // This is a button panel containing a +,-, reset time, start/stop time buttons
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
        if (actionEvent.getSource() == addPointButton) {
            Actions.addPoint();
        }
        if (actionEvent.getSource() == removePointButton) {
            Actions.removePoint();
        }
        if (actionEvent.getSource() == markAbsentButton) {
            Actions.markAbsent();
        }
    }

}
