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
        private Item data;
        private Node next;
        private Node prev;

        /**
         * @return the data
         */
        public Item getData() {
            return data;
        }

        /**
         * @param data the data to set
         */
        public void setData(Item data) {
            this.data = data;
        }

        /**
         * @return the next
         */
        public Node getNext() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /**
         * @return the prev
         */
        public Node getPrev() {
            return prev;
        }

        /**
         * @param prev the prev to set
         */
        public void setPrev(Node prev) {
            this.prev = prev;
        }
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
            newFirst.setData(item);
            newFirst.setNext(first);
            first.setPrev(newFirst);
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
            newLast.setData(item);
            newLast.setNext(null);
            last.setNext(newLast);
            newLast.setPrev(last);
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
        if (first.getNext() != null)
        {
            first = first.getNext();
            first.setPrev(null);
        }
        else
        {
            first = null;
        }
        size--;
        Item item = firstNode.getData();
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
        if (lastNode.getPrev() != null)
        {
            last = lastNode.getPrev();
            last.setNext(null);
        }
        else
        {
            last = null;
        }
        Item item = lastNode.getData();
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
            Item item = current.getData();
            current = current.getNext();
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }

    private void addFirstItem(Item item)
    {
        last = first = new Node();
        first.setData(item);
        first.setNext(null);
        first.setPrev(null);
    }
}
