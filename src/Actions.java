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
    //Updated selectVictim method that interacts with VictimPanels
    public static void selectVictim(VictimPicker vp, VictimPanel vPanel) {
        vPanel.setVictim(vp.chooseVictim());
        vPanel.updateVictimPanel();
    }
    public static void addPoint(VictimPicker vp, VictimLabel vl) {
        vp.getCurrentVictim().addScore();
        vl.updateText(vp.getCurrentVictim());
    }

    public static void removePoint(VictimPicker vp, VictimLabel vl) {
        vp.getCurrentVictim().subtractScore();
        vl.updateText(vp.getCurrentVictim());
    }

    public static void markAbsent(VictimPicker vp) {
        vp.getCurrentVictim().addAbsence();
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

    public static void selectVictim(VictimPicker vp, VictimLabel vl) {
        vp.chooseVictim();
        vl.updateText(vp.getCurrentVictim());
    }

    public static void selectVolunteer(VictimPicker vp, VictimLabel vl, String selectedName, ArrayList<Victim> students) {
        for (Victim student : students) {
            if (student.getName().equals(selectedName)) {
                vp.setCurrentVictim(student);
                vp.volunteerPT(student);
                vl.updateText(student);
                break;
            }
        }
    }

    public static void exportExportables(VictimPicker vp){
        FileHandler.Export(vp.exportVictims());
    }

    public static void updateScoreboard(ScoreboardPanel sbPanel){
        sbPanel.updateScoreboard();
    }
}


