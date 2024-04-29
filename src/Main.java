
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

/**
 * Driver class for VictimPicker w/ GUI
 */
public class Main {
    public static void main(String[] args) {

        // TODO: Replace with a file import
        String[] names = {"Channing Andrews", "Danny Barmanbekov", "Nate Benson", "Nate Bittle",
                "Excalibur Bunker", "Vincent Climer", "Nicholas Colet", "Fabrice Faustin", "Seth Garner",
                "Nicholas Gilleran", "Hunter Henderson", "Akhil John Bosco", "Jeremiah Jordan", "Bret Kagebein",
                "Owen Kiilsgaard", "Chuckie Koch", "Reagan Kohler", "Jace Kramer", "Levi Landers",
                "Abraham Martinez Brito", "Chandler Mason", "Matthew McCallister", "Connor Myers",
                "Oluwatobiloba Olaoye", "Connor Parr", "Markie Salzwedel", "Canon Shaw", "Gavin Smith",
                "Josh Stapera", "Justin Stauffer", "Kevin Stinnett", "Ethan Stucker", "Dakotah Sutton-Rodriguez",
                "Heather Watson"};

        Random rand = new Random(); // purpose??

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

        // Create a ScoreboardPanel instance
        ScoreboardPanel scoreboardPanel = new ScoreboardPanel(students);

        // Driver objects
        VictimPicker victimPicker = new VictimPicker(); // main driver for everything
        victimPicker.loadList(students);


        // Add them to a central frame
        Frame frame = new Frame();


        //Create ArrayList of every necessary VictimPanel
        ArrayList<VictimPanel> victimPanels = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            victimPanels.add(new VictimPanel(i, victimPicker));
        }
        for (VictimPanel v : victimPanels) {
            frame.add(v);
            v.setVisible(false);
        }

        VictimNumber victimNumber = new VictimNumber(victimPanels);

        AddVictimButton addVictimButton = new AddVictimButton(victimNumber);
        frame.add(addVictimButton);

        RemoveVictimButton removeVictimButton = new RemoveVictimButton(victimNumber);
        frame.add(removeVictimButton);

        frame.repaint();

        // Add a window listener to dispose the frame
        // exports all data on close, stupid-proofing accidental closing
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //Actions.exportExportables(victimPicker); // exports data on window close
                e.getWindow().dispose();
            }
        });



        //Created new testframe to show bounds of new components - Connor
        TestFrame testFrame = new TestFrame(victimPicker);

    }
}
