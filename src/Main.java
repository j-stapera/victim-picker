
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Driver class for VictimPicker w/ GUI
 */
public class Main {
    public static void main(String[] args) {
        // Create a ScoreboardPanel instance
        //ScoreboardPanel scoreboardPanel = new ScoreboardPanel(students);

        // Driver objects
        VictimPicker victimPicker = new VictimPicker(); // main driver for everything
        Actions.importVictims(victimPicker); // load victims into victim picker

        QuestionPicker questionPicker = new QuestionPicker();
        Actions.importQuestions(questionPicker);

        // Add them to a central frame
        Frame frame = new Frame();

        //Creating scoreboard components
        ScoreboardPanel scoreboardPanel = new ScoreboardPanel(victimPicker);
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
        ImportButton importButton = new ImportButton(victimPicker, questionPicker);
        QuestionsLabel questionsLabel = new QuestionsLabel();
        QuestionsButton questionsButton = new QuestionsButton(questionsLabel, questionPicker);
        PrizePanel prizePanel = new PrizePanel();

        frame.add(exportButton);
        frame.add(importButton);
        frame.add(questionsButton);
        frame.add(questionsLabel);
        frame.add(prizePanel);

        TimerLabel timerLabel = new TimerLabel();
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
                Actions.exportExportables(victimPicker); // exports data on window close
                e.getWindow().dispose();
            }
        });
    }
}
