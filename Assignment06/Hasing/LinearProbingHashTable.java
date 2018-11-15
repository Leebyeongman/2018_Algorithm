package Hasing;

public class LinearProbingHashTable {
	private Entry[] entries;
	private int size, collusion = 0;
	private final Entry NIL = new Entry(null, null);

	public LinearProbingHashTable(int capacity) {
		entries = new Entry[capacity];
	}

	public LinearProbingHashTable() {
		this(97);
	}

	public Object get(Object key) {
		int h = hash(key);
		for(int i=0; i<entries.length; i++) {
			int j = nextProbe(h, i);
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
		int h = hash(key); 
		for(int i=0; i<entries.length; i++) {
			int j = nextProbe(h, i); // 한 칸씩 이동
			Entry entry = entries[j];
			if(entry == null) { // 테이블이 비어있다면
				entries[j] = new Entry(key, value); // 값을 삽입한다.
				++size; // 테이블 size 1 증가
				return null;
			}
			if(entry == NIL) continue; // NIL이라면 계속 진행한다.
			if(entry.key.equals(key)) { // 테이블에 있는 key의 값이 같다면
				Object oldValue = entry.value; // oldValue 값을 보존
				entries[j].value=value; // update 해준다.
				return oldValue; // oldValue 리턴
			}
			collusion++; // 충돌 카운팅 1 증가
		}
		return null;
	}

	public Object remove(Object key) {
		int h = hash(key);
		for(int i=0; i<entries.length; i++) {
			int j = nextProbe(h,i);
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
		return (key.hashCode()&0x7fffffff) % entries.length;
	}

	private int nextProbe(int h, int i) {
		return (h + i)%entries.length;
	}

	public int collusionCount(){
		return collusion;
	}
}