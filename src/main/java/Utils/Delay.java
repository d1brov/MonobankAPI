package Utils;

import java.util.concurrent.TimeUnit;

public class Delay {

    public static void waitSeconds(int waitingTimeSec){
        try {
            TimeUnit.SECONDS.sleep(waitingTimeSec);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

}
