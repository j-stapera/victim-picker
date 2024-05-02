import java.util.*;
public class VictimPicker {

    private ArrayList<Victim> victims;
    private Victim currentVictim;
    private ArrayList<Victim> pickedToday;
    private ArrayList<Victim> absentToday;

    public VictimPicker(){
        victims = new ArrayList<>();
        pickedToday = new ArrayList<>();
        absentToday = new ArrayList<>();
        currentVictim = null;
    }

    //when volunteering set the victim manually
    public void setCurrentVictim(Victim currentVictim) {
        this.currentVictim = currentVictim;
    }

    public Victim chooseVictim(){
        //remove absent victims from being selected
        victims.removeAll(absentToday);

        // if the curr victim isn't absent update their last picked
        // checked for null in case this is the first time picker is ran
        if (currentVictim != null && !currentVictim.isAbsent()){
            currentVictim.setLastPicked();
            currentVictim.incrementPicks();
        }


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


    //add volunteer victim to the picked today list
    public void volunteerPT(Victim student){

        pickedToday.add(student);

    }



    // technically not used as victim is directly access most of the time
    //Mark students absent if they are not present
    public void markAbsent(Victim absentVictim){

        //TOGGLE
        //if victim is already marked absent, remove
        if(absentToday.contains(absentVictim)){
            absentToday.remove(absentVictim);
            absentVictim.removeAbsence();
        }
        //else, add them to absent list
        else{
            absentToday.add(absentVictim);
        }

    }

    //Load roster of students into victims array
    public void loadList(ArrayList<Victim> victims){
        this.victims = victims;
        this.pickedToday.clear();
    }

    public ArrayList<String> exportVictims(){
        ArrayList<String> victimExport = new ArrayList<>();
        //
        for (Victim victim : victims){
            victimExport.add(victim.export());
        }

        return victimExport;
    }

    public ArrayList<Victim> getVictims(){
        return victims;
    }

}
