package practice4;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class MyExecutorService implements ExecutorService {
    private final int numberOfThreads;
    private final ExecutorService myExecutorService;

    public MyExecutorService(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        this.myExecutorService = Executors.newFixedThreadPool(numberOfThreads);
    }

    @Override
    public void shutdown() {
        myExecutorService.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return myExecutorService.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return myExecutorService.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return myExecutorService.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return myExecutorService.awaitTermination(timeout, unit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return myExecutorService.submit(task);
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return myExecutorService.submit(task, result);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return myExecutorService.submit(task);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return myExecutorService.invokeAll(tasks);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return myExecutorService.invokeAll(tasks, timeout, unit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return myExecutorService.invokeAny(tasks);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return myExecutorService.invokeAny(tasks, timeout, unit);
    }

    @Override
    public void execute(Runnable command) {
        myExecutorService.execute(command);
    }
}
