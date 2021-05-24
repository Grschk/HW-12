package Annotation;

public class Main {
    public static void main(String[] args) {
        CustomThreadPoolExecutor poolExecutor = new CustomThreadPoolExecutor(10);
        poolExecutor.execute(new MyRunnable());
        poolExecutor.shutdown();
    }
}
