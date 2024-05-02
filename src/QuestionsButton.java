import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QuestionsButton extends JPanel implements ActionListener {

    JButton questionsButton;
    JButton backButton;
    QuestionsLabel ql;
    QuestionPicker questionPicker;

    QuestionsButton(QuestionsLabel ql, QuestionPicker qp){
        this.ql = ql;
        this.questionPicker = qp;
        this.setBounds(0,684,200,75);
        this.setFocusable(false);
        this.setLayout(null);
        //this.setBackground(Color.BLACK);

        questionsButton = new JButton();
        questionsButton.setBounds(0,25,200,50);
        questionsButton.setFocusable(false);
        questionsButton.addActionListener(this);
        questionsButton.setText("Question");
        this.add(questionsButton);

        backButton = new JButton();
        backButton.setBounds(0,0,100,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setText("Back");
        this.add(backButton);


        JButton back = new JButton("Back");
        back.setBounds(0,661, 100, 25);



        // have a question read when program is launched
        ql.setText(questionPicker.chooseQuestion());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==questionsButton) {
            ql.setText(questionPicker.chooseQuestion());
        }

        if(e.getSource()==backButton){
            ql.setText(questionPicker.getPreviousQuestion());
        }
    }
}
