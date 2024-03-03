import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerButtonPanel extends JPanel implements ActionListener{
    private final JButton timerButton;
    private final JButton addTimeButton;
    private final JButton removeTimeButton;
    private final TimerLabel timerLabel;
    private final TimerLogic timerLogic;

    TimerButtonPanel(TimerLabel tl){
        timerLabel = tl;
        timerButton = new JButton("Start TimerLogic");
        addTimeButton = new JButton("+");
        removeTimeButton = new JButton("-");
        timerLogic = new TimerLogic(timerLabel);

        timerButton.addActionListener(this);
        addTimeButton.addActionListener(this);
        removeTimeButton.addActionListener(this);

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(150,100));

        this.add(timerButton, BorderLayout.CENTER);
        this.add(addTimeButton, BorderLayout.NORTH);
        this.add(removeTimeButton, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timerButton){
            if (timerLogic.isRunning()){
                timerLogic.stopTimer();
            } else {
                timerLogic.startTimer();
            }
        }
        if (e.getSource() == addTimeButton)
        {
            timerLogic.addTime();
        }
        if (e.getSource() == removeTimeButton){
            timerLogic.removeTime();
        }
    }

}
