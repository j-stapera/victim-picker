import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerButtonPanel extends JPanel implements ActionListener{
    private final JButton startTimerButton;
    private final JButton resetTimerButton;
    private final JButton addTimeButton;
    private final JButton removeTimeButton;
    private final TimerLabel timerLabel;
    private final TimerLogic timerLogic;

    /**
     * Creates a panel with +,-,reset timer, start/stop timer buttons
     * creates a timer and updates associated timerLabel
     * @param tl
     * timerLabel that is associated with a specific timer
     */
    TimerButtonPanel(TimerLabel tl){
        timerLabel = tl;
        // buttons for panel
        startTimerButton = new JButton("<html>Start<br/>Timer<html/>");
        resetTimerButton = new JButton("<html>Reset<br/>Timer<html/>");
        addTimeButton = new JButton("+");
        removeTimeButton = new JButton("-");

        // timer
        timerLogic = new TimerLogic(timerLabel);

        // action listeners for buttons
        startTimerButton.addActionListener(this);
        resetTimerButton.addActionListener(this);
        addTimeButton.addActionListener(this);
        removeTimeButton.addActionListener(this);

        // panel layout, results in a panel that looks like
        // |       +       |
        // | start | reset |
        // |       -       |
        // start toggles between start and stop
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(200,100));
        startTimerButton.setPreferredSize(new Dimension(100,50));
        resetTimerButton.setPreferredSize(new Dimension(100,50));

        this.add(startTimerButton, BorderLayout.WEST);
        this.add(resetTimerButton,BorderLayout.EAST);
        this.add(addTimeButton, BorderLayout.NORTH);
        this.add(removeTimeButton, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startTimerButton) {
            Actions.toggleTimer();
        }
        if (e.getSource() == addTimeButton) {
            Actions.addTime();
        }
        if (e.getSource() == removeTimeButton) {
            Actions.removeTime();
        }
        if (e.getSource() == resetTimerButton) {
            Actions.resetTimer();
        }
    }

}
