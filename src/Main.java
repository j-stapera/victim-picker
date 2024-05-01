
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
        //ScoreboardPanel scoreboardPanel = new ScoreboardPanel(students);

        // Driver objects
        VictimPicker victimPicker = new VictimPicker(); // main driver for everything
        victimPicker.loadList(students);

        // Text display objects
        VictimLabel victimLabel = new VictimLabel(); // name of victim
        TimerLabel timerLabel = new TimerLabel(); // text for timer

        // Interactable objects
        VictimButton button = new VictimButton(victimPicker, victimLabel, students); // pick a victim button
        //ButtonsPanel panel = new ButtonsPanel(victimPicker, victimLabel, timerLabel, scoreboardPanel); // add point, remove point, timer buttons
        VolunteerComboBox volunteer = new VolunteerComboBox(names, victimPicker, students, victimLabel); // dropdown menu for selecting volunteer

        // Add them to a central frame
        Frame frame = new Frame();



        //Creating scoreboard components
        ScoreboardPanel scoreboardPanel = new ScoreboardPanel(students);
        ScoreboardFrame scoreboardFrame = new ScoreboardFrame(scoreboardPanel);
        ScoreboardButton scoreboardButton = new ScoreboardButton(scoreboardFrame);
        scoreboardPanel.setScoreboardButton(scoreboardButton);
        frame.add(scoreboardButton);


        //Create ArrayList of every necessary VictimPanel
        ArrayList<VictimPanel> victimPanels = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            victimPanels.add(new VictimPanel(i, victimPicker, scoreboardPanel));
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


        ExportButton exportButton = new ExportButton(victimPicker);
        ImportButton importButton = new ImportButton();
        QuestionsButton questionsButton = new QuestionsButton();
        QuestionsLabel questionsLabel = new QuestionsLabel();
        PrizePanel prizePanel = new PrizePanel();

        frame.add(exportButton);
        frame.add(importButton);
        frame.add(questionsButton);
        frame.add(questionsLabel);
        frame.add(prizePanel);

        TimerLabel timerimerLabel = new TimerLabel();
        // Puts timer label in different place in new frame
        timerLabel.setBounds(1000,200,220,150);
        TimerLogic timerLogic = new TimerLogic(timerLabel);
        TimerButtonPanel timerButtons = new TimerButtonPanel(timerLabel);
        timerButtons.setBounds(500,600,200,100);

        frame.add(timerButtons);
        frame.add(timerLabel);




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

        //frame.setVisible(true); 


        //Created new testframe to show bounds of new components - Connor
        //TestFrame testFrame = new TestFrame(victimPicker);

    }
}
