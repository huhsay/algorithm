package datastructure;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class TheoLinkedList<E> {
    Node first;
    Node last;
    int size; // 노드를 추가하거나 제거 할 때 아맞게 가감해준다.
    HashMap<Integer, Node> map = new HashMap<>();

    private static class Node<E>{
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(Node prev, E item, Node next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private void linkFirst(E e){
        final Node<E> f = first;
        final Node<E> newNode = new Node(null, e, f);
        first = newNode;
        if(f == null){
            last = newNode;
        }else{
            f.prev = newNode;
        }
        size++;
    }

    void linkLast(E e){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if(l == null){
            first = newNode;
        }else {
            l.next = newNode;
        }
        size++;
    }

    void linkBefore(E e, Node<E> succ){
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if(pred==null){
            first = newNode;
        }else{
            pred.next=newNode;
        }
        size++;
    }
    
    private E unlinkFirst(Node<E> f){
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null; // gc 명시적으로..
        f.next = null;
        first = next;
        if(next == null){
            last = null; // 텅빈상태
        }else{
            next.prev = null;
        }
        size--;

        return element;
    }

    private E unlinkLast(Node<E> l){
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null;
        last = prev;
        if(prev == null){
            first = null;
        }else{
            prev.next = null;
        }
        size--;
        return element;
    }

    E unlink(Node<E> x){
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if(prev == null){
            first = next;
        }else{
            prev.next = next;
            x.prev = null;
        }

        if(next == null){
            last = prev;
        }else{
            next.prev = prev;
            x.next = null;
        }
        size--;

        return element;
    }

    public E getFirst(){
        final Node<E> f = first;
        if(f == null){
            throw new NoSuchElementException();
        }
        return f.item;
    }

    public E getLast(){
        final Node<E> l = last;
        if(l == null){
            throw new NoSuchElementException();
        }
        return l.item;
    }

    public E removeFirst(){
        final Node<E> f = first;
        if(f == null){
            throw new NoSuchElementException();
        }
        return unlinkFirst(f);
    }

    public E removeLast(){
        final Node<E> l = last;
        if(l == null){
            throw new NoSuchElementException();
        }
        return unlinkLast(l);
    }

    public void addFirst(E e){
        linkFirst(e);
    }

    public void addLast(E e){
        linkLast(e);
    }

    public boolean contain(Object o){
        return indexOf(o) >=0;
    }

    public int size() {
        return size;
    }

    public boolean add(E e){
        linkLast(e);
        return true;
    }

    public void clear(){
        for(Node<E> x = first; x != null; ){
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    // Positional Access Operations

    public E get(int index){
        checkElementIndex(index);
        return node(index).item;
    }

    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }

    public void add(int index, E element){
        checkPositionIndex(index);

        if(index == size){
            linkLast(element);
        }else{
            linkBefore(element, node(index));
        }
    }

    public E remove(int index){
        checkElementIndex(index);
        return unlink(node(index));
    }

    private boolean isElementIndex(int index){
        return index >=0 && index<size;
    }

    private boolean isPositionIndex(int index){
        return index >= 0 && index <=size;
    }

    private String outOfBoundsMsg(int index){
        return "index: "+index+", Size: "+size;
    }

    private void checkElementIndex(int index){
        if(!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkPositionIndex(int index){
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    Node<E> node(int index){
        if(index < (size >> 1)){
            Node<E> x = first;
            for(int i = 0; i < index; i++){
                x = x.next;
            }
            return x;
        }else{
            Node<E> x = last;
            for(int i = size -1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    // Search Operations

    public int indexOf(Object o){
        int index = 0;
        if (o == null) {
            for(Node<E> x = first; x != null; x= x.next){
                if(x.item == null){
                    return index;
                }
                index++;
            }
        } else {
            for(Node<E> x = first; x != null; x = x.next){
                if(o.equals(x.item)){
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o){
        int index = size;
        if(o == null){
            for(Node<E> x = last; x != null; x = x.prev){
                index--;
                if(x.item == null){
                    return index;
                }
            }
        }else {
            for(Node<E> x = last; x != null; x = x.prev){
                index--;
                if(o.equals(x.item)){
                    return index;
                }
            }
        }
        return -1;
    }
}
