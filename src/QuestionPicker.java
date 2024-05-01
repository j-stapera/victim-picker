import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuestionPicker {

    private ArrayList<String> Questions;

    String Question;

    private ArrayList<String> AlreadyAnswered;

    public QuestionPicker(){
        Questions = new ArrayList<>();

    }


    public String chooseQuestion(){

        Random rand = new Random();

        int index = rand.nextInt(Questions.size());

        Question = Questions.get(index);

        Questions.remove(index);

        return Question;
    }



}
