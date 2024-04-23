import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionsButton extends JButton implements ActionListener {

    QuestionsButton(){
        this.setBounds(0,711,200,50);
        this.setFocusable(false);
        this.addActionListener(this);
        this.setText("Question");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this){
            //action to change the 'QuestionsLabel' to random question
        }
    }
}
