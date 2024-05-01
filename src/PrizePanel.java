import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrizePanel extends JPanel implements ActionListener {

    JLabel prizeLabel;
    JButton prizeButton;

    PrizePanel(){
        this.setBounds(30,200,150,150);
        this.setLayout(null);


        prizeLabel = new JLabel("<html>Congrats! You<br/> won a prize!");
        prizeLabel.setBounds(0,0,150,75);
        prizeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));


        prizeButton = new JButton("Class Poll");
        prizeButton.setBounds(0,75,150,75);
        prizeButton.setFocusable(false);
        prizeButton.addActionListener(this);


        this.add(prizeLabel);
        this.add(prizeButton);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == prizeButton) {
            //Still not sure how exactly we wanted this to work
            //Toggle on and off? Keep track of who uses which lifelines?
        }
    }
}
