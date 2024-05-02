import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuestionPicker {

    private ArrayList<String> questions;
    private String currQuestion;
    private ArrayList<String> alreadyAnswered;
    boolean onPreviousQuestion;

    public QuestionPicker(ArrayList<String> questions){
        this.questions = questions;
        onPreviousQuestion = false;
        currQuestion = "";
        // creates an empty list
        alreadyAnswered = new ArrayList<>();

    }


    public String chooseQuestion() {
        if (alreadyAnswered.size() == questions.size())
            return "No more Questions";

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

        // if we have reached the end of the questions
        if (alreadyAnswered.size() == questions.size()){
            return currQuestion;
        // if we are in the middle of the questions
        } else if (alreadyAnswered.size() > 1){
            onPreviousQuestion = true;
            // subtract 2, 1 because indexes count from zero, and 1 to get the previous index
            int previousIndex = alreadyAnswered.size() - 2;
            return alreadyAnswered.get(previousIndex);
        }
        // there is no previous question, return current instead
        return currQuestion;
    }



}
