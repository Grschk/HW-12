package Annotation;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {

    public CustomThreadPoolExecutor(int nThread) {
        super(nThread, nThread, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    @Override
    public void execute(Runnable command) {
        int countAnnotation = command.getClass().getAnnotation(Repeat.class).count();
        while (countAnnotation-- > 0) {
            super.execute(command);
        }
    }
}