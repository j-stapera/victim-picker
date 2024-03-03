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
     *
     * @param tl
     * timer label attached to timer
     */
    TimerLogic(TimerLabel tl){
        this.currTime = 60;
        this.startTime = 60;
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
                    timer.stop();
                    System.out.println("timer complete");
                }
            }
        });

    }

    public void addTime(){
        startTime += timeIncrement; // add 30s to start time
        currTime += timeIncrement; //add 30 to running time
        timerLabel.updateTime(currTime);
    }

    public void removeTime(){
        //prevent currTime from going negative
        if (currTime > 0 && (currTime - timeIncrement) > 0) {
            currTime -= timeIncrement; // remove timeIncrement amt from running time
          //if curr time goes negative then set to 0
        } else if ((currTime - timeIncrement) <= 0){
            currTime = 0;
        }
        timerLabel.updateTime(currTime);

        //prevent startTime from going negative
        if (startTime > 0 && (startTime - timeIncrement) > 0) {
            startTime -= timeIncrement; // remove timeIncrement from start time
          //if startTime goes negative then set to 0
        } else if ((startTime - timeIncrement) <= 0){
            startTime = 0;
        }
    }

    public void startTimer(){
        // start decrementing timer
        timer.start();
    }

    public void stopTimer(){
        // stop decrementing timer
        timer.stop();
    }

    public void resetTimer(){
        currTime = startTime;
        timerLabel.updateTime(currTime);
    }

    public int getCurrTime(){
        return currTime;
    }

    public boolean isRunning(){
        return timer.isRunning();
    }
}
