package thread.start;

import static thread.util.MyLogger.log;

public class ManyThreadMainV2 {

    public static void main(String[] args) {
        log("main() start");

        HelloRunnable helloRunnable = new HelloRunnable();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(helloRunnable);
            t.start();
        }

        log("main() end");
    }
}
