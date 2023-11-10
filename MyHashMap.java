public class MyHashMap<K, V>{
    private Object[] hashArray;
    private int size;
    private MyHashSet<K> keySet;

    public MyHashMap(){
        hashArray = new Object[100000];
        keySet = new MyHashSet<K>();
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public V put(K key, V value){
        int hashCode = key.hashCode();
        V tempVal = (V)hashArray[hashCode];
        hashArray[hashCode] = value;
        System.out.println(key);
        keySet.add(key);
        size++;
        return tempVal;
    }

    @SuppressWarnings("unchecked")
    public V get(Object o){
        K key = (K)o;
        int hashCode = key.hashCode();
        return (V)hashArray[hashCode];
    }

    @SuppressWarnings("unchecked")
    public V remove(Object o){
        K key = (K)o;
        int hashCode = key.hashCode();
        V tempVal = (V)hashArray[hashCode];
        hashArray[hashCode] = null;
        keySet.remove(key);
        size--;
        return tempVal;
    }

    public MyHashSet<K> keySet(){
        return keySet;
    }

    public int size(){
        return size;
    }



    // could be wrong
    public boolean contains(K obj){
        return keySet.contains( obj );
    }

}