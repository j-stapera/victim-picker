import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class QuestionsLabel extends JLabel {

    QuestionsLabel(){
        this.setText("What is the meaning of life?");
        this.setBounds(220,25,750,50);
        this.setBorder(new LineBorder(Color.GRAY, 1));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    }


}
