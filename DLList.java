public class DLList<E>{
    private Node<E> head, tail;
    private int size;
    public DLList(){
        head = new Node<E>(null);
        tail = new Node<E>(null);
        head.setNext(tail);
        size = 0;
    }
    public boolean add(E element){
        Node<E> temp = tail.prev();
        temp.setNext(new Node<E>(element));
        temp.next().setNext(tail);
        size++;
        return true;
    }
    public void add(int index, E element){ 
		if (index > 0 && index < size){
			Node<E> temp = getNode(index-1);
			Node<E> newNode = new Node<E>(element);
			newNode.setNext(temp.next());
			temp.setNext(newNode);
            size++;
            return;
		}
    }
    public E get(int index){
		return getNode(index).get();
    }
    public Node<E> getHead(){
        return head;
    }
    public Node<E> getTail(){
        return tail;
    }
    private Node<E> getNode(int index){
        Node<E> current;
        if (index < size/2){
            current = head.next();
            for (int i=0;i<index;i++){
                current = current.next();
            }
        }
        else{
            current = tail.prev();
            for (int i=size-1;i>index;i--){
                current = current.prev();
            }
        }
        return current;
    }
    public String toString(){
        String text = "[";
        Node<E> temp = head.next();
        for (int i=0;i<size;i++){
            text = text + temp.get().toString()+"";
            temp = temp.next();
            if (i<size-1){
                text += ", ";
            }
        }
        return text +"]";
    }
    public E remove(int index){
        Node<E> temp;
        E send = null;
        if (index < size/2){
            temp = head.next();
            for (int i=0;i<index;i++){
                temp = temp.next();
            }
        }
        else{
            temp = tail.prev();
            for (int i=size-1;i>index;i--){
                temp = temp.prev();
            }
        }
        send = temp.get();
        temp.prev().setNext(temp.next());
        size--;
        return send;
    }
    public boolean remove(E item){ 
        Node<E> temp = head;
        for (int i=0;i<size;i++){ 
            if (temp.next().get().equals(item)){
                // the next item is the one to remove
                temp.next().next().setPrev(temp);
                temp.setNext(temp.next().next());//Skip it
                size--;
                return true;
            }
            temp = temp.next();
        }
        return false;
    }
    public void set(int index, E element){
        Node<E> temp;
        if (index < size/2){
            temp = head.next();
            for (int i=0;i<index;i++){
                temp = temp.next();
            }
        }
        else{
            temp = tail.prev();
            for (int i=size-1;i>index;i--){
                temp = temp.prev();
            }
        }
        temp.setData(element);
    }
    public void swap(int num1, int num2){
        Node<E> node1=getNode(num1);
        Node<E> node2=getNode(num2); 
        E temp = node2.get();
        node2.setData(node1.get());
        node1.setData(temp);
    }

    public int size(){
        return size;
    }

    public int indexOf(E object){
        Node<E> temp = head.next();
        for (int i=0;i<size;i++){ 
            if (temp.get().equals(object)){
                return i;
            }
            temp = temp.next();
        }
        return -1;
    }
}
