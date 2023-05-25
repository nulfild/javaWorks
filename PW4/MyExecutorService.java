package PW4;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MyExecutorService implements ExecutorService {

	private final BlockingQueue<Runnable> taskQueue;
	private final ThreadPoolExecutor executor;

	public MyExecutorService(int numThreads) {
		taskQueue = new LinkedBlockingQueue<>();
		executor =
			new ThreadPoolExecutor(
				numThreads,
				numThreads,
				0,
				TimeUnit.MILLISECONDS,
				taskQueue
			);
	}

	@Override
	public void execute(Runnable task) {
		if (executor.isShutdown()) {
			throw new RejectedExecutionException(
				"ExecutorService has been shut down"
			);
		}
		executor.execute(task);
	}

	@Override
	public void shutdown() {
		executor.shutdown();
	}

	@Override
	public List<Runnable> shutdownNow() {
		return executor.shutdownNow();
	}

	@Override
	public boolean isShutdown() {
		return executor.isShutdown();
	}

	@Override
	public boolean isTerminated() {
		return executor.isTerminated();
	}

	@Override
	public boolean awaitTermination(
		long timeout,
		TimeUnit unit
	) throws InterruptedException {
		return executor.awaitTermination(timeout, unit);
	}

	@Override
	public <T> Future<T> submit(Callable<T> task) {
		return executor.submit(task);
	}

	@Override
	public <T> Future<T> submit(Runnable task, T result) {
		return executor.submit(task, result);
	}

	@Override
	public Future<?> submit(Runnable task) {
		return executor.submit(task);
	}

	@Override
	public <T> List<Future<T>> invokeAll(
		Collection<? extends Callable<T>> tasks
	) throws InterruptedException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(
			"Unimplemented method 'invokeAll'"
		);
	}

	@Override
	public <T> List<Future<T>> invokeAll(
		Collection<? extends Callable<T>> tasks,
		long timeout,
		TimeUnit unit
	) throws InterruptedException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(
			"Unimplemented method 'invokeAll'"
		);
	}

	@Override
	public <T> T invokeAny(
		Collection<? extends Callable<T>> tasks
	) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(
			"Unimplemented method 'invokeAny'"
		);
	}

	@Override
	public <T> T invokeAny(
		Collection<? extends Callable<T>> tasks,
		long timeout,
		TimeUnit unit
	)
		throws InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(
			"Unimplemented method 'invokeAny'"
		);
	}
}
