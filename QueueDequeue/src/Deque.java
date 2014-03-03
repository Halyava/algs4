import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Dmitryi
 */
public class Deque<Item> implements Iterable<Item> {
    
    private Node first = null;
    private Node last = null;
    private int size = 0;
    
    private class Node
    {
        Item data;
        Node next;
        Node prev;
    }
    
    /*
     * Construct an empty deque
     */
    public Deque()
    {
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
        if (item == null)
        {
            throw new java.lang.NullPointerException();
        }

        if (size < 1)
        {
            addFirstItem(item);
        }
        else
        {
            Node newFirst = new Node();
            newFirst.data = item;
            newFirst.next = first;
            first.prev = newFirst;
            first = newFirst;
        }
        size++;
    }

    /*
     * insert the item at the end
     */
    public void addLast(Item item)
    {
        if (item == null)
        {
            throw new java.lang.NullPointerException();
        }

        if (size < 1)
        {
            addFirstItem(item);
        }
        else
        {
            Node newLast = new Node();
            newLast.data = item;
            newLast.next = null;
            last.next = newLast;
            newLast.prev = last;
            last = newLast;
        }
        size++;
    }
    
    /*
     * delete and return the item at the front
     */
    public Item removeFirst()
    {
        if (size == 0)
        {
            throw new java.util.NoSuchElementException();
        }
        
        Node firstNode = first;
        first = first.next;
        first.prev = null;
        size--;
        Item item = firstNode.data;
        firstNode = null;
        return item;
    }
    
    /*
     * delete and return the item at the end
     */
    public Item removeLast()
    {
        if (size == 0)
        {
            throw new java.util.NoSuchElementException();
        }
        
        Node lastNode = last;
        last = lastNode.prev;
        last.next = null;
        Item item = lastNode.data;
        lastNode = null;
        size--;
        return item;
    }
    
    /*
     * return an iterator over items in order from front to end
     */
    public Iterator<Item> iterator()
    {
        return new QueueIterator();
    }
    
    /*
     * unit testing
     */
    public static void main(String[] args)
    {
        
    }

    private class QueueIterator implements Iterator<Item>
    {
        private Node current = first;
        
        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            Item item = current.data;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }

    private void addFirstItem(Item item)
    {
        last = first = new Node();
        first.data = item;
        first.next = null;
        first.prev = null;
    }
}
