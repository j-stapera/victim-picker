import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class QuestionsButton extends JPanel implements ActionListener {

    JButton questionsButton;
    JButton backButton;
    QuestionsLabel ql;
    QuestionPicker questionPicker;

    QuestionsButton(QuestionsLabel ql){
        this.ql = ql;
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

        // creates new question picker attached to THIS
        // uses the questions from Questions.txt
        questionPicker = new QuestionPicker(FileHandler.importQuestions());
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
