import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class HashMap<K, V> implements Map<K, V> {

	private int size;

	private Object[] data = new Object[8];

	private final KVPair removed = new KVPair(null, null);

	@Override
	public void clear() {
		data = new Object[8];
		size = 0;
	}

	@Override
	public boolean containsKey(Object key) {
		int h = findSlot((K) key);
		KVPair p = (KVPair) data[h];
		if (p != null && p != removed)
			return true;
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		for (Object o : data) {
			KVPair p = (KVPair) o;
			if (p == null) continue;
			if (value.equals(p.getValue()))
				return true;
		}
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(Object key) {
		int h = findSlot((K) key);
		KVPair p = (KVPair) data[h];
		if (p != null && p != removed)
			return p.getValue();
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	private int findSlot(K key) {
		int h = key.hashCode() % data.length;
		KVPair p;
		p = (KVPair) data[h];
		while (data[h] != null && data[h] != removed && !((KVPair) data[h]).getKey().equals(key)) {
			h = (h + 1) % data.length;
		}
		return h;
	}

	private void checkCapacity() {
		if (size > data.length / 2) {
			size = 0;
			Object[] newArray = new Object[data.length * 2];
			Object[] oldData = data;
			data = newArray;
			for (int i = 0; i < oldData.length; i++) {
				KVPair p = (KVPair) oldData[i];
				if (p == null)
					continue;
				put(p.getKey(), p.getValue());
			}
		}
	}

	@Override
	public V put(K key, V value) {
		checkCapacity();
		int h = findSlot(key);
		KVPair existing = (KVPair) data[h];
		KVPair p = new KVPair(key, value);
		data[h] = p;
		if (existing == null) {
			size++;
			return null;
		}
		return existing.getValue();
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub

	}

	@Override
	public V remove(Object key) {
		if (!containsKey(key))
			return null;
		int h = findSlot((K)key);
		KVPair existing = (KVPair)data[h];
		data[h] = removed;
		size--;
		if (existing == null)
			return null;
		return existing.getValue();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	private class KVPair {
		private K key;
		private V value;

		public KVPair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
	}
}
