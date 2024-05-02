import java.util.ArrayList;

public class Actions {


    //Updated addPoint method that adds point to a passed in Victim
    public static void addPoint(Victim v, VictimPanel vPanel) {
        v.addScore();
        vPanel.updateVictimPanel();
    }
    //Updated removePoint method that removes point from a passed in Victim
    public static void removePoint(Victim v, VictimPanel vPanel) {
        v.subtractScore();
        vPanel.updateVictimPanel();
    }
    //Updated markAbsent method that marks the passed in Victim absent
    public static void markAbsent(Victim v, VictimPanel vPanel) {
        v.addAbsence();
        vPanel.updateVictimPanel();
    }
    // removes an absence from a victim
    // typically used when a victim is accidentally marked absent
    public static void unmarkAbsent (Victim victim, VictimPanel victimPanel){
        victim.removeAbsence();
        victimPanel.updateVictimPanel();
    }
    //Updated selectVictim method that interacts with VictimPanels
    public static void selectVictim(VictimPicker vp, VictimPanel vPanel) {
        vPanel.setVictim(vp.chooseVictim());
        vPanel.updateVictimPanel();
    }




    public static void toggleTimer(TimerLogic tl) {
        if (tl.isRunning()) {
            tl.stopTimer();
        } else {
            tl.startTimer();
        }
    }

    public static void addTime(TimerLogic tl) {
        tl.addTime();
    }

    public static void removeTime(TimerLogic tl) {
        tl.removeTime();
    }

    public static void resetTimer(TimerLogic tl) {
        tl.stopTimer();
        tl.resetTimer();
    }

    public static void selectVolunteer(VictimPicker vp, VictimPanel vPanel, String selectedName, ArrayList<Victim> students) {
        for (Victim student : students) {
            if (student.getName().equals(selectedName)) {
                vp.setCurrentVictim(student);
                vp.volunteerPT(student);
                vPanel.setVictim(student);
                vPanel.updateVictimPanel();
                break;
            }
        }
    }

    public static void exportExportables(VictimPicker vp){
        FileHandler.Export(vp.exportVictims());
    }

    public static void importVictims(VictimPicker vp){
        vp.loadList(FileHandler.importVictims());
    }

    public static void importQuestions(QuestionPicker qp){
        qp.loadQuestions(FileHandler.importQuestions());
    }

    public static void updateScoreboard(ScoreboardPanel sbPanel){
        sbPanel.updateScoreboard();
    }
}


