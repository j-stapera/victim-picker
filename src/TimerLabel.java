import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TimerLabel extends JLabel{
    TimerLabel(){
        // would like to have time center under "Time left"
        // but it'll work - JS
        this.setText("<html>Time Left:<br/>0s</html>");
        this.setBounds(650,350,250,120);
        this.setBorder(new LineBorder(Color.GRAY, 1));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setFont(new Font("Times New Roman", Font.PLAIN, 50));


    }

    // When text changes, call updateText to make changes appear on screen
    public void updateTime(int time){
        this.setText("<html>Time Left:<br/>" + Integer.toString(time) + "s</html>");
    }
}
