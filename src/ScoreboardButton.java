import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreboardButton extends JButton implements ActionListener {

    private ScoreboardFrame sbFrame;

    ScoreboardButton(ScoreboardFrame sbFrame){
        this.sbFrame = sbFrame;
        this.setBounds(985,711,200,50);
        this.setFocusable(false);
        this.addActionListener(this);
        this.setText("Scoreboard");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sbFrame.setVisible(true);
        this.setEnabled(false);     //toggle off scoreboard button so the user doesn't open multiple scoreboards

    }
}
