import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class QuestionsButton extends JButton implements ActionListener {

    QuestionsLabel ql;
    ArrayList<String> questions = new ArrayList<>();

    QuestionsButton(QuestionsLabel ql){
        this.ql = ql;
        this.setBounds(0,711,200,50);
        this.setFocusable(false);
        this.addActionListener(this);
        this.setText("Question");

        //Add example questions to list
        questions.add("To java or not to java?");
        questions.add("Why?");
        questions.add("How?");
        questions.add("When does this semester end?");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this){
            //***This doesn't ensure that questions don't get picked twice yet

            //Randomly get question from list and change text of the
            //  questions label when button is clicked
            //***This arraylist of questions would be imported from a file***
            Random random = new Random();
            int randomIndex = random.nextInt(questions.size());
            String randomQuestion = questions.get(randomIndex);
            ql.setText(randomQuestion);
        }
    }
}
