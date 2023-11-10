public class Node<E>{
    private E data;
    private Node<E> next, prev;
    public Node(E data){
        this.data = data;
        next = null;
    }
    public E get(){
        return data;
    }
    public E getData(int index){
        return getNode(index).get();
    }
    public Node<E> getNode(int index){
        if (index <= 1){
            return this;
        }
        else{
            return next.getNode(index-1);
        }
    }

    public Node<E> next(){
        return next;
    }
    public Node<E> prev(){
        return prev;
    }
    public void setNext(Node<E> node){
        next = node;
        node.setPrev(this);
    }
    public void setPrev(Node<E> node){
        prev = node;
    }
    public void setData(E data){
        this.data = data;
    }
	public String toString(){
		return data.toString();
	}
}
