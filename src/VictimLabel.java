import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class VictimLabel extends JLabel {

    VictimLabel(){
        this.setText("Victim");
        this.setBounds(125,100,750,200);
        this.setBorder(new LineBorder(Color.GRAY, 1));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setFont(new Font("Times New Roman", Font.PLAIN, 50));


    }

}
