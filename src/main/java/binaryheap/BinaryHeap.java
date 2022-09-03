package binaryheap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;

/**
 * This class implements a binary heap data structure by extending the
 * ArrayList class.
 * @author Your name here
 * @param <E> the type of element stored on this binary heap
 */
public class BinaryHeap<E> extends ArrayList<E> implements Queue<E> {

    /**
     * Creates an empty binary heap with a given capacity and comparator.
     * @param capacity The initial size of the underlying ArrayList object.
     * @param comp A comparator object for comparing keys of binary heap elements.
     */
    public BinaryHeap(int capacity, Comparator<E> comp) {
        super(capacity+1);
        init();
        this.comp = comp;
    }

    /**
     * Getter for the comparator for this binary heap.
     * @return the comparator for this binary heap
     */
    public Comparator<E> getComp() {
        return comp;
    }

    /**
     * Initializes the underlying ArrayList object for use as a binary heap.
     * A null object is added to location 0, which is not used by the heap.
     */
    private void init() {
        add(0, null);
    }

    /**
     * Clears this binary heap by clearing and initializing the underlying
     * ArrayList object.
     */
    @Override
    public void clear() {
        super.clear();
        init();
    }

    /**
     * Returns the current size of this binary heap.  Since the first location 
     * (index 0) of the underlying ArrayList object is not used, the size of the 
     * binary heap is one less than the size of the ArrayList object.
     * @return The binary heap's current size. 
     */
    @Override
    public int size() {
        return super.size()-1;
    }

    /**
     * Returns true if this binary heap is empty, that is, its size is zero.
     * @return Whether this binary heap is empty.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Adds a new element to this binary heap.  At the end of the add,
     * the heap has one more element and the heap property is maintained.
     * @param element The element to add
     * @return true.  In accordance with the Collection interface, returns
     * true since duplicate elements are allowed.
     */
    @Override
    public boolean add(E element) {
        super.add(element);
        int index = super.indexOf(element);
        E parentNode = super.get(findParent(index));
        
        if(super.size() > 2) {
            while(comp.compare(element, parentNode) == -1) {
                super.set(findParent(index), element);
                super.set(index, parentNode);
                
                if(super.indexOf(element) == 1) {
                    break;
                }
                index = super.indexOf(element);
                parentNode = super.get(findParent(index));   
            }
        }
        return true;
    }
    

    
    private void swap(int index1, int index2) {
        E placeholder = super.get(index1);
        super.set(index1, super.get(index2));
        super.set(index2, placeholder);
        
    }

    /**
     * Removes an element from the root of this binary heap.  After removal,
     * the heap has one less element and the heap property is restored.
     * This method does not override any method in the ArrayList class 
     * (note absence of an index parameter).
     * @return The removed element
     */
    @Override
    public E remove() {
       E removed = super.get(1);
    this.swap(1, this.size());
    super.remove(this.size());
    int index = 1;
    
    while(index < this.size()){
        if(rightLeafIndex(index) <= this.size()){
            if(comp.compare(super.get(leftLeafIndex(index)), super.get(rightLeafIndex(index)))<0) {
                this.swap(index, leftLeafIndex(index));
                index = leftLeafIndex(index);
            }
            else if (comp.compare(super.get(rightLeafIndex(index)), super.get(leftLeafIndex(index)))<0) {
                this.swap(index, rightLeafIndex(index));
                index = rightLeafIndex(index);
            }
        }
        else if(leftLeafIndex(index) <= this.size() && comp.compare(super.get(index), super.get(leftLeafIndex(index)))>0) {

            this.swap(index, leftLeafIndex(index));
            index = leftLeafIndex(index);
        }
        else {
            index = leftLeafIndex(index);
        }
    }

    return removed; 

    }
    
    private int leftLeafIndex(int index) {
        return (index*2);
    }
    
    private int rightLeafIndex(int index) {
        return (index*2)+1;
    }
    
        private int findParent(int i) {
        return i/2;
    }

    /**
     * A Comparator object used to compare binary heap elements during its
     * add and remove operations.
     */
    private final Comparator<E> comp;

    /*
    The following are required to complete the implementation of the Queue<E> 
    interface. They are not used in the test.
    */
    
    @Override
    public boolean offer(E e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E poll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E element() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E peek() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}