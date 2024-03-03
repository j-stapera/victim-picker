
import java.util.ArrayList;
import java.util.Random;

/**
 * Driver class for VictimPicker w/ GUI
 */
public class Main{
    public static void main(String[] args){

        String[] names = {"Channing Andrews", "Danny Barmanbekov", "Nate Benson", "Nate Bittle",
                "Excalibur Bunker", "Vincent Climer", "Nicholas Colet", "Fabrice Faustin", "Seth Garner",
                "Nicholas Gilleran", "Hunter Henderson", "Akhil John Bosco", "Jeremiah Jordan", "Bret Kagebein",
                "Owen Klilsgaard", "Chuckie Koch", "Reagan Kohler", "Jace Kramer", "Levi Landers",
                "Abraham Martinez Brito", "Chandler Mason", "Matthew McCallister", "Connor Myers",
                "Oluwatobiloba Olaoye", "Connor Parr", "Markie Salzwedel", "Canon Shaw", "Gavin Smith",
                "Josh Stapera", "Justin Stauffer", "Kevin Stinnett", "Ethan Stucker", "Dakotah Sutton-Rodriguez",
                "Heather Watson"};

        Random rand = new Random();
        /*Create new arraylist of students and store each name from roster in array
            Each student in the roster is randomly generated a number of picks
            to test the sorting algorithm used in the 'chooseTwo' method of the
            Victims class
        */
        ArrayList<Victim> students = new ArrayList<>();
        for (String name : names) {
            students.add(new Victim(name));     //instantiates new victim objects
            //students.get(i).setNumberOfPicks(rand.nextInt(10));
        }

        VictimPicker victimPicker = new VictimPicker();

        VictimLabel victimLabel = new VictimLabel();
        TimerLabel timerLabel = new TimerLabel();

        VictimButton button = new VictimButton(victimPicker, victimLabel, students);
        ButtonsPanel panel = new ButtonsPanel(victimPicker, victimLabel,timerLabel);
        VolunteerButton volunteer = new VolunteerButton();


        Frame frame = new Frame();
        frame.add(button);
        frame.add(victimLabel);
        frame.add(panel);
        frame.add(volunteer);
        frame.add(timerLabel);


    }


}