import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel {

    JButton addPointButton;
    JButton removePointButton;
    JButton markAbsentButton;
    JButton startTimerButton;

    Victim victim;



    ButtonsPanel(){

        this.setBounds(150,525,700,150);
        this.setLayout(null);
        this.setBackground(Color.BLACK);

        addPointButton = new JButton("Add Point");
        addPointButton.setFocusable(false);
        addPointButton.setBounds(20,50,150,50);


        removePointButton = new JButton("Remove Point");
        removePointButton.setFocusable(false);
        removePointButton.setBounds(190,50,150,50);

        markAbsentButton = new JButton("Mark Absent");
        markAbsentButton.setFocusable(false);
        markAbsentButton.setBounds(360,50,150,50);

        startTimerButton = new JButton("Start Timer");
        startTimerButton.setFocusable(false);
        startTimerButton.setBounds(530,50,150,50);

        this.add(addPointButton);
        this.add(removePointButton);
        this.add(markAbsentButton);
        this.add(startTimerButton);


    }


}
