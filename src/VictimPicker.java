import javax.swing.*;
import java.sql.SQLOutput;
import java.util.*;
import java.awt.*;
public class VictimPicker {

    private ArrayList<Victim> victims;
    private Victim currentVictim;
    private ArrayList<Victim> pickedToday;
    private ArrayList<Victim> absentToday;

    public VictimPicker(){
        victims = new ArrayList<>();
        pickedToday = new ArrayList<>();
        absentToday = new ArrayList<>();
    }

    //when volunteering set the victim manually
    public void setCurrentVictim(Victim currentVictim) {
        this.currentVictim = currentVictim;
    }

    public Victim chooseVictim(){
        //remove absent victims from being selected
        victims.removeAll(absentToday);

        if (pickedToday.size() == victims.size()){
            pickedToday.clear();
        }


        //each victim is chosen at least ONCE
        do {
            Collections.shuffle(victims);
            currentVictim = victims.getFirst();
        } while(pickedToday.contains(currentVictim));

        pickedToday.add(currentVictim);

        return currentVictim;
    }

    public Victim getCurrentVictim()
    {
        return currentVictim;
    }

    /**
    *    Method to choose two random victims, prioritizing those with
    *    the lowest number of picks. <p>
     *   Done by sorting the array of victims by number of picks and randomly generating two unique integers
    *    between 0 and half of the size of the array. <p>
     *   Essentially chooses two random students from the first half of the array when it is
    *    sorted in ascending order by number of picks.
     */

    public ArrayList<Victim> chooseTwo(){
        ArrayList<Victim> twoVictims = new ArrayList<>();
        Random rand = new Random();

        //Sort array of victims
        Collections.sort(victims);

        //Generate two random indexes
        int index1 = rand.nextInt(victims.size() / 2);
        int index2 = rand.nextInt(victims.size() / 2);

        //Change second index if it is the same as first to make both unique
        while(index1 == index2){
            index2 = rand.nextInt(victims.size() / 2);
        }

        //Load victims into arraylist of two victims
        twoVictims.add(victims.get(index1));
        twoVictims.add(victims.get(index2));


        //Add victims to the 'pickedToday' array
        pickedToday.add(victims.get(index1));
        pickedToday.add(victims.get(index2));

        //Add all absent students to 'absentToday' array
        for(int i = 0; i < victims.size(); i++){
            if(victims.get(i).isAbsent()){
                markAbsent(victims.get(i));
            }
        }

        //Return victims
        return twoVictims;
    }

    //add volunteer victim to the picked today list
    public void volunteerPT(Victim student){

        pickedToday.add(student);

    }


    //Increment the score of those who were chosen and update when they were last picked
    // TODO: May not be needed anymore??
    public void increaseScore(int points){
        for(int i = 0; i < pickedToday.size(); i++){
            pickedToday.get(i).setScore(pickedToday.get(i).getScore() + 1);
            pickedToday.get(i).setLastPicked();
        }

    }

    //Mark students absent if they are not present
    public void markAbsent(Victim absentVictim){

        //TOGGLE
        //if victim is already marked absent, remove
        if(absentToday.contains(absentVictim)){
            absentToday.remove(absentVictim);
            Actions.unmarkAbsent(absentVictim);
        }
        //else, add them to absent list
        else{
            absentToday.add(absentVictim);
        }

    }

    //Load roster of students into victims array
    public void loadList(ArrayList<Victim> victims){
        this.victims = new ArrayList<Victim>(victims);
    }

    public ArrayList<String> exportVictims(){
        ArrayList<String> victimExport = new ArrayList<>();
        for (Victim victim : victims){
            victimExport.add(victim.export());
        }

        return victimExport;
    }

    public ArrayList<Victim> getVictims(){
        return victims;
    }

}
