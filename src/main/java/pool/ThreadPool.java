package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool<T extends Convertor> {

    private T convertor;
    private ExecutorService executorService;
    private boolean isStop;

    public ThreadPool(T convertor) {
        this.convertor = convertor;
    }

    public boolean isStop() {
        return isStop;
    }

    public void start() {

        executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                convertor.convert();
            }
        });
    }

    public void stop() {
        executorService.shutdown();
        this.isStop = executorService.isShutdown();
    }

}
