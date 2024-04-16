import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerLogic {
    private int startTime; //stored in seconds
    private int currTime; //stored in seconds
    private final TimerLabel timerLabel;
    private final Timer timer;
    private final int timeIncrement;



    /**
     * A timer that decrements by 1 every second.
     * Updates label for every decrement
     * @param tl
     * timer label attached to timer
     */
    TimerLogic(TimerLabel tl){
        this.startTime = 60;
        this.currTime = this.startTime;
        this.timerLabel = tl;
        timerLabel.updateTime(startTime);
        timeIncrement = 5;

        //creates timer with delay of 1 second
        this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currTime > 0) {
                    currTime -= 1;
                    timerLabel.updateTime(currTime);
                } else {
                    timerLabel.endTime(currTime);
                    timer.stop();

                    //AudioPlayer.playAudio();

                }
            }
        });

    }

    // adds time to timer based on set increments
    // if timer is running, it does not update the startTime
    public void addTime(){
        if (timer.isRunning()){
            currTime += timeIncrement; //add 30 to running time
        } else {
            startTime += timeIncrement; // add 30s to start time
            currTime = startTime; //update currTime
        }
        timerLabel.updateTime(currTime);
    }

    // removes time to timer based on set increments
    // if timer is running, it does not update the startTime
    public void removeTime(){
        if(timer.isRunning()) {
            //prevent currTime from going negative
            if (currTime > 0 && (currTime - timeIncrement) > 0) {
                currTime -= timeIncrement; // remove timeIncrement amt from running time

                //if curr time goes negative then set to 0
            } else if ((currTime - timeIncrement) <= 0) {
                currTime = 0;
            }
        } else {
            //prevent startTime from going negative
            if (startTime > 0 && (startTime - timeIncrement) > 0) {
                startTime -= timeIncrement; // remove timeIncrement from start time

                //if startTime goes negative then set to 0
            } else if ((startTime - timeIncrement) <= 0) {
                startTime = 0;
            }
            currTime = startTime; //update currTime to match startTime
        }
        timerLabel.updateTime(currTime);
    }

    // start decrementing timer
    public void startTimer(){
        timer.start();
    }

    // stop decrementing timer
    public void stopTimer(){
        timer.stop();
    }

    // resets time to the time before it was started
    public void resetTimer(){
        currTime = startTime;
        timerLabel.updateTime(currTime);
    }

    // returns current status of timer
    public boolean isRunning(){
        return timer.isRunning();
    }
}
