import javax.swing.*;
import java.awt.*;

public class TimerLabel extends JLabel{
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

    //show text "Time!" when timer reaches a desired point
    //NOTE: I wanted this to flash via Thread.sleep() but it refused to work. Should find
    //      another way to do it since it would look cool - JS
    public void endTime(int time){
        this.setText("<html>Time Left:<br/>" + time + "s<br/><i>Time!<i/></html>");
    }
}
