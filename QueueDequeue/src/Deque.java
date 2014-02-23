
import java.util.Iterator;

/**
 *
 * @author Dmitryi
 */
public class Deque<Item> implements Iterable<Item> {
    
    private Node first;
    private Node last;
    private int size = 0;
    
    private class Node
    {
        Item data;
        Node next;
    }
    
    /*
     * Construct an empty deque
     */
    public Deque()
    {
        last = first = new Node();
    }
    
    /*
     * Is the deque empty?
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    /*
     * Return the number of items on the deque
     */
    public int size()
    {
        return size;
    }
    
    /*
     * insert the item at the front
     */
    public void addFirst(Item item)
    {
        if (size < 1)
        {
            last = first = new Node();
            first.data = item;
            first.next = null; 
        }
        else
        {
            Node newFirst =new Node();
            newFirst.data = item;
            newFirst.next = first;
            first = newFirst;
        }
        size++;
    }

    /*
     * insert the item at the end
     */
    public void addLast(Item item)
    {
        if (size < 1)
        {
            last = first = new Node();
            first.data = item;
            first.next = null; 
        }
        else
        {
            Node newLast =new Node();
            newLast.data = item;
            newLast.next = null;
            last.next = newLast;
            last = newLast;
        }
        size++;
    }
    
    /*
     * delete and return the item at the front
     */
    public Item removeFirst()
    {
        size--;
        return null;
    }
    
    /*
     * delete and return the item at the end
     */
    public Item removeLast()
    {
        size--;
        return null;
    }
    
    /*
     * return an iterator over items in order from front to end
     */
    public Iterator<Item> iterator()
    {
        return null;
    }
    
    /*
     * unit testing
     */
    public static void main(String[] args)
    {
        
    }
}
