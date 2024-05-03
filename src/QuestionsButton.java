import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QuestionsButton extends JPanel implements ActionListener {

    //instance variables to hold references to variables
    JButton questionsButton;
    JButton backButton;
    QuestionsLabel ql;
    QuestionPicker questionPicker;

    //constructor
    QuestionsButton(QuestionsLabel ql, QuestionPicker qp){
        //passed parameters
        this.ql = ql;
        this.questionPicker = qp;
        //setting bounds
        this.setBounds(0,684,200,75);
        //focus initialized for later
        this.setFocusable(false);
        this.setLayout(null);
        //this.setBackground(Color.BLACK);

        //question button created
        questionsButton = new JButton();
        questionsButton.setBounds(0,25,200,50);
        questionsButton.setFocusable(false);
        questionsButton.addActionListener(this);
        questionsButton.setText("Question");
        this.add(questionsButton);

        //back button
        backButton = new JButton();
        backButton.setBounds(0,0,100,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setText("Back");
        this.add(backButton);

        //initialize the button and text
        JButton back = new JButton("Back");
        back.setBounds(0,661, 100, 25);



        // have a question read when program is launched
        ql.setText(questionPicker.chooseQuestion());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //check if the source of the action event is question button
        if(e.getSource()==questionsButton) {
            //set the text of the QuestionsLabel to a randomly chosen question
            ql.setText(questionPicker.chooseQuestion());
        }
        //if the source of the ActionEvent is the backButton
        if(e.getSource()==backButton){
            //set the text of the QuestionsLabel to the previous question
            ql.setText(questionPicker.getPreviousQuestion());
        }
    }
}
