package dev.is_a.acaiberii.client.cloosh.misc.util;

// intent tutorial gang
public class TimerUtil {

    public long lastMS = System.currentTimeMillis();

    public void reset() {
        lastMS = System.currentTimeMillis();
    }

    public boolean hasTimeElapsed(long time, boolean reset) {
        if (System.currentTimeMillis()-lastMS > time ) {
            if (reset)
                reset();

            return true;
        }

        return false;
    }
}
