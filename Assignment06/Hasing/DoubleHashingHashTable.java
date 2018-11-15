package Hasing;

public class DoubleHashingHashTable {
	private Entry[] entries; 
	private int size, collusion = 0;
	private final Entry NIL = new Entry(null, null);

	public DoubleHashingHashTable(int capacity) {
		entries = new Entry[capacity];
	}

	public DoubleHashingHashTable() {
		this(97);
	}

	public Object get(Object key) {
		int h = hash(key), d = hash2(key);
		for(int i=0; i<entries.length; i++) {
			int j = nextProbe(h, d, i);
			Entry entry = entries[j];
			if(entry == null) break;
			if(entry == NIL) continue;
			if(entry.key.equals(key)) {
				int index = j;
				Object value = entry.value;
				Object output = value + " " + index;
				return output;
			}
		}
		return null;
	}

	public Object put(Object key, Object value) {
		int h = hash(key), d = hash2(key); 
		for(int i=0; i < entries.length; i++) {
			int j = nextProbe(h, d, i);
			Entry entry = entries[j];
			if(entry == null) {
				entries[j] = new Entry(key, value);
				++size;
				return null;
			}
			if(entry == NIL) continue;
			if(entry.key.equals(key)) {
				Object oldValue = entry.value;
				entries[j].value=value;
				return oldValue;
			}
			collusion++;
		}
		return null;
	}

	public Object remove(Object key) {
		int h = hash(key), d = hash2(key);
		for(int i=0; i < entries.length; i++) {
			int j = nextProbe(h, d, i);
			Entry entry = entries[j];
			if(entry == null) break;
			if(entry == NIL) continue;
			if(entry.key.equals(key)) {
				Object oldValue = entry.value;
				entries[j] = NIL;
				--size;
				return oldValue;
			}
		}
		return null;
	}

	public int size() {
		return size;
	}

	private class Entry{
		Object key, value;
		Entry(Object k, Object v){
			key = k; value = v;
		}
	}

	private int hash(Object key) {
		if(key == null) throw new IllegalArgumentException();
		return (key.hashCode() & 0x7fffffff) % entries.length;
	}

	private int hash2(Object key) {
		if(key == null) throw new IllegalArgumentException();
		return ((key.hashCode() & 0x7fffffff) % 59) + 1;
	}

	private int nextProbe(int h, int d, int i) {
		return (h+i*d)%entries.length;
	}

	public int collusionCount(){
		return collusion;
	}
}