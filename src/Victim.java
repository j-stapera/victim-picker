import java.util.Date;
import java.util.ArrayList;

/**
 * A class instance of a single victim that tracks:
 * Name, section, score, date last picked, if absent, dates absent, num picks
 * Contains a comparable interface that compares num picks of two victims
 */
public class Victim implements Exportable {
// TODO: Needs a interface called Victim and Exportable, too many dependencies on this class
    //TODO: Make a method to export this data
    private String name;
    private static final int SECTION = 22199;
    private int score;
    private Date lastPicked;
    private boolean isAbsent = false;
    private ArrayList<Date> absences;
    private int numberOfPicks;

    /**
     * Creates a new victim with desired name
     * all other information is pre-filled
     * @param name
     * name of victim
     */
    //Constructor
    // TODO: Needs another constructor that allows for all vars to be filled
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
        isAbsent = true;
    }

    //returns bool for if a victim is absent
    public boolean isAbsent(){
        return isAbsent;
    }

    /**
     * Bases equality on number of picks each victim has
     * @param victim the object to be compared.
     * @return
     * 0 if victims are equal |
     * 1 if this victim is greater |
     * -1 if this victim is less
     */
    //Method used to sort array of victims by the number of picks they currently have
    public int compareTo(Victim victim){
        if (numberOfPicks == victim.numberOfPicks)
            return 0;
        else if (numberOfPicks > victim.numberOfPicks)
            return 1;
        else
            return -1;
    }

    //method implemented from Exportable interface used to export the victim data
    @Override
    public String export() {
        return name + "*" + SECTION + "*" +score + "*" + lastPicked + "*" + isAbsent + "*" + absences + "*" + numberOfPicks;
    }

}
