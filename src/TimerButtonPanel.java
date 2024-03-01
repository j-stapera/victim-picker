import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerButtonPanel extends JPanel implements ActionListener{
    private final JButton timerButton;
    private final JButton addTimeButton;
    private final JButton removeTimeButton;
    private final TimerLabel timerLabel;
    private final Timer timer;

    TimerButtonPanel(TimerLabel tl){
        timerLabel = tl;
        timerButton = new JButton("Start Timer");
        addTimeButton = new JButton("+");
        removeTimeButton = new JButton("-");
        timer = new Timer(timerLabel);

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
            if (timer.isRunning()){
                timer.stopTimer();
            } else {
                timer.startTimer();
            }
        }
        if (e.getSource() == addTimeButton)
        {
            timer.addTime();
        }
        if (e.getSource() == removeTimeButton){
            timer.removeTime();
        }
    };

}
