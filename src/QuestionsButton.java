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
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String> chosen = new ArrayList<>();

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

        //Add example questions to list
        questions.add("To java or not to java?");
        questions.add("Why?");
        questions.add("How?");
        questions.add("When does this semester end?");

        JButton back = new JButton("Back");
        back.setBounds(0,661, 100, 25);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==questionsButton){
            //***This doesn't ensure that questions don't get picked twice yet

            //Randomly get question from list and change text of the
            //  questions label when button is clicked
            //***This arraylist of questions would be imported from a file***
            Random random = new Random();
            int randomIndex = random.nextInt(questions.size());
            String randomQuestion = questions.get(randomIndex);

            if(chosen.containsAll(questions)){
                ql.setText("No more questions");
            }
            else{
                if(!chosen.contains(randomQuestion)){
                    ql.setText(randomQuestion);
                    chosen.add(randomQuestion);
                }
                else if(!chosen.containsAll(questions)){
                    while(chosen.contains(randomQuestion)){
                        randomIndex = random.nextInt(questions.size());
                        randomQuestion = questions.get(randomIndex);
                    }
                    ql.setText(randomQuestion);
                    chosen.add(randomQuestion);
                }
            }
        }

        if(e.getSource()==backButton){
            String lastQuestion;

            if(chosen.isEmpty()){

            }
            else if(chosen.size() == 1){
                lastQuestion = chosen.get(0);
                ql.setText(lastQuestion);
            }
            else{
                lastQuestion = chosen.remove(chosen.size()-1);
                ql.setText(lastQuestion);
            }
        }
    }
}
