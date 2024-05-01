import javax.swing.*;

public class TestFrame extends JFrame {
    /**
     * This is just a test frame for new components
     */
    // victimPicker needed for exportbutton - Josh
    TestFrame(VictimPicker vp){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1250,800);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        this.add(new ExportButton(vp));
        this.add(new ImportButton());
        this.add(new QuestionsButton());
        this.add(new QuestionsLabel());


        TimerLabel newTimerLabel = new TimerLabel();
        // Puts timer label in different place in new frame
        newTimerLabel.setBounds(1000,300,220,150);
        TimerLogic timerLogic = new TimerLogic(newTimerLabel);
        TimerButtonPanel timerButtons = new TimerButtonPanel(newTimerLabel);
        timerButtons.setBounds(525,600,200,100);

        this.add(timerButtons);
        this.add(newTimerLabel);


        this.add(new PrizePanel());

        this.repaint();
    }


}
