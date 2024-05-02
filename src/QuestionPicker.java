import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuestionPicker {

    private List<String> Questions;

    private String Question;

    private ArrayList<String> AlreadyAnswered;

    public QuestionPicker(List<String> Questions){
        this.Questions = Questions;
        Question = null;

    }


    public String chooseQuestion(){

        Random rand = new Random();

        int index = rand.nextInt(Questions.size());

        Question = Questions.get(index);

        Questions.remove(index);

        return Question;
    }



}
