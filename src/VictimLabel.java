import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * An instance of this class extends JLabel to display
 * the name of a person of type Victim
 */
public class VictimLabel extends JLabel {
    /**
     * Creates a label in times new roman font that will display the current victim
     * starting value display Victim
     */
    VictimLabel(){
        this.setText("Victim");
        this.setBounds(125,100,750,200);
        this.setBorder(new LineBorder(Color.GRAY, 1));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setFont(new Font("Times New Roman", Font.PLAIN, 50));


    }

}
