public class Timer {
    private int startTime; //stored in seconds
    private int currTime; //stored in seconds
    private boolean isRunning;
    private final TimerLabel timerLabel;

    Timer(TimerLabel tl){
        this.currTime = 60;
        this.startTime = 60;
        this.isRunning = false;
        this.timerLabel = tl;
        timerLabel.updateTime(startTime);
    }

    /**
     *
     * @param startTime
     * a time for timer in seconds
     * @param tl
     * timer label attached to timer
     */
    Timer(int startTime, TimerLabel tl){
        this.currTime = startTime;
        this.startTime = startTime;
        this.isRunning = false;
        this.timerLabel = tl;
        timerLabel.updateTime(startTime);

    }

    public void addTime(){
        startTime += 30; // add 30s to start time
        currTime += 30; //add 30 to running time
        timerLabel.updateTime(currTime);
    }

    public void removeTime(){
        //prevent currTime from going negative
        if (currTime > 0 && (currTime - 30) > 0) {
            currTime -= 30; // remove 30 from running time
          //if curr time goes negative then set to 0
        } else if ((currTime - 30) <= 0){
            currTime = 0;
        }
        timerLabel.updateTime(currTime);

        //prevent startTime from going negative
        if (startTime > 0 && (startTime - 30) > 0) {
            startTime -= 30; // remove 30 from start time
          //if startTime goes negative then set to 0
        } else if ((startTime - 30) <= 0){
            startTime = 0;
        }
    }

    public void startTimer(){
        isRunning = true;
        // start decrementing timer
    }

    public void stopTimer(){
        isRunning = false;
        // stop decrementing timer
    }

    public void resetTimer(){
        currTime = startTime;
        timerLabel.updateTime(currTime);
    }

    public int getCurrTime(){
        return currTime;
    }

    public boolean isRunning(){
        return isRunning;
    }
}
