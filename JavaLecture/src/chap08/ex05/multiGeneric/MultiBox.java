package chap08.ex05.multiGeneric;

public class MultiBox<K, V> { // Key, Value의 약자. 2개일 때 통상적으로 많이 씀
	
	private K key;
	private V value;
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}

}
