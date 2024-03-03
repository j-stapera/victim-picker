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

    TimerButtonPanel(TimerLabel tl){
        timerLabel = tl;
        startTimerButton = new JButton("<html>Start<br/>Timer<html/>");
        resetTimerButton = new JButton("<html>Reset<br/>Timer<html/>");
        addTimeButton = new JButton("+");
        removeTimeButton = new JButton("-");
        timerLogic = new TimerLogic(timerLabel);

        startTimerButton.addActionListener(this);
        resetTimerButton.addActionListener(this);
        addTimeButton.addActionListener(this);
        removeTimeButton.addActionListener(this);

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
        if (e.getSource() == startTimerButton){
            if (timerLogic.isRunning()){
                timerLogic.stopTimer();
                startTimerButton.setText("<html>Start<br/>Timer<html/>");
            } else {
                timerLogic.startTimer();
                startTimerButton.setText("<html>Stop<br/>Timer<html/>");
            }
        }
        if (e.getSource() == addTimeButton)
        {
            timerLogic.addTime();
        }
        if (e.getSource() == removeTimeButton){
            timerLogic.removeTime();
        }
        if (e.getSource() == resetTimerButton){
            timerLogic.stopTimer();
            timerLogic.resetTimer();
        }
    }

}
