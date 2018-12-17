package Trivia;

public class TimeoutListener {

    private boolean timeoutFlag;

    public TimeoutListener(){
        this.timeoutFlag = false;
    }

    public boolean isTimeoutFlag() {
        return timeoutFlag;
    }

    public void setTimeoutFlag(boolean timeoutFlag) {
        this.timeoutFlag = timeoutFlag;

        //TODO: pop a notifiaction box ?
    }


}
