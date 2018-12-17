package Trivia;

public class TimeoutListener {

    private boolean timeoutFlag;
    private QuestionFrame questionFrame;

    public TimeoutListener(QuestionFrame questionFrame){
        this.timeoutFlag = false;
        this.questionFrame = questionFrame;
    }

    public void setTimeoutFlag(boolean timeoutFlag) {
        if (timeoutFlag) {
            questionFrame.onTimeout();
        }

        this.timeoutFlag = timeoutFlag;


    }


}
