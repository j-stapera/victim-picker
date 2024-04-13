import java.util.ArrayList;

public class Actions {
    private static final VictimPicker victimPicker = new VictimPicker();
    private static final VictimLabel victimLabel = new VictimLabel();
    private static final TimerLabel timerLabel = new TimerLabel();
    private static final TimerLogic timerLogic = new TimerLogic(timerLabel);


    /**
     * Creates a set of 4 clickable buttons (add point, remove point, mark absent, timer panel)
     * see TimerButtonPanel for info on timer panel
     */

    
    public static void addPoint() {
        victimPicker.getCurrentVictim().addScore();
        victimLabel.updateText(victimPicker.getCurrentVictim());
    }

    public static void removePoint() {
        victimPicker.getCurrentVictim().subtractScore();
        victimLabel.updateText(victimPicker.getCurrentVictim());
    }

    public static void markAbsent() {
        victimPicker.getCurrentVictim().addAbsence();
    }

    public static void toggleTimer() {
        if (timerLogic.isRunning()) {
            timerLogic.stopTimer();
        } else {
            timerLogic.startTimer();
        }
    }

    public static void addTime() {
        timerLogic.addTime();
    }

    public static void removeTime() {
        timerLogic.removeTime();
    }

    public static void resetTimer() {
        timerLogic.stopTimer();
        timerLogic.resetTimer();
    }

    public static void selectVictim() {
        victimPicker.chooseVictim();
        victimLabel.updateText(victimPicker.getCurrentVictim());
    }

    public static void selectVolunteer(String selectedName, ArrayList<Victim> students) {
        for (Victim student : students) {
            if (student.getName().equals(selectedName)) {
                victimPicker.setCurrentVictim(student);
                victimPicker.volunteerPT(student);
                victimLabel.updateText(student);
                break;
            }
        }
    }
}


