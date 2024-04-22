import javax.swing.*;
import java.awt.*;

public class TimerLabel extends JLabel{
    /**
     * A label that is provided to a timer in order
     * to be displayed in a GUI
     */
    TimerLabel(){
        // would like to have time center under "Time left"
        // but it'll work - JS
        this.setText("<html>Time Left:<br/>0s</html>");
        this.setBounds(625,340,220,150);
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setVerticalAlignment(JLabel.NORTH);
        this.setFont(new Font("Times New Roman", Font.PLAIN, 40));


    }

    // When text changes, call updateText to make changes appear on screen
    public void updateTime(int time){
        this.setText("<html>Time Left:<br/>" + time + "s</html>");
    }

    // show text "Time!" after curr time:
    // Time Left:
    // <time>
    // Time!
    public void endTime(int time){
        this.setText("<html>Time Left:<br/>" + time + "s<br/><i>Time!<i/></html>");
    }
}
