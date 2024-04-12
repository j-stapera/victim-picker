import java.util.ArrayList;

public class Actions {
    private final VictimPicker victimPicker;
    private final VictimLabel victimLabel;
    private final TimerLogic timerLogic;

    /**
     * Creates a set of 4 clickable buttons (add point, remove point, mark absent, timer panel)
     * see TimerButtonPanel for info on timer panel
     */

    public Actions(VictimPicker vp, VictimLabel vl, TimerLogic tl) {
        this.victimPicker = vp;
        this.victimLabel = vl;
        this.timerLogic = tl;
    }

    public void addPoint() {
        victimPicker.getCurrentVictim().addScore();
        victimLabel.updateText(victimPicker.getCurrentVictim());
    }

    public void removePoint() {
        victimPicker.getCurrentVictim().subtractScore();
        victimLabel.updateText(victimPicker.getCurrentVictim());
    }

    public void markAbsent() {
        victimPicker.getCurrentVictim().addAbsence();
    }

    public void toggleTimer() {
        if (timerLogic.isRunning()) {
            timerLogic.stopTimer();
        } else {
            timerLogic.startTimer();
        }
    }

    public void addTime() {
        timerLogic.addTime();
    }

    public void removeTime() {
        timerLogic.removeTime();
    }

    public void resetTimer() {
        timerLogic.stopTimer();
        timerLogic.resetTimer();
    }

    public void selectVictim() {
        victimPicker.chooseVictim();
        victimLabel.updateText(victimPicker.getCurrentVictim());
    }

    public void selectVolunteer(String selectedName, ArrayList<Victim> students) {
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


