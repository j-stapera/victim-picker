import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.ArrayList;

/**
 * A class instance of a single victim that tracks:
 * Name, section, score, date last picked, if absent, dates absent, num picks
 * Contains a comparable interface that compares num picks of two victims
 */
public class Victim implements Exportable, Comparable<Victim> {


    private String name;
    private int score;
    private LocalDate lastPicked;
    private boolean isAbsent = false;
    private ArrayList<LocalDate> absences;
    private int numberOfPicks;

    /**
     * Creates a new victim with desired name
     * all other information is pre-filled
     * @param name
     * name of victim
     */
    //Constructor
    public Victim(String name){
        this.name = name;
        absences = new ArrayList<LocalDate>();
    }
    public Victim(String name, int score, LocalDate lastPicked, ArrayList<LocalDate> absences, int numberOfPicks){
        this.name = name;
        this.score = score;
        this.lastPicked = lastPicked;
        this.absences = absences;
        this.numberOfPicks = numberOfPicks;
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
        this.lastPicked = LocalDate.now();
    }

    public void incrementPicks(){ this.numberOfPicks += 1;}


    //Getters
    public String getName(){
        return name;
    }


    public int getScore(){
        return score;
    }

    public LocalDate getLastPicked(){
        return lastPicked;
    }

    public ArrayList<LocalDate> getAbsences(){
        return absences;
    }

    public int getNumberOfPicks(){
        return numberOfPicks;
    }

    //Method to add today's date to list of absences
    public void addAbsence(){
        LocalDate today = LocalDate.now();
        // only adds absent if one does not exist for today
        // for closing and reopening the same day
        if (!absences.contains(today)) {
            absences.add(today);
        }
        isAbsent = true;
    }

    public void removeAbsence(){
        LocalDate today = LocalDate.now();
        absences.remove(today);
        isAbsent = false;
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
        return "Name:" + name + "*Score:" + score + "*Last picked:" + lastPicked + "*Absences:" + absences + "*Number of picks:" + numberOfPicks;
    }
}
