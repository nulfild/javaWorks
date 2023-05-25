package PW3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class ThreadSafeMap<K, V> implements Map<K, V> {

	private final Map<K, V> map = new HashMap<>();
	private final Semaphore semaphore = new Semaphore(1);

	@Override
	public int size() {
		try {
			semaphore.acquire();
			int size = map.size();
			semaphore.release();
			return size;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean isEmpty() {
		try {
			semaphore.acquire();
			boolean isEmpty = map.isEmpty();
			semaphore.release();
			return isEmpty;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean containsKey(Object key) {
		try {
			semaphore.acquire();
			boolean containsKey = map.containsKey(key);
			semaphore.release();
			return containsKey;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean containsValue(Object value) {
		try {
			semaphore.acquire();
			boolean containsValue = map.containsValue(value);
			semaphore.release();
			return containsValue;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public V get(Object key) {
		try {
			semaphore.acquire();
			V value = map.get(key);
			semaphore.release();
			return value;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public V put(K key, V value) {
		try {
			semaphore.acquire();
			V previousValue = map.put(key, value);
			semaphore.release();
			return previousValue;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public V remove(Object key) {
		try {
			semaphore.acquire();
			V removedValue = map.remove(key);
			semaphore.release();
			return removedValue;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		try {
			semaphore.acquire();
			map.putAll(m);
			semaphore.release();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void clear() {
		try {
			semaphore.acquire();
			map.clear();
			semaphore.release();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public java.util.Set<K> keySet() {
		try {
			semaphore.acquire();
			java.util.Set<K> keySet = map.keySet();
			semaphore.release();
			return keySet;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public java.util.Collection<V> values() {
		try {
			semaphore.acquire();
			java.util.Collection<V> values = map.values();
			semaphore.release();
			return values;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public java.util.Set<Entry<K, V>> entrySet() {
		try {
			semaphore.acquire();
			java.util.Set<Entry<K, V>> entrySet = map.entrySet();
			semaphore.release();
			return entrySet;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
