import java.util.ArrayList;
import java.util.Collections;


public class QuestionPicker {

    private ArrayList<String> questions;
    private String currQuestion;
    private ArrayList<String> alreadyAnswered;
    boolean onPreviousQuestion;

    public QuestionPicker(){
        this.questions = new ArrayList<>();
        onPreviousQuestion = false;
        currQuestion = "";
        // creates an empty list
        alreadyAnswered = new ArrayList<>();

    }


    public String chooseQuestion() {
        if (alreadyAnswered.size() == questions.size())
            return "No more questions";

        if (onPreviousQuestion){
            onPreviousQuestion = false;
            return currQuestion;
        }

        do {
            Collections.shuffle(questions);
            currQuestion = questions.getFirst();
        } while (alreadyAnswered.contains(currQuestion));

        alreadyAnswered.add(currQuestion);
        return currQuestion;
    }

    public String getPreviousQuestion(){



        // if we are in the middle of the questions
        if (alreadyAnswered.size() > 1){
            onPreviousQuestion = true;

            // subtract 2, 1 because indexes count from zero, and 1 to get the previous index
            int previousIndex = alreadyAnswered.size() - 2;
            return alreadyAnswered.get(previousIndex);
        } else {
            // we have reached the end of the questions
            // OR
            // currQuestion is our previous question
            // "No more Questions" is currently displayed

            // either way, return currQuestion
            return currQuestion;
        }
    }

    public void loadQuestions(ArrayList<String> questions){
        this.questions = questions;
        this.alreadyAnswered.clear(); //reset already answered
    }

}
