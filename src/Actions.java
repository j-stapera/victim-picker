import java.util.ArrayList;

public class Actions {
//    private static final VictimPicker victimPicker = new VictimPicker();
//    private static final VictimLabel victimLabel = new VictimLabel();
//    private static final TimerLabel timerLabel = new TimerLabel();
//    private static final TimerLogic timerLogic = new TimerLogic(timerLabel);


    /**
     * Creates a set of 4 clickable buttons (add point, remove point, mark absent, timer panel)
     * see TimerButtonPanel for info on timer panel
     */

    
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
}


