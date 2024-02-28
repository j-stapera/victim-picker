import java.util.Date;
import java.util.ArrayList;
public class Victim implements Comparable<Victim>{

    private String name;
    private static final int SECTION = 22199;
    private int score;
    private Date lastPicked;
    private boolean absent = false;
    private ArrayList<Date> absences;
    private int numberOfPicks;

    //Constructor
    public Victim(String name){
        this.name = name;
        absences = new ArrayList<Date>();
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score){
        this.score = score;
    }
    public void addScore(){
        this.setScore(this.getScore() + 1);
    }

    public void subtractScore(){
        this.setScore(this.getScore() - 1);
    }

    public void setLastPicked(){
        this.lastPicked = new Date();
    }

    public void setNumberOfPicks(int numPicks){
        numberOfPicks = numPicks;
    }




    //Getters
    public String getName(){
        return name;
    }

    public int getSection(){
        return SECTION;
    }

    public int getScore(){
        return score;
    }

    public Date getLastPicked(){
        return lastPicked;
    }

    public ArrayList<Date> getAbsences(){
        return absences;
    }

    public int getNumberOfPicks(){
        return numberOfPicks;
    }




    //Method to add today's date to list of absences
    public void addAbsence(){
        Date today = new Date();
        absences.add(today);
        absent = true;
    }

    //Method to test if a student is absent
    public boolean ifAbsent(){
        return absent;
    }

    //Method used to sort array of victims by the number of picks they currently have
    public int compareTo(Victim victim){
        if (numberOfPicks == victim.numberOfPicks)
            return 0;
        else if (numberOfPicks > victim.numberOfPicks)
            return 1;
        else
            return -1;
    }

}
