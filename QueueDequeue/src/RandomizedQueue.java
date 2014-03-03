import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

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
        
        int position = new Random().nextInt(size);
        
        Item i = items[position];
        items[position] = null;
        size--;
        
        if (size < items.length /4 + 1)
        {
            shrinkArray();
        }
        return i;
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
        
        int position = new Random().nextInt(size);
        return items[position];
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
        Item[] newItems = (Item[]) new Object[items.length * 2];
        for (int i = 0; i < items.length; i++)
        {
            newItems[i] = items[i];
        }
        items = newItems;
    }
    
    private void shrinkArray()
    {
        Item[] newItems = (Item[]) new Object[items.length / 2];
        int j = 0;
        for (int i = 0; i < items.length; i++)
        {
            if (items[i] != null)
            {
                newItems[j] = items[i];
                j++;
            }
        }
        items = newItems;
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
            Item item = items[position];
            position++;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}