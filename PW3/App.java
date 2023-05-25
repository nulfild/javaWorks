package PW3;

import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
		List<Integer> list = new ThreadSafeList<>();

		Thread one = new Thread(() -> {
			for (int i = 0; i < 5000; i++) {
				list.add(0);
			}
		});
		Thread two = new Thread(() -> {
			for (int i = 0; i < 5000; i++) {
				list.add(1);
			}
		});

		one.start();
		two.start();
		Thread.sleep(2000);
		System.out.println(list.size());

		Map<Integer, Integer> map = new ThreadSafeMap<>();

		one =
			new Thread(() -> {
				for (int i = 0; i < 5000; i++) {
					map.put(i, i);
				}
			});
		two =
			new Thread(() -> {
				for (int i = 5001; i <= 10000; i++) {
					map.put(i, i);
				}
			});

		one.start();
		two.start();
		Thread.sleep(2000);
		System.out.println(map.size());
	}
}
