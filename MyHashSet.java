public class MyHashSet<E> {
    private Object[] hashArray;
    private DLList<E> hashList;
    int size;

    public MyHashSet(){
        hashArray = new Object[100000];
        hashList = new DLList<E>();
        size = 0;
    }

    public boolean add(E obj){
        int index = obj.hashCode();
        if (hashArray[index] == null){
            hashArray[index] = obj;
            size++;
            hashList.add(obj);
            return true;
        } 
        return false;
    }

    public void clear(){
        hashArray = new Object[100];
        hashList = new DLList<E>();
    }

    public boolean contains(E obj){
        int index = obj.hashCode();
        if (hashArray[index] == null){
            return false;
        }
        return true;
    }

    public boolean remove(E obj){
        int index = obj.hashCode();
        if (hashArray[index] != null){
            hashArray[index] = null;
            size--;
            hashList.remove(obj);
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public DLList<E> toDLList(){
        return hashList;
    }

    public String toString()
    {
        return toDLList().toString();
    }
}
