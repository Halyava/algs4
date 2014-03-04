import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitryi
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size = 0;
    private int upSize = 0;
    private Item[] items;
    
    /*
     * Construct an empty randomized queue
     */
    public RandomizedQueue()
    {
        items = (Item[]) new Object[10];
    }
    
    /*
     * Is the queue empty?
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    /*
     * Return the number of items on the queue
     */
    public int size()
    {
        return size;
    }
    
    /*
     * Add the item
     */
    public void enqueue(Item item)
    {
        if (item == null)
        {
            throw new java.lang.NullPointerException();
        }
        items[size] = item;
        size++;
        upSize++;

        if (size >= items.length)
        {
            growArray();
        }
    }
    
    /*
     * Delete and return a random item
     */
    public Item dequeue()
    {
        if (size == 0)
        {
            throw new java.util.NoSuchElementException();
        }
        
        int position = StdRandom.uniform(size);

        Item item = items[position];
        items[position] = null;
        if (position < size - 1)
        {
            for (int i = position + 1; i < items.length; i++)
            {
                items[i - 1] = items[i];
            }
        }
        size--;
        
        if (size < items.length /4 + 1)
        {
            shrinkArray();
        }
        return item;
    }
    
    /*
     * Return (but do not delete) a random item
     */
    public Item sample()
    {
        if (size == 0)
        {
            throw new java.util.NoSuchElementException();
        }
        
        int position = 0;
        Item item = null;
        position = StdRandom.uniform(size);

        item = items[position];
        return item;
    }
    
    /*
     * Return an independent iterator over items in random order
     */
    public Iterator<Item> iterator()
    {
        return new RandomizedQueueIterator();
    }

    private void growArray()
    {
        upSize = 0;
        Item[] newItems = (Item[]) new Object[items.length + 20];
        for (int i = 0; i < items.length; i++)
        {
            if (items[i] != null)
            {
                newItems[i] = items[i];
                upSize++;
            }
        }
        items = newItems;
        size = upSize;
    }
    
    private void shrinkArray()
    {
        upSize = 0;
        Item[] newItems = (Item[]) new Object[items.length / 2 + 1];
        for (int i = 0; i < items.length; i++)
        {
            if (items[i] != null)
            {
                newItems[upSize] = items[i];
                upSize++;
            }
        }
        items = newItems;
        size = upSize;
    }

    /*
     * Unit testing
     */
    public static void main(String[] args)
    {
        
    }

    private class RandomizedQueueIterator implements Iterator<Item>
    {
        private int position = 0;
        
        public boolean hasNext() {
            return position < size;
        }

        public Item next() {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }

            position = StdRandom.uniform(size);
            Item item = items[position];
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}