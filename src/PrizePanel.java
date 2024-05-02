import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrizePanel extends JPanel implements ActionListener {

    JLabel prizeLabel;
    JButton classPoll;
    JButton getOutOfJail;
    JButton phoneFriend;
    JButton doubleNothing;

    PrizePanel(){
        this.setBounds(30,100,150,400);
        this.setLayout(null);


        prizeLabel = new JLabel("Lifelines");
        prizeLabel.setBounds(0,0,150,75);
        prizeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));


        classPoll = new JButton("Class Poll");
        classPoll.setBounds(0,75,150,50);
        classPoll.setFocusable(false);
        classPoll.addActionListener(this);

        getOutOfJail = new JButton("Get Out of Jail");
        getOutOfJail.setBounds(0,150,150,50);
        getOutOfJail.setFocusable(false);
        getOutOfJail.addActionListener(this);

        phoneFriend = new JButton("Phone a Friend");
        phoneFriend.setBounds(0,225,150,50);
        phoneFriend.setFocusable(false);
        phoneFriend.addActionListener(this);

        doubleNothing = new JButton("Double or Nothing");
        doubleNothing.setBounds(0,300,150,50);
        doubleNothing.setFocusable(false);
        doubleNothing.addActionListener(this);

        this.add(prizeLabel);
        this.add(classPoll);
        this.add(getOutOfJail);
        this.add(phoneFriend);
        this.add(doubleNothing);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == classPoll) {
            //Still not sure how exactly we wanted this to work
            //Toggle on and off? Keep track of who uses which lifelines?
        }
    }
}
