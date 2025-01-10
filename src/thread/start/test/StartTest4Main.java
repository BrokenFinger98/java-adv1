package thread.start.test;

import static java.lang.Thread.sleep;
import static thread.util.MyLogger.log;

public class StartTest4Main {

    public static void main(String[] args) {
        Thread threadA = new Thread(new CustomRunnable(1000, "A"), "Thread-A");
        Thread threadB = new Thread(new CustomRunnable(500, "B"), "Thread-B");
        threadA.start();
        threadB.start();
    }
    
    static class CustomRunnable implements Runnable {
        private final long sleepMs;
        private final String content;

        public CustomRunnable(long sleepMs, String content) {
            this.sleepMs = sleepMs;
            this.content = content;
        }

        @Override
        public void run() {
            while (true) {
                log(content);
                try {
                    sleep(sleepMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
